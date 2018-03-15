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
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Orchi
 */
@Entity
public class CityInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String zipCode;
    private String city;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cityInfo")
    private List<AddressEntity> addresses = new ArrayList<>();

    public CityInfoEntity() {
    }

    public CityInfoEntity(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }
    
    public String getId() {
        return zipCode;
    }

    public void setId(String id) {
        this.zipCode = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipCode != null ? zipCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the zipCode fields are not set
        if (!(object instanceof CityInfoEntity)) {
            return false;
        }
        CityInfoEntity other = (CityInfoEntity) object;
        if ((this.zipCode == null && other.zipCode != null) || (this.zipCode != null && !this.zipCode.equals(other.zipCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CityInfoEntity[ id=" + zipCode + " ]";
    }
    
}
