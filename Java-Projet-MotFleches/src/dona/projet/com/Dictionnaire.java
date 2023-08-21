package dona.projet.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dictionnaire {
	
	private static final String CHEMIN_FICHIER = "/fr/limayrac/bsidsn/util/liste_francais.txt";
	private ArrayList<String> listeDeMots = new ArrayList<>();
	
	public Dictionnaire() {
		super();
		chargerDictionnaire();
	}
	
	// Charge les mots du fichier dans la liste de mots du dictionnaire
	private void chargerDictionnaire() {
		try {
			// Ouvre le fichier en tant que ressource du projet
			InputStream flux = Dictionnaire.class.getResourceAsStream(CHEMIN_FICHIER);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne = buff.readLine();
			while (ligne != null) {
				// Ajoute chaque ligne (mot) à la liste de mots
				listeDeMots.add(ligne);
				ligne = buff.readLine();
			}
			buff.close(); 
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// Affiche tous les mots du dictionnaire
	public void afficherMots() {
		System.out.println("Affichage des mots présents dans le dictionnaire :");
		int i = 0;
		while (i < listeDeMots.size()) {
			System.out.println(listeDeMots.get(i));
			i++;
		}
	}
		
	// Affiche les mots commençant par la chaîne spécifiée
	public void afficherMotsCommencantPar(String debut) {
		System.out.printf("Affichage des mots commençant par %s%n", debut);
		int i = 0;
		while (i < listeDeMots.size()) {
			String mot = listeDeMots.get(i);
			if (mot.startsWith(debut)) {
				System.out.println(mot);
			}
			i++;
		}
	}
}
