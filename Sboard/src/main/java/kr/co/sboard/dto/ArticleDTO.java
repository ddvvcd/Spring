package kr.co.sboard.dto;

import kr.co.sboard.entity.ArticleEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private MultipartFile fname;
    private int hit;
    private String writer;
    private String regip;
    private LocalDateTime rdate;

    public ArticleEntity toEntity(){
        return ArticleEntity.builder()
                .no(no)
                .parent(parent)
                .comment(comment)
                .cate(cate)
                .title(title)
                .content(content)
                .hit(hit)
                .writer(writer)
                .regip(regip)
                .rdate(rdate)
                .build();
    }

}
