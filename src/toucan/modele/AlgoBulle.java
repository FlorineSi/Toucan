package toucan.modele;

import toucan.graphique.AffectationCaseCase;
import toucan.graphique.AffectationCaseVar;
import toucan.graphique.AffectationVarCase;
import toucan.graphique.ComparaisonCaseCase;

/**
 * Classe modélisant un algorithme de tri à bulle
 * @author Florine
 *
 */
public class AlgoBulle implements IAlgo{

	private LesCases lesCases;
	private AffectationCaseCase acc;
	private ComparaisonCaseCase ccc;
	private AffectationCaseVar acv;
	private AffectationVarCase avc;

	/**
	 * Constructeur de AlgoBulle
	 * @param lc l'objet LesCases concerné
	 */
	public AlgoBulle(LesCases lc){
		this.lesCases = lc;
		this.ccc = new ComparaisonCaseCase();
		this.acc = new AffectationCaseCase();
		this.acv = new AffectationCaseVar();
		this.avc = new AffectationVarCase();
	}

	/**
	 * Algorithme du tri à bulle
	 */
	public void trier(){
		boolean tab_en_ordre = false;
		int taille = lesCases.getNbCases();
		while(!tab_en_ordre){
			tab_en_ordre = true;
			for(int i=1 ; i <= taille-1 ; i++){
				int j = i+1;
				// SI i > j
				boolean comp = ccc.executer(lesCases, i, j); 
				if(comp){
					// valeur de i dans case temp
					acv.executer(lesCases,i,i);
					// valeur de i dans i+1
					acc.executer(lesCases, i, j);
					// valeur de temp dans i+1
					avc.executer(lesCases, j, i);
					tab_en_ordre = false;
				}								
			}
			taille--;
		}
		
	}

	public void setLesCases(LesCases lc) {
		this.lesCases = lc;
	}

}
