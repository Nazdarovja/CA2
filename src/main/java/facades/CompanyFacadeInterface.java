package facades;

/**
 * All methods should return a JSON string
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public interface CompanyFacadeInterface {
    //POST 
    public String createCompanyJSON(String message);
    //GET
    public String getCompanyJSON(Long id);
    //PUT company by id & message(json) and return as JSON
    public String updateCompanyJSON(Long id, String message);
    //DELETE
    public String deleteCompanyJSON(Long id);
    public String getCompanyByPhoneNumberJSON(Integer phoneNumber);
    
    //return DTO object containing count as JSON
    public String getCompanyCountByZipCode(String zipcode);
    //return list of companies with a market value above given marketvalue
    public String getCompaniesByMarketValueAbove(Long marketValue);
    //return total count of companies with number of employees 
    public String getCompanyCountByNumEmployeesBelow(Integer numEmployees);
}
