package com.jo0oy.jcafeorder.menu.adapter.out.persistence;

import com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity.MenuJpaEntity;
import com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity.MenuOptionGroupJpaEntity;
import com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity.MenuOptionJpaEntity;
import com.jo0oy.jcafeorder.menu.domain.Menu;
import com.jo0oy.jcafeorder.menu.domain.MenuOption;
import com.jo0oy.jcafeorder.menu.domain.MenuOptionGroup;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MenuEntityMapper {

    public MenuJpaEntity toJpaEntity(Menu menu) {
        return MenuJpaEntity.builder()
            .id(
                Objects.nonNull(menu.getId()) ? menu.getId() : null
            )
            .menuName(menu.getMenuName())
            .menuPrice(menu.getMenuPrice())
            .description(menu.getDescription())
            .build();
    }

    public MenuOptionGroupJpaEntity toJpaEntity(MenuOptionGroup menuOptionGroup, MenuJpaEntity menu) {
        return MenuOptionGroupJpaEntity.builder()
            .id(
                Objects.nonNull(menuOptionGroup.getId()) ? menuOptionGroup.getId() : null
            )
            .menuOptionGroupName(menuOptionGroup.getMenuOptionGroupName())
            .ordering(menuOptionGroup.getOrdering())
            .menu(menu)
            .build();
    }

    public MenuOptionJpaEntity toJpaEntity(MenuOption menuOption, MenuOptionGroupJpaEntity menuOptionGroup) {
        return MenuOptionJpaEntity.builder()
            .id(
                Objects.nonNull(menuOption.getId()) ? menuOption.getId() : null
            )
            .menuOptionName(menuOption.getMenuOptionName())
            .menuOptionPrice(menuOption.getMenuOptionPrice())
            .ordering(menuOption.getOrdering())
            .menuOptionGroup(menuOptionGroup)
            .build();
    }

    public Menu toDomainEntity(MenuJpaEntity jpaEntity) {
        return Menu.builder()
            .id(jpaEntity.getId())
            .menuName(jpaEntity.getMenuName())
            .menuPrice(jpaEntity.getMenuPrice())
            .description(jpaEntity.getDescription())
            .build();
    }

    public MenuOptionGroup toDomainEntity(MenuOptionGroupJpaEntity jpaEntity) {
        return MenuOptionGroup.builder()
            .id(jpaEntity.getId())
            .menuOptionGroupName(jpaEntity.getMenuOptionGroupName())
            .ordering(jpaEntity.getOrdering())
            .menuId(jpaEntity.getMenu().getId())
            .build();
    }

    public MenuOption toDomainEntity(MenuOptionJpaEntity jpaEntity) {
        return MenuOption.builder()
            .id(jpaEntity.getId())
            .menuOptionName(jpaEntity.getMenuOptionName())
            .menuOptionPrice(jpaEntity.getMenuOptionPrice())
            .ordering(jpaEntity.getOrdering())
            .menuOptionGroupId(jpaEntity.getMenuOptionGroup().getId())
            .build();
    }
}
