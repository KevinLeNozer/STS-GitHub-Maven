package fr.openfoodfacts.readder.bll;

import fr.openfoodfacts.readder.bo.Allergene;
import fr.openfoodfacts.readder.bo.Categorie;
import fr.openfoodfacts.readder.bo.Marque;
import fr.openfoodfacts.readder.bo.Produit;
import fr.openfoodfacts.readder.dal.OpenFoodFactDao;

import java.util.ArrayList;
import java.util.List;

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

        if (columns.length == 29) {
            produit.setCategorie(new Categorie(columns[0]));
            produit.setMarque(new Marque(columns[1]));
            produit.setScoreNutritionnel(columns[4]);

            List<String> allergeneList =  new ArrayList<>();
            List<Allergene> allergenList2 = new ArrayList<>();

            allergeneList.addAll(List.of(columns[28].split(",")));
            for (String allergeneFromList : allergeneList) {
                if (allergeneList.get(0) != ""){
                    Allergene allergene = new Allergene(allergeneList.get(0));
                    allergenList2.add(allergene);
                }
            }
            produit.setAllergenes(allergenList2);
            return produit;
        }
        return null;
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