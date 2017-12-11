package com.sell;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test1(){
        String name = "immooc";
        String password = "123456";
        //变量可以用{}来表示
        log.info("name:{}, password: {}", name, password);

        //日志等级：error>warning>info>debug>trace
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
        log.warn("warn...");
        log.trace("trace...");
    }
}
