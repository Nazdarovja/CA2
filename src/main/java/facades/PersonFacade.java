/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.PersonEntityDTO;
import entities.PersonEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistence.EntityManagerControl;

/**
 *
 * @author Stanislav
 */
public class PersonFacade implements PersonFacadeInterface {

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
    public List<PersonEntity> getAllPersonsByStreet(String street
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getPersonCountByHobby(String hobby
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
