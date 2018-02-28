package jpa;

interface GenericDao<T> {

  /**
   * Method to create several t objects in the database.
   * @param t object to persist
   * @return t
   */
  void create(T... t);

  /**
   * Read provides a way to return an object from the database.
   * @param id object id
   * @return object
   */
  T read(int id);

  /**
   * Update enables us to update several objects.
   * @param t object to update
   * @return t
   */
  void update(T... t);

  /**
   * This method deletes several objects records from the database.
   * @param t object to delete
   */
  void delete(T... t);
}
