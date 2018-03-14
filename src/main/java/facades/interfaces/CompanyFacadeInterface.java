package facades.interfaces;

import entities.CompanyEntity;
import java.util.List;

/**
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public interface CompanyFacadeInterface {

    public CompanyEntity getCompanyByPhoneNumberJSON(Integer phoneNumber);
    public int getCompanyCountByZipCode(String zipcode);
    //return list of companies with a market value above given marketvalue
    public List<CompanyEntity> getCompaniesByMarketValueAbove(Long marketValue);
    //return total count of companies with number of employees 
    public int getCompanyCountByNumEmployeesBelow(Integer numEmployees);
    
}
