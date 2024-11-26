package Controller;

import View.*;
import outils.connexion.AsyncResponse;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;

/**
 * Point d'entré du programme.
 *
 * @author hedi
 */
public class Controller implements AsyncResponse {

    //proriétés
    private EntreeJeu frmEntreeJeu;
    private Arene frmArene;
    private ChoixJoueur frmChoixJoueur;
    private String typeJeu;
    private static final int PORT = 6666;
    

    /**
     * Point d'entré du programme
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Appel du controleur.");
        new Controller();
    }

    /**
     * Constructeur.
     */
    private Controller() {
        this.frmEntreeJeu = new EntreeJeu(this);
    }

    /**
     * Méthode qui est appelée après selection des btn Start ou Connect ans la frmEntreeJeu 
     * @param info serveur ou l'IP on en fonction de si on heberge ou se connecte. 
     */
    public void evenementEntreeJeu(String info) {
        switch (info) {
            case "serveur":
                typeJeu = "serveur";
                new ServeurSocket(this, PORT);
                this.frmEntreeJeu.dispose();
                this.frmArene = new Arene(this);
                this.frmArene.setVisible(true);
                break;
            default:
                typeJeu = "client";
                new ClientSocket(this, info, PORT);
                //this.frmArene = new Arene(this);
                break;
        }

    }

    
    /**
     * Méthode necessaire pour implements AsyncResponse
     * C'est le retour de la classe Connection
     * @param connection
     * @param ordre connexion, reception ou deconnexion en fonction de la situation
     * @param info 
     */
    @Override
    public void reception(Connection connection, String ordre, Object info) {
        switch (ordre) {
            case "connexion":
                if (typeJeu == "client"){
                    this.frmEntreeJeu.dispose();
                    this.frmChoixJoueur = new ChoixJoueur(this);
                    this.frmArene = new Arene(this);
                }
                break;
            case "reception":
                break;
            case "deconnexion":
                break;
        }
    }

}
