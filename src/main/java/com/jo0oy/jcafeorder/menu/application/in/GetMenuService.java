package com.jo0oy.jcafeorder.menu.application.in;

import com.jo0oy.jcafeorder.menu.application.in.usecase.GetMenuUseCase;
import com.jo0oy.jcafeorder.menu.application.out.port.LoadMenuOptionGroupPort;
import com.jo0oy.jcafeorder.menu.application.out.port.LoadMenuOptionPort;
import com.jo0oy.jcafeorder.menu.application.out.port.LoadMenuPort;
import com.jo0oy.jcafeorder.menu.domain.Menu;
import com.jo0oy.jcafeorder.menu.domain.MenuOption;
import com.jo0oy.jcafeorder.menu.domain.MenuOptionGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetMenuService implements GetMenuUseCase {

    private final LoadMenuPort loadMenuPort;
    private final LoadMenuOptionGroupPort loadMenuOptionGroupPort;
    private final LoadMenuOptionPort loadMenuOptionPort;

    @Transactional(readOnly = true)
    @Override
    public Menu getMenu(Long menuId) {

        // menu, menuOptionGroup, menuOption 조회
        var menu = loadMenuPort.getMenu(menuId);
        var menuOptionGroups = loadMenuOptionGroupPort.getMenuOptionGroupsByMenuId(menuId);
        var menuOptions = loadMenuOptionPort.getMenuOptionsInMenuOptionGroupIds(
            menuOptionGroups.stream()
                .map(MenuOptionGroup::getId)
                .toList()
        );

        // menuOptionList -> menuOptionGroup id로 그룹핑
        var menuOptionMap = menuOptions.stream()
            .collect(Collectors.groupingBy(MenuOption::getMenuOptionGroupId));

        menuOptionGroups.forEach(
            menuOptionGroup -> {
                var menuOptionList = menuOptionMap.get(menuOptionGroup.getId());
                if(menuOptionList != null) {
                    menuOptionGroup.addMenuOptions(menuOptionList);
                }
            }
        );

        menu.addMenuOptionGroups(menuOptionGroups);

        return menu;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Menu> getMenuList() {
        return loadMenuPort.getMenuList();
    }
}
