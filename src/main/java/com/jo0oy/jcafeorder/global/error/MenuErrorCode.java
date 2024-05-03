package com.jo0oy.jcafeorder.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Menu Error Code 경우, 2000번대 에러코드 사용
 */
@RequiredArgsConstructor
@Getter
public enum MenuErrorCode implements ErrorCodeIfs {

    MENU_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), 3404, "메뉴를 찾을 수 없음."),
    MENU_OPTION_GROUP_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), 3405, "메뉴 옵션 그룹을 찾을 수 없음.");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
