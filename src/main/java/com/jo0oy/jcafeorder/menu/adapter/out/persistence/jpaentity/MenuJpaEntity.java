package com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menu")
@Entity
public class MenuJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String menuName;

    private Integer menuPrice;

    @Column(length = 150)
    private String description;

    @Builder
    private MenuJpaEntity(
        Long id,
        String menuName,
        Integer menuPrice,
        String description
    ) {
        this.id = id;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.description = description;
    }
}
