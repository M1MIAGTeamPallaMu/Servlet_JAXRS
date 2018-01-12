package jpa;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {
    /**
     *
     * @param t
     * @return
     */
    T create(T t);

    /**
     *
     * @param id
     * @return
     */
    T read(PK id, Class c);

    /**
     *
     * @param t
     * @return
     */
    T update(T t);

    /**
     *
     * @param t
     */
    void delete(T t);
}
