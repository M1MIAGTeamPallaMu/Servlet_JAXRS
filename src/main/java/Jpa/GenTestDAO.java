package Jpa;

import javax.persistence.EntityManager;
import java.io.Serializable;


public class GenTestDAO implements GenericDAO {
    private EntityManager entityManager;

    /**
     *
     * @param entityManager
     */
    public GenTestDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
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
     * @param c
     */
    public Object read(Serializable id, Class c) {
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
        for (Object in : o){
            this.entityManager.remove(in);
        }
    }
    
}
