package com.andyatkinson.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private Integer id;
    private Integer externalId;

    public Product(Integer id, Integer externalId) {
        this.id = id;
        this.externalId = externalId;
    }

    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public Integer getExternalId() {
        return externalId;
    }
}
