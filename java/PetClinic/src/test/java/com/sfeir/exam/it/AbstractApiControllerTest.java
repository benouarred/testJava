package com.sfeir.exam.it;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by Abdelkader Midani on 30/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/test-config.xml"})
public class AbstractApiControllerTest {
    @Resource
    RestTemplate restTemplate;

    @Value("${server.url}")
    String server;

    @Value("${app.contextPath}")
    String contextPath;

    @Value("${app.apiPath}")
    String apiPath;
}
