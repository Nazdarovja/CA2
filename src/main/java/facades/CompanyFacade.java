/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.PersonEntityDTO;
import entities.CompanyEntity;
import entities.PersonEntity;
import facades.interfaces.CompanyFacadeInterface;
import java.util.List;
import facades.interfaces.CRUDInterface;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistence.EntityManagerControl;

/**
 *
 * @author Mellem
 */
public class CompanyFacade implements CompanyFacadeInterface, CRUDInterface<CompanyEntity> {

    EntityManagerControl emc = new EntityManagerControl("persistence");
    EntityManager em = emc.getEm();
    DTOFacade dto = new DTOFacade();
    
    @Override
    public CompanyEntity getCompanyByPhoneNumberJSON(Integer phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCompanyCountByZipCode(String zipcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CompanyEntity> getCompaniesByMarketValueAbove(Long marketValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCompanyCountByNumEmployeesBelow(Integer numEmployees) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    // ------- CRUD -------- CRUD -------- CRUD -------- CRUD --------
    
    // CREATE
    @Override
    public CompanyEntity create(CompanyEntity object) {
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

    // READ
    @Override
    public CompanyEntity read(Long id) {
        CompanyEntity c = em.find(CompanyEntity.class, id);
        if (c == null) {
            //TODO Exception stuffs
        }
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
        Query q = em.createQuery("SELECT c FROM CompanyEntity c");
        List<CompanyEntity> list = (List<CompanyEntity>)q.getResultList();
        
        if (list.isEmpty()) {
            //TODO Exception stuffs
        }
        return list;
    }

    // UPDATE
    @Override
    public CompanyEntity update(Long id, CompanyEntity object) {
        object.setId(id);

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

    // UPDATE
    @Override
    public CompanyEntity update(String id, CompanyEntity object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // DELETE
    @Override
    public CompanyEntity delete(Long id) {
        CompanyEntity c = em.find(CompanyEntity.class, id);
        if (c == null) {
            //TODO throw Exception
        }

        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            //TODO Add Catchblock to catch all RuntimeExceptions from em (convert to appropriate ex)
        } finally {
            em.close();
        }
        return c;
    }

    // DELETE
    @Override
    public CompanyEntity delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
