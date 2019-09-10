package com.hujinbo.blogs.service;

import com.hujinbo.blogs.dao.SlideDao;
import com.hujinbo.blogs.pojo.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 胡锦波
 */
@Service
public class SlideService {
    @Autowired
    private SlideDao dao;

    public List<Slide> findAll() {
        return dao.findAll();
    }
}
