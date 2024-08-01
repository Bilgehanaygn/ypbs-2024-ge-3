package yte.ypbs.ypbs_2024_ge3.news.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private String backgroundImage;
    private String content;
    private String header;

}
