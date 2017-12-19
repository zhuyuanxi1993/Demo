package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import com.example.demo.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public Map<String,Object> register(String username, String password){
        Map<String,Object> map = new HashMap<String,Object>();
        if(username == null){
            map.put("msgname","username can't be null");
        }
        if(password == null){
            map.put("msgpassword","password can't be null");
        }

        User user = userDAO.selectByName(username);
        if(user != null){
            map.put("msgname","has been register");
        }
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeadUrl(String.format("http://wwww.dsad.sad"));
        user.setPassword(ToutiaoUtil.MD5(password+user.getSalt()));
        userDAO.addUser(user);
        //登录

        return map;
    }

    public User getUser(int id) {
        return userDAO.selectById(id);
    }
    public void addUser(User user){
        userDAO.addUser(user);
    }
}
