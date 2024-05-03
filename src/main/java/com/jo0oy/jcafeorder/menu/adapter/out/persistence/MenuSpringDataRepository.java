package com.jo0oy.jcafeorder.menu.adapter.out.persistence;

import com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity.MenuJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuSpringDataRepository extends JpaRepository<MenuJpaEntity, Long> {
}
