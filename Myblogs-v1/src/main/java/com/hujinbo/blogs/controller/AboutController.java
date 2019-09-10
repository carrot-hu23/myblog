package com.hujinbo.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hujinbo
 * @version 1.0
 * @date 2019/8/30 10:33
 * 关于页面控制
 */
@Controller
public class AboutController {

    /**
     * 返回关于页面
     * @return about.html
     * */
    @GetMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }
}
