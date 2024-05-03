package com.jo0oy.jcafeorder.menu.adapter.in.web;

import com.jo0oy.jcafeorder.global.api.Api;
import com.jo0oy.jcafeorder.menu.adapter.in.dto.request.RegisterMenuRequest;
import com.jo0oy.jcafeorder.menu.application.in.usecase.RegisterMenuUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/menus")
@RestController
public class RegisterMenuApiController {

    private final RegisterMenuUseCase registerMenuUseCase;

    @PostMapping("")
    public ResponseEntity<Api<?>> registerMenu(
        @Valid @RequestBody RegisterMenuRequest request
    ) {

        var data = registerMenuUseCase.register(request.toCommand());

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                Api.OK()
            );
    }
}
