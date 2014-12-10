package toucan;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import toucan.graphique.VueGraphique;
import toucan.modele.Modele;

/**
 * Classe principale
 * @author Florine
 *
 */
public class Toucan extends JFrame {

	private static Modele modele;
	private static VueGraphique vueGraphique;

	/**
	 * Constructeur de Toucan
	 */
	public Toucan(){
		super("Projet Toucan - animation des algorithmes de tris");
	}

	/**
	 * Fonction main
	 * Initialise le modele et la vue graphique
	 * @param args
	 */
	public static void main(String[] args) {
		Toucan toucan = new Toucan();

		modele = new Modele();
		vueGraphique = new VueGraphique(modele);
		// VueGraphique observe le modele
		modele.addObserver(vueGraphique);

		toucan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		toucan.setContentPane(vueGraphique);

		// Appel de la fontion m.creerLEsMouvements();
		//modele.creerLesMouvements();
		toucan.pack() ;
		toucan.setExtendedState(JFrame.MAXIMIZED_BOTH);
		toucan.setVisible(true);
	}

}
