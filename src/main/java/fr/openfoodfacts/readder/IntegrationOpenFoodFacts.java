package fr.openfoodfacts.readder;

import fr.openfoodfacts.readder.bll.OpenFoodFactService;
import fr.openfoodfacts.readder.bll.OpenFoodFactServiceInterface;
import fr.openfoodfacts.readder.bo.Produit;
import fr.openfoodfacts.readder.dal.OpenFoodFactDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class IntegrationOpenFoodFacts {
    static OpenFoodFactServiceInterface service;

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("traitement-fichier");

    static final int BATCH_SIZE = 50;

    public static void main(String[] args) throws IOException, URISyntaxException {

        EntityManager em = emf.createEntityManager();
        OpenFoodFactDao dao = new OpenFoodFactDao(em);
        service = new OpenFoodFactService(dao);

        try (Stream<String> stream = Files.lines(Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI()))) {
            em.getTransaction().begin();
            AtomicInteger counter = new AtomicInteger();
            stream.forEach(line -> {

                // extraire du csv
                Produit produit = service.read(line);

                // enregister l'objet en base
                service.save(produit);

                // on
                if (counter.get() % BATCH_SIZE == 0) {
                    System.out.println("flush! " + counter.get());
                    em.flush();
                    em.clear();
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                }

                counter.getAndIncrement();
            });
            em.getTransaction().commit();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}