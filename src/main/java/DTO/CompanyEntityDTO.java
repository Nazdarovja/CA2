/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.CompanyEntity;
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
    private AddressEntityDTO address;
    private List<PhoneEntityDTO> phoneNumbers = new ArrayList();

    public CompanyEntityDTO(CompanyEntity c) {
        this.name = c.getName();
        this.description = c.getDescription();
        this.cvr = c.getCvr();
        this.address = new AddressEntityDTO(c.getAddress());
        this.numEmployees = c.getNumEmployees();
        this.marketValue = c.getMarketValue();
        c.getPhones().forEach((p) -> {
            phoneNumbers.add(new PhoneEntityDTO(p));
        });
    }

    @Override
    public CompanyEntity toInternal() {
        return new CompanyEntity(name, description, cvr, numEmployees, marketValue, name);
    }

}
