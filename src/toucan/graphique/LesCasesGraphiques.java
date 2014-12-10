package toucan.graphique;

import java.awt.Graphics;
import java.util.ArrayList;

import toucan.modele.LesCases;

/**
 * Classe modélisant un ensemble de CaseGraphique
 * @author Florine
 *
 */
public class LesCasesGraphiques {

	/**
	 * ArrayList comprenant les CaseGraphique
	 */
	private ArrayList<CaseGraphique> lesCasesGraphiques;
	
	/**
	 * La CaseGraphique comprenant la case de comparaison
	 */
	private CaseGraphique caseTestGraphique;

	/**
	 * Constructeur de LesCasesGraphiques
	 * @param lesCases lesCases représentant les CaseGraphique
	 */
	public LesCasesGraphiques(LesCases lesCases){
		// On parcourt lesCases
		// Pour chaque case, on créé une caseGraphique
		// on ajoute la caseGraphique à lesCasesGraphiques
		this.lesCasesGraphiques = new ArrayList<CaseGraphique>();
		for(int i = 0; i < lesCases.size(); i++){
			CaseGraphique cg1 = new CaseGraphique(lesCases.get(i));
			this.lesCasesGraphiques.add(cg1);
		} 

	}

	/**
	 * Dessine la CaseGrahique à l'indice i
	 * @param g
	 * @param i l'indice de la CaseGraphique à dessiner
	 */
	public void dessiner(Graphics g, int i) {   
		this.lesCasesGraphiques.get(i).dessiner(g);     
	}
	
	public void dessinerCaseTest(Graphics g){
		this.getCaseTestGraphique().dessiner(g);
	}

	/**
	 * Appelle la fonction prepareProchaineMouvement de la case associée à la CaseGraphique à l'indice i
	 * @param i
	 */
	public void prepareProchainMouvement(int i){
		this.lesCasesGraphiques.get(i).prepareProchainMouvement();
	}

	/**
	 * Retourne la taille de l'ArrayList lesCasesGraphiques
	 * @return la taille de lesCasesGraphiques
	 */
	public int size(){
		return this.lesCasesGraphiques.size();
	}

	/**
	 * Retourne la CaseGraphique à l'indice i
	 * @param i l'indice de la CaseGraphique à retourner
	 * @return la CaseGraphique à l'indice i
	 */	
	public CaseGraphique get(int i){
		return this.lesCasesGraphiques.get(i);
	}

	/**
	 * Détermine s'il reste encore au moins un mouvement à au moins une CaseGraphique
	 * @return true si au moins une CaseGraphique a encore au moins un mouvement à effectuer
	 */
	public boolean existeEncoreMouvement(){
		for(CaseGraphique cg : this.lesCasesGraphiques){
			if(cg.existeEncorePosition())
				return true;
		}
		return false;
	}

	public CaseGraphique getCaseTestGraphique() {
		return caseTestGraphique;
	}

	public void setCaseTestGraphique(CaseGraphique caseTestGraphique) {
		this.caseTestGraphique = caseTestGraphique;
	}

	/**
	 * Modélise textuellement un ojet LesCasesGraphiques
	 */
	@Override
	public String toString() {
		return "LesCasesGraphiques [lesCasesGraphiques=" + lesCasesGraphiques
				+ "]";
	}
}
