package com.jo0oy.jcafeorder.menu.adapter.out.persistence;

import com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity.MenuOptionGroupJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuOptionGroupSpringDataRepository
    extends JpaRepository<MenuOptionGroupJpaEntity, Long> {

    List<MenuOptionGroupJpaEntity> findByMenuId(Long menuId);
}
