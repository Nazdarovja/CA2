/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.interfaces;

import entities.PersonEntity;
import java.util.List;

/**
 *
 * @author Stanislav
 */
public interface PersonFacadeInterface {
    //POST 
    public PersonEntity createPerson(String message);
    //GET
    public PersonEntity getPerson(Long id);
    //PUT a person id as a URL parameter, and updates with given JSON (message)
    public PersonEntity updatePerson(Long id, String message);
    //DELETE (returns deleted PersonEntity, for whatever reason)
    public PersonEntity deletePerson(Long id);
    public PersonEntity getPersonByPhoneNumber(Integer number);
    public List<PersonEntity> getAllPersonsByHobby(String hobby);
    public List<PersonEntity> getAllPersonsByCity(String city);
    public List<PersonEntity> getAllPersonsByStreet(String street);
    public Integer getPersonCountByHobby(String hobby);
    
}
