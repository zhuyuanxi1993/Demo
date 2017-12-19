package com.example.demo.Controller;

import com.example.demo.service.NewsService;
import com.example.demo.service.UserService;
import com.example.demo.util.ToutiaoUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    NewsService newsService;
    @Autowired
    UserService userService;

    @RequestMapping(path = "/reg",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String reg(Model model, @RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam(value = "remember",defaultValue = "0") int rememberme) throws JSONException {
        try {
            Map<String,Object> map = userService.register(username,password);
            if(map.isEmpty()){
                return ToutiaoUtil.getJSONString(1,"注册成功");
            }else{
                return ToutiaoUtil.getJSONString(0,"注册失败");
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return ToutiaoUtil.getJSONString(1,"注册异常");

        }
    }



    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String, Object> map,Model model) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("hell");
        list.add("hel");
        list.add("he");
        model.addAttribute("mlist",list);
//        map.put("mlist",list);
        return "helloJsp";


    }
}
