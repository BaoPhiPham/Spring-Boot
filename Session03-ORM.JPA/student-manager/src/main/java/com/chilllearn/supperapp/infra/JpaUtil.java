package com.chilllearn.supperapp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    private JpaUtil() {
    }

    static {
        try {
            emf = Persistence.createEntityManagerFactory("com.chilllearn.superapp-PU");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void shutdown() {
        emf.close();
    }

}
