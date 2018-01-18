package Jpa;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {
    /**
     *
     * @param t object to persist
     * @return t
     */
    void create(T...t);

    /**
     *
     * @param id object id
     * @return object
     */
    T read(PK id, Class c);

    /**
     *
     * @param t object to update
     * @return t
     */
    void update(T...t);

    /**
     *
     * @param t object to delete
     */
    void delete(T...t);
}
