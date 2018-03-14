/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.google.gson.Gson;
import entities.AddressEntity;
import entities.CompanyEntity;
import entities.HobbyEntity;
import entities.InfoEntity;
import entities.PersonEntity;
import entities.PhoneEntity;
import facades.TestDataFacade;
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
    //ADDRESS ENTITY
    String[] street = {"Algade 2", "Raadhuspladsen 8", "Frederiksberg Alle 52a", "Roskildevej 13", "Ballerup Byvej 1"};
    String[] additionalInfo = {"Building 1", "Building 2", "Building 3", "Building 4", "Building 5"};
    //CITY ENTITY ?

    //COMPANY ENTITY
    int[] cvr = {25779770, 34739854, 27974333, 10629241, 40180753};
    String[] description = {"Real Estate", "Sports Club", "Restaurant", "Home Furnishing", "Shipping"};
    Long[] marketvalue = {250000L, 500000L, 750000L, 1000000l, 2000000L};
    String[] name = {"The Angry Cherry Marketing Computing", "Thin Beaver Marketing", "Hot Spoon web", "The Cold Duck theatre Company", "The Brey Phone Films Company"};
    int[] numemployees = {5, 25, 250, 1250, 10000};

    String[] email = {"noticias@outlook.com", "ivoibs@yahoo.com", "lpalmer@yahoo.com", "sethbrown@comcast.net", "jschauma@hotmail.com"};

    //PERSON ENTITY
    String[] firstName = {"Stanislav", "Mikkel", "Mathias", "Alexander", "Sigurd"};
    String[] lastName = {"Hansen", "Christensen", "Dinesen", "Henriksen", "Andersen"};

    //PHONE ENTITY
    String[] phonedescription = {"fastnet", "privat", "public", "mobil", "midlertidigt"};
    int[] phonenumbers = {12345678, 87654321, 11223344, 22334455, 33445566};

    //HOBBY ENTITY
    String[] hobbynames = {"fodbold", "håndbold", "floorball", "gaming", "windsurfing"};
    String[] hobbydescription = {"holdsport", "teamsport", "beskrivelse her", "enkeltperson", "gruppesport"};

    //CITYINFO / ZIPCODE
    String[] zipcode = {"2750", "3050", "3450", "2730", "1000"};
    
    //INFOENTITY
    String[] dtype = {"PersonEntity","CompanyEntity"};
    
    private int getRndIntValue(int[] array) {
        int index = r.nextInt(array.length);
        return array[index];
    }

    private Long getRndLongValue(Long[] array) {
        int index = r.nextInt(array.length);
        return array[index];
    }

    public int getRndID(int range) {
        int res = r.nextInt(range) + 1;
        return res;
    }

    private String getRndStringValue(String[] array) {
        int index = r.nextInt(array.length);
        return array[index];
    }

    private String sqlifyCompanyEntity(CompanyEntity temp, int counter) {
        String first = "INSERT INTO COMPANYENTITY (ID, NAME, DESCRIPTION, CVR, NUMEMPLOYEES, MARKETVALUE) VALUES ('";
        String second = counter + "', '" + temp.getName() + "', '" + temp.getDescription() + "', '" + temp.getCvr() + "', '" + temp.getNumEmployees() + "', '" + temp.getMarketValue() + "');\n";
        return first + second;
    }

    private String sqlifyPersonEntity(PersonEntity temp, int counter) {
        String first = "INSERT INTO PERSONENTITY (ID, FIRSTNAME, LASTNAME) VALUES ('";
        String second = counter + "', '" + temp.getFirstName() + "', '" + temp.getLastName() + "');\n";
        return first + second;
    }

    private String sqlifyInfoEntity(String dtype, InfoEntity temp, int samplesize) {
        String first = "INSERT INTO INFOENTITY (DTYPE, ADDRESSID, EMAIL) VALUES ('";
        String second = dtype + "', '" + getRndID(samplesize) + "', '" + temp.getEmail() + "');\n";
        return first + second;
    }

    private String sqlifyAddressEntity(AddressEntity temp) {
        String first = "INSERT INTO ADDRESSENTITY (ZIPCODE, STREET, ADDITIONALINFO) VALUES ('";
        String second = getRndStringValue(zipcode) + "', '" + temp.getStreet() + "', '" + temp.getAdditionalInfo() + "');\n";
        return first + second;
    }

    private String sqlifyPhoneEntity(PhoneEntity temp) {
        String first = "INSERT INTO PHONEENTITY (NUMBER, DESCRIPTION) VALUES ('";
        String second = temp.getNumber() + "', '" + temp.getDescription() + "');\n";
        return first + second;
    }

    private String sqlifyHobbyEntity(HobbyEntity temp) {
        String first = "INSERT INTO HOBBYENTITY (DESCRIPTION, NAME) VALUES ('";
        String second = temp.getDescription() + "', '" + temp.getName() + "');\n";
        return first + second;
    }

    public String generateCompanyEntity(int samplesToGenerate) {
        String sqlList = "";
        int counter = 1;
        while (samplesToGenerate > 0) {
            CompanyEntity temp = tdf.createCompanyEntity(getRndStringValue(name), getRndStringValue(description), getRndIntValue(cvr), getRndIntValue(numemployees), getRndLongValue(marketvalue), getRndStringValue(email));
            sqlList += sqlifyCompanyEntity(temp, counter);
            samplesToGenerate--;
            counter++;
        }
        return sqlList;
    }

    public String generatePersonEntity(int samplesToGenerate) {
        String sqlList = "";
        int counter = 1;
//        while (samplesToGenerate > 0) {
            PersonEntity temp = tdf.createPersonEntity(getRndStringValue(firstName), getRndStringValue(lastName), getRndStringValue(email));
            sqlList += sqlifyPersonEntity(temp, counter);
//            samplesToGenerate--;
            counter++;
//        }
        return sqlList;
    }

    public String generateInfoEntity(int samplesToGenerate) {
        String sqlList = "";
//        while (samplesToGenerate > 0) {
            InfoEntity temp = tdf.createInfoEntity(getRndStringValue(email));
            sqlList += sqlifyInfoEntity(getRndStringValue(dtype), temp, samplesToGenerate);
//            samplesToGenerate--;
//        }
        return sqlList;
    }

    public String generateAddressEntity(int samplesToGenerate) {
        String sqlList = "";
//        while (samplesToGenerate > 0) {
            AddressEntity temp = tdf.createAddressEntity(getRndStringValue(street), getRndStringValue(additionalInfo));
            sqlList += sqlifyAddressEntity(temp);
//            samplesToGenerate--;
//        }
        return sqlList;
    }

    public String generatePhoneEntity(int samplesToGenerate) {
        String sqlList = "";
        while (samplesToGenerate > 0) {
            PhoneEntity temp = tdf.createPhoneEntity(getRndIntValue(phonenumbers), getRndStringValue(phonedescription));
            sqlList += sqlifyPhoneEntity(temp);
            samplesToGenerate--;
        }
        return sqlList;
    }

    public String generateHobbyEntity(int samplesToGenerate) {
        String sqlList = "";
        while (samplesToGenerate > 0) {
            HobbyEntity temp = tdf.createHobbyEntity(getRndStringValue(hobbydescription), getRndStringValue(hobbynames));
            sqlList += sqlifyHobbyEntity(temp);
            samplesToGenerate--;
        }
        return sqlList;
    }

}
