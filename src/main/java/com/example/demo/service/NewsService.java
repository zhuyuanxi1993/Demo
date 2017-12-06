package com.example.demo.service;

import com.example.demo.dao.NewsDAO;
import com.example.demo.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class NewsService {
    @Autowired
    private NewsDAO newsDAO;

    public List<News> getLatestNews(int userId,int offset,int limit){
        return newsDAO.selectByUserIdAndOffset(userId,offset,limit);
    }
}
