/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DTO.CompanyEntityDTO;
import DTO.CountDTO;
import DTO.JSONDTO;
import entities.CompanyEntity;
import facades.CompanyFacade;
import facades.DTOFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Stanislav
 */
@Path("company")
public class CompanyResource {

    @Context
    private UriInfo context;
    DTOFacade dto = new DTOFacade();
    CompanyFacade cf = new CompanyFacade();

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createCompany(String message) {
        CompanyEntity c = dto.fromJson(message, CompanyEntityDTO.class);
        c = cf.create(c);
        CompanyEntityDTO cDTO = new CompanyEntityDTO(c);
        return dto.DTOtoJson(cDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getCompany(@PathParam("id") Long id) {
        CompanyEntity company = cf.read(id);
        return dto.DTOtoJson(new CompanyEntityDTO(company));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompanies() {
        List<CompanyEntity> companies = cf.readAll();
        List<JSONDTO> companiesDTO = new ArrayList();
        companies.forEach((companyEntity) -> {
            companiesDTO.add(new CompanyEntityDTO(companyEntity));
        });
        return dto.DTOListToJson(companiesDTO);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String updateCompany(@PathParam("id") Long id, String message) {
        CompanyEntity c = dto.fromJson(message, CompanyEntityDTO.class);
        c = cf.update(id, c);
        return dto.DTOtoJson(new CompanyEntityDTO(c));
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String deleteCompany(@PathParam("id") Long id) {
        //Deletes and returns company if needed for display
        CompanyEntity c = cf.delete(id);
        return dto.DTOtoJson(new CompanyEntityDTO(c));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/phonenumber/{number}")
    public String getCompanyByPhoneNumber(@PathParam("number") Long number) {
        CompanyEntity c = cf.getCompanyByPhoneNumber(number);
        return dto.DTOtoJson(new CompanyEntityDTO(c));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/countbyzipcode/{zipcode}")
    public String getCompanyCountByZipcode(@PathParam("zipcode") String zipcode) {
        Integer count = cf.getCompanyCountByZipCode(zipcode);
        return dto.DTOtoJson(new CountDTO(count));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/marketvalueabove/{marketValue}")
    public String getCompaniesByMarketValueAbove(@PathParam("marketValue") Long marketValue) {
        List<CompanyEntity> companies = cf.getCompaniesByMarketValueAbove(marketValue);
        List<JSONDTO> companiesDTO = new ArrayList();
        companies.forEach((companyEntity) -> {
            companiesDTO.add(new CompanyEntityDTO(companyEntity));
        });
        return dto.DTOListToJson(companiesDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/countbynumemployeesbelow/{numEmployees}")
    public String getCompanyCountByNumEmployeesBelow(@PathParam("numEmployees") Integer numEmployees) {
        List<CompanyEntity> companies = cf.getCompanyCountByNumEmployeesBelowTEST(numEmployees);
        List<JSONDTO> companiesDTO = new ArrayList();
        companies.forEach((companyEntity) -> {
            companiesDTO.add(new CompanyEntityDTO(companyEntity));
        });
//        return dto.DTOtoJson(new CountDTO(count));
        return dto.DTOListToJson(companiesDTO);
    }

}
