package kr.co.sboard.controller.article;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.service.ArticleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Log4j2
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/list")
    public String list(Model model, String cate, @RequestParam(defaultValue = "1") int pg){
        Page<ArticleEntity> pageArticle = articleService.findByParent(pg);
        model.addAttribute("pageArticle", pageArticle);
        return "/article/list";
    }

    @GetMapping("/article/register")
    public String register(){
        return "/article/register";
    }

    @PostMapping("/article/register")
    public String register(HttpServletRequest request, ArticleDTO dto){

        log.info(dto);

        dto.setRegip(request.getRemoteAddr());

        log.info(dto);

        articleService.save(dto);
        return "redirect:/article/list";
    }
}
