/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.PhoneEntity;
import facades.interfaces.CRUDInterface;
import java.util.List;
import javax.persistence.EntityManager;
import persistence.EntityManagerControl;

/**
 *
 * @author Mellem
 */
public class PhoneFacade implements CRUDInterface<PhoneEntity> {

    EntityManagerControl emc = new EntityManagerControl("persistence");
    EntityManager em = emc.getEm();
    DTOFacade dto = new DTOFacade();
    
    @Override
    public PhoneEntity create(PhoneEntity phone) {
        try {
            em.getTransaction().begin();
            em.persist(phone);
            em.getTransaction().commit();
        } //CATCH BLOCK
        finally {
            em.close();
        }
        return phone;
    }

    @Override
    public PhoneEntity read(Long id) {
        PhoneEntity pe = em.find(PhoneEntity.class, this);
        if(pe == null) {
            //ERROR Handling
        }
        return pe;
    }

    @Override
    public PhoneEntity read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhoneEntity> readAll() {
        return em.createQuery("SELECT p FROM PhoneEntity p").getResultList();
    }

    @Override
    public PhoneEntity update(Long id, PhoneEntity object) {
        object.setId(id);
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return object;
        } 
        finally {
            em.close();
        }
    }

    @Override
    public PhoneEntity update(String id, PhoneEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhoneEntity delete(Long id) {
        try {
            PhoneEntity pe = em.find(PhoneEntity.class, id);
            em.getTransaction().begin();
            em.remove(pe);
            em.getTransaction().commit();
            return pe;
        }
        finally {
            em.close();
        }
    }

    @Override
    public PhoneEntity delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
