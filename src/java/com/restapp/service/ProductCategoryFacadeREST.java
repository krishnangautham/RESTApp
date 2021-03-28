package com.restapp.service;

import com.restapp.entity.ProductCategory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("productcategory")
public class ProductCategoryFacadeREST extends AbstractFacade<ProductCategory> {

    @PersistenceContext(unitName = "RESTAppPU")
    private EntityManager em;

    public ProductCategoryFacadeREST() {
        super(ProductCategory.class);
    }

    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_XML})
    public String createEntity(ProductCategory entity) {
        try {
            super.create(entity);
            return "Creation Successful!";
        } catch (Exception e) {
            return "Creation failed!";
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public ProductCategory find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML})
    public List<ProductCategory> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
