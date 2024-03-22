package com.erichgamma.api.user;

import java.util.HashMap;
import java.util.Map;

import com.erichgamma.api.enums.Messenger;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final UserService userservice;
    private final UserRepository userRepository;
    @PostMapping(path = "/api/users")
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
    @PostMapping("/api/login")
    public Map<String, ?> login(@RequestBody Map<String, ?> reqMap){
        Map<String, String> resMap = new HashMap<>();
        String username = (String)reqMap.get("username"), pw = (String)reqMap.get("pw");
        System.out.println("Request : " + username + ", " + pw);
        resMap.put("username", username);
        resMap.put("pw", pw);
        resMap.put("login", "success");
        return resMap;
    }

}
