package toucan.modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Classe représentant un ensemble de Case
 * @author Florine
 *
 */
public class LesCases implements Observer{

	/**
	 * ArrayList contenant l'ensemble des Case
	 */
	private ArrayList<Case> lesCases;

	/**
	 * Instancie l'arrayList de Case et nbCase à 0
	 */
	public LesCases(){
		lesCases = new ArrayList<Case>();
	}	

	/**
	 * Initialise les Case
	 * @param n le nombre de Case à instancier
	 */
	public void initCases(int n){
		//vider arraylist
		this.lesCases = new ArrayList<Case>();
		int positionX = 30;
		Random r = new Random();
		Case casetest = new Case(" ", 30, 50, Color.BLACK,0);
		lesCases.add(casetest);
		// Pour i de 0 à n-1
		for(int i=0; i<n; i++){
			// génération d'une couleur aléatoire
			//Color c = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
			// Génération aléatoire de la valeur
			int nb = (int) (Math.random() * (301)-150);
			// Création de la case et ajout à l'arraylist
			lesCases.add(new Case(""+nb,(positionX+i*50+i*10),170,Color.MAGENTA, i+1));
		}
	}

	public int calculerDeplacement(int i, int j){
		return ((Math.abs(j-i-1))/2);
	}

	/**
	 * Appelle la fonction monter(nbFois,valeur) sur la case à l'index i et appelle mouvementVide(i,nbFois)
	 * @param i l'index de la case à faire monter
	 * @param nbFois le nombre de fois
	 * @param valeur la valeur de la case au moment du mouvement
	 */
	public void monter(int i, int nbFois, String valeur){
		lesCases.get(i).monter(nbFois, valeur);
		mouvementVide(i,nbFois);
	}

	/**
	 * Appelle la fonction descendre(nbFois,valeur) sur la case à l'index i et appelle mouvementVide(i,nbFois)
	 * @param i l'index de la case à faire monter
	 * @param nbFois le nombre de fois
	 * @param valeur la valeur de la case au moment du mouvement
	 */
	public void descendre(int i, int nbFois, String valeur){
		lesCases.get(i).descendre(nbFois, valeur);
		mouvementVide(i,nbFois);
	}

	/**
	 * Appelle la fonction gauche(nbFois,valeur) sur la case à l'index i et appelle mouvementVide(i,nbFois)
	 * @param i l'index de la case à faire monter
	 * @param nbFois le nombre de fois
	 * @param valeur la valeur de la case au moment du mouvement
	 */
	public void gauche(int i, int nbFois, String valeur){
		lesCases.get(i).gauche(nbFois, valeur);
		mouvementVide(i,nbFois);
	}

	/**
	 * Appelle la fonction droite(nbFois,valeur) sur la case à l'index i et appelle mouvementVide(i,nbFois)
	 * @param i l'index de la case à faire monter
	 * @param nbFois le nombre de fois
	 * @param valeur la valeur de la case au moment du mouvement
	 */
	public void droite(int i, int nbFois, String valeur){
		lesCases.get(i).droite(nbFois, valeur);
		mouvementVide(i,nbFois);
	}

	/**
	 * Associe un mouvement vide à toutes les Case (appelle la fonction surPlace de la classe Case), excpetée celle à l'indice i
	 * @param i la seule case qui n'est pas concernée
	 * @param nbFois le nombre de fois qu'un mouvement vide doit être affecté
	 */
	public void mouvementVide(int i, int nbFois){
		for(int k = 0; k<lesCases.size();k++){
			if(k!=i)
				lesCases.get(k).surPlace(nbFois,getValeur(k));
		}
	}

	/**
	 * Retourne la valeur de la Case à l'indice i
	 * @param i l'index de la Case concernée
	 * @return la valeur de la Case à l'indice i
	 */
	public String getValeur(int i){
		return lesCases.get(i).getValeur();
	}

	/**
	 * Retourne l'id de la Case à l'indice i
	 * @param i index de la Case concercée
	 * @return l'id de la Case à l'indice i
	 */
	public int getIdCase(int i){
		return lesCases.get(i).getIdCase();
	}

	@Override
	public void update(Observable o, Object arg) {
	}

	/**
	 * 
	 * @return la taille de l'ArrayList lesCases
	 */
	public int size(){
		return lesCases.size();
	}

	/**
	 * Retourne la Case à l'indice i
	 * @param i l'indice de la Case à retourner
	 * @return la Case à l'indice i
	 */
	public Case get(int i) {
		return lesCases.get(i);
	}

	/**
	 * Modifie la case à l'index i 
	 * @param i index de la Case à modifier
	 * @param c la nouvelle Case
	 */
	public void set(int i, Case c){
		lesCases.set(i,c);
	}

	/**
	 * Retourne le nombre de Case de l'ArrayList
	 * INUTILE : se référer à size()
	 * @return le nombre de Case
	 */
	public int getNbCases() {
		return lesCases.size()-1;
	}

	/**
	 * Appelle la fonction setValeur de la case à l'indice i
	 * @param i l'indice de la Case à modifier,
	 * @param s la nouvelle valeur
	 */
	public void setValeur(int i, String s){
		lesCases.get(i).setValeur(s);
	}

	/**
	 * Représente textuellement l'objet LesCases
	 */
	@Override
	public String toString() {
		return "LesCases [lesCases=" + lesCases+ "]";
	}	

}
