package com.jo0oy.jcafeorder.menu.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MenuOption {

    private Long id;
    private String menuOptionName;
    private Integer menuOptionPrice;
    private Integer ordering;
    private Long menuOptionGroupId;

    @Builder
    private MenuOption(
        Long id,
        String menuOptionName,
        Integer menuOptionPrice,
        Integer ordering,
        Long menuOptionGroupId
    ) {
        this.id = id;
        this.menuOptionName = menuOptionName;
        this.menuOptionPrice = menuOptionPrice;
        this.ordering = ordering;
        this.menuOptionGroupId = menuOptionGroupId;
    }
}
