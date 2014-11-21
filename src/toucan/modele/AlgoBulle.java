package toucan.modele;

import toucan.graphique.AffectationCaseCase;
import toucan.graphique.AllerACase;
import toucan.graphique.ComparaisonCaseCase;
import toucan.graphique.RetourAPosition;

/**
 * Classe modélisant un algorithme de tri à bulle
 * @author Florine
 *
 */
public class AlgoBulle implements IAlgo{

	private LesCases lesCases;
	private AffectationCaseCase acc;
	private ComparaisonCaseCase ccc;
	private AllerACase aac;
	private RetourAPosition rap;

	/**
	 * Constructeur de AlgoBulle
	 * @param lc l'objet LesCases concerné
	 */
	public AlgoBulle(LesCases lc){
		this.lesCases = lc;
		this.ccc = new ComparaisonCaseCase();
		this.acc = new AffectationCaseCase();
		this.aac = new AllerACase();
		this.rap = new RetourAPosition();
	}

	/**
	 * Algorithme du tri à bulle
	 */
	@Override
	public void trier(){
		boolean tab_en_ordre = false;
		int taille = lesCases.getNbCases();
		while(!tab_en_ordre){
			tab_en_ordre = true;
			for(int i=1 ; i <= taille-1 ; i++){
				aac.executer(lesCases, i, i+1);
				if(ccc.executerComparaison(lesCases, i, i+1)){
					acc.executer(lesCases, i, i+1);
					tab_en_ordre = false;
				}
				rap.executer(lesCases, i, i+1);									
			}
			taille--;
		}
	}

	@Override
	public void setLesCases(LesCases lc) {
		this.lesCases = lc;
	}

}
