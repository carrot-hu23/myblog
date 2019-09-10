package com.hujinbo.blogs.pojo;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author hujinbo
 * @version 1.0
 * @date 2019/8/30 17:14
 *
 * 返回wang editor 图片请求数据
 */
@Data
@Service
public class UploadData {
    /**
     *  0:上传成功
     *  1:上传失败
     * */
    private Integer errno;
    /**
     * 图片的url地址
     * */
    private String[] data;
}
