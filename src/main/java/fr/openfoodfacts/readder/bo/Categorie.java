package fr.openfoodfacts.readder.bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqCategorie", strategy = "increment")
    private long id;

    @Column(name = "categorieLib", length = 255, nullable = false, unique = true)
    private String categorieLib;

    public Categorie() {
    }

    public Categorie(String categorieLib) {
        this.setCategorieLib(categorieLib);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategorieLib() {
        return categorieLib;
    }

    public void setCategorieLib(String categorieLib) {
        this.categorieLib = categorieLib;
    }
}
