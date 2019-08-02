package com.sample.thymeleaf.controller;

import com.sample.thymeleaf.entity.Article;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoy
 * @since 2019/8/2
 */
@RestController
@RequestMapping("/")
public class DemoController {

    @GetMapping("articles")
    public ModelAndView getArticleList(Model model) {
        List<Article> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            Article article = new Article();
            article.setId(i);
            article.setName(i + "_文章");
            article.setCreateDate("2019-08-01 12:00:01");
            list.add(article);
        }
        model.addAttribute("data", list);
        return new ModelAndView("article/list");
    }

}