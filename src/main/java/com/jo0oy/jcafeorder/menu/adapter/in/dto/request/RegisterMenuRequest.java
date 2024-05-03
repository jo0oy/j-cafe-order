package com.jo0oy.jcafeorder.menu.adapter.in.dto.request;

import com.jo0oy.jcafeorder.menu.application.in.command.RegisterMenuCommand;
import jakarta.validation.Valid;

import java.util.List;

public record RegisterMenuRequest(
    String menuName,
    Integer menuPrice,
    String description,
    @Valid
    List<RegisterMenuOptionGroupRequest> menuOptionGroups
) {

    public RegisterMenuCommand toCommand() {
        return RegisterMenuCommand.builder()
            .menuName(this.menuName)
            .menuPrice(this.menuPrice)
            .description(this.description)
            .menuOptionGroups(
                this.menuOptionGroups.stream()
                    .map(RegisterMenuOptionGroupRequest::toCommand)
                    .toList()
            )
            .build();
    }
}
