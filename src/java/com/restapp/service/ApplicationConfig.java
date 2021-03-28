
package com.restapp.service;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.restapp.service.AddressFacadeREST.class);
        resources.add(com.restapp.service.ClientFacadeREST.class);
        resources.add(com.restapp.service.GenericResource.class);
        resources.add(com.restapp.service.ProductCatalogFacadeREST.class);
        resources.add(com.restapp.service.ProductCategoryFacadeREST.class);
        resources.add(com.restapp.service.SalesOrderFacadeREST.class);
        resources.add(com.restapp.service.SalutationFacadeREST.class);
    }
    
}
