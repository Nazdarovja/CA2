/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.AddressEntity;
import entities.PhoneEntity;
import facades.interfaces.CRUDInterface;
import java.util.List;
import javax.persistence.EntityManager;
import persistence.EntityManagerControl;

/**
 *
 * @author Mellem
 */
public class AddressFacade implements CRUDInterface<AddressEntity> {
    
    EntityManagerControl emc = new EntityManagerControl("persistence");
    EntityManager em = emc.getEm();
    DTOFacade dto = new DTOFacade();

    @Override
    public AddressEntity create(AddressEntity address) {
        try {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
        } //CATCH BLOCK //CATCH BLOCK
        finally {
            em.close();
        }
        return address;
    }

    @Override
    public AddressEntity read(Long id) {
        AddressEntity ae = em.find(AddressEntity.class, this);
        if(ae == null) {
            //ERROR Handling
        }
        return ae;
    }

    @Override
    public AddressEntity read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddressEntity> readAll() {
        return em.createQuery("SELECT a FROM AddressEntity a").getResultList();
    }

    @Override
    public AddressEntity update(Long id, AddressEntity object) {
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
    public AddressEntity update(String id, AddressEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddressEntity delete(Long id) {
        try {
            AddressEntity ae = em.find(AddressEntity.class, id);
            em.getTransaction().begin();
            em.remove(ae);
            em.getTransaction().commit();
            return ae;
        }
        finally {
            em.close();
        }
    }

    @Override
    public AddressEntity delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
