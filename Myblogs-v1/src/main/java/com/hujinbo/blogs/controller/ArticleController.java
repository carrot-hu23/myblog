package com.hujinbo.blogs.controller;
import com.hujinbo.blogs.pojo.Article;
import com.hujinbo.blogs.service.ArticleService;
import com.hujinbo.blogs.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 文章控制
 * @author 胡锦波
 * */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService service;

    /**
     * 返回文章详细页面
     * @param id 文章id
     * @param model
     * @return article.html
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Article article = numberOfViewsPlusOne(id);

        String str = TimeUtil.currentTimeDifferences(article.getAPublishTime());
        article.setADiff(str);
        model.addAttribute("article",article);
        return "article";
    }

    /**
     * 返回文章浏览量加一的article对象
     * @param id 文章id
     * @return article对象
     * */
    public Article numberOfViewsPlusOne(Long id) {
        return service.numberOfViewsPlusOne(id);
    }


    /**文章点赞加一
     * todo
     *  */


    /**
     * 文章评论加一
     * todo
     */
}
