package com.jo0oy.jcafeorder.menu.adapter.out.persistence;

import com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity.MenuOptionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MenuOptionSpringDataRepository
    extends JpaRepository<MenuOptionJpaEntity, Long> {

    List<MenuOptionJpaEntity> findByMenuOptionGroupIdIn(Collection<Long> menuOptionGroup);
}
