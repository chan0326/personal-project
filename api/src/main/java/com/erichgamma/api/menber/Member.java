package com.erichgamma.api.menber;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Member {

    private Long id;

    private String password;

    private String pwAgain;

    private String name;

    private String Username;

    private String phone;

    private Long adressId;

    private String job;

    private double height;

    private double weight;
@Builder(builderMethodName = "builder")

    public Member(Long id, String password, String pwAgain, String name, String username, String phone, String job, double height, double weight) {
        this.id = id;
        this.password = password;
        this.pwAgain = pwAgain;
        this.name = name;
        this.Username = username;
        this.phone = phone;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {

    }
}
