package Model;

/**
 * Informations et methodes communes aux jeux client et serveur
 *
 */
public abstract class Jeu {

	/**
	 * Reception d'une connexion (pour communiquer avec un ordinateur distant)
	 */
	public abstract void connexion() ;
	
	/**
	 * Reception d'une information provenant de l'ordinateur distant
	 */
	public abstract void reception() ;
	
	/**
	 * Deconnexion de l'ordinateur distant
	 */
	public abstract void deconnexion() ;
	
	/**
	 * Envoi d'une information vers un ordinateur distant
	 */
	public void envoi() {
	}
	
}
