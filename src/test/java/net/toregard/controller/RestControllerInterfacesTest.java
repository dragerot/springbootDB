package net.toregard.controller;

import net.toregard.Application;
import net.toregard.model.CV;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest // This will start the server on a random port
public class RestControllerInterfacesTest {

    // This will hold the port number the server was started on
    @Value("${local.server.port}")
    int port;

    final RestTemplate template = new RestTemplate();

    @Test
    public void cv_create() {
        MessageCV message = template.getForObject("http://localhost:" + port + "/cv/create/1212", MessageCV.class);
        Assert.assertEquals("1212", message.getCv().getYear());
        Assert.assertEquals("Kurs", message.getCv().getType());
        Assert.assertEquals("Oslo+year", message.getCv().getLocation());
        Assert.assertEquals("Schenker1212", message.getCv().getCompanyName());
        Assert.assertEquals("Besrivelse1212", message.getCv().getDescription());
        Assert.assertEquals(new Long(1) , message.getCv().getId());
    }

    @Test
    public void redis_create() {
        MessageCV message = template.getForObject("http://localhost:" + port + "/redis/create/1212", MessageCV.class);
        Assert.assertEquals("1212", message.getCv().getYear());
        Assert.assertEquals("Kurs", message.getCv().getType());
        Assert.assertEquals("Oslo+year", message.getCv().getLocation());
        Assert.assertEquals("Bedriften AS1212", message.getCv().getCompanyName());
        Assert.assertEquals("Besrivelse1212", message.getCv().getDescription());
        Assert.assertNull(message.getCv().getId());
    }
}
