package toucan.modele;

import java.util.ArrayList;

/**
 * Classe mod�lisant un ensemble de mouvements
 * @author Florine
 *
 */
public class LesMouvements {

	/**
	 * ArrayList contenant les Mouvement
	 */
	private ArrayList<Mouvement> lesMouvements;
	/**
	 * L'indice du Mouvement actuel
	 */
	private int indice;

	/**
	 * Constrcteur nul
	 * Initialise l'ArrayList lesMouvements
	 * Initialise indice � 0
	 */
	public LesMouvements() {
		this.lesMouvements = new ArrayList<Mouvement>();
		this.indice = 0;
	}

	/**
	 * Ajoute un Mouvement � l'ArrayList lesMouvements
	 * @param m le Mouvement � ajouter
	 */
	public void add(Mouvement m) {
		this.lesMouvements.add(m);
	}

	/**
	 * Retourne le Mouvement � l'indice i
	 * @param i l'indice du Mouvement � retourner
	 * @return le Mouvement � l'indice i
	 */
	public Mouvement get(int i) {
		return this.lesMouvements.get(i);
	}

	/**
	 * Retourne le prochain mouvement de l'ArrayList et incr�mente indice
	 * @return le prochaine Mouvement
	 */
	public Mouvement getProchainMouvement() {
		Mouvement m = this.lesMouvements.get(indice);
		this.indice++;
		return m;
	}

	/**
	 * Determine s'il existe encore un mouvement
	 * @return true si il reste encore un mouvement, false si on n'est positionn�s sur le dernier (si indice = taille de l'ArrayList)
	 */
	public boolean existeEncorePosition() {
		if (this.indice >= lesMouvements.size())
			return false;
		return true;
	}

	/**
	 * Ajoute un Mouvement vers le haut � lesMouvements
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case apr�s le mouvement
	 */
	public void haut(int nbFois, String v) {
		for(int i = 0; i<nbFois; i++){
			Mouvement m = new Mouvement(2,v);
			this.lesMouvements.add(m);
		}
	}

	/**
	 * Ajoute un Mouvement vers le bas � lesMouvements
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case apr�s le mouvement
	 */
	public void bas(int nbFois, String v) {
		for(int i = 0; i<nbFois; i++){
			Mouvement m = new Mouvement(3,v);
			this.lesMouvements.add(m);
		}
	}

	/**
	 * Ajoute un Mouvement vers la gauche � lesMouvements
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case apr�s le mouvement
	 */
	public void gauche(int nbFois, String v) {
		for(int i = 0; i<nbFois; i++){
			Mouvement m = new Mouvement(0,v);
			this.lesMouvements.add(m);
		}
	}

	/**
	 * Ajoute un Mouvement vers la droite � lesMouvements
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case apr�s le mouvement
	 */
	public void droite(int nbFois, String v) {
		for(int i = 0; i<nbFois; i++){
			Mouvement m = new Mouvement(1,v);
			this.lesMouvements.add(m);
		}
	}

	/**
	 * Ajoute un Mouvement vide � lesMouvements
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case apr�s le mouvement
	 */
	public void surPlace(int nbFois, String v){
		for(int i=0; i<nbFois; i++){
			Mouvement m = new Mouvement(-1,v);
			this.lesMouvements.add(m);
		}
	}

	/**
	 * Mod�lise textuellement un objet LesMouvements
	 */
	@Override
	public String toString() {
		return "LesMouvements [lesMouvements=" + lesMouvements + ", indice="
				+ indice + "]";
	}


}
