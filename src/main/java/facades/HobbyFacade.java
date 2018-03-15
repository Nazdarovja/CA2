/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.CityInfoEntity;
import entities.HobbyEntity;
import entities.PersonEntity;
import errors.code400.ValidationErrorException;
import errors.code404.CityNotFoundException;
import errors.code404.HobbyNotFoundException;
import errors.code409.AlreadyExistsException;
import facades.interfaces.CRUDInterface;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistence.EntityManagerControl;

/**
 *
 * @author Mellem
 */
public class HobbyFacade implements CRUDInterface<HobbyEntity> {

    EntityManagerControl emc = new EntityManagerControl();

    @Override
    public HobbyEntity create(HobbyEntity object) {
        EntityManager em = emc.getEm();
        if(object.getName().equals("") || object.getDescription().equals(""))
            throw new ValidationErrorException();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } 
        catch(EntityExistsException ex) {
            throw new AlreadyExistsException();
        }
        finally {
            em.close();
        }
        return object;
    }

    @Override
    public HobbyEntity read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HobbyEntity read(String id) {
        EntityManager em = emc.getEm();
        HobbyEntity h = em.find(HobbyEntity.class, id);
        if (h == null) {
            throw new HobbyNotFoundException();
        }
        em.close();
        return h;
    }

    @Override
    public List<HobbyEntity> readAll() {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT h FROM HobbyEntity h");
        List<HobbyEntity> list = (List<HobbyEntity>) q.getResultList();
        em.close();
        return list;
    }

    @Override
    public HobbyEntity update(Long id, HobbyEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HobbyEntity update(String id, HobbyEntity object) {
        EntityManager em = emc.getEm();
        if(object.getName().equals("") || object.getDescription().equals(""))
            throw new ValidationErrorException();
        object.setName(id);
        if(em.find(HobbyEntity.class, id) == null)
            throw new HobbyNotFoundException();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
        return object;
    }

    @Override
    public HobbyEntity delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HobbyEntity delete(String id) {
        EntityManager em = emc.getEm();
        HobbyEntity h = em.find(HobbyEntity.class, id);
        if (h == null) 
            throw new HobbyNotFoundException();
        em.getTransaction().begin();
        em.remove(h);
        em.getTransaction().commit();
        em.close();
        return h;
    }

}
