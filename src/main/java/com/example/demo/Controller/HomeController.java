package com.example.demo.Controller;

import com.example.demo.model.News;
import com.example.demo.model.User;
import com.example.demo.model.ViewObject;
import com.example.demo.service.NewsService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    NewsService newsService;

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/","/index"},method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model, HttpServletRequest request){
      /*  List<News> newsList = newsService.getLatestNews(0,0,10);
        List<ViewObject> vos = new ArrayList<>();
        for(News news:newsList){
            ViewObject vo = new ViewObject();
            vo.set("news",news);
            vo.set("user",userService.getUser(news.getUserId()));
            vos.add(vo);
        }
        model.addAttribute("vos",vos);
*/

        List<User> vos = new ArrayList<User>();
        vos.add(userService.getUser(1));
        vos.add(userService.getUser(4));
        vos.add(userService.getUser(3));
        model.addAttribute("vos",vos);
        System.out.println(vos.get(0).getName());
        System.out.println(vos.get(1).getName());
        System.out.println(vos.get(2).getName());
        return "home";
    }


    @RequestMapping("/register")
    public String re(){
        return "reg";
    }
}
