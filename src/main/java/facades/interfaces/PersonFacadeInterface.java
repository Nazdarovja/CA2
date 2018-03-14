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
    public PersonEntity getPersonByPhoneNumber(Integer number);
    public List<PersonEntity> getAllPersonsByHobby(String hobby);
    public List<PersonEntity> getAllPersonsByCity(String city);
    public List<PersonEntity> getAllPersonsByStreet(String street);
    public Integer getPersonCountByHobby(String hobby);
    
}
