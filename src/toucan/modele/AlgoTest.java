package toucan.modele;

import toucan.graphique.ComparaisonCaseCase;

/**
 * Classe modélisant un algorithme de test
 * @author Florine
 *
 */
public class AlgoTest implements IAlgo {

	private LesCases lesCases;
	private ComparaisonCaseCase ccc;

	public AlgoTest(LesCases lesCases){
		this.lesCases = lesCases;
		this.ccc = new ComparaisonCaseCase();
	}

	@Override
	public void trier() {
		ccc.executer(lesCases,1,4);
	}

	@Override
	public void setLesCases(LesCases lc) {
		this.lesCases = lc;

	}

}
