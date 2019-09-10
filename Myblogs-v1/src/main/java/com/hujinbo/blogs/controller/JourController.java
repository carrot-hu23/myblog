package com.hujinbo.blogs.controller;

import com.hujinbo.blogs.dao.ArticleDao;
import com.hujinbo.blogs.dao.CategoryDao;
import com.hujinbo.blogs.pojo.Article;
import com.hujinbo.blogs.pojo.Category;
import com.hujinbo.blogs.service.ArticleService;
import com.hujinbo.blogs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

/**
 * 文章列表控制
 * @author 胡锦波
 * */
@Controller
public class JourController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleDao articleDao;
    private final int SIZE = 9;
    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryDao categoryDao;
    /**
     * 返回不同分类的文章
     * @return jour.html
     * 返回数据
     * {
     *     data:{
     *         articles:[],     //文章列表
     *         tags:[]          //标签云
     *         indexPage:0,     //起始页
     *         totalPage:10,    //总页数
     *         categories:[],   //分类列表
     *         countPage:       //当前分类
     *     }
     * }
     * */
    @GetMapping("/jour/{category}")
    public String kindOfCategoryPage(@PathVariable("category") String name,String page,Model model) {

        System.out.println("访问第二个");
        System.out.println(name);
        int begin = indexOfPage(page);
        List<Article> articles;
        Long totalPages;
        String isHomepage = "all";
        //判断是否获取所有文章
        if (isHomepage.equals(name)) {
            totalPages= getKindOfCategorySize(articleService.count());
            articles = articleService.pageQueryByPublishTime(begin, SIZE);
        } else {
            //获取不同分类的文章
            Category category1 = categoryDao.findByCName(name);
            System.out.println(category1);
            totalPages = getKindOfCategorySize(category1.getArticles().size());
            long id = category1.getCId();
            articles = articleDao.findCategoryByPage(id,begin, SIZE);
        }

        model.addAttribute("articles",articles);
        if (page == null) {
            model.addAttribute("indexPage",1);
        } else {
            int index = Integer.parseInt(page);
            model.addAttribute("indexPage",index);
        }
        model.addAttribute("totalPage",totalPages);
        //设置标签云
        model.addAttribute("tags", tagService.getALlTags());
        //设置分类
        List<Category> categories = categoryDao.findAll(new Sort(Sort.Direction.DESC,"cCount"));
        model.addAttribute("categories",categories);
        model.addAttribute("countPage",name);
        return "category";
    }

    /**
     * 获取分页起始位置
     * @param page 页面数
     * @return 分页起始位置
     * */
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
    public long getKindOfCategorySize(long count) {
        final int size = 10;
        long totalPages = 1;
        if (count % size == 0 && count!= 0) {
            totalPages = count /10;
        }
        totalPages = count /10 + 1;
        return totalPages;
    }

    /**
     *
     @GetMapping("/jour")
     public String getAllArticles(Model model,String page){
     //总页数
     Long totalPages = totalPageNumber();

     //当前起始位置
     int begin = indexOfPage(page);

     List<Article> articles = service.pageQueryByPublishTime(begin, SIZE);

     model.addAttribute("articles",articles);

     if (page == null) {
     model.addAttribute("indexPage",1);
     } else {
     int index = Integer.parseInt(page);
     model.addAttribute("indexPage",index);
     }
     model.addAttribute("totalPage",totalPages);
     //设置标签云
     model.addAttribute("tags",tagService.getALlTags());
     //设置分类
     List<Category> categories = categoryDao.findAll(new Sort(Sort.Direction.DESC,"cCount"));
     model.addAttribute("categories",categories);
     //表明当前分页

     model.addAttribute("countPage",null);
     return "jour";
     }
     * */

}
