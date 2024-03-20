package com.erichgamma.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "welcome to spring boot-9 !";
    }
    @PostMapping("/name")
    public Map<String,?> name(@RequestBody Map<String,?> map){
        String name = (String)map.get("name");
        System.out.println("리퀘스트가  가져온 이름 : "+name);
        Map<String,String> respMap = new HashMap<>();
        respMap.put("name",name);
        return respMap;
    }




    
}
