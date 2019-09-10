package com.hujinbo.blogs.dao;

import com.hujinbo.blogs.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * 文章分类数据处理
 *
 * @author hujinbo
 * @version 1.0
 * @date 2019/9/3 10:48
 */
public interface CategoryDao extends JpaRepository<Category,Long> {
    /**
     * 按照c_name查找c_id
     * @param name 分类名称
     * @return 分类id
     * */
    @Query(value = "select * from  category c " +
            "where c.c_name = ?1 ;",nativeQuery = true)
    public Category findByName(String name);
    /**
     * 根据名称找id
     * @param name 分类名称
     * @return 分类id
     * */
    @Query(nativeQuery = true,value = "select * from category c where c.c_name = ?1")
    public Category findByCName(String name);

}
