package com.jo0oy.jcafeorder.user.adapter.out.persistence;

import com.jo0oy.jcafeorder.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserJpaEntity toJpaEntity(User user) {
        return UserJpaEntity.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .phoneNumber(user.getPhoneNumber())
            .build();
    }

    public User toDomainEntity(UserJpaEntity jpaEntity) {
        return User.builder()
            .id(jpaEntity.getId())
            .username(jpaEntity.getUsername())
            .password(jpaEntity.getPassword())
            .phoneNumber(jpaEntity.getPhoneNumber())
            .build();
    }
}
