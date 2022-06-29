package bo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Ingredient {

    @Id
    private long id;

    @Column(name = "ingredientLib", length = 255, nullable = false, unique = true)
    private String ingredientLib;
}
