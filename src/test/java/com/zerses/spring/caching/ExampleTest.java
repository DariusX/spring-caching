package com.zerses.spring.caching;


import com.zerses.spring.caching.repository.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleTest  {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleTest.class);

    @Autowired
    MyService myService;

    @Test
    public void test01() {

        makeCall("K1", 10);
        makeCall("K2",10);
        makeCall("K3",10);
        makeCall("K1",10);
        makeCall("K4",10);

    }

    private String makeCall(String key, long waitMilli) {

        try {
            Thread.sleep(waitMilli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("===========================");
        LOGGER.info("testing for Key:"+key);
        String retVal = myService.getV(key);
        LOGGER.info("Value return was:"+retVal);
        return retVal;
    }

}
