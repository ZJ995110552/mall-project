package com.mercury.mallproject.controller;

import com.mercury.mallproject.domain.Test;
import com.mercury.mallproject.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/testMethod",method = RequestMethod.GET)
    public String testMethod(){
        Test test = new Test();
        test.setId(110);
        test.setUserId("002");
        test.setUserName("fengjiangpi");

        int intValue = testService.addObject(test);

        return intValue+"";
    }

    @ResponseBody
    @RequestMapping(value = "test" ,method = RequestMethod.GET)
    public String test(){
        return "hhhhhh";
    }



}
