package toucan.modele;

/**
 * Classe modélisant un mouvement
 * @author Florine
 *
 */
public class Mouvement {

	/**
	 * La direction du mouvement: 0 -> gauche, 1 -> droite, 2 -> haut, 3 -> bas, -1 : sur place
	 */
	private int direction;

	/**
	 * La valeur de la Case au moment du mouvement
	 */
	private String valeurCase;


	/**
	 * Constructeur de Mouvement
	 * @param d la direction du mouvement, int
	 * @param v la valeur de la case, String
	 */
	public Mouvement(int d, String v){
		this.direction = d;
		this.valeurCase = v;
	}

	/**
	 * Retourne la direction du mouvement
	 * @return la direction du mouvement (int)
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Retourne la valeur de la case après le mouvement
	 * @return la valeur de la case après le mouvement
	 */
	public String getValeurCase() {
		return valeurCase;
	}

	/**
	 * Modélise textuellement un mouvement
	 */
	@Override
	public String toString() {
		return "Mouvement [direction=" + direction + ", valeurCase="
				+ valeurCase + "]";
	}



}
