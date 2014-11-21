package toucan.modele;

import java.util.Observable;

/**
 * CLasse mod�lisant le mod�le
 * @author Florine
 *
 */
public class Modele extends Observable {

	/**
	 * Objet de type LesCases repr�sentant l'ensemble des Case
	 */
	private LesCases lesCases;
	/**
	 * L'algo � executer
	 */
	private IAlgo algo;
	/**
	 * Le nombre de Case
	 */
	private int taille;
	/**
	 * D�termine si on peut lancer une execution
	 */
	private boolean executionPossible;

	/**
	 * Constructeur par d�faut
	 * Instancie lesCases (constructeur nul)
	 * Instancie un algo en lui passant en param�tre lesCases
	 * Instancie la taille � 0
	 * Ajoute l'objet lesCases � la liste de ses observeurs
	 */
	public Modele() {
		lesCases = new LesCases();
		this.addObserver(lesCases);
		//algo = new AlgoBulle(lesCases);
		this.executionPossible = false;
		taille = 0;
	}

	/**
	 * Initialise lesCases
	 * Si la taille vaut 0 (elle n'as pas �t� d�finie/ l'utilisateur a saisi 0), elle est fix�e arbitrairement � 5
	 * On r�initialise l'objet lesCases
	 * On appelle la fonction initCases(taille) de LesCases
	 * On appelle le fonction setLesCases(lesCases) sur l'objet algo pour qu'il dispose des bonnes cases
	 */
	public void initCases(){
		if(this.taille == 0)
			taille = 5;
		this.lesCases = new LesCases();
		this.lesCases.initCases(taille);
		this.algo.setLesCases(lesCases);
		setChanged();
		notifyObservers();
	}

	/**
	 * Retourne l'objet lesCases
	 * @return lesCases
	 */
	public LesCases getCases() {
		return this.lesCases;
	}

	/**
	 * Appelle la fonction trier() de l'algorithme
	 * Elle ne fait rien bouger, elle initialise juste les mouvements
	 */
	public void run() {
		algo.trier();
		setChanged();
		notifyObservers();
	}

	/**
	 * Modifie l'attribut taille
	 * @param i la nouvelle taille
	 */
	public void setTaille(int i){
		this.taille = i;
	}

	public void setAlgo(int i){
		switch(i){
		case 0:
			this.algo = new AlgoBulle(this.lesCases);
			break;
		case 1:
			this.algo = new AlgoTriInsertion(lesCases);
			break;
		default:
			this.algo = new AlgoBulle(lesCases);
			break;

		}
	}

	/**
	 * Determine si on peut lancer une execution
	 * @return true si on peut lancer une execution
	 */
	public boolean getExecutionPossible() {
		return executionPossible;
	}

	/**
	 * Affecter une nouvelle valeur � executionPossible
	 * @param executionPossible la nouvelle valeur bool�enne
	 */
	public void setExecutionPossible(boolean executionPossible) {
		this.executionPossible = executionPossible;
	}

	/**
	 * Mod�lise textuellement un objet Modele
	 */
	@Override
	public String toString() {
		return "Modele [lesCases=" + lesCases + ", algo=" + algo + ", taille="
				+ taille + "]";
	}



}
