package com.hujinbo.blogs.global;

import com.hujinbo.blogs.dao.TagDao;
import com.hujinbo.blogs.pojo.Tag;
import com.hujinbo.blogs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.util.List;

/**
 * 全局函数
 *
 *
 * @author hujinbo
 * @version 1.0
 * @date 2019/9/5 14:16
 */
public class GlobalFunction {
    @Autowired
    private static TagDao tagDao;

    /**
     * 获取标签云
     *
     * */

    public static List<Tag> settingLabelClouds(Model model) {
        List<Tag> tags = tagDao.findAll(new Sort(Sort.Direction.DESC,"tCount"));
        return tags;
    }
}
