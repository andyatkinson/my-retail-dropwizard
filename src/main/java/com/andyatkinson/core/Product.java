package com.andyatkinson.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class Product {
    private Integer id;
    private Integer externalId;
    private HashMap priceDetails;
    private String name;

    public Product(Integer id, Integer externalId, HashMap priceDetails) {
        this.id = id;
        this.externalId = externalId;
        this.priceDetails = priceDetails;
    }

    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public Integer getExternalId() {
        return externalId;
    }

    @JsonProperty("current_price")
    public HashMap getPriceDetails() {
        return priceDetails;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
