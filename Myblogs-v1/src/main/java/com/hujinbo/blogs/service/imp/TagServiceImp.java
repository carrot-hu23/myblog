package com.hujinbo.blogs.service.imp;

import com.hujinbo.blogs.dao.TagDao;
import com.hujinbo.blogs.pojo.Tag;
import com.hujinbo.blogs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hujinbo
 * @version 1.0
 * @date 2019/9/3 15:07
 */
@Service
public class TagServiceImp implements TagService {
    @Autowired
    private TagDao dao;
    @Override
    public boolean contains(String name) {
        if (dao.countByTName(name) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Tag save(Tag tag) {
        return dao.save(tag);
    }

    @Override
    public Tag findByTName(String name) {
        return dao.findByTName(name);
    }

    @Override
    public List<Tag> getALlTags() {
        return dao.findAll(new Sort(Sort.Direction.DESC,"tCount"));
    }
}
