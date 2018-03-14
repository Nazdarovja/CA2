/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import facades.interfaces.PersonFacadeInterface;
import DTO.PersonEntityDTO;
import entities.CompanyEntity;
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

    @Override
    public PersonEntity createPerson(String message) {
        PersonEntity p = dto.fromJson(message, PersonEntityDTO.class);
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em
        } finally {
            em.close();
        }
        return p;
    }

    @Override
    public PersonEntity getPerson(Long id) {
        PersonEntity p = em.find(PersonEntity.class, id);
        if (p == null) {
            //TODO Exception stuffs
        }
        return p;
    }

    @Override
    public PersonEntity updatePerson(Long id, String message) {
        PersonEntity p = dto.fromJson(message, PersonEntityDTO.class);
        p.setId(id);

        try {
            em.getTransaction().begin();
            //TODO catch exception thrown by .merge() (IllegalArgumentException) if person does not exist in DB
            em.merge(p);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
        } finally {
            em.close();
        }
        return p;
    }

    @Override
    public PersonEntity deletePerson(Long id) {
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

    @Override
    public PersonEntity getPersonByPhoneNumber(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonEntity> getAllPersonsByHobby(String hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonEntity> getAllPersonsByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonEntity> getAllPersonsByStreet(String street) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getPersonCountByHobby(String hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
    
    
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
        Query q = em.createQuery("SELECT c FROM CompanyEntity c");
        List<PersonEntity> list = (List<PersonEntity>)q.getResultList();
        
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

}
