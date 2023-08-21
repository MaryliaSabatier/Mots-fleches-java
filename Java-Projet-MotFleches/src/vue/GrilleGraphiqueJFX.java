package dona.projet.com;

import controller.IController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modele.IModelGrille;
import observer.IObservateur;

import java.util.ArrayList;

public class GrilleGraphiqueJFX implements IObservateur, EventHandler<MouseEvent> {

    private static final int HAUTEUR_MENU = 26;
    private int largeur = 3;
    private int hauteur = 3;
    private final int TAILLE_CASE = 100;
    private ArrayList<Label> tableau = new ArrayList<>();

    private MenuBar menuBar;
    private Menu menu;
    private MenuItem addTestMenuItem;
    private MenuItem addEssaiMenuItemOk;
    private MenuItem addEssaiMenuItemKO;
    private IController controller;
    private IModelGrille modele;
    private TilePane layout;

    public GrilleGraphiqueJFX(IModelGrille modele, IController controller) {
        this.modele = modele;
        this.controller = controller;
        modele.addObservateur(this);
        this.largeur = modele.getLargeur();
        this.hauteur = modele.getHauteur();
        System.out.printf("création d'une grille %s x %s%n", this.largeur, this.hauteur);
    }

    public Scene getScene() {
        Group root = new Group();
        Scene scene = new Scene(root, TAILLE_CASE * largeur, TAILLE_CASE * hauteur + HAUTEUR_MENU, Color.LIGHTGRAY);
        layout = new TilePane();
        layout.setVgap(0);
        layout.setHgap(0);
        layout.setMinSize(TAILLE_CASE * largeur, TAILLE_CASE * hauteur);
        buildGrilleChiffres();
        VBox vBox = new VBox();
        vBox.getChildren().add(createControls());
        vBox.getChildren().add(layout);
        root.getChildren().add(vBox);
        return scene;
    }

    private void buildGrilleChiffres() {
        for (int i = 1; i <= hauteur * largeur; i++) {
            Label label = createLabel(".");
            label.setOnMouseClicked(this);
            tableau.add(label);
            layout.getChildren().add(label);
        }

    }

    // Crée un Label avec du texte
    private Label createLabel(String texte) {
        Label label = new Label(texte);
        label.setOpacity(100);
        label.setBackground(Background.EMPTY);
        label.setAlignment(Pos.BASELINE_CENTER);
        label.setFont(new Font("Arial", TAILLE_CASE / 2));
        label.setPrefSize(TAILLE_CASE, TAILLE_CASE);
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(1))));
        return label;
    }

    // Crée la barre de menu et les items associés
    private MenuBar createControls() {
        menuBar = new MenuBar();
        menu = new Menu("actions");
        addTestMenuItem = new MenuItem("ajouter test en 0,0");
        menu.getItems().add(addTestMenuItem);
        addTestMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.ajouterMotHoriz("test", 0, 0);
            }
        });
        addEssaiMenuItemOk = new MenuItem("ajouter essai en 5,4 (ok)");
        menu.getItems().add(addEssaiMenuItemOk);
        addEssaiMenuItemOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.ajouterMotHoriz("essai", 5, 4);
            }
        });
        addEssaiMenuItemKO = new MenuItem("ajouter essai en 6,4 (KO)");
        menu.getItems().add(addEssaiMenuItemKO);
        addEssaiMenuItemKO.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.ajouterMotHoriz("essai", 6, 4);
            }
        });
        MenuItem exit = new MenuItem("Quitter");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.getItems().add(exit);
        menuBar.getMenus().add(menu);
        return menuBar;
    }

    @Override
    public void sendMessage(String s) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(s);
        alert.showAndWait();
    }

    @Override
    public void update(GrilleVirtuelle gv) {
        char[][] tab = gv.getTableauDeCases();
        for (int h = 0; h < gv.getHauteur(); h++) {
            for (int l = 0; l < gv.getLargeur(); l++) {
                tableau.get(h * gv.getLargeur() + l).setText(String.valueOf(tab[l][h]));
            }
        }
    }

    @Override
    public void handle(MouseEvent arg0) {
        // Coordonnées dans le Label
        double x = arg0.getX();
        double y = arg0.getY();
        // Coordonnées dans la scène
        double xScene = arg0.getSceneX();
        double yScene = arg0.getSceneY();
        if (arg0.getSource() instanceof Label) {
            Label label = (Label) arg0.getSource();
            System.out.println(label.getText());
            int xCase = (int) xScene / TAILLE_CASE;
            int yCase = (int) (yScene - HAUTEUR_MENU) / TAILLE_CASE;

            System.out.printf("case y=%s par x=%s%n", yCase, xCase);
            controller.gereCase(xCase, yCase);
        }
    }
}
