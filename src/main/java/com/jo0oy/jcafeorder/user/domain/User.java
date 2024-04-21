package com.jo0oy.jcafeorder.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class User {

    private Long id;
    private String username;
    private String password;
    private String phoneNumber;

    @Builder
    private User(
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
