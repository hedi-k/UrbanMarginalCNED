package View;

import Controller.Controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Fenêtre de démarrage du jeu.
 *
 * @author hedi
 */

/*
    En Java, JPanel et JFrame sont deux composants de l'interface graphique (GUI) fournis par la bibliothèque Swing
    JFrame est une fenêtre principale qui peut contenir d'autres composants Swing. C'est le conteneur de niveau supérieu
    JPanel est un conteneur léger qui peut contenir d'autres composants Swing. Il est souvent utilisé pour organiser des composants à l'intérieur d'un JFrame
*/
public class EntreeJeu extends JFrame {

    //Propriétés:
    //Largeur de la fenêtre.
    private int windowWidth = 400;
    //Hauteur de la fenêtre.
    private int windowHeight = 200;
    //Zone de saisie de l'@ ip.
    private JTextField txtIp;
    private Controller controller;

    //Constructeur
    public EntreeJeu(Controller controller) {
        //Caractéristiques Fenêtre principale
        // IMPORTANT Ajout d'un gestionnaire de mise en page IMPORTANT
        setLayout(null);
        //Dimensionne la fenêtre.
        setSize(windowWidth, windowHeight);
        //Position de la fenêtre au centre de l'écran.
        setLocationRelativeTo(null);
        //Empêche de modifier la taille de la fenêtre.
        setResizable(false);

        //Caractéristiques Labels
        JLabel lblStartAServer = new JLabel("Start a server :");
        lblStartAServer.setBounds(10, 11, 94, 14);
        add(lblStartAServer);
        JLabel lblConnectAnExisting = new JLabel("Connect an existing server :");
        lblConnectAnExisting.setBounds(10, 36, 197, 14);
        add(lblConnectAnExisting);
        JLabel lblIpServer = new JLabel("IP server :");
        lblIpServer.setBounds(10, 61, 68, 14);
        add(lblIpServer);

        //Caractéristiques Boutons
        JButton btnStart = new JButton("Start");
        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                btnStart_clic();
            }
        });
        btnStart.setBounds(186, 7, 89, 23);
        add(btnStart);
        
        JButton btnExit = new JButton("Exit");
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnExit_clic();
            }
        });
        btnExit.setBounds(186, 91, 89, 23);
        add(btnExit);
        
        JButton btnConnect = new JButton("Connect");
        btnConnect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnConnect_clic();
            }
        });
        btnConnect.setBounds(186, 57, 89, 23);
        add(btnConnect);

        //Caractéristiques txtBox
        txtIp = new JTextField();
        txtIp.setText("127.0.0.1");
        txtIp.setBounds(69, 58, 107, 20);
        add(txtIp);
        txtIp.setColumns(10);

        setVisible(true);
        System.out.println("Appel de la vue EntreeJeu");

        this.controller = controller;
    }

    //Action du btn Start
    private void btnStart_clic() {
        this.controller.evenementEntreeJeu("serveur");
    }
    //Action du btn Connect
    private void btnConnect_clic(){
        controller.evenementEntreeJeu("IP");
    }
    //Action du btn Exit
    private void btnExit_clic() {
        System.exit(0);
    }
}
