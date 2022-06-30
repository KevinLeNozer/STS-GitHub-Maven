package fr.openfoodfacts.readder.bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqAllergene", strategy = "increment")
    private long id;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "marque_id")
    Marque marque;
    @ManyToMany
    @JoinColumn(name = "allergene_id")
    private List<Allergene> allergenes;

    @Column(name = "scoreNutritonnel", nullable = false)
    private String scoreNutritionnel;

    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append(", categorie=").append(categorie);
        sb.append(", marque=").append(marque);
        sb.append(", allergenes=").append(allergenes);
        sb.append(", scoreNutritionnel='").append(scoreNutritionnel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
