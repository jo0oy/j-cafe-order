package com.jo0oy.jcafeorder.global.exception;


import com.jo0oy.jcafeorder.global.error.ErrorCodeIfs;

public interface ApiExceptionIfs {

    ErrorCodeIfs getErrorCodeIfs();
    String getErrorDescription();
}
