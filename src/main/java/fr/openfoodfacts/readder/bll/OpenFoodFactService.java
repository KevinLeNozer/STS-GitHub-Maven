package fr.openfoodfacts.readder.bll;


import fr.openfoodfacts.readder.bo.Categorie;
import fr.openfoodfacts.readder.bo.Marque;
import fr.openfoodfacts.readder.bo.Produit;
import fr.openfoodfacts.readder.dal.OpenFoodFactDao;

public class OpenFoodFactService implements OpenFoodFactServiceInterface {

    public static final String REGEX_DELIMITER = "\\|";

    private OpenFoodFactDao dao;

    public OpenFoodFactService(OpenFoodFactDao dao) {
        this.dao = dao;
    }

    @Override
    public Produit read(String line) {
        String[] columns = line.split(REGEX_DELIMITER);

        Produit produit = new Produit();
        produit.setCategorie(new Categorie(columns[0]));
        produit.setMarque(new Marque(columns[1]));

        return produit;
    }

    @Override
    public void save(Produit produit) {
        Marque marque = dao.getMarque(produit.getMarque().getMarqueLib());
        Categorie categorie = dao.getCategorie(produit.getCategorie().getCategorieLib());

        if (marque != null) {
            produit.setMarque(marque);
        }

        if (categorie != null) {
            produit.setCategorie(categorie);
        }

        dao.create(produit);
    }
}