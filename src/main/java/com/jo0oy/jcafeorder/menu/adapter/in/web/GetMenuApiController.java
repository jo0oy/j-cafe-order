package com.jo0oy.jcafeorder.menu.adapter.in.web;

import com.jo0oy.jcafeorder.global.api.Api;
import com.jo0oy.jcafeorder.menu.application.in.usecase.GetMenuUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/menus")
@RestController
public class GetMenuApiController {

    private final GetMenuUseCase getMenuUseCase;
    private final MenuResponseMapper menuResponseMapper;

    @GetMapping("/{menuId}")
    public ResponseEntity<Api<?>> getMenu(
        @PathVariable("menuId") Long menuId
    ) {

        var data = getMenuUseCase.getMenu(menuId);
        var response = menuResponseMapper.toResponse(data);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                Api.OK(response)
            );
    }

    @GetMapping("")
    public ResponseEntity<Api<?>> getMenuList() {

        var data = getMenuUseCase.getMenuList();
        var response = data.stream()
            .map(menuResponseMapper::toResponse)
            .toList();

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                Api.OK(response)
            );
    }
}
