package com.oriol.app.data.config;

public record CheckFraudResponse(Boolean isFraudster) {
    public CheckFraudResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
}
