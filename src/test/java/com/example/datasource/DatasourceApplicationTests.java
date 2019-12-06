package com.example.datasource;


import com.example.datasource.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DatasourceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        userService.save();
    }

    @Test
    public void test1(){
        userService.getById();
    }

    @Test
    public void test2(){
        userService.getById2();
    }

}
