package toucan.graphique;

import toucan.modele.LesCases;


/**
 * Classe mod�lisant la comparaison entre 2 cases
 * @author Florine
 *
 */
public class ComparaisonCaseCase implements IAnimation{

	private AffectationCaseCase acc;
	private AllerACase aac;
	private RetourAPosition rap;

	/**
	 * Constructeur de ComparaisonCaseCase
	 * Instancie les attributs
	 */
	public ComparaisonCaseCase() {
		this.acc = new AffectationCaseCase();
		this.aac = new AllerACase();
		this.rap = new RetourAPosition();
	}

	/**
	 * Effectue la comparaison entre 2 cases
	 * D'abord la Case se d�place vers la Case � comparer
	 * Si la valeur de la Case � comparer est sup�rieure � la sienne, on fait une AffectationCaseCase
	 * Puis la Case retourne � sa place
	 * @return true si i>j
	 */
	@Override
	public boolean executerComparaison(LesCases lesCases, int i, int j) {
		boolean comp = false;
		int vali = Integer.parseInt(lesCases.getValeur(i));
		int valj = Integer.parseInt(lesCases.getValeur(j));
		// La case i va vers la case j
		//aac.executer(lesCases, i, j);
		// si la valeur de i est sup�rieure � celle de j
		if(vali>valj){
			comp = true;
			//acc.executer(lesCases, i, j);
		}
		// ensuite elle retourne � sa place
		//rap.executer(lesCases, i, j);
		return comp;
	}

	@Override
	public void executer(LesCases lesCases, int i, int j) {
		// TODO Auto-generated method stub
	}
}
