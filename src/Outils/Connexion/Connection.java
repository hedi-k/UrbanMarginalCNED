package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Gestion de la connexion entre 2 ordinateurs distants
 * @author emds
 *
 */
public class Connection extends Thread {
	
	/**
	 * canal d'entrée
	 */
	private ObjectInputStream in ;
	/**
	 * canal de sortie
	 */
	private ObjectOutputStream out ; 
	/**
	 * objet de lien avec une autre classe qui implémente AsyncResponse pour transferer les reponses
	 */
	private AsyncResponse delegate;

	/**
	 * Constructeur : cree une connexion a partir d'un socket (contenant les spécificites de l'ordinateur distant)
	 * @param socket objet de connexion de type serveur ou client
	 * @param delegate instance de la classe vers laquelle il faut transferer les réponses
	 */
	public Connection(Socket socket, AsyncResponse delegate) {
		this.delegate = delegate;
		// cr�ation du canal de sortie pour envoyer des informations
		try {
			this.out = new ObjectOutputStream(socket.getOutputStream()) ;
		} catch (IOException e) {
			System.out.println("erreur creation canal out : "+e);
			System.exit(0);
		}
		// création du canal d'entree pour recevoir des informations
		try {
			this.in = new ObjectInputStream(socket.getInputStream()) ;
		} catch (IOException e) {
			System.out.println("erreur creation canal in : "+e);
			System.exit(0);
		}
		// démarrage du thread d'écoute (attente d'un message de l'ordi distant)
		this.start() ;
		// envoi de l'instance de connexion vers la classe qui implémente AsyncResponse pour récupèrer la réponse
		this.delegate.reception(this, "connexion", null);
	}
	
	/**
	 * Envoi d'un objet vers l'ordinateur distant, sur le canal de sortie
	 * @param unObjet contieny l'objet à envoyer
	 */
	public synchronized void envoi(Object unObjet) {
		// l'envoi ne peut se faire que si un objet delegate existe (pour récupèrer la réponse)
		if(delegate != null) {
			try {
				this.out.reset();
				out.writeObject(unObjet);
				out.flush();
			} catch (IOException e) {
				System.out.println("erreur d'envoi sur le canal out : "+e);
			}
		}
	}
	
	/**
	 * Méthode thread qui permet d'attendre des messages provenant de l'ordi distant
	 */
	public void run() {
		// permet de savoir s'il faut continuer � �couter
		boolean inOk = true ;
		// objet qui va recuperer l'information recue
		Object reception ;
		// boucle tant qu'il faut ecouter
		while (inOk) {
			try {
				// reception d'un objet sur le canal d'entree
				reception = in.readObject();
				// envoi de l'information revue vers la classe qui implemente AsyncResponse pour recuperer la reponse
				delegate.reception(this, "reception", reception);
			} catch (ClassNotFoundException e) {
				// probleme grave qui ne devrait pas se produire : arret du programme
				System.out.println("erreur de classe sur reception : "+e);
				System.exit(0);
			} catch (IOException e) {
				// envoi de l'information de deconnexion  vers la classe qui implemente AsyncResponse pour recuperer la reponse
				delegate.reception(this, "deconnexion", null);
				// demande d'arreter de boucler sur l'attente d'une reponse
				inOk = false ;
				// l'ordinateur distant n'est plus accessible
				System.out.println("l'ordinateur distant est deconnecte");
				// fermeture du canal d'entrée
				try {
					in.close();
				} catch (IOException e1) {
					System.out.println("la fermeture du canal d'entree a echoue : "+e);
				}
			}
		}
		
	}
	
}
