package dona.projet.com;

public class CaseGrille {
    private String contenu; // Contenu de la case (lettre ou vide)

    // Constructeur par défaut de la classe CaseGrille
    public CaseGrille() {
        // Le constructeur est vide car il ne fait rien de particulier à l'initialisation
    }
    
    // Méthode pour définir le contenu de la case
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    // Méthode pour obtenir le contenu de la case
    public String getContenu() {
        return contenu;
    }
}
