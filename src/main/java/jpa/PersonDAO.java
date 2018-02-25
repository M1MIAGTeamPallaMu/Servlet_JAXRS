package jpa;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class PersonDAO implements GenericDAO<Person>{

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
    private EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = this.entityManager.getTransaction();

    /**
     * @param o
     */
    public void create(Person...o) {
        this.transaction.begin();
        for (Person anO : o) {
            this.entityManager.persist(anO);
        }
        this.transaction.commit();
    }

    /**
     * @param id
     */
    public Person read(int id) {
        return this.entityManager.find(Person.class, id);
    }

    /**
     * @param o
     */
    public void update(Person...o) {
        this.transaction.begin();
        for (Object in: o) {
            this.entityManager.merge(in);
        }
        this.transaction.commit();
    }

    /**
     * @param o
     */
    public void delete(Person...o) {
        this.transaction.begin();
        for (Object in : o){
            this.entityManager.remove(in);
        }
        entityManager.flush();
        entityManager.clear();
        this.transaction.commit();
    }

    public List<Person> readAll(){
        return this.entityManager.createQuery("from Person", Person.class).
                getResultList();
    }

    /**
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     *
     * @return
     */
    public EntityManagerFactory getEntityManagerFactory() {
        return this.entityManagerFactory;
    }

    /**
     * @return EntityTransaction
     */
    public EntityTransaction getTransaction() {
        return this.transaction;
    }
}
