package com.hujinbo.blogs.controller;

import com.hujinbo.blogs.dao.TagDao;
import com.hujinbo.blogs.global.GlobalFunction;
import com.hujinbo.blogs.pojo.Article;
import com.hujinbo.blogs.pojo.Slide;
import com.hujinbo.blogs.pojo.Tag;
import com.hujinbo.blogs.service.ArticleService;
import com.hujinbo.blogs.service.SlideService;
import com.hujinbo.blogs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 主页控制
 * @author 胡锦波
 */
@Controller
public class IndexController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private SlideService service;

    @Autowired
    private TagService tagService;

    /***
     * 跳转首页
     * @return index.html
     * */
    @GetMapping("/")
    public String index(Model model) {
        //获取前三篇文章
        List<Article> lists = articleService.getTheLatestThreeArticles();

        //获取全部标签并按数量排序
        List<Tag> tags = tagService.getALlTags();

        //获取首页轮播图url
        List<Slide> slides = service.findAll();

        model.addAttribute("lists",lists);
        model.addAttribute("slides",slides);
        model.addAttribute("tags",tags);
        return "index";
    }
}
