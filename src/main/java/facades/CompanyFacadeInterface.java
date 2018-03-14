package facades;

import entities.CompanyEntity;
import java.util.List;

/**
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public interface CompanyFacadeInterface {
    //POST 
    public CompanyEntity createCompanyJSON(String message);
    //GET
    public CompanyEntity getCompanyJSON(Long id);
    //PUT company by id & message(json)
    public CompanyEntity updateCompanyJSON(Long id, String message);
    //DELETE
    public CompanyEntity deleteCompanyJSON(Long id);
    public CompanyEntity getCompanyByPhoneNumberJSON(Integer phoneNumber);
    
    public int getCompanyCountByZipCode(String zipcode);
    //return list of companies with a market value above given marketvalue
    public List<CompanyEntity> getCompaniesByMarketValueAbove(Long marketValue);
    //return total count of companies with number of employees 
    public int getCompanyCountByNumEmployeesBelow(Integer numEmployees);
}
