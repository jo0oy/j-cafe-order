package com.jo0oy.jcafeorder.user.application.port.in.usecase;

import com.jo0oy.jcafeorder.user.application.port.in.dto.RegisterUserCommand;
import com.jo0oy.jcafeorder.user.domain.User;

public interface RegisterUserUseCase {
    User register(RegisterUserCommand command);
}
