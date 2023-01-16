package com.sample.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum User {
    STANDARD("standard_user", "secret_sauce"),
    LOCKED("locked_out_user", "secret_sauce"),
    INVALID("invalid_user", "secret_sauce");

    private final String username;
    private final String password;
}
