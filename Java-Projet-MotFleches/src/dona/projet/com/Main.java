package dona.projet.com; 

public class Main {

    public static void main(String[] args) {
        // Création d'une instance de ModèleGrille
        ModeleGrille grille = new ModeleGrille();
        
        // Création de la grille
        grille.creerGrille();
        
        // Ajout des définitions
        grille.ajouterDefinition();
        
        // Affichage de la grille
        grille.afficherGrille();
        
        System.out.println();
        
        // Ajout d'une autre définition
        grille.ajouterDefinition();
        
        // Affichage de la grille mise à jour
        grille.afficherGrille();
        
        System.out.println();
        
        // Ajout d'une autre définition
        grille.ajouterDefinition();
        
        // Affichage de la grille mise à jour
        grille.afficherGrille();
    }
}
