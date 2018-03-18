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

    //dirty hack
    public boolean companyDataGenerated = false;

    ////////////////////
    //RANDOM TEST DATA// 
    ////////////////////
    //ADDRESS ENTITY
    String[] street = {"Algade ", "Raadhuspladsen ", "Frederiksberg Alle ", "Roskildevej ", "Ballerup Byvej "};
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

    //HOBBY ENTITY
    String[] hobbynames = {"fodbold", "håndbold", "floorball", "gaming", "windsurfing"};
    String[] hobbydescription = {"holdsport", "teamsport", "beskrivelse her", "enkeltperson", "gruppesport"};

    //CITYINFO / ZIPCODE
    String[] zipcode = {"2750", "3050", "3450", "2730", "1000"};

    //INFOENTITY
    String[] dtype = {"PersonEntity", "CompanyEntity"};

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

    private String sqlifyInfoEntity(String dtype, InfoEntity temp, int addressID) {
        String first = "INSERT INTO INFOENTITY (DTYPE, ADDRESSID, EMAIL) VALUES ('";
        String second = dtype + "', '" + addressID + "', '" + temp.getEmail() + "');\n";
        return first + second;
    }

    private String sqlifyAddressEntity(AddressEntity temp) {
        String first = "INSERT INTO ADDRESSENTITY (ZIPCODE, STREET, ADDITIONALINFO) VALUES ('";
        String second = getRndStringValue(zipcode) + "', '" + temp.getStreet() + "', '" + temp.getAdditionalInfo() + "');\n";
        return first + second;
    }

    private String sqlifyPhoneEntity(PhoneEntity temp, int infoEntityID) {
        String first = "INSERT INTO PHONEENTITY (NUMBER, DESCRIPTION, INFOENTITYID) VALUES ('";
        String second = temp.getNumber() + "', '" + temp.getDescription() + "', '" + infoEntityID + "');\n";
        return first + second;
    }

    private String sqlifyHobbyEntity(HobbyEntity temp) {
        String first = "INSERT INTO HOBBYENTITY (NAME, DESCRIPTION) VALUES ('";
        String second = temp.getName() + "', '" + temp.getDescription() + "');\n";
        return first + second;
    }

    private String sqlifyPersonEntityHobbyEntity(String hobbyID, int personID) {
        String first = "INSERT INTO PERSONENTITY_HOBBYENTITY (hobbies_NAME, persons_ID) VALUES ('";
        String second = hobbyID + "', '" + personID + "');\n";
        return first + second;
    }

    public String generateCompanyEntity(int samplesToGenerate) {
        String sqlList = "";
        int counterID = 1;
        while (counterID < samplesToGenerate + 1) {
            CompanyEntity temp = tdf.createCompanyEntity(getRndStringValue(name), getRndStringValue(description), getRndIntValue(cvr), getRndIntValue(numemployees), getRndLongValue(marketvalue));
            sqlList += sqlifyCompanyEntity(temp, counterID);
            counterID++;
        }
        return sqlList;
    }

    public String generatePersonEntity(int samplesToGenerate) {
        String sqlList = "";
        int counterID = 1;
                if (companyDataGenerated) {
            counterID += samplesToGenerate;
            samplesToGenerate *= 2;
        }
        while (counterID < samplesToGenerate + 1) {
            PersonEntity temp = tdf.createPersonEntity(getRndStringValue(firstName), getRndStringValue(lastName), getRndStringValue(email));
            sqlList += sqlifyPersonEntity(temp, counterID);
            counterID++;
        }
        return sqlList;
    }

    public String generateInfoEntity(int samplesToGenerate, String DTYPE) {
        String sqlList = "";
        int counterID = 1;
        if (companyDataGenerated) {
            counterID += samplesToGenerate;
            samplesToGenerate *= 2;
        }
        while (counterID < samplesToGenerate + 1) {
            InfoEntity temp = tdf.createInfoEntity(getRndStringValue(email));
            sqlList += sqlifyInfoEntity(DTYPE, temp, counterID);
            counterID++;
        }
        return sqlList;
    }

    public String generateAddressEntity(int samplesToGenerate) {
        String sqlList = "";
                int counterID = 1;
        if (companyDataGenerated) {
            counterID += samplesToGenerate;
        }
        while (samplesToGenerate > 0) {
            AddressEntity temp = tdf.createAddressEntity(getRndStringValue(street)+counterID, getRndStringValue(additionalInfo));
            sqlList += sqlifyAddressEntity(temp);
            samplesToGenerate--;
            counterID++;
        }
        return sqlList;
    }

    public String generatePhoneEntity(int samplesToGenerate) {
        String sqlList = "";
        Long initialPhonenumber = 12345678L;
        Long phoneNumberChangeFactor = 1L;
        int counterID = 1;
        if (companyDataGenerated) {
            counterID += samplesToGenerate;
            samplesToGenerate *= 2;
            phoneNumberChangeFactor += samplesToGenerate;
        }
        while (counterID < samplesToGenerate + 1) {
            PhoneEntity temp = tdf.createPhoneEntity(initialPhonenumber + phoneNumberChangeFactor, getRndStringValue(phonedescription));
            sqlList += sqlifyPhoneEntity(temp, counterID);
            phoneNumberChangeFactor++;
            counterID++;
        }
        return sqlList;
    }

    public String generateHobbyEntity() {
        String sqlList = "";
        int samplesToGenerate = hobbynames.length;
        while (samplesToGenerate > 0) {
        String hobbyToUse = hobbynames[samplesToGenerate-1];
            HobbyEntity temp = tdf.createHobbyEntity(hobbyToUse, getRndStringValue(hobbydescription));
            sqlList += sqlifyHobbyEntity(temp);
            samplesToGenerate--;
        }
        return sqlList;
    }

    public String generatePersonEntityHobbyEntity(int samplesToGenerate) {
        String sqlList = "";
        int samplesID = 1;
        if (companyDataGenerated) {
            samplesID += samplesToGenerate;
            samplesToGenerate *= 2;
        }
        while (samplesID < samplesToGenerate+ 1) {
        String hobby = getRndStringValue(hobbynames);
            sqlList += sqlifyPersonEntityHobbyEntity(hobby, samplesID);
            samplesID++;
        }
        return sqlList;
    }
}
