package com.andyatkinson.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Product {
    private Integer id;
    private Integer externalId;
    private Map     priceDetails;
    private String  name;

    public Product(final Integer id, final Integer externalId, final Map priceDetails) {
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
    public Map getPriceDetails() {
      return this.priceDetails;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
