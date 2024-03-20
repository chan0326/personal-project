package com.erichgamma.api.menber;

import com.erichgamma.api.enums.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public Map<String,?>login(@RequestBody Map<?,?> paramap){
        Map<String,String> resQMap = new HashMap<>();
        String UserName = (String)paramap.get("UserName");
        String PassWord = (String)paramap.get("PassWord");
        resQMap.put("UserName",UserName);
        resQMap.put("PassWord",PassWord);
        System.out.println("리퀘스트가 가져온 id,pw"+UserName+PassWord);
        return resQMap;
    }
    public  List<?> findUsers() throws SQLException {
        return userService.findUsers();
    }

    public String addUsers() {
        return userService.addUsers();
    }

    public Message join(Scanner sc) {
        System.out.println("ID, " +
                "비밀번호, " +
                "비밀번호 확인, " +
                "이름, " +
                "전화번호, " +
                "주소, " +
                "직업을 입력해주세요");
        return null;
    }

    public String login(Scanner sc) {
        System.out.println("ID를 입력하세요");
        System.out.println("PW를 입력하세요");
        return userService.login(Member.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }

    public Optional<Member> findUserById(Scanner sc) {
        System.out.println("검색할 ID를 입력하세요");
        return null;
    }

    public String updatePassword(Scanner sc) {
        System.out.println(" ID를 입력하세요");
        System.out.println("수정할 PW를 입력하세요");
        return userService.updatePassword(Member.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }

    public String deleteUser(Scanner sc) {
        System.out.println("삭제할 ID를 입력하세요");
        return null;
    }

    public List<?> findAll() {
        System.out.println("전체 목록 출력");
        return null;
    }

    public  List<?> findUsersByName(Scanner sc) {
        System.out.println("찾을 Name을 입력하세요");
        return userService.findUsersByName(sc.next());
    }

    public List<?> findUsersByJob(Scanner sc) {
        System.out.println("찾을 job을 입력하세요");
        return  userService.findUsersByJob(sc.next());
    }

    public String countUsers() {
        return null;
    }

    public Map<String, ?> getUserMap() {
        return userService.getUserMap();
    }


    public String test() {
        return userService.test();
    }

    public Map<String,?> findUser(Scanner sc) {
        return userService.findUser();
    }

    public String creatTable() throws SQLException {
        return userService.creatTable();

    }

    public String deleteTable() throws SQLException {
        return userService.deleteTable();

    }

    public Message tableadd(Scanner sc) throws SQLException {
        System.out.println("username, " +
                "비밀번호, " +
                "비밀번호 확인, " +
                "이름, " +
                "전화번호, " +
                "주소, " +
                "직업을 입력해주세요");
        userService.tableadd();
        return  null;

    }
}
