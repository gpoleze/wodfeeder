package com.gabrielpf.wodfeeder.vo;

import javax.validation.constraints.NotBlank;

public class TokenVO {

    @NotBlank
    private final String token;

    @NotBlank
    private final String type;

    public TokenVO(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
