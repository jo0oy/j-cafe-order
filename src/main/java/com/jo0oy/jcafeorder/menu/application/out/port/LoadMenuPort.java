package com.jo0oy.jcafeorder.menu.application.out.port;

import com.jo0oy.jcafeorder.menu.domain.Menu;

import java.util.List;

public interface LoadMenuPort {
    Menu getMenu(Long menuId);

    List<Menu> getMenuList();
}
