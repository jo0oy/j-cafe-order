package com.jo0oy.jcafeorder.menu.application.in;

import com.jo0oy.jcafeorder.menu.application.in.command.RegisterMenuCommand;
import com.jo0oy.jcafeorder.menu.application.in.usecase.RegisterMenuUseCase;
import com.jo0oy.jcafeorder.menu.application.out.port.SaveMenuOptionGroupPort;
import com.jo0oy.jcafeorder.menu.application.out.port.SaveMenuOptionPort;
import com.jo0oy.jcafeorder.menu.application.out.port.SaveMenuPort;
import com.jo0oy.jcafeorder.menu.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@RequiredArgsConstructor
@Service
public class RegisterMenuService implements RegisterMenuUseCase {

    private final SaveMenuPort saveMenuPort;
    private final SaveMenuOptionGroupPort saveMenuOptionGroupPort;
    private final SaveMenuOptionPort saveMenuOptionPort;

    @Transactional
    @Override
    public Menu register(RegisterMenuCommand command) {
        // menu 저장
        var menu = saveMenuPort.save(command.toEntity());

        // menuOptionGroup 저장
        if(!CollectionUtils.isEmpty(command.menuOptionGroups())) {
            command.menuOptionGroups()
                .forEach(menuOptionGroupCommand -> {
                    var menuOptionGroup = saveMenuOptionGroupPort.save(menuOptionGroupCommand.toEntity(menu.getId()));

                    // menuOption 저장
                    if (!CollectionUtils.isEmpty(menuOptionGroupCommand.menuOptions())) {
                        menuOptionGroupCommand.menuOptions()
                            .forEach(menuOptionCommand -> {
                                saveMenuOptionPort.save(menuOptionCommand.toEntity(menuOptionGroup.getId()));
                            });
                    }
                });
        }

        return menu;
    }
}
