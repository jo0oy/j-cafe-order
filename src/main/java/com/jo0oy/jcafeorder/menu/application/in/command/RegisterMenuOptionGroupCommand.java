package com.jo0oy.jcafeorder.menu.application.in.command;

import com.jo0oy.jcafeorder.menu.domain.MenuOptionGroup;
import lombok.Builder;

import java.util.List;

@Builder
public record RegisterMenuOptionGroupCommand(
    String menuOptionGroupName,
    Integer ordering,
    Long menuId,
    List<RegisterMenuOptionCommand> menuOptions
) {

    public MenuOptionGroup toEntity() {
        return MenuOptionGroup.builder()
            .menuOptionGroupName(this.menuOptionGroupName)
            .ordering(this.ordering)
            .menuId(this.menuId)
            .build();
    }

    public MenuOptionGroup toEntity(Long menuId) {
        return MenuOptionGroup.builder()
            .menuOptionGroupName(this.menuOptionGroupName)
            .ordering(this.ordering)
            .menuId(menuId)
            .build();
    }
}
