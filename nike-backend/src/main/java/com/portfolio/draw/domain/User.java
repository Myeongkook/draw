package com.portfolio.draw.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long userId;
    private String id;
    private String pw;
    private String name;
    private String salt;
    private String phone;

    @CreationTimestamp
    @Column(name = "signin_timestamp")
    private LocalDateTime createTimestamp;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "is_subscribed")
    private Boolean isSubscribed;
}
