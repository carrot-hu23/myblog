package com.hujinbo.blogs.service.imp;

import com.hujinbo.blogs.dao.ArticleDao;
import com.hujinbo.blogs.pojo.Article;
import com.hujinbo.blogs.service.ArticleService;
import com.hujinbo.blogs.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胡锦波
 */
@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    private ArticleDao dao;
    @Override
    public List<Article> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Article> getTheLatestThreeArticles() {
        return pageQueryByPublishTime(0,3);
    }

    @Override
    public List<Article> pageQueryByPublishTime(int begin, int size) {
        List<Article> articles = dao.findByPage(begin, size);
        for (Article article :articles) {
            article.setADiff(TimeUtil.currentTimeDifferences(article.getAPublishTime()));
        }
        return articles;
    }


    @Override
    public Article getArticleById(Long id) {
        return dao.findByAId(id);
    }

    @Override
    public Article numberOfViewsPlusOne(Long id) {
        Article article = dao.findByAId(id);
        Long pre = article.getAPageView();
        article.setAPageView(pre+1);
        return dao.save(article);
    }

    @Override
    public Article save(Article article) {
        return dao.save(article);
    }

    @Override
    public Long count() {
       return dao.count();
    }

}
