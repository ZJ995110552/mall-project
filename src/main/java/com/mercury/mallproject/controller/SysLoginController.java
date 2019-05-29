package com.mercury.mallproject.controller;


import com.mercury.mallproject.common.exception.ResultCode;
import com.mercury.mallproject.common.utils.Result;
import com.mercury.mallproject.domain.SysUser;
import com.mercury.mallproject.service.api.SysUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sys")
public class SysLoginController {

    @Autowired
    private SysUserService sysUserService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Map<String, Object>> login(@RequestParam("username") String username, @RequestParam("password") String password, String captcha) {
//        if(username.equals("admin") && inputPassword.equals("admin")){
//            return "SUCCES";
//        }else{
//            return "FAILE";
//        }

        Map<String, Object> map = new HashMap<>();


        SysUser sysUser = sysUserService.queryByUserName(username);
        if(sysUser == null){
            return Result.error(ResultCode.USER_NOT_FOUNT.getDescription());
        }else if(!sysUser.getPassword().equals(DigestUtils.sha256Hex(password))){
            return Result.error(ResultCode.PASSWORD_ERROR.getDescription());
        }else{
            map.put("token", "");
            map.put("expire", "");
        }

        return Result.ok(map);

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
