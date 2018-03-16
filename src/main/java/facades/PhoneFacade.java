/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.PhoneEntity;
import errors.code400.ValidationErrorException;
import errors.code404.PhoneNotFoundException;
import errors.code409.AlreadyExistsException;
import facades.interfaces.CRUDInterface;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import persistence.EntityManagerControl;

/**
 *
 * @author Mellem
 */
public class PhoneFacade implements CRUDInterface<PhoneEntity> {

    EntityManagerControl emc = new EntityManagerControl();
    DTOFacade dto = new DTOFacade();

    @Override
    public PhoneEntity create(PhoneEntity phone) {
        EntityManager em = emc.getEm();
        if(phone.getNumber() == 0L || phone.getDescription().equals(""))
            throw new ValidationErrorException();
        try {
            em.getTransaction().begin();
            em.persist(phone);
            em.getTransaction().commit();
        } 
        catch(EntityExistsException ex) {
            throw new AlreadyExistsException();
        }
        finally {
            em.close();
        }
        return phone;
    }

    @Override
    public PhoneEntity read(Long id) {
        EntityManager em = emc.getEm();
        PhoneEntity pe = em.find(PhoneEntity.class, id);
        if (pe == null) {
            throw new PhoneNotFoundException();
        }
        return pe;
    }

    @Override
    public PhoneEntity read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhoneEntity> readAll() {
        EntityManager em = emc.getEm();
        return em.createQuery("SELECT p FROM PhoneEntity p").getResultList();
    }

    @Override
    public PhoneEntity update(Long id, PhoneEntity object) {
        EntityManager em = emc.getEm();
        if(object.getNumber() == 0L || object.getDescription().equals(""))
            throw new ValidationErrorException();
        object.setId(id);
        if(em.find(PhoneEntity.class, id) == null) 
            throw new PhoneNotFoundException();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
        return object;
    }

    @Override
    public PhoneEntity update(String id, PhoneEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhoneEntity delete(Long id) {
        EntityManager em = emc.getEm();
        PhoneEntity pe = em.find(PhoneEntity.class, id);
        if(pe == null) 
            throw new PhoneNotFoundException();
        em.getTransaction().begin();
        em.remove(pe);
        em.getTransaction().commit();
        em.close();
        return pe;
    }

    @Override
    public PhoneEntity delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
