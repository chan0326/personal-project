package com.erichgamma.api.article;

import java.sql.SQLException;
import java.util.*;

import com.erichgamma.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //controller + ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleServiceImpl articleService;
    private final ArticleRepository repo;

    @SuppressWarnings("unchecked")
    @GetMapping("/api/articles/all-articles")
    public Map <?,?> findAll() throws SQLException {
        Map<String, Object> map = new HashMap<>();
        map.put("message",Messenger.SUCCESS);
        List<Article> list = new ArrayList<>();
        list = articleService.findAll();
        list.forEach(System.out::println);
        System.out.println("리스트 사이즈 : "+list.size());
        map.put("result",list);
        return map;
    }
}
