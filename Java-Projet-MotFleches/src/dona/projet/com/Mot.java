package dona.projet.com;

public class Mot extends CaseGrille {
    private int positionX; // Position X du mot sur la grille
    private int positionY; // Position Y du mot sur la grille
    private int direction; // Direction du mot (horizontale ou verticale)
    private String description; // Description du mot
    
    public Mot() {
        // Le constructeur est vide car il ne fait rien de particulier à l'initialisation
    }

    // Méthode pour obtenir la description du mot
    public String getDescription() {
        return description;
    }

    // Méthode pour définir la description du mot
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Méthode pour définir la position X du mot
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    // Méthode pour définir la position Y du mot
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    
    // Méthode pour obtenir la position X du mot
    public int getPositionX() {
        return positionX;
    }
    
    // Méthode pour obtenir la position Y du mot
    public int getPositionY() {
        return positionY;
    }

    // Méthode pour obtenir la direction du mot
    public int getDirection() {
        return direction;
    }

    // Méthode pour définir la direction du mot
    public void setDirection(int direction) {
        this.direction = direction;
    }
}
