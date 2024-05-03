package com.jo0oy.jcafeorder.menu.adapter.in.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record MenuResponse(
    Long menuId,
    String menuName,
    Integer menuPrice,
    String description,
    List<MenuOptionGroupResponse> menuOptionGroups
) {
}
