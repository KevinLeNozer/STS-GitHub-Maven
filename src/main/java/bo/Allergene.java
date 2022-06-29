package bo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Allergene {
    @Id
    private long id;

    @Column(name = "allergeneLib", length = 255, nullable = false, unique = true)
    private String allergeneLib;
}
