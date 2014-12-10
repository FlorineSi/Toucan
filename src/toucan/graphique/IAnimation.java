package toucan.graphique;

import toucan.modele.LesCases;

/**
 * Classe modélisant les animation des Case
 * @author Florine
 *
 */
public interface IAnimation {

	/**
	 * 
	 * @param lesCases l'ensemble de Case à animer
	 * @param i l'indice de la Case à animer
	 * @param j l'indice de la 2eme Case à éventuellement animer
	 */
	public boolean executer(LesCases lesCases, int i, int j);
}
