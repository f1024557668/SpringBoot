package cn.itcast.springboot.controller;

import cn.itcast.springboot.elasticsearch.model.Article;
import cn.itcast.springboot.elasticsearch.service.ArticleSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
@Controller
public class TitleController {
    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @RequestMapping("/buildTitle")
    public void buildTitle() {
        List<String> list = new ArrayList<String>();
        list.add("测试");
        list.add("ceshi");
        list.add("天气");
        List<Article> entitys = new ArrayList<Article>(list.size());
        for(String title : list) {
            Article tmp = new Article();
            tmp.setTitle(title);
            entitys.add(tmp);
        }

        articleSearchRepository.save(entitys);
    }
}
