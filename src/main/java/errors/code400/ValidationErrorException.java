/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors.code400;

/**
 *
 * @author Orchi
 */
public class ValidationErrorException extends RuntimeException {
    String message = "Your input could not be validated";
    
    @Override
    public String getMessage() {
        return message;
    }
    
}
