package toucan.graphique;

import toucan.modele.LesCases;

public class AffectationCaseVar implements IAnimation{


	/**
	 * Constructeur par defaut
	 */
	public AffectationCaseVar(){
	}

	/**
	 * Cette fonction définis les mouvements attribués à une Case
	 * pour simuler l’affectation entre 2 cases du tableau. 
	 * Le contenu des Case affectée est mis à jour
	 * La valeur de la case i est recopi�e dans la case temporaire
	 **/
	public boolean executer(LesCases lesCases, int i, int j) {
		// la case temporaire se d�place vers la case
		lesCases.droite(0,i-1,lesCases.getValeur(0));
		// la casetemporaire descend
		lesCases.descendre(0, 2, lesCases.getValeur(0));
		//Valeur de i dans la case temporaire
		lesCases.setValeur(0, lesCases.getValeur(i));
		// la case temoraire remonte
		lesCases.monter(0, 2, lesCases.getValeur(0));
		// la case temporaire retourne � sa place
		lesCases.gauche(0, i-1,  lesCases.getValeur(0));
		return true;
	}

}
