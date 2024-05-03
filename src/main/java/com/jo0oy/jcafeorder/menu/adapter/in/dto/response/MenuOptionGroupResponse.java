package com.jo0oy.jcafeorder.menu.adapter.in.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MenuOptionGroupResponse(
    Long menuOptionGroupId,
    String menuOptionGroupName,
    Integer ordering,
    Long menuId,
    List<MenuOptionResponse> menuOptions
) {
}
