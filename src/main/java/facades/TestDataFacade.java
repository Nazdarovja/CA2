/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.CompanyEntity;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class TestDataFacade {

    public CompanyEntity createCompanyEntity(String name, String description, int cvr, int numEmployees, long marketValue, String email) {
        return new CompanyEntity(name, description, cvr, numEmployees, marketValue, email);
    }

}
