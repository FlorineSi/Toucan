package toucan.modele;

import toucan.graphique.AffectationCaseCase;
import toucan.graphique.ComparaisonCaseCase;

/**
 * Classe modélisant un algorithme par insertion
 * @author Florine
 *
 */
public class AlgoTriInsertion implements IAlgo{

	private LesCases lesCases;
	private AffectationCaseCase acc;
	private ComparaisonCaseCase ccc;
	/**
	 * Constructeur de AlgoTriInsertion
	 * Instancie les attributs
	 * @param lc l'objet LesCases concerné
	 */
	public AlgoTriInsertion(LesCases lc){
		this.lesCases = lc;
		this.ccc = new ComparaisonCaseCase();
		this.acc = new AffectationCaseCase();
	}

	/**
	 * Algorithme du tri par insertion	
	 */


	@Override
	public void trier(){
		int cpt;
	    Case element;
	    int taille = lesCases.getNbCases();
	    for (int i = 2; i <= taille ; i++)
	    {    
	        element = lesCases.get(i);
	        cpt = i - 1;
	        element.monter(1, element.getValeur());
	        while (cpt > 0 && Integer.parseInt(lesCases.getValeur(cpt)) > Integer.parseInt(element.getValeur()))
	        {
	        	element.gauche(1, element.getValeur());
	        //   tab[cpt + 1] = tab[cpt];
	           cpt--;
	        }
	        acc.executer(lesCases, i, cpt);
	       // tab[cpt + 1] = element;
	    }
	}

	
	public void setLesCases(LesCases lc) {
		this.lesCases = lc;
	}

}
