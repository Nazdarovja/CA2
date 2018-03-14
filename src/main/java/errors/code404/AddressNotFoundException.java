/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors.code404;

/**
 *
 * @author Orchi
 */
public class AddressNotFoundException extends NotFoundException {
    
     public AddressNotFoundException() {
        message = "Address not found!";
    }
    
}
