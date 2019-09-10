package com.hujinbo.blogs.dao;

import com.hujinbo.blogs.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 文章数据处理
 *
 * @author 胡锦波
 * */

public interface ArticleDao extends JpaRepository<Article,Long> {
    /**
     * 按照id查找文章
     * @param id 文章id
     * @return 返回文章对象
     * */
    public Article findByAId(Long id);

    /**
     * 文章分页
     * @param start 起始位置
     * @param size 大小
     * @return 返回list文章
     * */
    @Query(value ="select * from article a "
            + "order by a.a_publish_time desc  limit ?1,?2 ",nativeQuery = true)
    public List<Article> findByPage(Integer start,int size);
    /**
     * 返回不同分类的文章
     * @param start 起始位置
     * @param size 大小
     * @param id 分类id
     * @return list
     *              注意原生sql语句空格问题，不然报错，+ 号拼接建议前后都打上空格
     *              还有这里好像可以直接使用categoryDao.findByName 就可以查到所有所属分类的文章list
     *              使用list.subList(包左不包右] 该函数自动帮我们检查范围不需要自己判断（subListRangeCheck）
     * */
    @Query(value ="select * from article a where a.a_category_id = ?1 "
            + "order by a.a_publish_time desc  limit ?2,?3  ",nativeQuery = true)
    public List<Article> findCategoryByPage(long id,int start,int size);

    /**
     * 使用spring data jpa ORM框架要站在java思维去写sql，而不是站在sql去写sql
     * 这种思维很重要，不然代码写的很别扭，很奇怪
     * 用spring data jpa的目的就是为了从数据库那里夺回掌握权，你们不要闹了，就这样，都听我的。
     *
     * 反正我觉我自己写的就感觉很奇怪，虽然能够跑起来
     * */

    /**
     * 根据标签id找文章
     * @param id 标签id
     * @param start 起始位置
     * @param size 每页数量
     * @return list
     * */
    @Query(nativeQuery = true,
            value = " SELECT * from article WHERE a_id in " +
                    "  (SELECT relationship_a_id from tag_relationship " +
                    " WHERE relationship_t_id = ?1) " +
                    " ORDER BY a_publish_time DESC " +
                    " LIMIT ?2,?3 "
    )
    public List<Article> findArticlesByTagId(long id,int start,int size);
}
