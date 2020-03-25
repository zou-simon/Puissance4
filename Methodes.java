public class Methodes {

	// affiche la grille
	public static void grille(int[][] grille) {
		
		System.out.println();
		for(int i = 0; i < grille[0].length; i++) {
			System.out.print(i+1 + "  ");
		}
		System.out.println();
		for(int ligne = 0; ligne < grille.length; ligne++) {
			for(int colonne = 0; colonne < grille[ligne].length; colonne++) {
				if(grille[ligne][colonne] == 0)
					System.out.print(".  ");
				else if(grille[ligne][colonne] == 1)
					System.out.print("O  ");
				else
					System.out.print("X  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// affiche le tour
	public static int tour(int player, String joueur1, String joueur2) {
		if(player == 1) {
			player++;
			System.out.println("Au tour de " + joueur2 + "(X).");
		}
		else if(player == 2) {
			player--;
			System.out.println("Au tour de " + joueur1 + "(O).");
		}
		return player;
	}
	
	// vérifie la verticale
	public static boolean verifVerti(int[][] grille, int colonne, int joueur) {
		int nbPuissance = 0;
		for(int ligne = 0; ligne < grille.length; ligne++) {
			if(grille[ligne][colonne] == joueur)
				nbPuissance++;
			else
				nbPuissance = 0;
			if(nbPuissance == 4)
				return true;
		}
		return false;
	}
	
	// vérifie l'horizontale
	public static boolean verifHoriz(int[][] grille, int ligne, int joueur) {
		int nbPuissance = 0;
		for(int colonne = 0; colonne < grille.length+1; colonne++) {
			if(grille[ligne][colonne] == joueur)
				nbPuissance++;
			else
				nbPuissance = 0;
			if(nbPuissance == 4)
				return true;
		}
		return false;
	}
	
	// vérifie la diagonale vers la droite
	public static boolean verifDiagoD(int[][] grille, int joueur) {
		for(int ligne = 3; ligne < 6; ligne++) {
			for(int colonne = 0; colonne < 4; colonne++) {
				if(grille[ligne][colonne] == joueur && 
				grille[ligne-1][colonne+1] == joueur && 
				grille[ligne-2][colonne+2] == joueur && 
				grille[ligne-3][colonne+3] == joueur)
					return true;
			}
		}
		return false;
			
	}
	
	// vérifie la diagonale vers la gauche
	public static boolean verifDiagoG(int[][] grille, int joueur) {
		for(int ligne = 3; ligne < 6; ligne++) {
			for(int colonne = 3; colonne < 7; colonne++) {
				if(grille[ligne][colonne] == joueur && 
				grille[ligne-1][colonne-1] == joueur && 
				grille[ligne-2][colonne-2] == joueur && 
				grille[ligne-3][colonne-3] == joueur)
					return true;
			}
		}
		return false;
	}
	
	// vérifie si une personne gagne
	public static boolean verifGagne(int[][] grille, int ligne, int colonne, int joueur) {
			if(verifVerti(grille, colonne, joueur) || 
				verifHoriz(grille, ligne, joueur) || 
				verifDiagoD(grille, joueur) || 
				verifDiagoG(grille, joueur)) {
				return true;
			}
		return false;
	}
	
	// remise à zéro de la grille
	public static void nouvGrille(int[][] grille) {
		for(int ligne = 0; ligne < grille.length; ligne++) {
			for(int colonne = 0; colonne < grille[ligne].length; colonne++) {
				grille[ligne][colonne] = 0;
			}
		}
	}
}
