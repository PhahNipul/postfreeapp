package com.dinsaren.oneposappserverapi.payload.request;

public class TokenRefreshReq {
    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
