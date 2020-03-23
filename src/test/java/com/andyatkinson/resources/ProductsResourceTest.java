package com.andyatkinson.resources;

import com.google.common.collect.ImmutableMap;

import com.andyatkinson.core.Product;
import com.andyatkinson.jdbi.dao.ProductDAO;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.util.Map;

import javax.ws.rs.core.Response;

import io.dropwizard.testing.junit.ResourceTestRule;

import static org.mockito.Mockito.*;

public class ProductsResourceTest {
    private ProductsResource resource;

    private static final ProductDAO dao = mock(ProductDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
                                                                     .addResource(new ProductsResource(dao))
                                                                     .build();

    final Map<String,Object> priceDetails = ImmutableMap.of("value", 13.49, "currency_code", "USD");
    private final       Product product = new Product(1, 15117729, priceDetails);

    @Before
    public void setup() {
        when(dao.findByExternalId(eq(15117729))).thenReturn(product);
    }

    @Test
    public void testGetProduct() {
        final Response response = resources.client().target("/products/15117729").request().get();

        final String responseBody = response.readEntity(String.class);

        final String expectedJSON = "{\"id\":15117729,\"name\":\"The Big Lebowski (Blu-ray)\",\"current_price\":{\"value\":13.49,\"currency_code\":\"USD\"}}";

        JSONAssert.assertEquals(expectedJSON, responseBody, JSONCompareMode.LENIENT);
    }
}
