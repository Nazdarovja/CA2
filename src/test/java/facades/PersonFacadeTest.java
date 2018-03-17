//package facades;
//
//import entities.PersonEntity;
//import java.util.HashMap;
//import java.util.List;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import persistence.EntityManagerControl;
//
///**
// *
// * @author awha8
// */
//public class PersonFacadeTest {
//    
//    EntityManagerControl emc;
//    PersonFacade pf;
//    HashMap<String, String> persistenceMap = new HashMap<>();
//
//    public PersonFacadeTest() {
//    }
//
//    @Before
//    public void setUp() {
//        persistenceMap.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/ca2test");
//        emc = new EntityManagerControl(persistenceMap);
//        pf = new PersonFacade(emc);
//
//    }
//
//    @Test
//    public void testRead_Long() {
//        System.out.println("read");
//        Long id = 1L;
//        Long expResult = 1L;
//        Long result = pf.read(id).getId();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testCreate() {
//        System.out.println("create");
//        PersonEntity object = new PersonEntity("xx", "xx", "newlycreated@email.dk");
//        PersonEntity expResult = object;
//        PersonEntity result = pf.create(object);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testReadAll() {
//        System.out.println("readAll");
//        int expResult = 10;
//        List<PersonEntity> result = pf.readAll();
//        assertEquals(expResult, result.size(), 1);
//    }
//
//    @Test
//    public void testUpdate_Long_PersonEntity() {
//        System.out.println("update");
//        Long id = 11L;
//        PersonEntity newObject = new PersonEntity("NEW UPDATED", "PERSON", "NEWUPDATEDPERSON@email.dk");
//        Long expResult = 11L;
//        PersonEntity result = pf.update(id, newObject);
//        assertEquals(expResult, result.getId());
//    }
//
//    @Test
//    public void testDelete_Long() {
//        System.out.println("delete");
//        Long id = 11L;
//        Long expResult = 11L;
//        PersonEntity result = pf.delete(id);
//        assertEquals(expResult, result.getId());
//    }
//
//    @Test
//    public void testGetPersonByPhoneNumber() {
//        System.out.println("getPersonByPhoneNumber");
//        Long number = 12345700L;
//        Long expResult = 12L;
//        PersonEntity person = pf.getPersonByPhoneNumber(number);
//        Long result = person.getId();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testGetAllPersonsByHobby() {
//        System.out.println("getAllPersonsByHobby");
//        int expResult = 3;
//        List<PersonEntity> list = pf.getAllPersonsByHobby("floorball");
//        int result = list.size();
//        Long expPersId1 = 12L;
//        Long expPersId2 = 13L;
//        Long expPersId3 = 18L;
//        
//        assertEquals(expPersId1, list.get(0).getId());
//        assertEquals(expPersId2, list.get(1).getId());
//        assertEquals(expPersId3, list.get(2).getId());
//        assertEquals(expResult, result);
//    }
//
//    //@Test
//    public void testGetAllPersonsByCity() {
//        System.out.println("getAllPersonsByCity");
//        String city = "";
//        PersonFacade instance = new PersonFacade();
//        List<PersonEntity> expResult = null;
//        List<PersonEntity> result = instance.getAllPersonsByCity(city);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    //@Test
//    public void testGetAllPersonsByStreet() {
//        System.out.println("getAllPersonsByStreet");
//        String street = "";
//        PersonFacade instance = new PersonFacade();
//        List<PersonEntity> expResult = null;
//        List<PersonEntity> result = instance.getAllPersonsByStreet(street);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    //@Test
//    public void testGetPersonCountByHobby() {
//        System.out.println("getPersonCountByHobby");
//        String hobby = "";
//        PersonFacade instance = new PersonFacade();
//        Integer expResult = null;
//        Integer result = instance.getPersonCountByHobby(hobby);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//}
