package com.jo0oy.jcafeorder.menu.application.in.usecase;

import com.jo0oy.jcafeorder.menu.domain.Menu;

import java.util.List;

public interface GetMenuUseCase {

    Menu getMenu(Long menuId);

    List<Menu> getMenuList();
}
