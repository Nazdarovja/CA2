/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.HobbyEntity;

/**
 *
 * @author Stanislav
 */
public class HobbyEntityDTO implements JSONDTO<HobbyEntity> {

    private String name;
    private String description;

    public HobbyEntityDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public HobbyEntityDTO(HobbyEntity h) {
        this.name = h.getName();
        this.description = h.getDescription();
    }

    @Override
    public HobbyEntity toInternal() {
        return new HobbyEntity(name, description);
    }

}
