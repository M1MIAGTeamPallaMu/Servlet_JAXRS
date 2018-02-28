package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class GenTestDao implements GenericDao {

  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
  private EntityManager entityManager = this.entityManagerFactory.createEntityManager();
  private EntityTransaction transaction = this.entityManager.getTransaction();

  public GenTestDao() {
  }

  /**
   * Method to create several t objects in the database.
   *
   * @param t object to persist
   */
  @Override
  public void create(Object... t) {
    this.transaction.begin();
    for (Object anO : t) {
      this.entityManager.persist(anO);
    }
    this.transaction.commit();
  }

  /**
   * Read provides a way to return an object from the database.
   *
   * @param id object id
   * @return object
   */
  @Override
  public Object read(int id) {
    return null;
  }

  /**
   * Update enables us to update several objects.
   *
   * @param t object to update
   */
  @Override
  public void update(Object... t) {
    this.transaction.begin();
    for (Object in : t) {
      this.entityManager.merge(in);
    }
    this.transaction.commit();
  }

  /**
   * This method deletes several objects records from the database.
   *
   * @param t object to delete
   */
  @Override
  public void delete(Object... t) {
    this.transaction.begin();
    for (Object in : t) {
      this.entityManager.remove(in);
    }
    entityManager.flush();
    entityManager.clear();
    this.transaction.commit();
  }
}
