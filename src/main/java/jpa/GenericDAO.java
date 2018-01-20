package jpa;

public interface GenericDAO<T> {
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
    T read(int id, Class c);

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
