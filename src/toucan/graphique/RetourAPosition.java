package toucan.graphique;

import toucan.modele.LesCases;

/**
 * Modélise le retour de la case à sa position initiale
 * @author Florine
 *
 */
public class RetourAPosition implements IAnimation{


	/**
	 * La Case retourne à sa position
	 */
	@Override
	public void executer(LesCases lesCases, int i, int j) {
		int deplacement;
		if(lesCases.getIdCase(j) > lesCases.getIdCase(i)){
				deplacement = lesCases.getIdCase(j)-lesCases.getIdCase(i);
			lesCases.gauche(i,deplacement,lesCases.getValeur(i));
		}
		else{
			deplacement = lesCases.getIdCase(i)-lesCases.getIdCase(j);
			lesCases.droite(i,deplacement,lesCases.getValeur(i));
		}
		if(i!=0)
			lesCases.descendre(i,1,lesCases.getValeur(i));
	}

	@Override
	public boolean executerComparaison(LesCases lesCases, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

}
