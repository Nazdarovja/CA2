/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

/**
 *
 * @author Stanislav
 */
public interface PersonFacadeInterface {
    // ALL THSE METHODS SHOULD RETURN A JSON STRING !!!!
    //POST 
    public String createPersonJSON(String message);
    //GET
    public String getPersonJSON(Long id);
    //PUT a person id as a URL parameter, and updates with given JSON (message)
    public String updatePersonJSON(Long id, String message);
    //DELETE (returns deleted personJSON, for whatever reason)
    public String deletePersonJSON(Long id);
    public String getPersonByPhoneNumberJSON(Integer number);
    public String getAllPersonsByHobbyJSON(String hobby);
    public String getAllPersonsByCity(String city);
    // return DTO object containing count as JSON
    public String getPersonCountByHobby(String hobby);
    public String getAllPersonsByStreet(String street);
    
}
