package com.gabrielpf.wodfeeder.service;

public enum AuthGroupEnum {
    COMMON("common"), ADMIN("admin");

    private final String name;

    AuthGroupEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
