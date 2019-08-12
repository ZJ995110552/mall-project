package com.mercury.mallproject.project.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.mercury.mallproject.common.enums.ResultEnum;
import com.mercury.mallproject.common.response.R;
import com.mercury.mallproject.common.utils.CodeUtil;
import com.mercury.mallproject.project.domain.SysUser;
import com.mercury.mallproject.project.service.api.SysUserService;
import io.swagger.annotations.Api;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Api(value = "登陆接口", tags = "登陆接口")
@Controller
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


        Map<String, Object> map = new HashMap<>();


        if (!CodeUtil.checkVerifyCode(request)) {
            return R.error(ResultEnum.CAPTCHA_ERROR.getDescription());
        }


        SysUser sysUser = sysUserService.queryByUserName(username);
        if (sysUser == null) {
            return R.error(ResultEnum.USER_NOT_FOUNT.getDescription());
        } else if (!sysUser.getPassword().equals(DigestUtils.sha256Hex(password))) {
            return R.error(ResultEnum.PASSWORD_ERROR.getDescription());
        } else {
            map.put("token", "");
            map.put("expire", "");
        }

        return R.ok();

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
