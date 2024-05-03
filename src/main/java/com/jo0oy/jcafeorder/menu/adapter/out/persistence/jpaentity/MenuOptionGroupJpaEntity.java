package com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menu_option_group")
@Entity
public class MenuOptionGroupJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String menuOptionGroupName;

    private Integer ordering;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id")
    private MenuJpaEntity menu;

    @Builder
    private MenuOptionGroupJpaEntity(
        Long id,
        String menuOptionGroupName,
        Integer ordering,
        MenuJpaEntity menu
    ) {
        this.id = id;
        this.menuOptionGroupName = menuOptionGroupName;
        this.ordering = ordering;
        this.menu = menu;
    }
}
