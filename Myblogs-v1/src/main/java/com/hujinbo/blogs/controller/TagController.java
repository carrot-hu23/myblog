package com.hujinbo.blogs.controller;

import com.hujinbo.blogs.dao.ArticleDao;
import com.hujinbo.blogs.dao.TagDao;
import com.hujinbo.blogs.pojo.Article;
import com.hujinbo.blogs.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 标签
 * @author hujinbo
 * @version 1.0
 * @date 2019/9/6 9:22
 */
@Controller
@RequestMapping("/search")
public class TagController {
    @Autowired
    private TagDao tagDao;
    @Autowired
    private ArticleDao articleDao;
    /**
     * 返回所属该标签文章列表
     * @param id 标签id
     * @return tag.html 页面
     *
     * {
     *      data:{
     *          articles:[],//文章
     *          indexPage:  //当前页
     *          totalPages: //总页数
     *          count：     //文章个数
     *          tagName:    //标签名
     *          id:         //标签id
     *
     *
     *      }
     * }
     * */
    @GetMapping("/tag/{id}")
    public String tagPage(@PathVariable long id, String page, Model model) {
        int begin = indexOfPage(page);
        List<Article> articles;
        Long totalPages;
        totalPages = getTotalPages(tagDao.countByTId(id));
        int size = 9;
        articles = articleDao.findArticlesByTagId(id,begin,size);

        for (Article article :articles) {
            article.setADiff(TimeUtil.currentTimeDifferences(article.getAPublishTime()));
        }
        model.addAttribute("articles",articles);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("count",tagDao.countByTId(id));
        String tagName = tagDao.findByTId(id).getTName();
        model.addAttribute("tagName",tagName);
        model.addAttribute("id",id);
        if (page == null) {
            model.addAttribute("indexPage",1);
        } else {
            int index = Integer.parseInt(page);
            model.addAttribute("indexPage",index);
        }
        return "tag";

    }
    private int indexOfPage(String page) {
        int start = 1;
        if (page != null) {
            start = Integer.parseInt(page);
        }
        int begin = (start -1) *10;
        return begin;
    }

    /**
     * 获取不同分类文章总数
     * @return 总页数
     * */
    public long getTotalPages(long count) {
        final int size = 10;
        long totalPages = 1;
        if (count % size == 0 && count!= 0) {
            totalPages = count /10;
        }
        totalPages = count /10 + 1;
        return totalPages;
    }
}
