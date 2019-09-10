package com.hujinbo.blogs.service;

import com.hujinbo.blogs.pojo.Article;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author 胡锦波
 */
public interface ArticleService {
    /**
     * 获取所有文章
     * @return 所有文章列表
     * */
    public List<Article> findAll();

    /**
     * 获取最新的三篇文章
     * @return 返回三个文章实体列表
     * */
    public List<Article> getTheLatestThreeArticles();

    /**
     * 分页查询(发布时间)
     * @param begin 起始位置
     * @param size  大小
     * @return 返回符合条件的文章列表
     * */
    public List<Article> pageQueryByPublishTime(int begin, int size);

    /**
     * 获取某一篇文章
     * @param id 文章id
     * @return 返回该文章对象
     * */
    public Article getArticleById(Long id);


    /**
     * 浏览数加1
     * @param id 文章id
     * @return 返回浏览数加一后的文章对象
     * */
    public Article numberOfViewsPlusOne(Long id);

    /**
     * 保存/修改文章
     * @param article 文章对象
     * @return 文章对象
     * */
    public Article save(Article article);

    /**
     * 计算文章的个数
     * @return 总文章记录
     * */
    public Long count();
    /**
     * 获取标记页面
     * todo
     * */

}
