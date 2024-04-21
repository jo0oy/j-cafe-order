package com.jo0oy.jcafeorder.user.adapter.in.web;

import com.jo0oy.jcafeorder.global.api.Api;
import com.jo0oy.jcafeorder.user.application.port.in.usecase.GetUserUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserGetApiController {

    private final GetUserUserCase getUserUserCase;
    private final UserResponseMapper userResponseMapper;

    @GetMapping("/{userId}")
    public ResponseEntity<Api<?>> getUser(
        @PathVariable("userId") Long userId
    ) {

        var response = userResponseMapper.toUserResponse(
            getUserUserCase.getUser(userId)
        );

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                Api.OK(response)
            );
    }
}
