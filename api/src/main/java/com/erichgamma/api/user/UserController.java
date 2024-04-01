package com.erichgamma.api.user;

import java.sql.SQLException;
import java.util.*;

import com.erichgamma.api.enums.Messenger;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;


@RestController  //controller + ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userservice;
    private final UserRepository userRepository;


    @SuppressWarnings("unchecked")
    @GetMapping("/api/users/all-users")
    public Map<?,?>findAll() throws SQLException {
        System.out.println("java 실행");
        Map<String,Object> map = new HashMap<>();
        map.put("message",Messenger.SUCCESS);
        List<User> list = new ArrayList<>();
        list = userservice.findAll();
        list.forEach(System.out::println);
        System.out.println("리스트 사이즈: "+ list.size());
        map.put("result",list);
        System.out.println("자바 실행 마무리");
        return map;
    }

    @PostMapping(path = "/api/users/join")
    public Map<String,?> join(@RequestBody Map<String,?> reMap){
        String serHeight = String.valueOf(reMap.get("height"));
        String serWeight = String.valueOf(reMap.get("weight"));

        User newUser = userRepository.save(
        User.builder().username((String) reMap.get("username"))
                .height(Double.parseDouble(serHeight))
                .weight(Double.parseDouble(serWeight))
                .job((String) reMap.get("job"))
                .phone((String) reMap.get("phone"))
                .name((String) reMap.get("name"))
                .password((String) reMap.get("password"))
                .build());
        System.out.println("DB에 저장된 user 정보:"+newUser);
        Map<String, Messenger> map =new HashMap<>();
        map.put(("result"),Messenger.SUCCESS);


        return map;
    }
    @PostMapping("/api/users/login")
    public Map<String, ?> login(@RequestBody Map<String, ?> reqMap){
        Map<String, Messenger> resMap = new HashMap<>();
        User optuser =userRepository.findByUsername((String) reqMap.get("username")).orElse(null); //DB정보
        String PW = (String) reqMap.get("password"); // 리엑트에서 입력한 값
        if (optuser == null){
            System.out.println("ID Error");
            System.out.println(Messenger.FAIL);
            resMap.put("message",Messenger.FAIL);
        }else if (!optuser.getPassword().equals(PW)){
            System.out.println("Password Error");
            System.out.println(Messenger.WRONG_PASSWORD);
            resMap.put("message",Messenger.WRONG_PASSWORD);
        }
        else {
            System.out.println("login success");
            System.out.println(Messenger.SUCCESS);
            resMap.put("message",Messenger.SUCCESS);
        }
        return resMap;
    }

}
