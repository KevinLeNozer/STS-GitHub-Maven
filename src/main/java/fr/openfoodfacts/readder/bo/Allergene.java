package fr.openfoodfacts.readder.bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Allergene")
public class Allergene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqAllergene", strategy = "increment")
    private long id;

    @Column(name = "allergeneLib", length = 255, nullable = false, unique = true)
    private String allergeneLib;

    public Allergene() {
    }

    public Allergene(String allergeneLib) {
        this.setAllergeneLib(allergeneLib);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAllergeneLib() {
        return allergeneLib;
    }

    public void setAllergeneLib(String allergeneLib) {
        this.allergeneLib = allergeneLib;
    }
}
