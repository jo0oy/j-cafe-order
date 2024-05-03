package com.jo0oy.jcafeorder.menu.application.out.port;

import com.jo0oy.jcafeorder.menu.domain.MenuOptionGroup;

import java.util.List;

public interface LoadMenuOptionGroupPort {
    List<MenuOptionGroup> getMenuOptionGroupsByMenuId(Long menuId);
}
