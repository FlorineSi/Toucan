package toucan.graphique;

import toucan.modele.LesCases;

/**
 * Classe modélisant l'affectation de la valeur d'une Case à une autre
 * @author Florine
 *
 */
public class AffectationCaseCase implements IAnimation{

	/**
	 * Constructeur par défaut
	 * Initialise aac (AllerACase)
	 */
	public AffectationCaseCase(){
	}

	/**
	 * Cette fonction définis les mouvements attribués à une Case
	 * pour simuler l’affectation entre 2 cases du tableau. 
	 * Le contenu des Case affectée est mis à jour
	 * On met le contenu de la case j dans la case i
	 * */
	
	public boolean executer(LesCases lesCases, int i, int j) {
		// La case i monte
		lesCases.monter(i,1,lesCases.getValeur(i));
		// SI elle se trouve � GAUCHE de la case j 
		if(i<j){
			// elle se d�cale vers j
			lesCases.droite(i,j-i,lesCases.getValeur(i));
			// elle descend
			lesCases.descendre(i, 1, lesCases.getValeur(i));
			// elle prend la valeur de j
			lesCases.setValeur(i, lesCases.getValeur(j));
			// elle remonte
			lesCases.monter(i,1,lesCases.getValeur(i));
			// et retourne � sa place
			lesCases.gauche(i, j-i, lesCases.getValeur(i));
		}
		// SI elle se trouve � DROITE de la case j 
		else{
			// elle se d�cale vers j
			lesCases.gauche(i, j-i, lesCases.getValeur(i));
			// elle descend
			lesCases.descendre(i, 1, lesCases.getValeur(i));
			// elle prend la valeur de j
			lesCases.setValeur(i, lesCases.getValeur(j));
			// elle remonte
			lesCases.monter(i,1,lesCases.getValeur(i));
			// et retourne � sa place
			lesCases.droite(i, j-i, lesCases.getValeur(i));
		}	
		lesCases.descendre(i, 1, lesCases.getValeur(i));
		return true;
	}


}
