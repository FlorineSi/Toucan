package toucan.graphique;

import toucan.modele.LesCases;

/**
 * Classe mod√©lisant l'affectation de la valeur d'une Case √† une autre
 * @author Florine
 *
 */
public class AffectationCaseCase implements IAnimation{

	/**
	 * Constructeur par d√©faut
	 * Initialise aac (AllerACase)
	 */
	public AffectationCaseCase(){
	}

	/**
	 * Cette fonction d√©finis les mouvements attribu√©s √† une Case
	 * pour simuler l‚Äôaffectation entre 2 cases du tableau. 
	 * Le contenu des Case affect√©e est mis √† jour
	 * On met le contenu de la case j dans la case i
	 * */
	
	public boolean executer(LesCases lesCases, int i, int j) {
		// La case i monte
		lesCases.monter(i,1,lesCases.getValeur(i));
		// SI elle se trouve ‡ GAUCHE de la case j 
		if(i<j){
			// elle se dÈcale vers j
			lesCases.droite(i,j-i,lesCases.getValeur(i));
			// elle descend
			lesCases.descendre(i, 1, lesCases.getValeur(i));
			// elle prend la valeur de j
			lesCases.setValeur(i, lesCases.getValeur(j));
			// elle remonte
			lesCases.monter(i,1,lesCases.getValeur(i));
			// et retourne ‡ sa place
			lesCases.gauche(i, j-i, lesCases.getValeur(i));
		}
		// SI elle se trouve ‡ DROITE de la case j 
		else{
			// elle se dÈcale vers j
			lesCases.gauche(i, j-i, lesCases.getValeur(i));
			// elle descend
			lesCases.descendre(i, 1, lesCases.getValeur(i));
			// elle prend la valeur de j
			lesCases.setValeur(i, lesCases.getValeur(j));
			// elle remonte
			lesCases.monter(i,1,lesCases.getValeur(i));
			// et retourne ‡ sa place
			lesCases.droite(i, j-i, lesCases.getValeur(i));
		}	
		lesCases.descendre(i, 1, lesCases.getValeur(i));
		return true;
	}


}
