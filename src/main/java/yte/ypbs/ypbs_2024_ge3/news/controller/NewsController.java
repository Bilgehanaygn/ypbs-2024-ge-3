package yte.ypbs.ypbs_2024_ge3.news.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.ypbs.ypbs_2024_ge3.news.entitiy.NewsDTO;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {

    @GetMapping("/news")
    public List<NewsDTO> getNews() {
        NewsDTO news1 = new NewsDTO();
        news1.setBackgroundImage("https://picsum.photos/id/1018/800/400");
        news1.setContent("Bu, ilk haberin içeriğidir. Doğa ile ilgili önemli bir haber.");

        NewsDTO news2 = new NewsDTO();
        news2.setBackgroundImage("https://picsum.photos/id/1025/800/400");
        news2.setContent("Bu, ikinci haberin içeriğidir. Şehir hayatı ve güncel olaylar hakkında bilgi verir.");

        return Arrays.asList(news1, news2);
    }
}
