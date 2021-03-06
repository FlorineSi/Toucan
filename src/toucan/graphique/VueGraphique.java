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
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import toucan.modele.Modele;

/**
 * Classe mod�lisant la Vue Graphique
 * @author Florine
 *
 */
public class VueGraphique extends JPanel implements Observer{

	private VueAnimation vueAnimation;
	private Modele modele;

	// Appelle la fonction cr�er les mouvements du modele
	private JButton boutonDemarrer;

	// Choix de la vitesse
	private JLabel labelVitesse;
	private JSlider vitesse;

	// Choix du nombre de cases
	private JLabel labelTaille;
	private JTextField saisieTaille;
	private JButton boutonTaille;

	// Choix de l'algo
	private JComboBox<String> listeAlgo;

	// Initialise les cases du tableau
	private JButton boutonInitCases;
	
	//
	private JTextArea zoneSaisie;

	/**
	 * Constructeur de VueAnimation
	 * Initialise les composants graphiques
	 * @param m le modele concern�
	 */
	public VueGraphique(Modele m){
		super();
		this.modele = m;
		modele.setAlgo(0);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		this.vueAnimation = new VueAnimation(m);
		this.labelVitesse = new JLabel("Vitesse : ");
		this.vitesse = new JSlider(0, 10);		
		this.vitesse.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				m.setVitesse(10-vitesse.getValue());
			}

		});

		this.labelTaille =new JLabel("Nb de cases : ");
		this.saisieTaille = new SaisieEntier(10);
		this.saisieTaille.setToolTipText("Le nombre de cases du tableau");
		this.boutonTaille = new JButton("OK");
		this.boutonTaille.addActionListener(new ActionListener() {
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
				//Thread t = new Thread((Runnable) modele, "Toucan") ;
				//t.start() ;
				modele.creerLesMouvements();
			}
		});
		this.boutonInitCases = new JButton("Initialiser les cases");
		this.boutonInitCases.setToolTipText("Cliquez pour initialiser les cases de mani�re al�atoire");
		this.boutonInitCases.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modele.setExecutionPossible(true);
				modele.initCases();
			}
		});
		this.listeAlgo = new JComboBox<String>();
		listeAlgo.addItem("Tri � bulle");
		listeAlgo.addItem("Tri par insertion (fonctionne pas)");
		listeAlgo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				modele.setAlgo(listeAlgo.getSelectedIndex());				
			}
		});
		this.zoneSaisie = new JTextArea(37, 50);
		this.add(listeAlgo);
		this.add(boutonDemarrer);
		this.add(boutonInitCases);
		this.add(vitesse);
		this.add(labelTaille);
		this.add(saisieTaille);
		this.add(boutonTaille);
		this.add(zoneSaisie);
		this.add(vueAnimation);
		boutonDemarrer.setEnabled(modele.getExecutionPossible());
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		boutonDemarrer.setEnabled(modele.getExecutionPossible());
		vueAnimation.repaint();		
		/*Runnable code = new Runnable() {
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
			}*/
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

	public int getVitesse(){
		return vitesse.getValue();
	}

	public JButton getBoutonDemarrer(){
		return this.boutonDemarrer;
	}

}
