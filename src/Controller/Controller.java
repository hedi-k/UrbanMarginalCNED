package Controller;
import View.*;

/**
 * Point d'entré du programme.
 * @author hedi
 */
public class Controller {
    ChoixJoueur essai;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Appel du controleur.");    
        Controller controller = new Controller();
        controller.choix();
    }
    
    public void choix(){
    essai = new ChoixJoueur();
    }
    
}




