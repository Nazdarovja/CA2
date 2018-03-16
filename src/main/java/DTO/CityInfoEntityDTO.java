/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.CityInfoEntity;

/**
 *
 * @author Stanislav
 */
public class CityInfoEntityDTO implements JSONDTO<CityInfoEntity> {

    private String zipCode;
    private String city;

    public CityInfoEntityDTO(CityInfoEntity cie) {
        this.zipCode = cie.getZipCode();
        this.city = cie.getCity();
    }

    @Override
    public CityInfoEntity toInternal() {
        return new CityInfoEntity(zipCode, city);
    }
}
