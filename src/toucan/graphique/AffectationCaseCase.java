package toucan.graphique;

import toucan.modele.LesCases;

/**
 * Classe modélisant l'affectation de la valeur d'une Case à une autre
 * @author Florine
 *
 */
public class AffectationCaseCase implements IAnimation{


	private AllerACase aac;
	private RetourAPosition aap;

	/**
	 * Constructeur par défaut
	 * Initialise aac (AllerACase)
	 */
	public AffectationCaseCase(){
		this.aac = new AllerACase();
		this.aap = new RetourAPosition();
	}

	/**
	 * Cette fonction définis les mouvements attribués à une Case
	 * pour simuler l’affectation entre 2 cases du tableau. 
	 * Le contenu des Case affectée est mis à jour
	 * */
	@Override
	public void executer(LesCases lesCases, int i, int j) {
		// Si on doit faire l'échange, la case de comparaison va vers la case i
		aac.executer(lesCases,0,i);
		// On fait le swap
		
		// valeur de i dans case temporaire
		lesCases.descendre(0, 1, lesCases.getValeur(0));
		lesCases.setValeur(0,lesCases.getValeur(i));
		lesCases.setValeur(i," ");
		lesCases.monter(0, 1, lesCases.getValeur(0));
		
		// valeur de j dans valeur de i	
		lesCases.descendre(i, 1, lesCases.getValeur(i));
		lesCases.setValeur(i, lesCases.getValeur(j));
		lesCases.setValeur(j, " ");
		lesCases.monter(i, 1, lesCases.getValeur(i));
		
		// valeur de case temp dans j
		lesCases.descendre(0, 2, lesCases.getValeur(0));
		lesCases.setValeur(j, lesCases.getValeur(0));
		lesCases.setValeur(0, " ");
		lesCases.monter(0, 2, lesCases.getValeur(0));
		
		aap.executer(lesCases, 0, i);
		
	}

	@Override
	public boolean executerComparaison(LesCases lesCases, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
}
