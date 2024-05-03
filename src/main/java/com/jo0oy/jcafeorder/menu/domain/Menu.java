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
public class Menu {

    private Long id;
    private String menuName;
    private Integer menuPrice;
    private String description;
    private List<MenuOptionGroup> menuOptionGroups;

    @Builder
    private Menu(
        Long id,
        String menuName,
        Integer menuPrice,
        String description,
        List<MenuOptionGroup> menuOptionGroups
    ) {
        this.id = id;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.description = description;

        if (Objects.nonNull(menuOptionGroups)) {
            checkInitializeList();
            this.addMenuOptionGroups(menuOptionGroups);
        }
    }

    public void addMenuOptionGroup(MenuOptionGroup menuOptionGroup) {
        checkInitializeList();
        this.menuOptionGroups.add(menuOptionGroup);
    }

    public void addMenuOptionGroups(List<MenuOptionGroup> menuOptionGroups) {
        checkInitializeList();
        this.menuOptionGroups.addAll(menuOptionGroups);
    }

    private void checkInitializeList() {
        if (Objects.isNull(this.menuOptionGroups)) {
            this.menuOptionGroups = new ArrayList<>();
        }
    }
}
