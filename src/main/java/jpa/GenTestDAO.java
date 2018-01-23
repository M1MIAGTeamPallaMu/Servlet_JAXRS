package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class GenTestDAO {
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
     * @param c
     */
    public Object read(int id, Class c) {
        return this.entityManager.find(c, id);
    }

    /**
     * @param o
     */
    public void update(Object...o) {
        for (Object in: o) {
            this.entityManager.merge(in);
        }
    }

    /**
     * @param o
     */
    public void delete(Object...o) {
        this.transaction.begin();
        for (Object in : o){
            this.entityManager.remove(in);
        }
        this.transaction.commit();
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
