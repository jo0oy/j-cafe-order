package com.jo0oy.jcafeorder.menu.adapter.in.dto.request;

import com.jo0oy.jcafeorder.menu.application.in.command.RegisterMenuOptionGroupCommand;
import jakarta.validation.Valid;

import java.util.List;

public record RegisterMenuOptionGroupRequest(
    String menuOptionGroupName,
    Integer ordering,
    Long menuId,
    @Valid
    List<RegisterMenuOptionRequest> menuOptions
) {

    public RegisterMenuOptionGroupCommand toCommand() {
        return RegisterMenuOptionGroupCommand.builder()
            .menuOptionGroupName(this.menuOptionGroupName)
            .ordering(this.ordering)
            .menuId(this.menuId)
            .menuOptions(
                this.menuOptions.stream()
                    .map(RegisterMenuOptionRequest::toCommand)
                    .toList()
            )
            .build();
    }
}
