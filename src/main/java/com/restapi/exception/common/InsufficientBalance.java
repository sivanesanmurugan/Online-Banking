package com.restapi.exception.common;

import lombok.Getter;

@Getter
public class InsufficientBalance extends RuntimeException {

    public InsufficientBalance() {
        super("Insufficent Ba");
    }
}
