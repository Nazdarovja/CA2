/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import tests.Generator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
@Path("testdata")
public class testdataRessource {

    Generator generator = new Generator();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of data
     */
    public testdataRessource() {
    }

    @Path("/company/{samples}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTestData(@PathParam("samples") Integer samples) {
        return generator.generateCompanyEntity(samples);
    }


}
