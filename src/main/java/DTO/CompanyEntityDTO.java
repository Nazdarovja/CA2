/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.CompanyEntity;
import entities.PhoneEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CompanyEntityDTO implements JSONDTO<CompanyEntity> {

    private String name;
    private String description;
    private int cvr;
    private int numEmployees;
    private long marketValue;
    private String email;
    private AddressEntityDTO address;
    private List<PhoneEntityDTO> phoneNumbers = new ArrayList();

    public CompanyEntityDTO(CompanyEntity c) {
        this.name = c.getName();
        this.description = c.getDescription();
        this.cvr = c.getCvr();
        this.address = new AddressEntityDTO(c.getAddress());
        this.numEmployees = c.getNumEmployees();
        this.marketValue = c.getMarketValue();
        this.email = c.getEmail();
        c.getPhones().forEach((p) -> {
            phoneNumbers.add(new PhoneEntityDTO(p));
        });
    }

    @Override
    public CompanyEntity toInternal() {
        CompanyEntity c = new CompanyEntity(name, description, cvr, numEmployees, marketValue, email);
        
        List<PhoneEntity> phones = new ArrayList();
        phoneNumbers.forEach((pn) -> {
            phones.add(pn.toInternal());
        });
        c.setPhones(phones);
        
        return c;
    }

}
