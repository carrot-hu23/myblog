package com.hujinbo.blogs.dao;

import com.hujinbo.blogs.pojo.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 轮播图数据处理
 *
 * @author 胡锦波
 **/
public interface SlideDao extends JpaRepository<Slide,Long> {

}
