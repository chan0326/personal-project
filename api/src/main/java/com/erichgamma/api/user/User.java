package com.erichgamma.api.user;

import java.util.List;

import com.erichgamma.api.order.Order;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "users")
@ToString(exclude = "id")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Order> ordersId;

    private Long addressId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String job;
    private Double height;
    private Double weight;

    @Builder(builderMethodName = "builder")
    public User(Long id, String password,  String name, String username, String phone,  String job, double height, double weight){
        this.id = id;
        this.password = password;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }




}

