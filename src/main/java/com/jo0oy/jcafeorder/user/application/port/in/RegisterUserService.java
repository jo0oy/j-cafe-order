package com.jo0oy.jcafeorder.user.application.port.in;

import com.jo0oy.jcafeorder.user.application.port.in.dto.RegisterUserCommand;
import com.jo0oy.jcafeorder.user.application.port.in.usecase.RegisterUserUseCase;
import com.jo0oy.jcafeorder.user.application.port.out.SaveUserPort;
import com.jo0oy.jcafeorder.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final SaveUserPort saveUserPort;

    @Transactional
    @Override
    public User register(RegisterUserCommand command) {
        var userEntity = command.toEntity();

        return saveUserPort.save(userEntity);
    }
}
