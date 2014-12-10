package toucan.modele;

import java.awt.Color;

/**
 * Modélise une case
 * @author Florine
 *
 */
public class Case {

	/**
	 * La liste de mouvements associée à la case
	 */
	private LesMouvements lesMouvements;
	/**
	 * La valeur de la case
	 */
	private String valeur;
	/**
	 * La position horizontale de la case
	 */
	private int posX;
	/**
	 * La position verticale de la case
	 */
	private int posY;
//	private static int id = 0;
	/**
	 * L'id de la case
	 */
	private int idCase;
	/**
	 * La couleur de la case
	 */
	private Color couleur;

	/**
	 * Constructeur de la classe Case
	 * @param val La valeur à attribuer à la case, int
	 * @param posX La position horizontale de la case, int
	 * @param posY La position verticale de la case, int
	 * @param coul La couleur de la case, Color
	 */
	public Case(String val, int posX, int posY, Color coul, int id) {
		this.valeur = val;
		this.posX = posX;
		this.posY = posY;
		this.idCase = id;
		//id++;
		this.lesMouvements = new LesMouvements();
		this.couleur = coul;
	}

	/**
	 * Prepare le prochain mouvement de la case.
	 * 1 : Vérifie qu'il reste au moins un mouvement à efféctuer (si plus de mouvement, ne fais rien)
	 * 2 : Récupère et identifie le prochain mouvement
	 * 3 : Modifie la position de la case
	 */
	public void prepareProchainMouvement() {
		if (this.lesMouvements.existeEncorePosition()) {
			Mouvement m = this.lesMouvements.getProchainMouvement();
			switch (m.getDirection()) {
			case -1:
				break;
			case 0:
				this.posX --;
				break;
			case 1:
				this.posX ++;
				break;
			case 2:
				this.posY --;
				break;
			case 3:
				this.posY ++;
				break;
			}
			this.valeur = m.getValeurCase();
		}
	}

	/**
	 * Appelle la fonction haut(nbFois,v) sur l'attribut lesMouvements de la case
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case au moment du déplacement
	 */
	public void monter(int nbFois, String v) {
		this.lesMouvements.haut(nbFois * (50+10),v);
	}

	/**
	 * Appelle la fonction bas(nbFois,v) sur l'attribut lesMouvements de la case
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case au moment du déplacement
	 */
	public void descendre(int nbFois, String v) {
		this.lesMouvements.bas(nbFois * (50+10),v);
	}

	/**
	 * Appelle la fonction gauche(nbFois,v) sur l'attribut lesMouvements de la case
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case au moment du déplacement
	 */
	public void gauche(int nbFois, String v) {
		this.lesMouvements.gauche(nbFois * (50+10),v);
	}
	/**
	 * Appelle la fonction droite(nbFois,v) sur l'attribut lesMouvements de la case
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case au moment du déplacement
	 */
	public void droite(int nbFois, String v) {
		this.lesMouvements.droite(nbFois * (50+10),v);
	}

	/**
	 * Appelle la fonction surPlace(nbFois,v) sur l'attribut lesMouvements de la case
	 * @param nbFois le nombre de fois
	 * @param v la valeur de la case au moment du déplacement
	 */
	public void surPlace(int nbFois, String v){
		this.lesMouvements.surPlace(nbFois * (50+10), v);
	}

	/**
	 * Détermine s'il reste encore un mouvement à effectuer par la case
	 * @return true si il existe encore un mouvement
	 */
	public boolean existeEncorePosition() {
		if (this.lesMouvements.existeEncorePosition())
			return true;
		return false;
	}

	/**
	 * Ajoute un mouvement à la case
	 * @param mv le mouvement à ajouter
	 */
	public void ajoutMouvements(LesMouvements mv) {
		this.lesMouvements = mv;
	}
	/**
	 * Retourne la liste de mouvements de la case
	 * @return l'objet LesMouvements associé à la case, c'est sa liste de mouvements
	 */
	public LesMouvements getLesMouvements() {
		return lesMouvements;
	}

	/**
	 * Remplace les mouvements de la case
	 * @param lesMouvements l'objet LesMouvements à attribuer à la case
	 */
	public void setLesMouvements(LesMouvements lesMouvements) {
		this.lesMouvements = lesMouvements;
	}

	/**
	 * Retourne la valeur associée à la case
	 * @return valeur la valeur associée à la case
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * Modifie la valeur associée à la case
	 * @param valeur la nouvelle valeur à lui affecter 
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * Retourne la position horizontale de la vase
	 * @return posX la position horizontale de la vase
	 */
	public int getPosX() {
		return this.posX;
	}

	/**
	 * Modifie la position X de la case
	 * @param posX la nouvelle position horizontale de la case
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Retourne la position verticale de la case
	 * @return posY la position verticale de la case
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Modifie la valeur verticale de la case
	 * @param posY le nouvelle position verticale de la case
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Retourne la couleur de la case
	 * @return couleur la couleur de la case
	 */
	public Color getCouleur(){
		return this.couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	/**
	 * Retourne l'id de la case
	 * @return idCase 
	 * l'id de la case
	 */
	public int getIdCase() {
		return idCase;
	}


	/**
	 * Modélise textuellement la case
	 */
	@Override
	public String toString() {
		/*return "Case [lesMouvements=" + lesMouvements + ", valeur=" + valeur
				+ ", posX=" + posX + ", posY=" + posY + ", idCase=" + idCase
				+ ", couleur=" + couleur + "]";*/
		return "Case [valeur=" + valeur+ ", idCase=" + idCase + "]";
	}
}
