/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.interfaces;

import java.util.List;

/**
 *
 * @author Mellem
 * @param <T>
 */
public interface CRUDInterface <T> {
    
    public T create(T object);
    
    public T read(Long id);
    public T read(String id);
    
    public List<T> readAll();
    
    public T update(Long id, T object);
    public T update(String id, T object);
    
    public T delete(Long id);
    public T delete(String id);
    
}
