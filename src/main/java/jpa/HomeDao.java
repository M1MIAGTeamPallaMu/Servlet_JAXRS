package jpa;

import domain.Home;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HomeDao implements GenericDao<Home> {

  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
  private EntityManager entityManager = this.entityManagerFactory.createEntityManager();
  private EntityTransaction transaction = this.entityManager.getTransaction();

  /**
   * Method to create several home objects in the database.
   *
   * @param o home objects
   */
  public void create(Home... o) {
    this.transaction.begin();
    for (Home anO : o) {
      this.entityManager.persist(anO);
    }
    this.transaction.commit();
  }

  /**
   * Read provides a way to return a home object from the database.
   *
   * @param id home id in the database
   */
  public Home read(int id) {
    return this.entityManager.find(Home.class, id);
  }

  /**
   * Update enables us to update several home objects.
   *
   * @param o home objects
   */
  public void update(Home... o) {
    this.transaction.begin();
    for (Home in : o) {
      this.entityManager.merge(in);
    }
    this.transaction.commit();
  }

  /**
   * This method deletes several home objects records from the database.
   *
   * @param o home objects
   */
  public void delete(Home... o) {
    this.transaction.begin();
    for (Home in : o) {
      this.entityManager.remove(in);
    }
    entityManager.flush();
    entityManager.clear();
    this.transaction.commit();
  }

  public List<Home> readAll() {
    return this.entityManager.createQuery("from Home", Home.class).getResultList();
  }
}
