package com.mercury.mallproject.project.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.mercury.mallproject.common.enums.ErrorCodeEnum;
import com.mercury.mallproject.common.response.R;
import com.mercury.mallproject.common.utils.IpUtils;
import com.mercury.mallproject.project.service.SysUserService;
import com.mercury.mallproject.shiro.utils.ShiroUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Api(value = "登陆接口", tags = "登陆接口")
@RestController
@RequestMapping
@Slf4j
public class SysLoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private Producer captchaProducer = null;

    @RequestMapping("/images/captcha.png")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //向客户端写出
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public R login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {


//        if (!CodeUtil.checkVerifyCode(request)) {
//            return R.error(ResultEnum.CAPTCHA_ERROR.getDescription());
//        }

        password = DigestUtils.sha256Hex(password);
        try {
            Subject subjct = ShiroUtils.getSubjct();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subjct.login(usernamePasswordToken);

            log.info("用户[{}]请求登陆，登陆IP为[{}]",username, IpUtils.getIpAddr(request));
            if(subjct.isAuthenticated()){
                log.info("用户[{}]身份认证成功，登陆IP为[{}]",username, IpUtils.getIpAddr(request));
            }

        } catch (UnknownAccountException e){
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e){
            return R.error(e.getMessage());
        } catch (LockedAccountException e){
            return R.error(e.getMessage());
        } catch (AuthenticationException e){
            return R.error(ErrorCodeEnum.ACCOUNT_PASSWORD_ERROR.getDescription());
        }

//        Map<String, Object> map = new HashMap<>();
//
//        SysUser sysUser = sysUserService.queryByUserName(username);
//        if (sysUser == null) {
//            return R.error(ResultEnum.USER_NOT_FOUNT.getDescription());
//        } else if (!sysUser.getPassword().equals(DigestUtils.sha256Hex(password))) {
//            return R.error(ResultEnum.PASSWORD_ERROR.getDescription());
//        } else {
//            map.put("token", "");
//            map.put("expire", "");
//        }


        return R.ok("登陆成功");

    }

//    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
//        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
//        if (token == null) {
//            return CommonResult.validateFailed("用户名或密码错误");
//        }
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("token", token);
//        tokenMap.put("tokenHead", tokenHead);
//        return CommonResu∂lt.success(tokenMap);
//    }
}
