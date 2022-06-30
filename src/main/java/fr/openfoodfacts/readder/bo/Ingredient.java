package fr.openfoodfacts.readder.bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqIngredient", strategy = "increment")
    private long id;

    @Column(name = "ingredientLib", length = 255, nullable = false)
    private String ingredientLib;

    public Ingredient() {
    }

    public Ingredient(String ingredientLib) {
        this.setIngredientLib(ingredientLib);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIngredientLib() {
        return ingredientLib;
    }

    public void setIngredientLib(String ingredientLib) {
        this.ingredientLib = ingredientLib;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("ingredientLib='").append(ingredientLib).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
