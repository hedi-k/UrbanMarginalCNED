package Controller;
import View.*;

/**
 * Point d'entré du programme.
 * @author hedi
 */
public class Controller {
    EntreeJeu essai;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Appel du controleur.");    
        Controller controller = new Controller();
        controller.entreeJeu();
    }
    
    public void entreeJeu(){
    essai = new EntreeJeu();
    }
    
}




