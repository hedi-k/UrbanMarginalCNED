package Controller;

import View.*;
import outils.connexion.AsyncResponse;
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

    public void evenementEntreeJeu(String info) {
        switch (info) {
            case "serveur":
                new ServeurSocket(this, 6666);
                this.frmEntreeJeu.dispose();
                this.frmArene = new Arene(this);
                break;
            case "IP":
                //this.frmArene = new Arene(this);
                break;
        }

    }

    //Méthode necessaire pour implements AsyncResponse
    @Override
    public void reception(Connection connection, String ordre, Object info) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
