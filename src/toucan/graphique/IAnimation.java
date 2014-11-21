package toucan.graphique;

import toucan.modele.LesCases;

/**
 * Classe mod�lisant les animation des Case
 * @author Florine
 *
 */
public interface IAnimation {

	/**
	 * 
	 * @param lesCases l'ensemble de Case � animer
	 * @param i l'indice de la Case � animer
	 * @param j l'indice de la 2eme Case � �ventuellement animer
	 */
	public void executer(LesCases lesCases, int i, int j);
	public boolean executerComparaison(LesCases lesCases, int i, int j);
}
