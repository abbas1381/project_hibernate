package util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManerFactoryProvider {
    private final static EntityManagerFactory entityManagerFactory;

    static{
        entityManagerFactory = Persistence.createEntityManagerFactory("default");

    }
    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
