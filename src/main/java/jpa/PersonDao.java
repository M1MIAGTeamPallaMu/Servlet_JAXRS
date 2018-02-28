package jpa;

import domain.Person;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class PersonDao implements GenericDao<Person> {

  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
  private EntityManager entityManager = this.entityManagerFactory.createEntityManager();
  private EntityTransaction transaction = this.entityManager.getTransaction();

  /**
   * Method to create several persons objects in the database.
   *
   * @param o person objects
   */
  public void create(Person... o) {
    this.transaction.begin();
    for (Person anO : o) {
      this.entityManager.persist(anO);
    }
    this.transaction.commit();
  }

  /**
   * Read provides a way to return an object from the database.
   *
   * @param id person id in the database
   */
  public Person read(int id) {
    return this.entityManager.find(Person.class, id);
  }

  /**
   * Update enables us to update several objects of type person.
   *
   * @param o person objects
   */
  public void update(Person... o) {
    this.transaction.begin();
    for (Object in : o) {
      this.entityManager.merge(in);
    }
    this.transaction.commit();
  }

  /**
   * This method deletes several person objects records from the database.d
   *
   * @param o person objects
   */
  public void delete(Person... o) {
    this.transaction.begin();
    for (Person in : o) {
      this.entityManager.remove(in);
    }
    entityManager.flush();
    entityManager.clear();
    this.transaction.commit();
  }

  public List<Person> readAll() {
    return this.entityManager.createQuery("from Person", Person.class).getResultList();
  }

}
