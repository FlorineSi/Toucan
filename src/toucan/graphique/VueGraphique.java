package toucan.graphique;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import toucan.modele.Modele;

/**
 * Classe modélisant la Vue Graphique
 * @author Florine
 *
 */
public class VueGraphique extends JPanel implements Observer{

	private VueAnimation vueAnimation;
	private Modele modele;

	// Appelle la fonction créer les mouvements du modele
	private JButton boutonDemarrer;

	// Composant à déterminer : vitesse;
	private JLabel labelVitesse;
	private JTextField saisieVitesse;
	private JButton boutonVitesse;

	// Choix du nombre de cases
	private JLabel labelTaille;
	private JTextField saisieTaille;
	private JButton boutonTaille;

	// Choix de l'algo
	private JComboBox listeAlgo;

	// Initialise les cases du tableau
	private JButton boutonInitCases;

	/**
	 * Constructeur de VueAnimation
	 * Initialise les composants graphiques
	 * @param m le modele concerné
	 */
	public VueGraphique(Modele m){
		super();
		this.modele = m;
		modele.setAlgo(0);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		this.vueAnimation = new VueAnimation(m);
		this.labelVitesse = new JLabel("Vitesse : ");
		this.saisieVitesse = new SaisieEntier(10);
		this.saisieVitesse.setToolTipText("Entrez un entier : plus l'entier est grand, plus la vitesse est réduite");
		this.boutonVitesse = new JButton("OK");
		this.boutonVitesse.setToolTipText("Cliquer pour modifier la vitesse");
		this.boutonVitesse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String saisie = saisieVitesse.getText();
				int vitesse = Integer.parseInt(saisie);
				VueAnimation.setTemporisation(vitesse);
			}
		});
		this.labelTaille =new JLabel("Nb de cases : ");
		this.saisieTaille = new SaisieEntier(10);
		this.saisieTaille.setToolTipText("Le nombre de cases du tableau");
		this.boutonTaille = new JButton("OK");
		this.boutonTaille.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String saisie = saisieTaille.getText();
				int taille = Integer.parseInt(saisie);
				modele.setTaille(taille);
				modele.setExecutionPossible(true);
				modele.initCases();
			}
		});
		this.boutonDemarrer = new JButton("Executer");
		this.boutonDemarrer.setToolTipText("Cliquez pour executer l'algorithme");
		this.boutonDemarrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modele.setExecutionPossible(false);
				Thread t = new Thread((Runnable) modele, "Toucan") ;
				t.start() ;
				//modele.creerLesMouvements();
			}
		});
		this.boutonInitCases = new JButton("Initialiser les cases");
		this.boutonInitCases.setToolTipText("Cliquez pour initialiser les cases de manière aléatoire");
		this.boutonInitCases.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modele.setExecutionPossible(true);
				modele.initCases();
			}
		});
		this.listeAlgo = new JComboBox();
		listeAlgo.addItem("Tri à bulle");
		listeAlgo.addItem("Tri par insertion (fonctionne pas)");
		listeAlgo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				modele.setAlgo(listeAlgo.getSelectedIndex());				
			}
		});
		this.add(listeAlgo);
		//boutonDemarrer.setBounds(5,105,250,30);
		this.add(boutonDemarrer);
		//boutonInitCases.setBounds(5,55,250,30);
		this.add(boutonInitCases);
		//labelVitesse.setBounds(300, 5, 100, 30);
		this.add(labelVitesse);
		//saisieVitesse.setBounds(370,5,50,30);
		this.add(saisieVitesse);
		//boutonVitesse.setBounds(430, 5, 60, 30);
		this.add(boutonVitesse);
		//labelTaille.setBounds(x, y, width, height);
		this.add(labelTaille);
		this.add(saisieTaille);
		this.add(boutonTaille);
		this.add(vueAnimation);
		boutonDemarrer.setEnabled(modele.getExecutionPossible());
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		boutonDemarrer.setEnabled(modele.getExecutionPossible());
		vueAnimation.repaint();		
		Runnable code = new Runnable() {
			public void run() {
				boutonDemarrer.setEnabled(modele.getExecutionPossible());
				vueAnimation.repaint();	
			}
		} ;
		if (SwingUtilities.isEventDispatchThread())
			code.run() ;
		else
			try {
				SwingUtilities.invokeAndWait(code) ;
			} catch (InvocationTargetException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


/**
 * Retourne la VueAnimation de la VueGraphique
 * @return vueAnimation
 */
public VueAnimation getVueAnimation(){
	return this.vueAnimation;
}

public JButton getBoutonInit(){
	return this.boutonInitCases;
}

public JLabel getLabelVitesse(){
	return this.labelVitesse;
}

public JButton getBoutonDemarrer(){
	return this.boutonDemarrer;
}

}
