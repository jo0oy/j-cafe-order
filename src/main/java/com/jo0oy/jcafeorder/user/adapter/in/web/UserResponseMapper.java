package com.jo0oy.jcafeorder.user.adapter.in.web;

import com.jo0oy.jcafeorder.user.adapter.in.dto.response.UserResponse;
import com.jo0oy.jcafeorder.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper {

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .username(user.getUsername())
            .phoneNumber(user.getPhoneNumber())
            .build();
    }
}
