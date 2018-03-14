/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Orchi
 */
@Entity
public class HobbyEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String name;
    private String description;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,  mappedBy = "hobbies")
    List<PersonEntity> persons = new ArrayList<>();
    
    public HobbyEntity() {
        
    }

    public HobbyEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public List<PersonEntity> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonEntity> persons) {
        this.persons = persons;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HobbyEntity)) {
            return false;
        }
        HobbyEntity other = (HobbyEntity) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HobbyEntity{" + "name=" + name + ", description=" + description + '}';
    }

    
}
