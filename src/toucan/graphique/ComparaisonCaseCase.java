package toucan.graphique;

import toucan.modele.LesCases;


/**
 * Classe modélisant la comparaison entre 2 cases
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
	 * D'abord la Case se déplace vers la Case à comparer
	 * Si la valeur de la Case à comparer est supérieure à la sienne, on fait une AffectationCaseCase
	 * Puis la Case retourne à sa place
	 * @return true si i>j
	 */
	@Override
	public boolean executerComparaison(LesCases lesCases, int i, int j) {
		boolean comp = false;
		int vali = Integer.parseInt(lesCases.getValeur(i));
		int valj = Integer.parseInt(lesCases.getValeur(j));
		// La case i va vers la case j
		//aac.executer(lesCases, i, j);
		// si la valeur de i est supérieure à celle de j
		if(vali>valj){
			comp = true;
			//acc.executer(lesCases, i, j);
		}
		// ensuite elle retourne à sa place
		//rap.executer(lesCases, i, j);
		return comp;
	}

	@Override
	public void executer(LesCases lesCases, int i, int j) {
		// TODO Auto-generated method stub
	}
}
