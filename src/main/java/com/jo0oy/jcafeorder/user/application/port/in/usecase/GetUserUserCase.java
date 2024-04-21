package com.jo0oy.jcafeorder.user.application.port.in.usecase;

import com.jo0oy.jcafeorder.user.domain.User;


public interface GetUserUserCase {
    User getUser(Long userId);
}
