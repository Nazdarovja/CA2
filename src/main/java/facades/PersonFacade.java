/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.InfoEntity;
import facades.interfaces.PersonFacadeInterface;
import entities.PersonEntity;
import entities.PhoneEntity;
import errors.code400.ValidationErrorException;
import errors.code404.PersonNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import persistence.EntityManagerControl;
import facades.interfaces.CRUDInterface;
import java.util.ArrayList;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Stanislav
 */
public class PersonFacade implements PersonFacadeInterface, CRUDInterface<PersonEntity> {

    EntityManagerControl emc;

    public PersonFacade() {
        emc = new EntityManagerControl();
    }

    public PersonFacade(EntityManagerControl emc) {
        this.emc = emc;
    }

    // ------- CRUD -------- CRUD -------- CRUD -------- CRUD --------
    // CREATE
    @Override
    public PersonEntity create(PersonEntity object) {
        EntityManager em = emc.getEm();
        if (object.getFirstName().equals("") || object.getLastName().equals("") || object.getEmail().equals("")) {
            throw new ValidationErrorException();
        }
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em
        } catch (EntityExistsException ex) {
            throw new PersonNotFoundException();
        } finally {
            em.close();
        }
        return object;
    }

    // READ
    @Override
    public PersonEntity read(Long id) {
        EntityManager em = emc.getEm();
        try {
            InfoEntity p = em.find(InfoEntity.class, id);
            if (p == null || !(p instanceof PersonEntity)) {
                throw new PersonNotFoundException();
            }
            return (PersonEntity) p;
        } finally {
            em.close();
        }
    }

    // READ
    @Override
    public PersonEntity read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // READ (all)
    @Override
    public List<PersonEntity> readAll() {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT p FROM PersonEntity p");
        List<PersonEntity> list = (List<PersonEntity>) q.getResultList();
        for (PersonEntity personEntity : list) {
            System.out.println(personEntity);
        }
        em.close();
        return list;
    }

    // UPDATE
    @Override
    public PersonEntity update(Long id, PersonEntity object) {
        EntityManager em = emc.getEm();
        if (object.getFirstName().equals("") || object.getLastName().equals("") || object.getEmail().equals("")) {
            throw new ValidationErrorException();
        }
        object.setId(id);
        if (em.find(PersonEntity.class, id) == null) {
            throw new PersonNotFoundException();
        }
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
        return object;
    }

    // UPDATE
    @Override
    public PersonEntity update(String id, PersonEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // DELETE
    @Override
    public PersonEntity delete(Long id) {
        EntityManager em = emc.getEm();
        PersonEntity p = em.find(PersonEntity.class, id);
        if (p == null) {
            throw new PersonNotFoundException();
        }
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    // DELETE
    @Override
    public PersonEntity delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonEntity getPersonByPhoneNumber(Long number) {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT p FROM PersonEntity p JOIN p.phones ph WHERE ph.number = :number");
        q.setParameter("number", number);
        try {
            PersonEntity p = (PersonEntity) q.getSingleResult();
            return p;
        } catch (NoResultException ex) {
            throw new PersonNotFoundException();
        } finally {
            em.close();
        }
    }

    @Override
    public List<PersonEntity> getAllPersonsByHobby(String hobby) {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT p FROM PersonEntity p JOIN p.hobbies h WHERE h.name = :hobby");
        q.setParameter("hobby", hobby);
        return q.getResultList();
    }

    @Override
    public List<PersonEntity> getAllPersonsByCity(String city) {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT p FROM PersonEntity p WHERE p.address.cityInfo.city = :city");
        q.setParameter("city", city);
        return q.getResultList();
    }

    @Override
    public List<PersonEntity> getAllPersonsByStreet(String street) {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT p FROM PersonEntity p WHERE p.address.street = :street");
        q.setParameter("street", street);
        return q.getResultList();
    }

    @Override
    public Integer getPersonCountByHobby(String hobby) {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT COUNT(p.id) FROM PersonEntity p JOIN p.hobbies h WHERE h.name = :hobby");
        q.setParameter("hobby", hobby);
        return ((Long) q.getSingleResult()).intValue();
    }

}
