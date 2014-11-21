package toucan.graphique;

import toucan.modele.LesCases;

/**
 * Classe modélisant le déplacement d'une Case vers une autre
 * @author Florine
 *
 */
public class AllerACase implements IAnimation{

	/**
	 * Déplacement de la Case d'indice i vers la Case j
	 */
	@Override
	public void executer(LesCases lesCases, int i, int j) {
		//La case i va vers la case j (au dessus)
		// La case i monte (sauf pour la case de comparaison)
		if(i != 0)
			lesCases.monter(i,1,lesCases.getValeur(i));
		// Si la case j se trouve après la case i dans le tableau (à sa droite)
		if(lesCases.getIdCase(j) > lesCases.getIdCase(i)){
			// Alors on déplace la case i vers la droite de (indice j - indice i) pas
			lesCases.droite(i,lesCases.getIdCase(j)-lesCases.getIdCase(i),lesCases.getValeur(i));
		}
		else{
			// Sinon on déplace la case i vers la gauche de (indice j - indice i) pas
			lesCases.gauche(i,lesCases.getIdCase(i)-lesCases.getIdCase(j),lesCases.getValeur(i));
		}

	}

	@Override
	public boolean executerComparaison(LesCases lesCases, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

}
