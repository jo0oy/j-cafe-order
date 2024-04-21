package com.jo0oy.jcafeorder.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpringDataRepository extends JpaRepository<UserJpaEntity, Long> {
}
