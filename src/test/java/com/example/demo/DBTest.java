package com.example.demo;

import com.example.demo.dao.LoginTicketDAO;
import com.example.demo.dao.NewsDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.LoginTicket;
import com.example.demo.model.News;
import com.example.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.internal.Ticket;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DBTest {
    @Autowired
    UserDAO userDAO;
    @Autowired
    NewsDAO newsDAO;
    @Autowired
    LoginTicketDAO loginTicketDAO;
    @Test
    public void contextLoad(){
       for(int i=0;i<10;i++){
            User user = new User();
            user.setHeadUrl(String.format("http://www.baidu.com/image"));
            user.setName(String.format("customer"+i));
            user.setPassword("");
            user.setSalt("");
            userDAO.addUser(user);
           LoginTicket loginTicket = new LoginTicket();
           loginTicket.setStatus(0);
           loginTicket.setUserId(i);
           loginTicket.setExpired(new Date());
           loginTicket.setTicket(String.format("TICKET%d",i));
           loginTicketDAO.addTicket(loginTicket);

       }

        for (int i = 0;i<10;i++) {
            News news = new News();
            news.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime()+1000*3600*5*i);
            news.setCreatedDate(date);
            news.setImage(String.format("http://image.png"+i));
            news.setLikeCount(i+1);
            news.setUserId(i+1);
            news.setTitle(String.format("TITLE{%d}",i));
            news.setLink(String.format("http://wewewe"+i));
            newsDAO.addNews(news);
        }


    }
}
