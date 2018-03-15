/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.PersonEntity;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import persistence.EntityManagerControl;

/**
 *
 * @author awha8
 */
public class PersonFacadeTest {
    
        EntityManagerControl emc = new EntityManagerControl();
        
        EntityManager em = emc.getEm();
    
    public PersonFacadeTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    @org.junit.Test
    public void testCreate() {
        System.out.println("create");
        PersonEntity object = null;
        PersonFacade instance = new PersonFacade();
        PersonEntity expResult = null;
        PersonEntity result = instance.create(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testRead_Long() {
        System.out.println("read");
        Long id = null;
        PersonFacade instance = new PersonFacade();
        PersonEntity expResult = null;
        PersonEntity result = instance.read(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testRead_String() {
        System.out.println("read");
        String id = "";
        PersonFacade instance = new PersonFacade();
        PersonEntity expResult = null;
        PersonEntity result = instance.read(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testReadAll() {
        System.out.println("readAll");
        PersonFacade instance = new PersonFacade();
        List<PersonEntity> expResult = null;
        List<PersonEntity> result = instance.readAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testUpdate_Long_PersonEntity() {
        System.out.println("update");
        Long id = null;
        PersonEntity object = null;
        PersonFacade instance = new PersonFacade();
        PersonEntity expResult = null;
        PersonEntity result = instance.update(id, object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testUpdate_String_PersonEntity() {
        System.out.println("update");
        String id = "";
        PersonEntity object = null;
        PersonFacade instance = new PersonFacade();
        PersonEntity expResult = null;
        PersonEntity result = instance.update(id, object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testDelete_Long() {
        System.out.println("delete");
        Long id = null;
        PersonFacade instance = new PersonFacade();
        PersonEntity expResult = null;
        PersonEntity result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testDelete_String() {
        System.out.println("delete");
        String id = "";
        PersonFacade instance = new PersonFacade();
        PersonEntity expResult = null;
        PersonEntity result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testGetPersonByPhoneNumber() {
        System.out.println("getPersonByPhoneNumber");
        Long number = null;
        PersonFacade instance = new PersonFacade();
        PersonEntity expResult = null;
        PersonEntity result = instance.getPersonByPhoneNumber(number);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testGetAllPersonsByHobby() {
        System.out.println("getAllPersonsByHobby");
        String hobby = "";
        PersonFacade instance = new PersonFacade();
        List<PersonEntity> expResult = null;
        List<PersonEntity> result = instance.getAllPersonsByHobby(hobby);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testGetAllPersonsByCity() {
        System.out.println("getAllPersonsByCity");
        String city = "";
        PersonFacade instance = new PersonFacade();
        List<PersonEntity> expResult = null;
        List<PersonEntity> result = instance.getAllPersonsByCity(city);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testGetAllPersonsByStreet() {
        System.out.println("getAllPersonsByStreet");
        String street = "";
        PersonFacade instance = new PersonFacade();
        List<PersonEntity> expResult = null;
        List<PersonEntity> result = instance.getAllPersonsByStreet(street);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testGetPersonCountByHobby() {
        System.out.println("getPersonCountByHobby");
        String hobby = "";
        PersonFacade instance = new PersonFacade();
        Integer expResult = null;
        Integer result = instance.getPersonCountByHobby(hobby);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
