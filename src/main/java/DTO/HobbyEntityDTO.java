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
public class HobbyEntityDTO implements JSONDTO<HobbyEntity>{
    private String name;
    private String description;

    public HobbyEntityDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
        
    @Override
    public HobbyEntity toInternal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
