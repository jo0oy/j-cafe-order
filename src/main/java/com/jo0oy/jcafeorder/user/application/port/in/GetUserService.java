package com.jo0oy.jcafeorder.user.application.port.in;

import com.jo0oy.jcafeorder.user.application.port.in.usecase.GetUserUserCase;
import com.jo0oy.jcafeorder.user.application.port.out.LoadUserPort;
import com.jo0oy.jcafeorder.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetUserService implements GetUserUserCase {

    private final LoadUserPort loadUserPort;

    @Override
    public User getUser(Long userId) {
        return loadUserPort.loadUser(userId);
    }
}
