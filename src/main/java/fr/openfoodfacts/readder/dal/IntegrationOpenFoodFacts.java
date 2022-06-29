package fr.openfoodfacts.readder.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IntegrationOpenFoodFacts {
    public static void main(String[] args) {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("traitement-fichier");

        EntityManager em = entityManager.createEntityManager();
    }
}
