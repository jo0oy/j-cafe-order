package com.jo0oy.jcafeorder.menu.application.in.command;

import com.jo0oy.jcafeorder.menu.domain.Menu;
import lombok.Builder;

import java.util.List;

@Builder
public record RegisterMenuCommand(
    String menuName,
    Integer menuPrice,
    String description,
    List<RegisterMenuOptionGroupCommand> menuOptionGroups
) {

    public Menu toEntity() {
        return Menu.builder()
            .menuName(this.menuName)
            .menuPrice(this.menuPrice)
            .description(this.description)
            .build();
    }
}
