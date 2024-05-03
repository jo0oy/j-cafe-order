package com.jo0oy.jcafeorder.menu.adapter.in.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MenuOptionResponse(
    Long menuOptionId,
    String menuOptionName,
    Integer menuOptionPrice,
    Integer ordering,
    Long menuOptionGroupId
) {
}
