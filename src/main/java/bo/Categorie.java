package bo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Categorie {
    @Id
    private long id;

    @Column(name = "categorieLib", length = 255, nullable = false, unique = true)
    private String categorieLib;
}
