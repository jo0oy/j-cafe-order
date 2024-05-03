package com.jo0oy.jcafeorder.menu.adapter.out.persistence;

import com.jo0oy.jcafeorder.global.error.MenuErrorCode;
import com.jo0oy.jcafeorder.global.exception.ApiException;
import com.jo0oy.jcafeorder.menu.application.out.port.*;
import com.jo0oy.jcafeorder.menu.domain.Menu;
import com.jo0oy.jcafeorder.menu.domain.MenuOption;
import com.jo0oy.jcafeorder.menu.domain.MenuOptionGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MenuPersistenceAdapter
    implements SaveMenuPort, SaveMenuOptionGroupPort, SaveMenuOptionPort,
    LoadMenuPort, LoadMenuOptionGroupPort, LoadMenuOptionPort {

    private final MenuSpringDataRepository menuSpringDataRepository;
    private final MenuOptionGroupSpringDataRepository menuOptionGroupSpringDataRepository;
    private final MenuOptionSpringDataRepository menuOptionSpringDataRepository;
    private final MenuEntityMapper menuEntityMapper;

    @Override
    public Menu save(Menu menu) {
        var menuJpaEntity = menuEntityMapper.toJpaEntity(menu);
        var savedMenu = menuSpringDataRepository.save(menuJpaEntity);

        return menuEntityMapper.toDomainEntity(savedMenu);
    }

    @Override
    public MenuOptionGroup save(MenuOptionGroup menuOptionGroup) {

        var menuJpaEntity = menuSpringDataRepository.findById(menuOptionGroup.getMenuId())
            .orElseThrow(() -> new ApiException(MenuErrorCode.MENU_NOT_FOUND));

        var menuOptionGroupJpaEntity = menuEntityMapper.toJpaEntity(menuOptionGroup, menuJpaEntity);
        var savedMenuOptionGroup = menuOptionGroupSpringDataRepository.save(menuOptionGroupJpaEntity);

        return menuEntityMapper.toDomainEntity(savedMenuOptionGroup);
    }

    @Override
    public void save(MenuOption menuOption) {
        var menuOptionGroupJpaEntity = menuOptionGroupSpringDataRepository
            .findById(menuOption.getMenuOptionGroupId())
            .orElseThrow(() -> new ApiException(MenuErrorCode.MENU_OPTION_GROUP_NOT_FOUND));

        var menuOptionJpaEntity = menuEntityMapper.toJpaEntity(menuOption, menuOptionGroupJpaEntity);

        menuOptionSpringDataRepository.save(menuOptionJpaEntity);
    }

    @Override
    public Menu getMenu(Long menuId) {
        var menuJpaEntity = menuSpringDataRepository.findById(menuId)
            .orElseThrow(() -> new ApiException(MenuErrorCode.MENU_NOT_FOUND));

        return menuEntityMapper.toDomainEntity(menuJpaEntity);
    }

    @Override
    public List<Menu> getMenuList() {
        return menuSpringDataRepository.findAll()
            .stream()
            .map(menuEntityMapper::toDomainEntity)
            .toList();
    }

    @Override
    public List<MenuOptionGroup> getMenuOptionGroupsByMenuId(Long menuId) {
        var menuOptionGroups = menuOptionGroupSpringDataRepository.findByMenuId(menuId);

        return menuOptionGroups.stream()
            .map(menuEntityMapper::toDomainEntity)
            .toList();
    }

    @Override
    public List<MenuOption> getMenuOptionsInMenuOptionGroupIds(List<Long> menuOptionGroupIds) {
        var menuOptions = menuOptionSpringDataRepository.findByMenuOptionGroupIdIn(menuOptionGroupIds);

        return menuOptions.stream()
            .map(menuEntityMapper::toDomainEntity)
            .toList();
    }
}
