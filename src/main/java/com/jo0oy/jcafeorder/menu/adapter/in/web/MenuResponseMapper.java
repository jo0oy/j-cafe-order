package com.jo0oy.jcafeorder.menu.adapter.in.web;

import com.jo0oy.jcafeorder.menu.adapter.in.dto.response.MenuOptionGroupResponse;
import com.jo0oy.jcafeorder.menu.adapter.in.dto.response.MenuOptionResponse;
import com.jo0oy.jcafeorder.menu.adapter.in.dto.response.MenuResponse;
import com.jo0oy.jcafeorder.menu.domain.Menu;
import com.jo0oy.jcafeorder.menu.domain.MenuOption;
import com.jo0oy.jcafeorder.menu.domain.MenuOptionGroup;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MenuResponseMapper {

    public MenuResponse toResponse(Menu menu) {
        return MenuResponse.builder()
            .menuId(menu.getId())
            .menuName(menu.getMenuName())
            .menuPrice(menu.getMenuPrice())
            .description(menu.getDescription())
            .menuOptionGroups(
                Objects.nonNull(menu.getMenuOptionGroups()) ?
                    menu.getMenuOptionGroups().stream().map(this::toResponse).toList() : null
            )
            .build();
    }

    public MenuOptionGroupResponse toResponse(MenuOptionGroup menuOptionGroup) {
        return MenuOptionGroupResponse.builder()
            .menuOptionGroupId(menuOptionGroup.getId())
            .menuOptionGroupName(menuOptionGroup.getMenuOptionGroupName())
            .ordering(menuOptionGroup.getOrdering())
            .menuId(menuOptionGroup.getMenuId())
            .menuOptions(
                Objects.nonNull(menuOptionGroup.getMenuOptions()) ?
                    menuOptionGroup.getMenuOptions().stream().map(this::toResponse).toList() : null
            )
            .build();
    }

    public MenuOptionResponse toResponse(MenuOption menuOption) {
        return MenuOptionResponse.builder()
            .menuOptionGroupId(menuOption.getId())
            .menuOptionName(menuOption.getMenuOptionName())
            .menuOptionPrice(menuOption.getMenuOptionPrice())
            .ordering(menuOption.getOrdering())
            .menuOptionGroupId(menuOption.getMenuOptionGroupId())
            .build();
    }
}
