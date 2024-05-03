package com.jo0oy.jcafeorder.menu.application.out.port;

import com.jo0oy.jcafeorder.menu.domain.MenuOption;

import java.util.List;

public interface LoadMenuOptionPort {
    List<MenuOption> getMenuOptionsInMenuOptionGroupIds(List<Long> menuOptionGroupIds);
}
