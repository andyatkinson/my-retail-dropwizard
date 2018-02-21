package com.andyatkinson.jdbi.mappers;

import com.andyatkinson.core.Product;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements ResultSetMapper<Product> {
    public Product map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Product(r.getInt("id"), r.getInt("external_id"));
    }
}
