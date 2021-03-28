package com.restapp.service;

import com.restapp.entity.Client;
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
@Path("client")
public class ClientFacadeREST extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "RESTAppPU")
    private EntityManager em;

    public ClientFacadeREST() {
        super(Client.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.TEXT_PLAIN})
    public String createEntity(Client entity) {
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
    public Client find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML})
    public List<Client> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
