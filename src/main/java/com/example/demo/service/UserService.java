package com.example.demo.service;

import com.example.demo.dao.LoginTicketDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.LoginTicket;
import com.example.demo.model.User;
import com.example.demo.util.ToutiaoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private LoginTicketDAO ticketDAO;


    public Map<String,Object> register(String username, String password){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","username can't be null");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpassword","password can't be null");
            return map;
        }

        User user = userDAO.selectByName(username);
        if(user != null){
            map.put("msgname","has been register");
            return map;
        }
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeadUrl(String.format("http://wwww.dsad.sad"));
        user.setPassword(ToutiaoUtil.MD5(password+user.getSalt()));
        userDAO.addUser(user);
        //登录
        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);


        return map;
    }

    public Map<String,Object> login(String username, String password){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","username can't be null");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpassword","password can't be null");
            return map;
        }

        User user = userDAO.selectByName(username);
        if(user == null){
            map.put("msgname","用户名不存在");
            return map;
        }

        if(!ToutiaoUtil.MD5(password+user.getSalt()).equals(user.getPassword())){
            map.put("msg","密码错误");
            return map;
        }

        //ticket
        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);


        return map;
    }


    private String addLoginTicket(int userId){
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        ticketDAO.addTicket(ticket);
        return ticket.getTicket();
    }

    public User getUser(int id) {
        return userDAO.selectById(id);
    }
    public void addUser(User user){
        userDAO.addUser(user);
    }
}
