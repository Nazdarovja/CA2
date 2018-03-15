/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.CityInfoEntity;
import entities.CompanyEntity;
import errors.code400.ValidationErrorException;
import errors.code404.CityNotFoundException;
import errors.code404.CompanyNotFoundException;
import errors.code409.AlreadyExistsException;
import facades.interfaces.CompanyFacadeInterface;
import java.util.List;
import facades.interfaces.CRUDInterface;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import persistence.EntityManagerControl;

/**
 *
 * @author Mellem
 */
public class CompanyFacade implements CompanyFacadeInterface, CRUDInterface<CompanyEntity> {

    EntityManagerControl emc = new EntityManagerControl();
    DTOFacade dto = new DTOFacade();

    @Override
    public CompanyEntity getCompanyByPhoneNumberJSON(Integer phoneNumber) {
        EntityManager em = emc.getEm();
        Query query = em.createQuery("SELECT p from PersonEntity p JOIN p.phones ph WHERE ph.number = :number");
        query.setParameter("number", phoneNumber);
        try {
            CompanyEntity ce = (CompanyEntity) query.getSingleResult();
            em.close();
            return ce; 
        }
        catch(NoResultException ex) {
            throw new CompanyNotFoundException();
        }
    }

    @Override
    public int getCompanyCountByZipCode(String zipcode) {
        EntityManager em = emc.getEm();
        Query query = em.createQuery("SELECT count(c.id) from CompanyEntity c WHERE c.address.cityInfo.zipCode = :zipcode");
        query.setParameter("zipcode", zipcode);
        return (int) query.getSingleResult();
    }

    @Override
    public List<CompanyEntity> getCompaniesByMarketValueAbove(Long marketValue) {
        EntityManager em = emc.getEm();
        Query query = em.createQuery("SELECT c from CompanyEntity c WHERE c.marketValue > :marketValue");
        query.setParameter("marketValue", marketValue);
        return query.getResultList();
        
    }

    @Override
    public int getCompanyCountByNumEmployeesBelow(Integer numEmployees) {
        EntityManager em = emc.getEm();
        Query query = em.createQuery("SELECT count(c.id) from CompanyEntity c WHERE c.numEmployees < :numEmployees");
        query.setParameter("numEmployees", numEmployees);
        return (int) query.getSingleResult();
    }

    // ------- CRUD -------- CRUD -------- CRUD -------- CRUD --------
    // CREATE
    @Override
    public CompanyEntity create(CompanyEntity object) {
        EntityManager em = emc.getEm();
        if(object.getName().equals("") || object.getCvr() == 0)
            throw new ValidationErrorException();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em
        }
        catch(EntityExistsException ex) {
            throw new AlreadyExistsException();
        }
        finally {
            em.close();
        }
        return object;
    }

    // READ
    @Override
    public CompanyEntity read(Long id) {
        EntityManager em = emc.getEm();
        CompanyEntity c = em.find(CompanyEntity.class, id);
        if (c == null) {
            throw new CompanyNotFoundException();
        }
        em.close();
        return c;
    }

    // READ
    @Override
    public CompanyEntity read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // READ (all)
    @Override
    public List<CompanyEntity> readAll() {
        EntityManager em = emc.getEm();
        Query q = em.createQuery("SELECT c FROM CompanyEntity c");
        List<CompanyEntity> list = (List<CompanyEntity>) q.getResultList();
        em.close();
        return list;
    }

    // UPDATE
    @Override
    public CompanyEntity update(Long id, CompanyEntity object) {
        EntityManager em = emc.getEm();
        object.setId(id);
        if(object.getName().equals("") || object.getCvr() == 0)
            throw new ValidationErrorException();
         if(em.find(CompanyEntity.class, id) == null)
            throw new CompanyNotFoundException();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
        return object;
    }

    // UPDATE
    @Override
    public CompanyEntity update(String id, CompanyEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // DELETE
    @Override
    public CompanyEntity delete(Long id) {
        EntityManager em = emc.getEm();
        CompanyEntity c = em.find(CompanyEntity.class, id);
        if (c == null) 
            throw new CompanyNotFoundException();
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();
        return c;
    }

    // DELETE
    @Override
    public CompanyEntity delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
