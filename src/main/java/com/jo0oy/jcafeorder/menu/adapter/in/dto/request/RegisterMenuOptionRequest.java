package com.jo0oy.jcafeorder.menu.adapter.in.dto.request;

import com.jo0oy.jcafeorder.menu.application.in.command.RegisterMenuOptionCommand;

public record RegisterMenuOptionRequest(
    String menuOptionName,
    Integer menuOptionPrice,
    Integer ordering,
    Long menuOptionGroupId
) {

    public RegisterMenuOptionCommand toCommand() {
        return RegisterMenuOptionCommand.builder()
            .menuOptionName(this.menuOptionName)
            .menuOptionPrice(this.menuOptionPrice)
            .ordering(this.ordering)
            .menuOptionGroupId(this.menuOptionGroupId)
            .build();
    }
}
