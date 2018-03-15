/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Stanislav
 */
public class PersonCountDTO implements JSONDTO<Object> {

    private Integer count;

    public PersonCountDTO(Integer count) {
        this.count = count;
    }

    @Override
    public Object toInternal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
