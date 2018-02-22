package com.andyatkinson.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class Product {
    private Integer id;
    private Integer externalId;
    private HashMap priceDetails;

    public Product(Integer id, Integer externalId, HashMap priceDetails) {
        this.id = id;
        this.externalId = externalId;
        this.priceDetails = priceDetails;
    }

    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public Integer getExternalId() {
        return externalId;
    }

    @JsonProperty
    public HashMap getPriceDetails() {
        return priceDetails;
    }
}
