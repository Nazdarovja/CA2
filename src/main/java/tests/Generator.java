/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import DTO.CompanyEntityDTO;
import com.google.gson.Gson;
import entities.CompanyEntity;
import facades.TestDataFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class Generator {

    Gson gson = new Gson();
    Random r = new Random();
    TestDataFacade tdf = new TestDataFacade();

    ////////////////////
    //RANDOM TEST DATA// 
    ////////////////////
    //ADDRESS ENTITY ?
    String[] additionalInfo = {"Building 1", "Building 2", "Building 3", "Building 4", "Building 5"};
    //CITY ENTITY ?

    //COMPANY ENTITY
    int[] cvr = {25779770, 34739854, 27974333, 10629241, 40180753};
    String[] description = {"Real Estate", "Sports Club", "Restaurant", "Home Furnishing", "Shipping"};
    Long[] marketvalue = {250000L, 500000L, 750000L, 1000000l, 2000000L};
    String[] name = {"The Angry Cherry Marketing Computing", "Thin Beaver Marketing", "Hot Spoon web", "The Cold Duck theatre Company", "The Brey Phone Films Company"};
    int[] numemployees = {5, 25, 250, 1250, 10000};
    String[] email = {"noticias@outlook.com", "ivoibs@yahoo.com", "lpalmer@yahoo.com", "sethbrown@comcast.net", "jschauma@hotmail.com"};

    private int getRndIntValue(int[] array) {
        int index = r.nextInt(array.length);
        return array[index];
    }

    private Long getRndLongValue(Long[] array) {
        int index = r.nextInt(array.length);
        return array[index];
    }

    private String getRndStringValue(String[] array) {
        int index = r.nextInt(array.length);
        return array[index];
    }

    private String sqlify(CompanyEntity temp, int counter){
        String first = "INSERT INTO COMPANYENTITY (ID, NAME, DESCRIPTION, CVR, NUMEMPLOYEES, MARKETVALUE) VALUES ('";
        String second = counter + "', '" + temp.getName() + "', '" + temp.getDescription() + "', '" + temp.getCvr()+ "', '" + temp.getNumEmployees() + "', '" + temp.getMarketValue() + "');\n";
        return first+second;
    }
    
    public String generateCompanyEntity(int samplesToGenerate) {   //generate metode for hver testdata
        

        String sqlList = "";
        int counter = 1;

        while (samplesToGenerate > 0) {
            CompanyEntity temp = tdf.createCompanyEntity(getRndStringValue(name), getRndStringValue(description), getRndIntValue(cvr), getRndIntValue(numemployees), getRndLongValue(marketvalue), getRndStringValue(email));
            sqlList += sqlify(temp, counter);
            samplesToGenerate--;
            counter++;
        }
        return sqlList;
    }

    public static void main(String[] args) {
        Generator g = new Generator();
        System.out.println(g.generateCompanyEntity(3));
    }

}
