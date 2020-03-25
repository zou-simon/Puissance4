import java.util.Scanner;

public class Puissance4 {

	public static void jouer() {
		
		Scanner saisie = new Scanner(System.in); 
		String joueur1, joueur2;
		int[][] grille = new int[6][7];
		boolean matchNul = true;
		int colonne;
		int ligne;
		int rejouer;
		int nbPion = 0;
		
		// saisie joueur
		System.out.print("Entrez le nom du 1er joueur : ");
		joueur1 = saisie.nextLine();
		System.out.print("Entrez le nom du 2eme joueur : ");
		joueur2 = saisie.nextLine();
		
		// annonce des joueurs
		System.out.println("\n1er joueur(O) : " + joueur1 + "\n2eme joueur(X) : " + joueur2);
		
		// boucle rejouer
		do {
			// affiche la grille
			Méthodes.grille(grille);
			
			// premier qui commence
			int joueur = (int)(Math.random() * 2 + 1);
			
			//annonce du joueur qui commence
			if(joueur == 1)
				System.out.println("C'est " + joueur1 + "(O) qui commence !");
			else
				System.out.println("C'est " + joueur2 + "(X) qui commence !");
			
			// départ
			while(nbPion < 42 && joueur == 1 || joueur == 2) {
				nbPion++;
				ligne = 5;
				// saisie colonne
				do {
					System.out.print("Entrez une colonne : ");
					colonne = Integer.parseInt(saisie.nextLine());
				} while(colonne < 1 || colonne > 7);
				
				// vérifie la colonne
				while(grille[ligne][colonne-1] != 0) {
					ligne--;
					// si colonne pleine
					while(ligne < 0) {
						// saisie colonne
						do {
							System.out.print("Entrez une colonne : ");
							colonne = Integer.parseInt(saisie.nextLine());
						} while(colonne < 1 || colonne > 7);
						ligne = 5;
					}
				}
				
				// ajoute au tableau
				grille[ligne][colonne-1] = joueur;
				// affiche la grille
				Méthodes.grille(grille);
				
				// vérifie le puissance 4
				if(Méthodes.verifGagne(grille, ligne, (colonne-1), joueur)) {
					if(joueur == 1)
						System.out.println(joueur1 + "(O) a gagné(e) !");
					else
						System.out.println(joueur2 + "(X) a gagné(e) !");
					// match pas nul
					matchNul = false;
					// arrête les tours si puissance 4
					joueur = 0;
				}
				
				// arrête les tours si match nul
				if(nbPion == 42)
					joueur = 0;
				
				// affiche le tour
				joueur = Méthodes.tour(joueur, joueur1, joueur2);
			}
			
			// match nul
			if(matchNul)
				System.out.println("Match nul !");
			
			// rejouer ?
			do {
				System.out.print("Voulez-vous jouer une autre partie ? (Oui : 1 / Non : 0) ");
				rejouer = Integer.parseInt(saisie.nextLine());
			} while(rejouer > 1 || rejouer < 0);
			// nouvelle grille
			if(rejouer == 1) {
				Méthodes.nouvGrille(grille);
				nbPion = 0;
			}
				
			
		} while(rejouer != 0);
		
		// message de fin
		System.out.println("Au revoir !");
			
		saisie.close();
	}

}
