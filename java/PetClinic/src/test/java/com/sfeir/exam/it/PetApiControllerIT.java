package com.sfeir.exam.it;

import com.sfeir.exam.petclinic.model.Pet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Abdelkader Midani on 30/12/14.
 */
public class PetApiControllerIT extends AbstractApiControllerTest{

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.url}")
    String server;

    @Value("${app.contextPath}")
    String contextPath;

    @Value("${app.apiPath}")
    String apiPath;

    @Test
    public void getPets(){
        List<Pet> response = restTemplate.exchange(server+contextPath+apiPath+"/pets",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Pet>>() {}).getBody();
        Assert.assertEquals("Leo", response.get(0).getName());
    }
}
