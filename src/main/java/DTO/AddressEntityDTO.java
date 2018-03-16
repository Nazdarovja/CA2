/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.AddressEntity;
import java.math.BigInteger;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class AddressEntityDTO implements JSONDTO<AddressEntity> {

    private Long id; // used for toInternal() and discarded when displayed in javascript later on.
    private String street;
    private String additionalInfo;
    private CityInfoEntityDTO cityInfo;

    public AddressEntityDTO(AddressEntity a) {
        this.id = a.getId();
        this.street = a.getStreet();
        this.additionalInfo = a.getAdditionalInfo();
        this.cityInfo = new CityInfoEntityDTO(a.getCityInfo());
    }

    public Long getId() {
        return id;
    }

    @Override
    public AddressEntity toInternal() {
        return new AddressEntity(id, street, additionalInfo, cityInfo.toInternal());
    }

}
