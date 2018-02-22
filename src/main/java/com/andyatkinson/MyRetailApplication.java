package com.andyatkinson;

import com.andyatkinson.jdbi.dao.ProductDAO;
import com.andyatkinson.resources.ProductsResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class MyRetailApplication extends Application<MyRetailConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MyRetailApplication().run(args);
    }

    @Override
    public String getName() {
        return "MyRetail";
    }

    @Override
    public void initialize(final Bootstrap<MyRetailConfiguration> bootstrap) {
    }

    @Override
    public void run(final MyRetailConfiguration configuration,
                    final Environment environment) {

        //create database connection
        final DBIFactory factory = new DBIFactory();
        final DataSourceFactory dataSourceFactory = configuration.getDataSourceFactory();
        final DBI jdbi = factory.build(environment, dataSourceFactory, "postgresql");

        //add resources
        final ProductDAO productDAO = jdbi.onDemand(ProductDAO.class);

        final ProductsResource productsResource = new ProductsResource(productDAO);
        environment.jersey().register(productsResource);
    }

}
