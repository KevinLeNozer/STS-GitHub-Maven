package bo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Marque {
    @Id
    private long id;

    @Column(name = "marqueLib", length = 255, nullable = false, unique = true)
    private String marqueLib;
}
