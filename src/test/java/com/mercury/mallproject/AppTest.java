package com.mercury.mallproject;

import com.mercury.mallproject.common.config.DruidConfig;
import com.mercury.mallproject.domain.ext.ExtTest;
import com.mercury.mallproject.job.service.api.ScheduleJobService;
import com.mercury.mallproject.repository.mapper.ext.ExtTestMapper;
import com.mercury.mallproject.service.api.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DruidConfig druidConfig;

    @Autowired
    private TestService testService;

    @Autowired
    private ExtTestMapper extTestMapper;

    @Autowired
    private ScheduleJobService  scheduleJobService;

    @Test
    public void testLog() {

        logger.info("info");

//        ScheduleJobEntity scheduleJobEntity = new ScheduleJobEntity();
//        scheduleJobEntity.setBeanName(getClass().getName());
//        long ss=111;
//        scheduleJobEntity.setJobId(ss);
//        scheduleJobEntity.setCronExpression("* * * * * ?");
//        scheduleJobEntity.setMethodName("sss");
//
//        scheduleJobService.save(scheduleJobEntity);

        logger.error("error");
    }

    @Test
    public void testDruid() {
        try (
                Connection connection = druidConfig.druidDataSource().getConnection();

        ) {
        } catch (Exception e) {
        }
    }


    @Test
    public void contextLoads() {
    }


    @Test
    public void testService() {
        long count = testService.queryToalTestObject();
        logger.debug(String.valueOf(count));
    }

    @Test
    public void testBatch(){




        List<ExtTest> extTestList = new ArrayList<ExtTest>();

        ExtTest extTest = new ExtTest();
        extTest.setId(3);
        extTest.setUserId("wangyangdahai");
        extTest.setUserName("wangyangdahai");

        extTestList.add(extTest);

        ExtTest extTest4 = new ExtTest();
        extTest4.setId(4);
        extTest4.setUserId("wangyangdahai4");
        extTest4.setUserName("wangyangdahai4");
        extTestList.add(extTest4);


        testService.batchInsert(extTestList);
    }

    @Test
    public void testRun(){
        logger.info("Springboot Test run ");

    }





}
