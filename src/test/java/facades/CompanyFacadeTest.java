//package facades;
//
//import entities.CompanyEntity;
//import entities.PersonEntity;
//import errors.code404.CompanyNotFoundException;
//import java.util.HashMap;
//import java.util.List;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import persistence.EntityManagerControl;
//
///**
// *
// * @author Mellem
// */
//public class CompanyFacadeTest {
//     
//    EntityManagerControl emc;
//    CompanyFacade cf;
//    HashMap<String, String> persistenceMap = new HashMap<>();
//
//    public CompanyFacadeTest() {
//    }
//
//    @Before
//    public void setUp() {
//        persistenceMap.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/ca2");
//        emc = new EntityManagerControl(persistenceMap);
//        cf = new CompanyFacade(emc);
//
//    }
//
//    @Test
//    public void testGetCompanyByPhoneNumber() {
//        System.out.println("getCompanyByPhoneNumber");
//        Long number = 12345680L;
//        Long expResult = 2L;
//        CompanyEntity company = cf.getCompanyByPhoneNumber(number);
//        Long result = company.getId();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testGetCompanyCountByZipCode() {
//        System.out.println("getCompanyCountByZipCode");
//        int expResult = 4;
//        int result = cf.getCompanyCountByZipCode("2730");
//
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testGetCompaniesByMarketValueAbove() {
//        System.out.println("getCompaniesByMarketValueAbove");
//        
//        int expResult = 3;
//        List<CompanyEntity> list = cf.getCompaniesByMarketValueAbove(1900000L);
//        int result = list.size();
//        Long expPersId1 = 4L;
//        Long expPersId2 = 5L;
//        Long expPersId3 = 7L;
//        assertEquals(expPersId1, list.get(0).getId());
//        assertEquals(expPersId2, list.get(1).getId());
//        assertEquals(expPersId3, list.get(2).getId());
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testCreate() {
//        System.out.println("create");
//        CompanyEntity object = new CompanyEntity("xx", "xx", 88888888, 12555555, 1000000L, "x@x.dk");
//        CompanyEntity expResult = object;
//        CompanyEntity result = cf.create(object);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testRead_Long() {
//        System.out.println("read");
//        Long id = 1L;
//        Long expResult = 1L;
//        Long result = cf.read(id).getId();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testReadAll() {
//        System.out.println("readAll");
//        int expResult = 10;
//        List<CompanyEntity> result = cf.readAll();
//        assertEquals(expResult, result.size(), 1);
//    }
//
//    @Test
//    public void testUpdate_Long_CompanyEntity() {
//        System.out.println("update");
//        Long id = 1L;
//        CompanyEntity newObject = new CompanyEntity("xx", "xx", 88888888, 12555555, 1000000L, "x@x.dk");
//        String expResult = "xx";
//        cf.update(id, newObject);
//        String result = cf.read(id).getName();
//        assertTrue(expResult.equals(result));
//        System.out.println(cf.read(id).getId());
//    }
//
//    @Test(expected = CompanyNotFoundException.class)
//    public void testDelete_Long() {
//        System.out.println("delete");
//        Long id = 3L;
//        Long expResult = 3L;
//        CompanyEntity result = cf.delete(id);
//        assertEquals(expResult, result.getId());
//        cf.read(id);
//    }
//    
//}
//
