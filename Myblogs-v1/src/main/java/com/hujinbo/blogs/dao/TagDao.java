package com.hujinbo.blogs.dao;

import com.hujinbo.blogs.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 标签数据处理
 *
 * @author hujinbo
 * @version 1.0
 * @date 2019/9/3 14:54
 */
public interface TagDao extends JpaRepository<Tag,Long> {
    /**
     * 查询标签个数
     * @param tName 标签名称
     * @return 返回标签个数
     * */
    public long countByTName(String tName);

    public long countByTId(long TId);

    public Tag findByTId(long id);

    /**
     * 按名称查找标签
     * @param tName 标签名称
     * @return 返回标签对象
     * */
    public Tag findByTName(String tName);
}
