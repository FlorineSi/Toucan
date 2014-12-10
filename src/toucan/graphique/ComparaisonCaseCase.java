package toucan.graphique;

import java.awt.Color;

import toucan.modele.LesCases;


/**
 * Classe modélisant la comparaison entre 2 cases
 * @author Florine
 *
 */
public class ComparaisonCaseCase implements IAnimation{

	private AffectationCaseCase acc;

	/**
	 * Constructeur de ComparaisonCaseCase
	 * Instancie les attributs
	 */
	public ComparaisonCaseCase() {
		this.acc = new AffectationCaseCase();
	}

	/**
	 * Effectue la comparaison entre 2 cases
	 * Les 2 cases montent
	 * La plus grande case monte une fois de plus
	 * Les 2 cases retournent à leurs positions
	 * @return true si i>j
	 */
	@Override
	public boolean executer(LesCases lesCases, int i, int j) {
		boolean comp = false;
		int vali = Integer.parseInt(lesCases.getValeur(i));
		int valj = Integer.parseInt(lesCases.getValeur(j));
		int depl;
		lesCases.monter(i,1, lesCases.getValeur(i));
		lesCases.monter(j,1, lesCases.getValeur(j));
		depl = lesCases.calculerDeplacement(i, j);
		if(i<j){
			lesCases.droite(i,depl, lesCases.getValeur(i));
			lesCases.gauche(j,depl, lesCases.getValeur(j));
		}
		else{
			lesCases.gauche(i,depl, lesCases.getValeur(i));
			lesCases.droite(j,depl, lesCases.getValeur(j));
		}
		if(vali>valj){
			comp = true;
			lesCases.monter(i,1, lesCases.getValeur(i));
			lesCases.descendre(i,1,lesCases.getValeur(i));
		}
		else{
			comp = false;
			lesCases.monter(j,1, lesCases.getValeur(j));
			lesCases.descendre(j,1,lesCases.getValeur(j));
		}
		if(i<j){
			lesCases.gauche(i,depl, lesCases.getValeur(i));
			lesCases.droite(j,depl, lesCases.getValeur(j));
		}
		else{
			lesCases.droite(i,depl, lesCases.getValeur(i));
			lesCases.gauche(j,depl, lesCases.getValeur(j));
		}
		lesCases.descendre(i,1, lesCases.getValeur(i));
		lesCases.descendre(j,1, lesCases.getValeur(j));
		return comp;
	}

}
