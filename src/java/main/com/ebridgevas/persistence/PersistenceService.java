package com.ebridgevas.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Performs CRUD operations on a table for any T.
 * Simple define T and annotate as in @see User
 *
 * @author david@tekeshe.com
 */
public interface PersistenceService<T, Id extends Serializable> {

    public void persist(T entity);

    public void update(T entity);

    public T findById(Class<T> t, Id id);

    public void delete(T entity);

    public List<T> findAll(Class<T> t);

    public void deleteAll(Class<T> t);
}
