package toucan.graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import toucan.modele.Case;

/**
 * 24 juin 2014
 *
 * @author brigitte wrobel-dautcourt
 */

public class CaseGraphique extends BufferedImage{


	private Graphics2D carre ;
	private int cote = 50 ;
	/**
	 * La couleur de la CaseGraphique
	 */
	private Color couleur ;
	/**
	 * La position horizontale de la CaseGraphique
	 */
	private int positionX ;
	/**
	 * La position verticale de la CaseGraphique
	 */
	private int positionY ;
	/**
	 * La valeur à écrire dans la CaseGraphique
	 */
	private String valeur ;
	/**
	 * La case associée à la CaseGraphique
	 */
	private Case c;

	/**
	 * Constructeur de CaseGraphique
	 * @param c la Case associée
	 */
	public CaseGraphique(Case c) {
		super(150, 150, BufferedImage.TYPE_INT_ARGB);
		carre = createGraphics();
		valeur = c.getValeur();
		positionX = c.getPosX();
		positionY = c.getPosY();
		couleur = c.getCouleur() ;
		this.c = c;
		dessinerCase() ;
	}

	/**
	 * Retourne la Case associée à la Case Graphique
	 * @return la Case associée à l'objet
	 */
	public Case getCase(){
		return this.c;
	}

	/**
	 * Dessin de l'élément graphique (l'élément graphique est redessiné, car sa couleur et son contenu peuvent changer au cours de l'animation
	 */
	private void dessinerCase() {
		carre.setPaint(Color.white) ;
		carre.fillRect(0, 0, cote, cote) ;

		carre.setColor(couleur) ;
		carre.drawRect(0, 0, cote, cote); 

		carre.setFont(new Font("Arial", Font.BOLD, 16));
		dessinerChaineAuCentre(valeur, 0, 0, cote, carre);  
	}

	/**
	 * Fonction pour centrer la chaine de caracteres dans l'élément graphique
	 * @param s chaine de caractere à écrire au centre de l'élément graphique
	 * @param w abscisse initiale relative de la chaine par rapport à l'élément graphique
	 * @param h ordonnée initiale relative de la chaine par rapport à l'élément graphique
	 * @param c largeur de l'élément dans lequel on centre la chaine
	 * @param g élément graphique
	 */
	private void dessinerChaineAuCentre(String s, int w, int h, int c, Graphics2D g) {
		// Find the size of string s in the font of the Graphics context 
		FontMetrics fm = g.getFontMetrics();
		int xC = (c - fm.stringWidth(s)) / 2;
		int yC = (fm.getAscent() + (c - (fm.getAscent() + fm.getDescent())) / 2);        
		// Center text horizontally and vertically within provided rectangular bounds
		g.drawString(s, xC + w, yC + h);
	} 

	/**
	 * Dessin de l'élément graphique et positionnement dans la feneyre graphique
	 * @param g fenetre graphique dans laquelle on dessine
	 */
	public void dessiner(Graphics g) {   
		dessinerCase() ;
		this.positionX = c.getPosX();
		this.positionY = c.getPosY();
		g.drawImage(this, positionX, positionY, null);
	}

	/**
	 * Determine s'il existe encore une position à une case
	 * @param c la case concernée
	 * @return true s'il reste encore une position à c
	 */
	public boolean existeEncorePosition(){
		return c.existeEncorePosition();
	}

	/**
	 * Prépare le prochain mouvement de la case associée
	 */
	public void prepareProchainMouvement(){
		this.c.prepareProchainMouvement();
	}

	/**
	 * Modélise textuellement un objet de type CaseGraphique
	 */
	@Override
	public String toString() {
		return "CaseGraphique [carre=" + carre + ", cote=" + cote
				+ ", couleur=" + couleur + ", positionX=" + positionX
				+ ", positionY=" + positionY + ", valeur=" + valeur + ", c="
				+ c+"]";
	}

}
