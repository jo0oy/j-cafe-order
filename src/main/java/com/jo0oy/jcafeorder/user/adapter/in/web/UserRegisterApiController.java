package com.jo0oy.jcafeorder.user.adapter.in.web;

import com.jo0oy.jcafeorder.global.api.Api;
import com.jo0oy.jcafeorder.user.adapter.in.dto.request.RegisterUserRequest;
import com.jo0oy.jcafeorder.user.application.port.in.usecase.RegisterUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserRegisterApiController {

    private final RegisterUserUseCase registerUserUseCase;
    private final UserResponseMapper userResponseMapper;

    @PostMapping("")
    public ResponseEntity<Api<?>> registerUser(
        @Valid @RequestBody RegisterUserRequest request
    ) {
        var response = userResponseMapper.toUserResponse(
            registerUserUseCase.register(request.toCommand())
        );

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                Api.OK(response)
            );
    }
}
