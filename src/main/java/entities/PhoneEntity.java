/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Orchi
 */
@Entity
public class PhoneEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer number;
    private String description;

    public PhoneEntity() {
    }
    
    public PhoneEntity(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getId() {
        return number;
    }

    public void setId(int id) {
        this.number = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the number fields are not set
        if (!(object instanceof PhoneEntity)) {
            return false;
        }
        PhoneEntity other = (PhoneEntity) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PhoneEntity[ id=" + number + " ]";
    }
    
}
