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

    public HobbyEntityDTO(HobbyEntity he) {
        this.name = he.getName();
        this.description = he.getDescription();
    } 

    public String getName() {
        return name;
    }


    @Override
    public HobbyEntity toInternal() {
        return new HobbyEntity(name, description);
    }
}
