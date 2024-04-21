package com.jo0oy.jcafeorder.user.application.port.in.dto;

import com.jo0oy.jcafeorder.user.domain.User;
import lombok.Builder;

@Builder
public record RegisterUserCommand(
    String username,
    String password,
    String phoneNumber
) {

    public User toEntity() {
        return User.builder()
            .username(this.username)
            .password(this.password)
            .phoneNumber(this.phoneNumber)
            .build();
    }
}
