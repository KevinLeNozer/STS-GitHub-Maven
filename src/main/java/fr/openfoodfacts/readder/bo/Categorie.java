package fr.openfoodfacts.readder.bo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqCategorie", strategy = "increment")
    private long id;

    @Column(name = "categorieLib", length = 255, nullable = false, unique = true)
    private String categorieLib;

    @OneToMany(mappedBy = "categorie")
    private Set<Produit> produits;

    public Categorie(String categorieLib) {
        this.setCategorieLib(categorieLib);
    }

    public Categorie() {
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Categorie{");
        sb.append(", categorieLib='").append(categorieLib).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
