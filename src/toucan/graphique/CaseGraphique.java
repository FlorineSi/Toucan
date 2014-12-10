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
	 * La valeur � �crire dans la CaseGraphique
	 */
	private String valeur ;
	/**
	 * La case associ�e � la CaseGraphique
	 */
	private Case c;

	/**
	 * Constructeur de CaseGraphique
	 * @param c la Case associ�e
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
	 * Retourne la Case associ�e � la Case Graphique
	 * @return la Case associ�e � l'objet
	 */
	public Case getCase(){
		return this.c;
	}

	/**
	 * Dessin de l'�l�ment graphique (l'�l�ment graphique est redessin�, car sa couleur et son contenu peuvent changer au cours de l'animation
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
	 * Fonction pour centrer la chaine de caracteres dans l'�l�ment graphique
	 * @param s chaine de caractere � �crire au centre de l'�l�ment graphique
	 * @param w abscisse initiale relative de la chaine par rapport � l'�l�ment graphique
	 * @param h ordonn�e initiale relative de la chaine par rapport � l'�l�ment graphique
	 * @param c largeur de l'�l�ment dans lequel on centre la chaine
	 * @param g �l�ment graphique
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
	 * Dessin de l'�l�ment graphique et positionnement dans la feneyre graphique
	 * @param g fenetre graphique dans laquelle on dessine
	 */
	public void dessiner(Graphics g) {   
		dessinerCase() ;
		this.positionX = c.getPosX();
		this.positionY = c.getPosY();
		g.drawImage(this, positionX, positionY, null);
	}

	/**
	 * Determine s'il existe encore une position � une case
	 * @param c la case concern�e
	 * @return true s'il reste encore une position � c
	 */
	public boolean existeEncorePosition(){
		return c.existeEncorePosition();
	}

	/**
	 * Pr�pare le prochain mouvement de la case associ�e
	 */
	public void prepareProchainMouvement(){
		this.c.prepareProchainMouvement();
	}

	/**
	 * Mod�lise textuellement un objet de type CaseGraphique
	 */
	@Override
	public String toString() {
		return "CaseGraphique [carre=" + carre + ", cote=" + cote
				+ ", couleur=" + couleur + ", positionX=" + positionX
				+ ", positionY=" + positionY + ", valeur=" + valeur + ", c="
				+ c+"]";
	}

}
