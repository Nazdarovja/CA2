/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.CityInfoEntity;
import entities.HobbyEntity;
import facades.interfaces.CRUDInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistence.EntityManagerControl;

/**
 *
 * @author Mellem
 */
public class CityInfoFacade implements CRUDInterface<CityInfoEntity> {

    EntityManagerControl emc = new EntityManagerControl("persistence");
    EntityManager em = emc.getEm();

    @Override
    public CityInfoEntity create(CityInfoEntity object) {
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
    public CityInfoEntity read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CityInfoEntity read(String id) {
        CityInfoEntity cI = em.find(CityInfoEntity.class, id);
        if (cI == null) {
            //TODO Exception stuffs
        }
        return cI;
    }

    @Override
    public List<CityInfoEntity> readAll() {
        Query q = em.createQuery("SELECT cI FROM CityInfoEntity cI");
        List<CityInfoEntity> list = (List<CityInfoEntity>) q.getResultList();

        if (list.isEmpty()) {
            //TODO Exception stuffs
        }
        return list;
    }

    @Override
    public CityInfoEntity update(Long id, CityInfoEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CityInfoEntity update(String id, CityInfoEntity object) {
        object.setZipCode(id);

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
    public CityInfoEntity delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CityInfoEntity delete(String id) {
        CityInfoEntity cI = em.find(CityInfoEntity.class, id);
        if (cI == null) {
            //TODO throw Exception
        }

        try {
            em.getTransaction().begin();
            em.remove(cI);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
        } finally {
            em.close();
        }
        return cI;

    }

}
