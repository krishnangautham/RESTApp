
package com.restapp.service;

import com.restapp.utils.TableCreator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("createTables")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Creates database tables
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String createTables(String content) {
        TableCreator tableCreator = new TableCreator();
        try {
            tableCreator.createTables();
        } catch (Exception e) {
            return "Table creation failed!";
        }

        return "Tables created!";
    }
}
