package com.jo0oy.jcafeorder.user.adapter.in.dto.response;

import lombok.Builder;

@Builder
public record UserResponse(
    Long id,
    String username,
    String phoneNumber
) {
}
