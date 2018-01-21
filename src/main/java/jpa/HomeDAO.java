package jpa;

import domain.Home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class HomeDAO implements GenericDAO{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
    EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    EntityTransaction transaction = this.entityManager.getTransaction();

    /**
     * @param o
     */
    public void create(Object...o) {
        for (Object anO : o) {
            this.entityManager.persist(anO);
        }
    }

    /**
     * @param id
     */
    public Object read(int id) {
        return this.entityManager.find(Home.class, id);
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
        for (Object in : o){
            this.entityManager.remove(in);
        }
    }

    public List<Home> readAll(){
        return this.entityManager.createQuery("from Home", Home.class).
                getResultList();
    }

    /**
     * @return
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
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
