package com.jo0oy.jcafeorder.menu.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MenuOptionGroup {

    private Long id;
    private String menuOptionGroupName;
    private Integer ordering;
    private Long menuId;
    private List<MenuOption> menuOptions = new ArrayList<>();

    @Builder
    private MenuOptionGroup(
        Long id,
        String menuOptionGroupName,
        Integer ordering,
        Long menuId,
        List<MenuOption> menuOptions
    ) {
        this.id = id;
        this.menuOptionGroupName = menuOptionGroupName;
        this.ordering = ordering;
        this.menuId = menuId;

        if (Objects.nonNull(menuOptions)) {
            this.addMenuOptions(menuOptions);
        }
    }

    public void addMenuOption(MenuOption menuOption) {
        this.menuOptions.add(menuOption);
    }

    public void addMenuOptions(List<MenuOption> menuOptions) {
        this.menuOptions.addAll(menuOptions);
    }
}
