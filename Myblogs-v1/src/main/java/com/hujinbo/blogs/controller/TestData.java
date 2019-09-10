package com.hujinbo.blogs.controller;

import com.hujinbo.blogs.pojo.Article;
import com.hujinbo.blogs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hujinbo
 * @version 1.0
 * @date 2019/8/29 13:56
 *
 * 测试数据
 */
@RestController
public class TestData {
    @Autowired
    private ArticleService service;

    @GetMapping("/add/test/data/articles")
    public List<Article> addArticleData() {
        List<Article> list = new ArrayList<>(50);
        int size = 30;
        for (int i = 0;i < size; i++) {
            String title = "背影(测试数据"+i+")";
            String content = "(测试数据"+i+")我与父亲不相见已二年余了，我最不能忘记的是他的背影。那年冬天，祖母死了，父亲的差使也交卸了，正是祸不单"+
                    "行的日子，我从北京到徐州，打算跟着父亲奔丧回家。到徐州见着父亲，看见满院狼藉的东西，又想起祖母，不禁簌簌地流下眼" + "泪。父亲说，“事已如此，不必难过，好在天无绝人之路！”\n" +
                    "　　回家变卖典质，父亲还了亏空；又借钱办了丧事。这些日子，家中光景很是惨淡，一半为了丧事，一半为了父亲赋闲。丧事完毕，父亲要到南京谋事，我也要回北京念书，我们便同行。\n" +
                    "　　到南京时，有朋友约去游逛，勾留了一日；第二日上午便须渡江到浦口，下午上车北去。父亲因为事忙，本已说定不送我，" +
                            "叫旅馆里一个熟识的茶房陪我同去。他再三嘱咐茶房，甚是仔细。但他终于不放心，怕茶房不妥帖；颇踌躇了一会。" +
                            "其实我那年已二十岁，北京已来往过两三次，是没有甚么要紧的了。他踌躇了一会，终于决定还是自己送我去。" +
                            "我两三回劝他不必去；他只说，“不要紧，他们去不好！";
            String preview = content.substring(0,70);
            Article article = new Article();
            article.setATitle(title);
            article.setAUserId(2019824);
            article.setAContext(content);
            article.setAPreviewText(preview);
            service.save(article);
            list.add(article);
        }
        return list;
    }
}
