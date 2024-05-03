package com.jo0oy.jcafeorder.menu.application.in.command;

import com.jo0oy.jcafeorder.menu.domain.MenuOption;
import lombok.Builder;

@Builder
public record RegisterMenuOptionCommand(
    String menuOptionName,
    Integer menuOptionPrice,
    Integer ordering,
    Long menuOptionGroupId
) {

    public MenuOption toEntity() {
        return MenuOption.builder()
            .menuOptionName(this.menuOptionName)
            .menuOptionPrice(this.menuOptionPrice)
            .ordering(this.ordering)
            .menuOptionGroupId(this.menuOptionGroupId)
            .build();
    }

    public MenuOption toEntity(Long menuOptionGroupId) {
        return MenuOption.builder()
            .menuOptionName(this.menuOptionName)
            .menuOptionPrice(this.menuOptionPrice)
            .ordering(this.ordering)
            .menuOptionGroupId(menuOptionGroupId)
            .build();
    }
}
