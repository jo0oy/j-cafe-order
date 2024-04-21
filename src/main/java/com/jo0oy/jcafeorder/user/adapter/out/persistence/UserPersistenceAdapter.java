package com.jo0oy.jcafeorder.user.adapter.out.persistence;

import com.jo0oy.jcafeorder.global.error.UserErrorCode;
import com.jo0oy.jcafeorder.global.exception.ApiException;
import com.jo0oy.jcafeorder.user.application.port.out.LoadUserPort;
import com.jo0oy.jcafeorder.user.application.port.out.SaveUserPort;
import com.jo0oy.jcafeorder.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements SaveUserPort, LoadUserPort {

    private final UserSpringDataRepository userSpringDataRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User save(User user) {
        var userJpaEntity = userEntityMapper.toJpaEntity(user);
        var savedUser = userSpringDataRepository.save(userJpaEntity);

        return userEntityMapper.toDomainEntity(savedUser);
    }

    @Override
    public User loadUser(Long userId) {
        var user = userSpringDataRepository.findById(userId)
            .orElseThrow(() -> new ApiException(UserErrorCode.USER_NOT_FOUND));

        return userEntityMapper.toDomainEntity(user);
    }
}
