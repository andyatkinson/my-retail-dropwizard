package com.andyatkinson.jdbi.mappers;

import com.andyatkinson.core.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ProductMapper implements ResultSetMapper<Product> {
    public Product map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        String priceDetailsJSON = r.getString("price_details");
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap priceDetailsMap = new HashMap();

        try {
            priceDetailsMap = objectMapper.readValue(priceDetailsJSON, HashMap.class);
        } catch (Exception e) {
            System.out.println("error=failed to deserialize product");
        }

        return new Product(
                r.getInt("id"),
                r.getInt("external_id"),
                priceDetailsMap
            );
    }
}
