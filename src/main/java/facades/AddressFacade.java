/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.AddressEntity;
import errors.code400.ValidationErrorException;
import errors.code404.AddressNotFoundException;
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
public class AddressFacade implements CRUDInterface<AddressEntity> {

    EntityManagerControl emc = new EntityManagerControl();
    DTOFacade dto = new DTOFacade();

    @Override
    public AddressEntity create(AddressEntity address) {
        if(address.getStreet().equals(""))
            throw new ValidationErrorException();
        EntityManager em = emc.getEm();
        try {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
        } //CATCH BLOCK //CATCH BLOCK
        catch(EntityExistsException ex) {
            throw new AlreadyExistsException();
        }
        finally {
            em.close();
        }
        return address;
    }

    @Override
    public AddressEntity read(Long id) {
        EntityManager em = emc.getEm();
        AddressEntity ae = em.find(AddressEntity.class, this);
        if (ae == null) {
            throw new AddressNotFoundException();
        }
        em.close();
        return ae;
    }

    @Override
    public AddressEntity read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddressEntity> readAll() {
        EntityManager em = emc.getEm();
        return em.createQuery("SELECT a FROM AddressEntity a").getResultList();
    }

    @Override
    public AddressEntity update(Long id, AddressEntity object) {
        EntityManager em = emc.getEm();
        if(object.getStreet().equals(""))
            throw new ValidationErrorException();
        if(em.find(AddressEntity.class, id) == null)
            throw new AddressNotFoundException();
        object.setId(id);
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
        return object;
    }

    @Override
    public AddressEntity update(String id, AddressEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddressEntity delete(Long id) {
        EntityManager em = emc.getEm();
        AddressEntity ae = em.find(AddressEntity.class, id);
        if (ae == null)
            throw new AddressNotFoundException();
        em.getTransaction().begin();
        em.remove(ae);
        em.getTransaction().commit();
        em.close();
        return ae;
    }

    @Override
    public AddressEntity delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
