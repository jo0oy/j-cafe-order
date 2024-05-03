package com.jo0oy.jcafeorder.menu.adapter.out.persistence.jpaentity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menu_option")
@Entity
public class MenuOptionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String menuOptionName;

    private Integer menuOptionPrice;

    private Integer ordering;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_option_group_id")
    private MenuOptionGroupJpaEntity menuOptionGroup;

    @Builder
    private MenuOptionJpaEntity(
        Long id,
        String menuOptionName,
        Integer menuOptionPrice,
        Integer ordering,
        MenuOptionGroupJpaEntity menuOptionGroup
    ) {
        this.id = id;
        this.menuOptionName = menuOptionName;
        this.menuOptionPrice = menuOptionPrice;
        this.ordering = ordering;
        this.menuOptionGroup = menuOptionGroup;
    }
}
