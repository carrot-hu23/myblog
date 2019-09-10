package com.hujinbo.blogs.controller;

import com.hujinbo.blogs.pojo.UploadData;
import com.hujinbo.blogs.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hujinbo
 * @version 1.0
 * @date 2019/8/30 17:10
 *
 */
@RestController
public class UploadController {
    @Autowired
    private UploadData data;

    /**
     * 上传图片并返回data
     * */
    @RequestMapping("/upload")
    public UploadData uploadFile(@RequestParam("file") MultipartFile file) {
        String path = FileUtil.uploadFile(file);
        System.out.println(path);
        data.setErrno(0);
        data.setData(new String[]{path});
        return data;
    }
}
