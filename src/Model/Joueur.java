package Model;

/**
 * Gestion des joueurs
 *
 */
public class Joueur extends Objet {

	/**
	 * vie de depart pour tous les joueurs
	 */
	private static final int MAXVIE = 10 ;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	private static final int GAIN = 1 ; 
	/**
	 * perte de points de vie lors d'une attaque
	 */
	private static final int PERTE = 2 ; 
	
	/**
	 * pseudo saisi
	 */
	private String pseudo ;
	/**
	 * numero correspondant au personnage (avatar) pour le fichier correspondant
	 */
	private int numPerso ; 
	/**
	 * instance de JeuServeur pour communiquer avec lui
	 */
	private JeuServeur jeuServeur ;
	/**
	 * numero d'etape dans l'animation (de la marche, touche ou mort)
	 */
	private int etape ;
	/**
	 * la boule du joueur
	 */
	private Boule boule ;
	/**
	 * vie restante du joueur
	 */
	private int vie ; 
	/**
	 * tourne vers la gauche (0) ou vers la droite (1)
	 */
	private int orientation ;
	
	/**
	 * Constructeur
	 */
	public Joueur() {
	}

	/**
	 * Initialisation d'un joueur (pseudo et numero, calcul de la 1_re position, affichage, creation de la boule)
	 */
	public void initPerso() {
	}

	/**
	 * Calcul de la premiere position aleatoire du joueur (sans chevaucher un autre joueur ou un mur)
	 */
	private void premierePosition() {
	}
	
	/**
	 * Affiche le personnage et son message
	 */
	public void affiche() {
	}

	/**
	 * Gere une action re_ue et qu'il faut afficher (deplacement, tire de boule...)
	 */
	public void action() {
	}

	/**
	 * Gere le deplacement du personnage
	 */
	private void deplace() { 
	}

	/**
	 * Controle si le joueur touche un des autres joueurs
	 * @return true si deux joueurs se touchent
	 */
	private Boolean toucheJoueur() {
		return null;
	}

	/**
	* Controle si le joueur touche un des murs
	 * @return true si un joueur touche un mur
	 */
	private Boolean toucheMur() {
		return null;
	}
	
	/**
	 * Gain de points de vie apres avoir touche un joueur
	 */
	public void gainVie() {
	}
	
	/**
	 * Perte de points de vie apres avoir ete touche 
	 */
	public void perteVie() {
	}
	
	/**
	 * vrai si la vie est a 0
	 * @return true si vie = 0
	 */
	public Boolean estMort() {
		return null;
	}
	
	/**
	 * Le joueur se deconnecte et disparait
	 */
	public void departJoueur() {
	}
	
}
