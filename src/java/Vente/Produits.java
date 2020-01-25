package Vente;


public class Produits {

    private  String nom_prod;
    private  String photo;
    private  Double prix;
    private  int qts;

    public Produits(String nom_prod, String photo, Double prix ) {
        this.nom_prod = nom_prod;
        this.photo = photo;
        this.prix = prix;
       
       
    }

    Produits() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

   
 
    
}
