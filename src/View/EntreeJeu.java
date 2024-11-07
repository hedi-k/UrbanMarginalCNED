package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Fenêtre de démarrage du jeu.
 *
 * @author hedi
 */
public class EntreeJeu extends JPanel {

    //Propriétés:
    private JFrame frmEntreeJeu;
    //Largeur de la fenêtre.
    private int windowWith = 400;
    //Hauteur de la fenêtre.
    private int windowHeight = 200;
    //Zone de saisie de l'@ ip.
    private JTextField txtIp;

    //Constructeur
    public EntreeJeu() {
        //Caractéristiques Fenêtre principale
        frmEntreeJeu = new JFrame("Urban Marginal");
        // IMPORTANT Ajout d'un gestionnaire de mise en page IMPORTANT
        frmEntreeJeu.setLayout(null);
        //Dimensionne la fenêtre.
        frmEntreeJeu.setSize(windowWith, windowHeight);
        //Position de la fenêtre au centre de l'écran.
        frmEntreeJeu.setLocationRelativeTo(null);
        //Empêche de modifier la taille de la fenêtre.
        frmEntreeJeu.setResizable(false);

        //Caractéristiques Labels
        JLabel lblStartAServer = new JLabel("Start a server :");
        lblStartAServer.setBounds(10, 11, 94, 14);
        frmEntreeJeu.add(lblStartAServer);
        JLabel lblConnectAnExisting = new JLabel("Connect an existing server :");
        lblConnectAnExisting.setBounds(10, 36, 197, 14);
        frmEntreeJeu.add(lblConnectAnExisting);
        JLabel lblIpServer = new JLabel("IP server :");
        lblIpServer.setBounds(10, 61, 68, 14);
        frmEntreeJeu.add(lblIpServer);

        //Caractéristiques Boutons
        JButton btnStart = new JButton("Start");
        btnStart.addMouseListener(new MouseAdapter() {
            /*
            @Override
            public void mouseClicked(MouseEvent arg0) {
                btnStart_clic();
            }
             */
        });
        btnStart.setBounds(186, 7, 89, 23);
        frmEntreeJeu.add(btnStart);
        JButton btnExit = new JButton("Exit");
        btnExit.addMouseListener(new MouseAdapter() {
            /*
            @Override
            public void mouseClicked(MouseEvent e) {
                btnExit_clic();
            }
             */
        });
        btnExit.setBounds(186, 91, 89, 23);
        frmEntreeJeu.add(btnExit);
        JButton btnConnect = new JButton("Connect");
        btnConnect.addMouseListener(new MouseAdapter() {
            /*
            @Override
            public void mouseClicked(MouseEvent e) {
                btnConnect_clic();
            }
             */
        });
        btnConnect.setBounds(186, 57, 89, 23);
        frmEntreeJeu.add(btnConnect);

        //Caractéristiques txtBox
        txtIp = new JTextField();
        txtIp.setText("127.0.0.1");
        txtIp.setBounds(69, 58, 107, 20);
        frmEntreeJeu.add(txtIp);
        txtIp.setColumns(10);

        frmEntreeJeu.setVisible(true);
        System.out.println("Appel de la vue");
    }
}