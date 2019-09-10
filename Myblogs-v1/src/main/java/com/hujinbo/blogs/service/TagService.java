package com.hujinbo.blogs.service;

import com.hujinbo.blogs.pojo.Tag;

import java.util.List;

/**
 * @author hujinbo
 * @version 1.0
 * @date 2019/9/3 15:02
 */
public interface TagService {
    /**
     * 判断tag表是否存在某个标签
     * @param name 标签名称
     * @return 存在返回true
     * */
    public boolean contains(String name);
    /**
     * 保存标签
     * @param tag 要保存的实体
     * @return 返回保存后的实体（更新后）
     * */
    public Tag save(Tag tag);

    /**
     * 按照名字查找标签
     * @param name 标签名
     * @return 标签实体
     * */
    public Tag findByTName(String name);

    /**
     * 获取所有的标签，并按数量排序
     * @return tags
     * */
    public List<Tag> getALlTags();
}
