package fr.openfoodfacts.readder.bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Marque")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqMarque", strategy = "increment")
    private long id;

    @Column(name = "marqueLib", length = 255, nullable = false, unique = true)
    private String marqueLib;

    public Marque() {
    }

    public Marque(String marqueLib) {
        this.setMarqueLib(marqueLib);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarqueLib() {
        return marqueLib;
    }

    public void setMarqueLib(String marqueLib) {
        this.marqueLib = marqueLib;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Marque{");
        sb.append("marqueLib='").append(marqueLib).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
