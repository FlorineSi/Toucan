package toucan.graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import toucan.modele.Modele;

/**
 * 24 juin 2014
 * Classe modélisant la Vue de l'animation
 * @author brigitte wrobel-dautcourt
 */

public class VueAnimation extends JPanel {

	private LesCasesGraphiques lesCasesGraphiques;
	private Modele modele;
	private int temporisation;

	/**
	 * Constructeur de VueAnimation
	 * @param m le modele concerné par la vue
	 */
	public VueAnimation(Modele m) {
		super();
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.lesCasesGraphiques = new LesCasesGraphiques(m.getCases());
		this.modele = m;
		this.temporisation=0;
		repaint();
	}


	/**
	 * Fonction paintComponent
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int w = getWidth();
		int h = getHeight();
		GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h,Color.WHITE);
		g2.setPaint(gp);
		g2.fillRect(0, 0, w, h);
		this.lesCasesGraphiques = new LesCasesGraphiques(modele.getCases());
		// On dessine toutes les cases graphiques
		for (int i = 0; i < lesCasesGraphiques.size(); i++) {
			lesCasesGraphiques.dessiner(g2,i); 
			try {
				// Récupérer la temporisation via le modele
				Thread.sleep(modele.getVitesse());
			} catch (InterruptedException ex) {
				Logger.getLogger(VueAnimation.class.getName()).log(Level.SEVERE,
						null, ex);
			}
			// On se place sur le prochain mouvement
			lesCasesGraphiques.get(i).getCase().prepareProchainMouvement();
		}
		if (lesCasesGraphiques.existeEncoreMouvement()) {
			repaint();
		}
	}

	public void setTemporisation(int temporisation) {
		this.temporisation = temporisation;
	}
}
