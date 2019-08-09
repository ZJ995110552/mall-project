package com.mercury.mallproject.activiti.config;

import org.activiti.engine.ProcessEngineConfiguration;
import org.springframework.stereotype.Component;

@Component
public class ActivitiConfig {

    public void initTable(){
        ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
    }
}
