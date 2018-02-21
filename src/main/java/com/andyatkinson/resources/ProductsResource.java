package com.andyatkinson.resources;

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
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Integer id) {

        final Product product = this.productDAO.findById(id);

        return Response.ok().
                type(MediaType.APPLICATION_JSON_TYPE).
                entity(product).
                build();
    }

}
