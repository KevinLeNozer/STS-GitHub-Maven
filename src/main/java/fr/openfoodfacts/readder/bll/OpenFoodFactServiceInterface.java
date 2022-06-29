package fr.openfoodfacts.readder.bll;

import fr.openfoodfacts.readder.bo.Produit;

public interface OpenFoodFactServiceInterface {

    Produit read(String line);

    void save(Produit produit);
}
