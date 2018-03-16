//package facades;
//
//import entities.PersonEntity;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
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
//    EntityManagerFactory emf;
//    EntityManager em;
//    EntityManagerControl emc;
//    PersonFacade pf;
//
//    public PersonFacadeTest() {
//    }
//
//    @Before
//    public void setUp() {
////        emf = Persistence.createEntityManagerFactory("persistenceTEST");
////        em = emf.createEntityManager();
////        Persistence.generateSchema("persistenceTEST", null);
//        emc = new EntityManagerControl();
//        emc.setPersistenceUnitName("persistenceTEST");
//        pf = new PersonFacade();
//        pf.emc = emc;
//
//    }
//
//    //@Test
//    public void testCreate() {
//        System.out.println("create");
//        PersonEntity object = new PersonEntity("xx", "xx", "test@email.dk");
//        PersonEntity expResult = object;
//        PersonEntity result = pf.create(object);
//        assertEquals(expResult, result);
//    }
//
//    //@Test
//    public void testRead_Long() {
//        System.out.println("read");
//        Long id = 1L;
//        PersonEntity expResult = null;
//        PersonEntity result = pf.read(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    //@Test
//    public void testRead_String() {
//        System.out.println("read");
//        String id = "";
//        PersonFacade instance = new PersonFacade();
//        PersonEntity expResult = null;
//        PersonEntity result = instance.read(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    //@Test
//    public void testReadAll() {
//        System.out.println("readAll");
//        PersonFacade instance = new PersonFacade();
//        List<PersonEntity> expResult = null;
//        List<PersonEntity> result = instance.readAll();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    //@Test
//    public void testUpdate_Long_PersonEntity() {
//        System.out.println("update");
//        Long id = null;
//        PersonEntity object = null;
//        PersonFacade instance = new PersonFacade();
//        PersonEntity expResult = null;
//        PersonEntity result = instance.update(id, object);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    //@Test
//    public void testUpdate_String_PersonEntity() {
//        System.out.println("update");
//        String id = "";
//        PersonEntity object = null;
//        PersonFacade instance = new PersonFacade();
//        PersonEntity expResult = null;
//        PersonEntity result = instance.update(id, object);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    //@Test
//    public void testDelete_Long() {
//        System.out.println("delete");
//        Long id = null;
//        PersonFacade instance = new PersonFacade();
//        PersonEntity expResult = null;
//        PersonEntity result = instance.delete(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testDelete_String() {
//        System.out.println("delete");
//        String id = "";
//        PersonFacade instance = new PersonFacade();
//        PersonEntity expResult = null;
//        PersonEntity result = instance.delete(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetPersonByPhoneNumber() {
//        System.out.println("getPersonByPhoneNumber");
//        Long number = null;
//        PersonFacade instance = new PersonFacade();
//        PersonEntity expResult = null;
//        PersonEntity result = instance.getPersonByPhoneNumber(number);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllPersonsByHobby() {
//        System.out.println("getAllPersonsByHobby");
//        String hobby = "";
//        PersonFacade instance = new PersonFacade();
//        List<PersonEntity> expResult = null;
//        List<PersonEntity> result = instance.getAllPersonsByHobby(hobby);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
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
//    @Test
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
//    @Test
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
