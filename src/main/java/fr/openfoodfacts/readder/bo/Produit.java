package fr.openfoodfacts.readder.bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "allergene_id")
    Allergene allergene;

    @Column(name = "scoreNutritonnel", length = 1, nullable = false)
    private String scoreNutritionnel;

    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public Allergene getAllergene() {
        return allergene;
    }

    public void setAllergene(Allergene allergene) {
        this.allergene = allergene;
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
}
