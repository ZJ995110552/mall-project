package com.mercury.mallproject.controller;

import com.mercury.mallproject.common.annotation.OperationLogger;
import com.mercury.mallproject.domain.Test;
import com.mercury.mallproject.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @OperationLogger(modelName = "temp", user = "admin", option = "test")
    @RequestMapping(value = "/testMethod", method = RequestMethod.GET)
    public String testMethod() {
        Test test = new Test();
        test.setId(1101);
        test.setUserId("002");
        test.setUserName("fengjiangpi");

        int intValue = testService.addObject(test);

        return intValue + "";
    }

    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "testftl", method = RequestMethod.GET)
    public String testftl(Model model) {
        String testString = "This is test";
        model.addAttribute("test", testString);
        return "test";
    }


}
