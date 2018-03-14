/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.HobbyEntity;
import entities.PersonEntity;
import facades.interfaces.CRUDInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistence.EntityManagerControl;

/**
 *
 * @author Mellem
 */
public class HobbyFacade implements CRUDInterface<HobbyEntity> {

    EntityManagerControl emc = new EntityManagerControl("persistence");
    EntityManager em = emc.getEm();

    @Override
    public HobbyEntity create(HobbyEntity object) {
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

    @Override
    public HobbyEntity read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HobbyEntity read(String id) {
        HobbyEntity h = em.find(HobbyEntity.class, id);
        if (h == null) {
            //TODO Exception stuffs
        }
        return h;
    }

    @Override
    public List<HobbyEntity> readAll() {
        Query q = em.createQuery("SELECT h FROM HobbyEntity h");
        List<HobbyEntity> list = (List<HobbyEntity>) q.getResultList();

        if (list.isEmpty()) {
            //TODO Exception stuffs
        }
        return list;
    }

    @Override
    public HobbyEntity update(Long id, HobbyEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HobbyEntity update(String id, HobbyEntity object) {
        object.setName(id);

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

    @Override
    public HobbyEntity delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HobbyEntity delete(String id) {
        HobbyEntity h = em.find(HobbyEntity.class, id);
        if (h == null) {
            //TODO throw Exception
        }

        try {
            em.getTransaction().begin();
            em.remove(h);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
        } finally {
            em.close();
        }
        return h;

    }

}
