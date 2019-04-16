package com.mercury.mallproject;

import com.mercury.mallproject.common.config.DruidConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProjectApplicationTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DruidConfig druidConfig;

    @Test
    public void testLog() {

        logger.info("info");

        logger.error("error");
    }

    @Test
    public void testDruid() {
        try (


                Connection connection = druidConfig.druidDataSource().getConnection()



        ) {
        } catch (Exception e) {
        }
    }


    @Test
    public void contextLoads() {
    }

}
