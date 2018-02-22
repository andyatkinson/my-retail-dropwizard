package com.andyatkinson.resources;

import com.andyatkinson.client.RedSkyClient;
import com.andyatkinson.client.RedSkyProduct;
import com.andyatkinson.core.Product;
import com.andyatkinson.jdbi.dao.ProductDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductsResource {

    private ProductDAO productDAO;

    public ProductsResource(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GET
    @Path("/{external_id}")
    public Response getProduct(@PathParam("external_id") Integer externalId) {


        RedSkyProduct redSkyProduct = new RedSkyClient().getRedSkyProduct();

        Product product = this.productDAO.findByExternalId(externalId);
        product.setName(redSkyProduct.getTitle());

        return Response.ok().
                type(MediaType.APPLICATION_JSON_TYPE).
                entity(product).
                build();
    }

}
