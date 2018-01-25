package jpa;

import domain.Home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class HomeDAO implements GenericDAO<Home>{

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
    private EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = this.entityManager.getTransaction();

    /**
     * @param o
     */
    @Override
    public void create(Home...o) {
        this.transaction.begin();
        for (Home anO : o) {
            this.entityManager.persist(anO);
        }
        this.transaction.commit();
    }

    /**
     * @param id
     */
    @Override
    public Home read(int id) {
        return this.entityManager.find(Home.class, id);
    }

    /**
     * @param o
     */
    @Override
    public void update(Home...o) {
        this.transaction.begin();
        for (Home in: o) {
            this.entityManager.merge(in);
        }
        this.transaction.commit();
    }

    /**
     * @param o
     */
    @Override
    public void delete(Home...o) {
        this.transaction.begin();
        for (Object in : o){
            this.entityManager.remove(in);
        }
        this.transaction.commit();
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
