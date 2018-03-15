/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.InfoEntity;
import entities.PhoneEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stanislav
 */
public class InfoEntityDTO implements JSONDTO<InfoEntity> {

    public String email;
    public List<PhoneEntity> phones = new ArrayList();

    public InfoEntityDTO(InfoEntity e) {
        this.email = e.getEmail();
        e.getPhones().forEach((p) -> {
            this.phones.add(new PhoneEntity(p.getNumber(), p.getDescription()));
        });
    }

    @Override
    public InfoEntity toInternal() {
        InfoEntity i = new InfoEntity(email) {
        };

        //TOFIX lidt i tvivl om hvordan vi skal få fat i de rigtige objekter her
        List<PhoneEntity> phones = new ArrayList();
        // ADD MAGIC HERE ! :D 

        i.setPhones(phones);
        return i;
    }

}
