/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import java.util.List;

/**
 *
 * @author Mellem
 * @param <T>
 */
public interface CRUDFacade <T> {
    
    public T create(T object);
    
    public T read();
    public List<T> readAll();
    
    public T update(Long id, T object);
    public T update(String id, T object);
    
    public T delete(Long id);
    public T delete(String id);
    
}
