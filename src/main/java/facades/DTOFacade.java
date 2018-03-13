/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.JSONDTO;
import com.google.gson.Gson;

/**
 *
 * @author Stanislav
 */
public class DTOFacade {

    private Gson gson = new Gson();

    //This seemingly silly wrapper ensures that the object is a JSONDTO, proving that we intend to serialize it
    public String messagetoJson(JSONDTO jm) {
        return gson.toJson(jm);
    }

    public String objectToJson(Object t){
        return gson.toJson(t);
    }
    
    public <T extends JSONDTO> T jsonToMessage(String json, Class<T> c) {
        return gson.fromJson(json, c);
    }

    public <T2, T extends JSONDTO<T2>> T2 fromJson(String json, Class<T> DTOClass) {
        return jsonToMessage(json, DTOClass).toInternal();
    }
}
