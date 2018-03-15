/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.CityInfoEntity;
import errors.code400.ValidationErrorException;
import errors.code404.CityNotFoundException;
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
public class CityInfoFacade implements CRUDInterface<CityInfoEntity> {

    EntityManagerControl emc = new EntityManagerControl();

    @Override
    public CityInfoEntity create(CityInfoEntity object) {
        if(object.getCity().equals("") || object.getZipCode().equals(""))
            throw new ValidationErrorException();
        EntityManager em = emc.getEm();
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
    public CityInfoEntity read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CityInfoEntity read(String id) {
        EntityManager em = emc.getEm();
        CityInfoEntity cI = em.find(CityInfoEntity.class, id);
        if (cI == null) {
            throw new CityNotFoundException();
        }
        em.close();
        return cI;
    }

    @Override
    public List<CityInfoEntity> readAll() {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT cI FROM CityInfoEntity cI");
        List<CityInfoEntity> list = (List<CityInfoEntity>) q.getResultList();
        em.close();
        return list;
    }

    @Override
    public CityInfoEntity update(Long id, CityInfoEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CityInfoEntity update(String id, CityInfoEntity object) {
        EntityManager em = emc.getEm();
        object.setZipCode(id);
        if(object.getCity().equals("") || object.getZipCode().equals(""))
            throw new ValidationErrorException();
        if(em.find(CityInfoEntity.class, id) == null)
            throw new CityNotFoundException();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
        return object;
   
    }

    @Override
    public CityInfoEntity delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CityInfoEntity delete(String id) {
        EntityManager em = emc.getEm();
        CityInfoEntity cI = em.find(CityInfoEntity.class, id);
        if (cI == null) 
            throw new CityNotFoundException();
        em.getTransaction().begin();
        em.remove(cI);
        em.getTransaction().commit();
        em.close();
        return cI;

    }

}
