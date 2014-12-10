package toucan.graphique;

import toucan.modele.LesCases;

public class AffectationVarCase implements IAnimation{

	/**
	 * Cette fonction d�finis les mouvements attribu�s � une Case
	 * La valeur de la case temporaire est recopi�e dans la case i
	 * */
	public boolean executer(LesCases lesCases, int i, int j) {
		// la case temporaire se d�place vers la case
		lesCases.droite(0,i-1,lesCases.getValeur(0));
		// la case temporaire descend
		lesCases.descendre(0, 2, lesCases.getValeur(0));
		//Valeur de la case temporaire dans i
		lesCases.setValeur(i, lesCases.getValeur(0));
		// la case temoraire remonte
		lesCases.monter(0, 2, lesCases.getValeur(0));
		// la case temporaire retourne � sa place
		lesCases.gauche(0, i-1,  lesCases.getValeur(0));
		return true;
	}

}
