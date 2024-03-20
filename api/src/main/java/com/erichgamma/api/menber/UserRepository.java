package com.erichgamma.api.menber;

import com.erichgamma.api.enums.Message;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private PreparedStatement pstmt ;
    private ResultSet rs;
    private Connection connection;

    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        List<Member> ls = new ArrayList<>();
        String sql = "select * from users";
        System.out.println("sql : " + sql);
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(Member.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .username(rs.getString("username"))
                        .phone(rs.getString("phone"))
                        .password(rs.getString("password"))
                        .job(rs.getString("job"))
                        .build());

            } while (rs.next());

        } else {
            System.out.println("데이터가 없습니다.");
        }
        return ls;
    }

    public String creatTable() throws SQLException {
        int result;

        String sql = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(20),"
                + " password varchar(20) , name VARCHAR(20),phone VARCHAR(20),height VARCHAR(20)," +
                "weight VARCHAR(20),job VARCHAR(20))";


        pstmt = connection.prepareStatement(sql);
        result =pstmt.executeUpdate();
        return (result >=0)?"성공" :"실패" ;
        // retrun (ex ==0) ? "succes" : "Fail"; 삼항 연산자.
    }

    public String deleteTable() throws SQLException {
        try {
            String sql = "Drop table users";
            pstmt = connection.prepareStatement(sql);
            int result = pstmt.executeUpdate(sql);
            System.out.println("데이터 삭제 성공!"+result);
        } catch(Exception e) {
            System.out.println("데이터 삭제 실패 이유 : " + e);
        }

        return "테이블 삭제 성공";
    }

    public Message tableadd() throws SQLException {
        Member member = new Member();
        int result = 0;
        String sql = "INSERT INTO users(username, password) VALUES(?,?)";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,member.getUsername());
        pstmt.setString(2,member.getPassword());
        result = pstmt.executeUpdate();

        System.out.println((result >0)?Message.SUCCESS:Message.FAIL);

        return (result >0)?Message.SUCCESS:Message.FAIL;




    }

}
