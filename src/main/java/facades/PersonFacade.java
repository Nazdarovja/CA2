/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import facades.interfaces.PersonFacadeInterface;
import entities.PersonEntity;
import java.util.List;
import javax.persistence.EntityManager;
import persistence.EntityManagerControl;
import facades.interfaces.CRUDInterface;
import javax.persistence.Query;

/**
 *
 * @author Stanislav
 */
public class PersonFacade implements PersonFacadeInterface, CRUDInterface<PersonEntity> {

    EntityManagerControl emc = new EntityManagerControl("persistence");
    EntityManager em = emc.getEm();
    DTOFacade dto = new DTOFacade();

    // ------- CRUD -------- CRUD -------- CRUD -------- CRUD --------
    // CREATE
    @Override
    public PersonEntity create(PersonEntity object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em
        } finally {
            em.close();
        }
        return object;
    }

    // READ
    @Override
    public PersonEntity read(Long id) {
        PersonEntity p = em.find(PersonEntity.class, id);
        if (p == null) {
            //TODO Exception stuffs
        }
        return p;
    }

    // READ
    @Override
    public PersonEntity read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // READ (all)
    @Override
    public List<PersonEntity> readAll() {
        Query q = em.createQuery("SELECT p FROM PersonEntity p");
        List<PersonEntity> list = (List<PersonEntity>) q.getResultList();

        if (list.isEmpty()) {
            //TODO Exception stuffs
        }
        return list;
    }

    // UPDATE
    @Override
    public PersonEntity update(Long id, PersonEntity object) {
        object.setId(id);

        try {
            em.getTransaction().begin();
            //TODO catch exception thrown by .merge() (IllegalArgumentException) if person does not exist in DB
            em.merge(object);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
        } finally {
            em.close();
        }
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
        PersonEntity p = em.find(PersonEntity.class, id);
        if (p == null) {
            //TODO throw Exception
        }

        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
        } finally {
            em.close();
        }
        return p;
    }

    // DELETE
    @Override
    public PersonEntity delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonEntity getPersonByPhoneNumber(Integer number) {

        Query q = em.createQuery("SELECT p FROM PersonEntity p JOIN p.phones ph WHERE ph.number = :number");
        q.setParameter("number", number);
        PersonEntity p = (PersonEntity) q.getSingleResult();
        if (p == null) {
            //TODO throw Exception
        }
        return p;
        //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
    }

    @Override
    public List<PersonEntity> getAllPersonsByHobby(String hobby) {
        Query q = em.createQuery("SELECT p FROM PersonEntity p JOIN p.hobbies h WHERE h.name = :hobby");
        q.setParameter("hobby", hobby);
        List<PersonEntity> persons = (List<PersonEntity>) q.getResultList();
        if (persons == null) {
            //TODO throw Exception
        }
        return persons;
        //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
    }

    @Override
    public List<PersonEntity> getAllPersonsByCity(String city) {
        Query q = em.createQuery("SELECT p FROM PersonEntity p WHERE p.address.cityInfo.city = :city");
        q.setParameter("city", city);
        List<PersonEntity> persons = (List<PersonEntity>) q.getResultList();
        if (persons == null) {
            //TODO throw Exception
        }
        return persons;
        //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
    }

    @Override
    public List<PersonEntity> getAllPersonsByStreet(String street) {
        Query q = em.createQuery("SELECT p FROM PersonEntity p WHERE p.address.street = :street");
        q.setParameter("street", street);
        List<PersonEntity> persons = (List<PersonEntity>) q.getResultList();
        if (persons == null) {
            //TODO throw Exception
        }
        return persons;
        //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
    }

    @Override
    public Integer getPersonCountByHobby(String hobby) {
        Integer res = 0;
        Query q = em.createQuery("SELECT COUNT(p.id) FROM PersonEntity p JOIN p.hobbies h WHERE h.name = :hobby");
        q.setParameter("hobby", hobby);
        res = (Integer) q.getSingleResult();
        if (res == null) {
            //TODO Throw approp. Exception
        }
        return res;
    }

}
