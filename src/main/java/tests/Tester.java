/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Orchi
 */
public class Tester {
    
    EntityManagerFactory emf;
    
    public Tester(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Tester() {
    }
    
    public EntityManager getEntityManager(){ 
        return emf.createEntityManager();
    }
    
    public static void main(String[] args) {
      
        Tester tester = new Tester(Persistence.createEntityManagerFactory("persistence"));
        EntityManager em = tester.getEntityManager();
        Persistence.generateSchema("persistence", null);
        
    }
    
}
