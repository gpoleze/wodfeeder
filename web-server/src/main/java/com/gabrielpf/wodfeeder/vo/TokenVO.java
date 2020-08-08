package com.gabrielpf.wodfeeder.vo;

public class TokenVO {
    private final String token;
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
