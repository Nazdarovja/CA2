/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors.code500;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import errors.ErrorMessage;
import errors.code404.NotFoundException;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author Orchi
 */
public class GenericExceptionMapper implements
        ExceptionMapper<RuntimeException> {
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;
    
    @Override
    public Response toResponse(RuntimeException ex) {
        //boolean isDebug = context.getInitParameter("debug").equals("true");
        ErrorMessage err = new ErrorMessage(ex, 500, true);
        err.setDescription("An internal error has occured, sorry man!");
        return Response.status(500)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON)
                .build();
                
    }
    
}
