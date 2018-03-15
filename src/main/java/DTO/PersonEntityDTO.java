/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.HobbyEntity;
import entities.PersonEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stanislav
 */
public class PersonEntityDTO implements JSONDTO<PersonEntity> {

    private String firstName;
    private String lastName;
    private String email;
    private List<HobbyEntityDTO> hobbyDTOs = new ArrayList();

    //TODO: Simpel representation.
    public PersonEntityDTO(PersonEntity p) {
        
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        p.getHobbies().forEach((h) -> {
            this.hobbyDTOs.add(new HobbyEntityDTO(h));
        });
    }

    @Override
    public PersonEntity toInternal() {
        PersonEntity p = new PersonEntity(firstName,lastName,email);
        
        //TOFIX lidt i tvivl om hvordan vi skal få fat i de rigtige objekter her
        List<HobbyEntity> hobbies = new ArrayList();
        // ADD MAGIC HERE ! :D 
        
        p.setHobbies(hobbies);
        return p;
    }

}
