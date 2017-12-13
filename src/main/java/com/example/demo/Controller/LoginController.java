package com.example.demo.Controller;

import com.example.demo.service.NewsService;
import com.example.demo.service.UserService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    NewsService newsService;
    @Autowired
    UserService userService;

    @RequestMapping(path = "/reg",method = {RequestMethod.GET,RequestMethod.POST})
    public String reg(Model model, @RequestParam("username") String username, @RequestParam("password") String password,@RequestParam(value = "remember",defaultValue = "0") int rememberme){
        try {
            Map<String,Object> map = userService.register(username,password);
        }catch (Exception e){

        }
        return "";
    }

}
