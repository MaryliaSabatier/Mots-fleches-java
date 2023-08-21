package dona.projet.com;

import java.util.Scanner;

class ModeleGrille {
    private int hauteur;
    private int largeur;
    private CaseGrille grille[][];
    private Mot definitions[][];

    public void creerGrille() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Combien voulez-vous de lignes ? : ");
        hauteur = sc.nextInt();

        System.out.print("Combien voulez-vous de colonnes ? : ");
        largeur = sc.nextInt();

        grille = new CaseGrille[largeur][hauteur];

        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                grille[x][y] = new CaseGrille();
                grille[x][y].setContenu(" ");
            }
        }
    }

    public void afficherGrille() {
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                System.out.printf(" %s |", grille[x][y].getContenu());
            }
            System.out.print("\n");
        }
    }

    public void ajouterDefinition() {
        Scanner sc = new Scanner(System.in);
        int x, y;

        do {
            System.out.print("Position de la définition horizontale : ");
            x = sc.nextInt() - 1;

            System.out.print("Position de la définition verticale : ");
            y = sc.nextInt() - 1;

            if (x == grille[0].length - 1 && y == grille.length - 1) {
                System.out.println("Erreur, choisir une position valide");
            }
        } while (x == grille[0].length - 1 && y == grille.length - 1);

        grille[x][y].setContenu("D");
        afficherGrille();
        choisirDirection(x, y);
    }

    public void choisirDirection(int definitionX, int definitionY) {
        Scanner sc = new Scanner(System.in);
        int direction;

        do {
            System.out.println("Choisissez la direction pour le mot :");
            System.out.println("[0] Horizontal direct");
            System.out.println("[1] Horizontal indirect");
            System.out.println("[2] Vertical direct");
            System.out.println("[3] Vertical indirect");

            direction = sc.nextInt();
        } while (!verifierNbCasesVides(direction, definitionX, definitionY));
    }

    public boolean verifierNbCasesVides(int direction, int definitionX, int definitionY) {
        // ... (ton code ici)
        return false; // Remplace cette ligne par le retour correct
    }

    public void ajouterMot(int direction, int positionX, int positionY, int nbEmptyCases, String caseCroisee) {
        // ... (ton code ici)
    }
}

class CaseGrille {
    private String contenu;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}

class Mot extends CaseGrille {
    private int positionX;
    private int positionY;
    private int direction;
    private String description;

    // ... (le reste de tes méthodes et attributs ici)
}
