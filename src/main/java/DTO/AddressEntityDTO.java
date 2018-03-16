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

    public String street;
    public String additionalInfo;

    public AddressEntityDTO(AddressEntity a) {
        this.street = a.getStreet();
        this.additionalInfo = a.getAdditionalInfo();
    }

    @Override
    public AddressEntity toInternal() {
        return new AddressEntity(street, additionalInfo);
    }

}
