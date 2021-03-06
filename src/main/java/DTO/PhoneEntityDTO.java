/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.PhoneEntity;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class PhoneEntityDTO implements JSONDTO<PhoneEntity> {

    private Long number;
    private String description;

    public PhoneEntityDTO(PhoneEntity p) {
        this.number = p.getNumber();
        this.description = p.getDescription();
    }

    public Long getNumber() {
        return number;
    }

    @Override
    public PhoneEntity toInternal() {
        return new PhoneEntity(number, description);
    }

}
