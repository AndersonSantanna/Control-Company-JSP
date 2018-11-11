package br.unip.cc.trabalho.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    
    public static EntityManager getEntityManager(){
        if(entityManager==null){
            entityManagerFactory = 
                    Persistence.createEntityManagerFactory("Controle_de_Estoque_webPU");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
    
    public static void fechar(){
        entityManager.close();
        entityManagerFactory.close();
    }

}
