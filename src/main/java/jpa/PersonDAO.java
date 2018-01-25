package jpa;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class PersonDAO implements GenericDAO{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    EntityTransaction transaction = this.entityManager.getTransaction();

    /**
     * @param o
     */
    public void create(Object...o) {
        this.transaction.begin();
        for (Object anO : o) {
            this.entityManager.persist(anO);
        }
        this.transaction.commit();
    }

    /**
     * @param id
     */
    public Object read(int id) {
        return this.entityManager.find(Person.class, id);
    }

    /**
     * @param o
     */
    public void update(Object...o) {
        this.transaction.begin();
        for (Object in: o) {
            this.entityManager.merge(in);
        }
        this.transaction.commit();
    }

    /**
     * @param o
     */
    public void delete(Object...o) {
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
