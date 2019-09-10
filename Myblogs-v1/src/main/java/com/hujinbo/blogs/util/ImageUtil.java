package com.hujinbo.blogs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 图片工具类
 *
 * @author hujinbo
 * @version 1.0
 * @date 2019/8/28 16:46
 */
public class ImageUtil {

    /**
     * 从html中获取所有图片的url
     * @param html html文本
     * @return 图片url的集合
     * */
    public static List<String> getUrlsForAllImagesFromHtml(String html) {
        List<String> pictures = new ArrayList<>();
        //String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regular = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        Pattern pImage = Pattern.compile(regular, Pattern.CASE_INSENSITIVE);
        Matcher mImage = pImage.matcher(html);
        while (mImage.find()) {
            // 得到<img />数据
            String img = mImage.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pictures.add(m.group(1));
            }
        }
        return pictures;
    }
    /**
     * 从html获取第一张图片的url
     * @param html html文本
     * @return url or null
     * */
    public static String getTheUrlForTheFirstImage(String html) {
        List<String> pictures = getUrlsForAllImagesFromHtml(html);
        if (pictures.size() < 1) {
            return null;
        }
        return pictures.get(0);
    }
}
