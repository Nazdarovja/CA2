/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DTO.JSONDTO;
import DTO.PersonCountDTO;
import DTO.PersonEntityDTO;
import entities.PersonEntity;
import facades.DTOFacade;
import facades.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
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
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;

    DTOFacade dto = new DTOFacade();
    PersonFacade pf = new PersonFacade();

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createPerson(String message) {
        PersonEntity p = dto.fromJson(message, PersonEntityDTO.class);
        p = pf.create(p);
        PersonEntityDTO pDTO = new PersonEntityDTO(p);
        return dto.DTOtoJson(pDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersons() {
        List<PersonEntity> persons = pf.readAll();
        List<JSONDTO> personsDTO = new ArrayList();
        for (PersonEntity personEntity : persons) {
            personsDTO.add(new PersonEntityDTO(personEntity));
        }
        return dto.DTOListToJson(personsDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getPerson(@PathParam("id") Long id) {
        PersonEntity person = pf.read(id);
        return dto.DTOtoJson(new PersonEntityDTO(person));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String updatePerson(@PathParam("id") Long id, String message) {
        PersonEntity p = dto.fromJson(message, PersonEntityDTO.class);
        p = pf.update(id, p);
        return dto.DTOtoJson(new PersonEntityDTO(p));
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String deletePerson(@PathParam("id") Long id) {
        //Deletes and returns the deleted person as JSON (for display or other reasons)
        PersonEntity p = pf.delete(id);
        return dto.DTOtoJson(new PersonEntityDTO(p));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/phonenumber/{number}")
    public String getPersonByPhonenumber(@PathParam("number") Long number) {
        PersonEntity p = pf.getPersonByPhoneNumber(number);
        return dto.DTOtoJson(new PersonEntityDTO(p));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hobby/{hobby}")
    public String getPersonListByHobby(@PathParam("hobby") String hobby) {
        List<PersonEntity> persons = pf.getAllPersonsByHobby(hobby);
        List<JSONDTO> personsDTO = new ArrayList();
        for (PersonEntity person : persons) {
            personsDTO.add(new PersonEntityDTO(person));
        }
        return dto.DTOListToJson(personsDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/city/{city}")
    public String getPersonListByCity(@PathParam("city") String city) {
        List<PersonEntity> persons = pf.getAllPersonsByCity(city);
        List<JSONDTO> personsDTO = new ArrayList();
        for (PersonEntity person : persons) {
            personsDTO.add(new PersonEntityDTO(person));
        }
        return dto.DTOListToJson(personsDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/street/{street}")
    public String getPersonListByStreet(@PathParam("street") String street) {
        List<PersonEntity> persons = pf.getAllPersonsByStreet(street);
        List<JSONDTO> personsDTO = new ArrayList();
        for (PersonEntity person : persons) {
            personsDTO.add(new PersonEntityDTO(person));
        }
        return dto.DTOListToJson(personsDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/countbyhobby/{hobby}")
    public String getPersonCountByHobby(@PathParam("hobby") String hobby){
        int count = pf.getPersonCountByHobby(hobby);
        return dto.DTOtoJson(new PersonCountDTO(count));
    }
    
}
