package com.hujinbo.blogs.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 *
 * @author hujinbo
 * @version 1.0
 * @date 2019/8/28 16:46
 */
public class FileUtil {
    /**
     * 保存文件到本地
     * @param file 要保存的文件
     * @return true or false
     * */
    public static String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            //抛出异常
            return "文件不能为空";
        }
        String fileName = file.getOriginalFilename();
        String path = "C:\\blogData\\article\\" + fileName;
        //创建文件路径
        File dest = new File(path);
        if (dest.exists()) {
            return "文件已存在";
        }
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            //上传文件
            file.transferTo(dest);
        } catch (IOException e) {
            System.out.println("上传失败！");
            return "上传失败";
        }

        return "http://localhost:8080/image/article/" + fileName;
    }
}
