package com.jerry.springboot_junit4;

import com.jerry.springboot_junit4.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = SpringbootJunit4Application.class)
@RunWith(SpringRunner.class)
public class SpringbootJunit4ApplicationTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private UserService userService;
    @Before
    public void before()
    {
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testPage() throws Exception
    {
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/user/list")).andReturn();
        int status=mvcResult.getResponse().getStatus();
        String resString=mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("fail",200,status);
    }

    @Test
    public void testJson() throws Exception
    {
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/user/delete").param("id","9fd8ee5729d64041a9d9722aa5f181cb")).andReturn();
        int status=mvcResult.getResponse().getStatus();
        String resString=mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("fail",200,status);
        Assert.assertEquals("not same","{\"status\":\"1\",\"data\":null,\"msg\":\"success\"}",resString);
    }


}
