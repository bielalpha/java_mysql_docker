/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mysql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author garaujo
 */
public class MYSQL {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sankhya_pu");
        EntityManager em = factory.createEntityManager();
        
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO alunos(CODIGO, NOME) VALUES (");
        sb.append("   NULL");
        sb.append("   ,'LMATURANO'");
        sb.append(" )");
        System.out.println(sb.toString());
        Query q = em.createNativeQuery(sb.toString());
        
        EntityTransaction et = em.getTransaction();
        int n = 0;
        try {
            et.begin();
            n = q.executeUpdate();
        } finally {
            et.commit();
        }

        if (em.isOpen()) {
            em.close();
        }
        if (factory.isOpen()) {
            factory.close();
        }
    }
}
