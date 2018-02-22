package com.andyatkinson.jdbi.dao;


import com.andyatkinson.core.Product;
import com.andyatkinson.jdbi.mappers.ProductMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ProductMapper.class)
public interface ProductDAO {

    @SqlQuery("SELECT * FROM products where external_id = :externalId")
    Product findByExternalId(@Bind("externalId") Integer externalId);
}
