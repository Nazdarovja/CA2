/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.AddressEntity;
import entities.CompanyEntity;
import entities.HobbyEntity;
import entities.InfoEntity;
import entities.PersonEntity;
import entities.PhoneEntity;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class TestDataFacade {

//    public CompanyEntity createCompanyEntity(String name, String description, int cvr, int numEmployees, long marketValue, String email) {
//        return new CompanyEntity(name, description, cvr, numEmployees, marketValue, email);
//    }
    //test
    public CompanyEntity createCompanyEntity(String name, String description, int cvr, int numEmployees, long marketValue) {
        return new CompanyEntity(name, description, cvr, numEmployees, marketValue);
    }

    public PersonEntity createPersonEntity(String firstName, String lastName, String email) {
        return new PersonEntity(firstName, lastName, email);
    }

    //abstract?
    public InfoEntity createInfoEntity(String email) {
        return new InfoEntity(email) {
        };
    }

    public AddressEntity createAddressEntity(String street, String additionalInfo) {
        return new AddressEntity(street, additionalInfo);
    }

    public PhoneEntity createPhoneEntity(Long number, String description) {
        return new PhoneEntity(number, description);
    }
    public HobbyEntity createHobbyEntity(String name, String description) {
        return new HobbyEntity(name, description);
    }
    
}
