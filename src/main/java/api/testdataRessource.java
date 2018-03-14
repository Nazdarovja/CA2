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
    public String getCompanyTestData(@PathParam("samples") Integer samples) {
        return generator.generateCompanyEntity(samples);
    }

    @Path("/person/{samples}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPersonTestData(@PathParam("samples") Integer samples) {
        return generator.generatePersonEntity(samples);
    }

    @Path("/infoentity/{samples}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfoEntityTestData(@PathParam("samples") Integer samples) {
        return generator.generateInfoEntity(samples);
    }

    @Path("/address/{samples}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAddressTestData(@PathParam("samples") Integer samples) {
        return generator.generateAddressEntity(samples);
    }

    @Path("/phone/{samples}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPhoneTestData(@PathParam("samples") Integer samples) {
        return generator.generatePhoneEntity(samples);
    }

    @Path("/hobby/{samples}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHobbyTestData(@PathParam("samples") Integer samples) {
        return generator.generateHobbyEntity(samples);
    }

    @Path("/sql/{samples}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTestData(@PathParam("samples") Integer samples) {
 
        
        //skal gøres via DTO
        String sql = "INSERT INTO CITYINFOENTITY (ZIPCODE, CITY) VALUES ('2750', 'Ballerup');\n"
                + "INSERT INTO CITYINFOENTITY (ZIPCODE, CITY) VALUES ('3050', 'Humlebæk');\n"
                + "INSERT INTO CITYINFOENTITY (ZIPCODE, CITY) VALUES ('3450', 'Allerød');\n"
                + "INSERT INTO CITYINFOENTITY (ZIPCODE, CITY) VALUES ('2730', 'Herlev');\n"
                + "INSERT INTO CITYINFOENTITY (ZIPCODE, CITY) VALUES ('1000', 'København K');\n";

            sql += generator.generateAddressEntity(samples);
            sql += generator.generateInfoEntity(samples);
            sql += generator.generatePhoneEntity(samples);
            sql += generator.generateCompanyEntity(samples);
        return sql;
    }

}
