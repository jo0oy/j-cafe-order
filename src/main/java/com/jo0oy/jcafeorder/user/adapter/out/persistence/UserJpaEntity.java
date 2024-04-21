package com.jo0oy.jcafeorder.user.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@Entity
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String username;

    @Column(length = 150, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String phoneNumber;

    @Builder
    private UserJpaEntity(
        Long id,
        String username,
        String password,
        String phoneNumber
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
