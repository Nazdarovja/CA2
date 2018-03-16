/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.HobbyEntity;
import entities.PersonEntity;
import entities.PhoneEntity;
import facades.AddressFacade;
import facades.HobbyFacade;
import facades.PhoneFacade;
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
    private AddressEntityDTO address;
    private List<PhoneEntityDTO> phoneNumbers = new ArrayList();
    private List<HobbyEntityDTO> hobbyDTOs = new ArrayList();

    //TODO: Simpel representation.
    public PersonEntityDTO(PersonEntity p) {

        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        p.getHobbies().forEach((h) -> {
            this.hobbyDTOs.add(new HobbyEntityDTO(h));
        });
        this.address = new AddressEntityDTO(p.getAddress());
        p.getPhones().forEach((pn) -> {
            this.phoneNumbers.add(new PhoneEntityDTO(pn));
        });
    }

    @Override
    public PersonEntity toInternal() {
        PersonEntity p = new PersonEntity(firstName, lastName, email);
        HobbyFacade hobbyFacade = new HobbyFacade();
        PhoneFacade phoneFacade = new PhoneFacade();

        //TOFIX in doubt if these are the right object representations, as they lack the bidirectional relationships.
        p.setAddress(address.toInternal());

        List<HobbyEntity> hobbies = new ArrayList();
        hobbyDTOs.forEach((h) -> {
            HobbyEntity he = hobbyFacade.read(h.getName());
            if (he == null) {
                he = hobbyFacade.create(h.toInternal());
                hobbies.add(he);
            } else {
                hobbies.add(he);
            }
        });
        p.setHobbies(hobbies);

        List<PhoneEntity> phones = new ArrayList();
        phoneNumbers.forEach((pn) -> {
            phones.add(pn.toInternal());
        });
        p.setPhones(phones);

        return p;
    }

}
