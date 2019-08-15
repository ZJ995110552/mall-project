package com.mercury.mallproject.project.controller;

import com.mercury.mallproject.log.aspect.annotaion.OperationLogger;
import com.mercury.mallproject.project.domain.Test;
import com.mercury.mallproject.project.service.TestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @OperationLogger(modelName = "test", user = "admin1", option = "test")
    @RequestMapping(value = "/testMethod", method = RequestMethod.GET)
    public String testMethod() {
        Test test = new Test();
        test.setId(1101);
        test.setUserId("002");
        test.setUserName("fengjiangpi");

        int intValue = testService.addObject(test);

        return intValue + "";
    }

    @RequiresPermissions("test:demo:menu002")
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
