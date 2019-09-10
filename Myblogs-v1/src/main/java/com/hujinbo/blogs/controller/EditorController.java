package com.hujinbo.blogs.controller;

import com.hujinbo.blogs.dao.CategoryDao;
import com.hujinbo.blogs.pojo.Article;
import com.hujinbo.blogs.pojo.Category;
import com.hujinbo.blogs.pojo.Tag;
import com.hujinbo.blogs.service.ArticleService;
import com.hujinbo.blogs.service.TagService;
import com.hujinbo.blogs.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


/**
 * 文章编写页面
 *
 * 未编写全部功能：
 *               缺少上传图片     已解决
 *               缺少cookie信息
 *
 * @author 胡锦波
 * */
@Controller
public class EditorController {
    /**
     * 跳转编写页面
     *      注释：由于为编写登录功能，所以没法保存用户id，作者id默认
     *
     * @return editor.html
     * */
    @RequestMapping("/editor")
    public String test() {
        return "editor";
    }

    @Autowired
    private ArticleService service;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private TagService tagService;

    /**
     * 接受前端文章数据，并处理保存到数据库中
     * */
    @ResponseBody
    @PostMapping("/publish")
    public String publish(String title,String content,String category,String tags) {
        //保存文章
        Article article = save(title, content, category,tags);

        return "发布成功";
    }
    public String[] splitTags(String tags) {
        //去掉空格
        tags.replaceAll(" ","");
        //使用split分割字符
        return tags.split("#");
    }
    /**
     * 保存文章实体
     * @param title 标题
     * @param content 正文
     * @param category 分类
     * @return 返回已更新的实体
     * */
    private Article save(String title,String content,String category,String tags) {

        Article article = new Article();
        article.setATitle(title);
        article.setAContext(content);
        article.setAUserId(2019824);
        //使用正则表达式过滤 html格式
        String preview = filterTheHtml(content);
        article.setAPreviewText(preview);
        article.setACoverPicture(ImageUtil.getTheUrlForTheFirstImage(content));
        //设置分类
        Category cate = categoryDao.findByName(category);
        article.setCategory(cate);
        //保存标签
        String[] label = splitTags(tags);

        for (String tag:label) {
            Tag tag1 = tagService.findByTName(tag);
            if (tag1 == null) {
                tag1 = new Tag();
                tag1.setTName(tag);
            }
            tag1.setTCount(tag1.getTCount()+1);
            tagService.save(tag1);
            if (article.getTags() == null) {
                article.setTags(new ArrayList<>());
            }
            article.getTags().add(tag1);
        }

        //保存文章
        Article save = service.save(article);
        return save;
    }

    /**
     * 过滤html标签保存纯text
     * */
    private String filterTheHtml(String html) {
        String preview = html.replaceAll("<.*?>", "").replaceAll("&nbsp;","");
        int previewLength = 50;
        if (preview.length() > previewLength) {
            preview = preview.substring(0,70);
        }
        return preview;
    }


    @GetMapping("/markdown")
    public String testEditor() {
        return "markdown";
    }
    @ResponseBody
    @PostMapping("/markdown")
    public String publish(@RequestParam("context") String context) {
        System.out.println(context);
        return context;
    }

}
