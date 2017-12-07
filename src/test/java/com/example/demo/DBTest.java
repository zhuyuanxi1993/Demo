package com.example.demo;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DBTest {
    @Autowired
    UserDAO userDAO;
    @Test
    public void contextLoad(){
  /*     for(int i=0;i<10;i++){
            User user = new User();
            user.setHeadUrl(String.format("http://www.baidu.com/image"));
            user.setName(String.format("customer"+i));
            user.setPassword("");
            user.setSalt("");
            userDAO.addUser(user);

       }*/
    System.out.println(userDAO.selectById(1).getHeadUrl());
    }
}
