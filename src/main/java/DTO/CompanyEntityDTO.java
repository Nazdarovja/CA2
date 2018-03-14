/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.CompanyEntity;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CompanyEntityDTO implements JSONDTO<CompanyEntity> {

    public String name;
    public String description;
    public int cvr;
    public int numEmployees;
    public long marketValue;

    public CompanyEntityDTO(CompanyEntity c) {
        this.name = c.getName();
        this.description = c.getDescription();
        this.cvr = c.getCvr();
        this.numEmployees = c.getNumEmployees();
        this.marketValue = c.getMarketValue();
    }

    @Override
    public CompanyEntity toInternal() {
        return new CompanyEntity(name, description, cvr, numEmployees, marketValue, name);
    }

}
