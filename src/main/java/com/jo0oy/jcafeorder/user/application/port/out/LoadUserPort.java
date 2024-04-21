package com.jo0oy.jcafeorder.user.application.port.out;

import com.jo0oy.jcafeorder.user.domain.User;

public interface LoadUserPort {
    User loadUser(Long userId);
}
