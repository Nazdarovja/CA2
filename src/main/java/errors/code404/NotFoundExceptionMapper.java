/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors.code404;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import errors.ErrorMessage;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Orchi
 */
@Provider
public class NotFoundExceptionMapper implements
        ExceptionMapper<NotFoundException> {
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;
    
    @Override
    public Response toResponse(NotFoundException ex) {
        //boolean isDebug = context.getInitParameter("debug").equals("true");
        ErrorMessage err = new ErrorMessage(ex, 404, true);
        err.setDescription("The item you're looking for could not be found! Too bad");
        return Response.status(400)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON)
                .build();
                
    }
}
