/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stanislav
 */
public class EntityManagerControl {

    EntityManagerFactory emf;

    public EntityManagerControl() {
        this.emf = Persistence.createEntityManagerFactory("persistence");
    }

    public EntityManagerControl(HashMap<String, String> map) {
        this.emf = Persistence.createEntityManagerFactory("persistence",map);
    }
    
    public EntityManager getEm() {
        return emf.createEntityManager();
    }

    public void setTestEmf() {
        this.emf = Persistence.createEntityManagerFactory("");
    }

    public void setProductionEmf(String persistenceUnitName) {
        this.emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    public void setPersistenceUnitName(String persistenceUnitName){
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }
}
