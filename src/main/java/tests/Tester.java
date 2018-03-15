/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.HobbyEntity;
import entities.PersonEntity;
import facades.PersonFacade;
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
        
        PersonFacade pf = new PersonFacade();

        PersonEntity p = new PersonEntity("wazza", "name", "abe@banan.dk");
        p.addHobby(new HobbyEntity("Hoppe", "wauw"));
        p.addHobby(new HobbyEntity("cykle", "hurtigt"));
        p.addHobby(new HobbyEntity("spillePUBG", "Sindzygt"));
        PersonEntity p1 = new PersonEntity("wazza2", "name2", "abe@badasdnan.dk");
        p.addHobby(new HobbyEntity("løbe", "Sindzygt2"));
        p.addHobby(new HobbyEntity("lavememes", "Sindzygt524"));
        PersonEntity p2 = new PersonEntity("wazza3", "nam3", "abe@banadsadsddddddddddn.dk");
        
        pf.create(p);
        pf.create(p1);
        pf.create(p2);
        
    }
    
}
