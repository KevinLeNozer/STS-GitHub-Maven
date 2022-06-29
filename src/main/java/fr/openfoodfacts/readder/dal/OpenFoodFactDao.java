package fr.openfoodfacts.readder.dal;


import fr.openfoodfacts.readder.bo.Categorie;
import fr.openfoodfacts.readder.bo.Ingredient;
import fr.openfoodfacts.readder.bo.Marque;
import fr.openfoodfacts.readder.bo.Produit;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OpenFoodFactDao {
    private final EntityManager em;

    public OpenFoodFactDao(EntityManager em) {
        this.em = em;
    }

    public void create(Produit produit) {
        em.persist(produit);
    }

    public Marque getMarque(String libelle) {
        TypedQuery<Marque> query = em.createQuery("select e from Marque e where e.marqueLib = :libelle",
                Marque.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Categorie getCategorie(String libelle) {
        TypedQuery<Categorie> query = em.createQuery("select e from Categorie e where e.categorieLib = " +
                ":libelle", Categorie.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

    public Ingredient getIngredient(String libelle) {
        TypedQuery<Ingredient> query = em.createQuery("select e from Ingredient e where e" +
                ".ingredientLib = " + ":libelle", Ingredient.class);
        query.setParameter("libelle", libelle);
        return query.getSingleResult();
    }
}
