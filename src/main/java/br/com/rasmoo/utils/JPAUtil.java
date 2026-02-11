package br.com.rasmoo.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory RAS_FOOD = Persistence.createEntityManagerFactory("rasfood");

    public static EntityManager getEntityManagerRasFood(){
        return RAS_FOOD.createEntityManager();
    }
}
