package com.jo0oy.jcafeorder.user.adapter.in.dto.request;

import com.jo0oy.jcafeorder.user.application.port.in.dto.RegisterUserCommand;

public record RegisterUserRequest(
    String username,
    String password,
    String phoneNumber
) {
    public RegisterUserCommand toCommand() {
        return RegisterUserCommand.builder()
            .username(this.username)
            .password(this.password)
            .phoneNumber(this.phoneNumber)
            .build();
    }
}
