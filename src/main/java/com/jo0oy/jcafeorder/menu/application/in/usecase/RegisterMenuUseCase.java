package com.jo0oy.jcafeorder.menu.application.in.usecase;

import com.jo0oy.jcafeorder.menu.application.in.command.RegisterMenuCommand;
import com.jo0oy.jcafeorder.menu.domain.Menu;

public interface RegisterMenuUseCase {

    Menu register(RegisterMenuCommand command);
}
