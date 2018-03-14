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
