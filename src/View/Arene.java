package View;

import Controller.Controller;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Fenêtre de l'arène.
 *
 * @author hedi
 */
public class Arene extends JFrame {

    //Propriétés:
    //Largeur de la fenêtre.
    private int windowWidth = 815;
    //Hauteur de la fenêtre.
    private int windowHeight = 805;
    //Zone de saisie du t'chat
    private JTextField txtSaisie;
    //Zone d'affichage du t'chat
    private JTextArea txtChat;
    Controller controller;

    /*Vérifier pour extends JPanel */
    public Arene(Controller controller) {
        System.out.println("Appel de la vue Arene");
        this.controller = controller;
        //Caractéristiques Fenêtre principale
        setLayout(null);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel lblFond = new JLabel("");
        String chemin = "media/fonds/fondarene.jpg";
        URL resource = getClass().getClassLoader().getResource(chemin);
        lblFond.setIcon(new ImageIcon(resource));
        lblFond.setBounds(0, 0, 800, 600);
        add(lblFond);

        txtSaisie = new JTextField();
        txtSaisie.setBounds(0, 600, 800, 25);
        add(txtSaisie);
        txtSaisie.setColumns(10);

        JScrollPane jspChat = new JScrollPane();
        jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jspChat.setBounds(0, 625, 800, 140);
        add(jspChat);

        txtChat = new JTextArea();
        jspChat.setViewportView(txtChat);

    }
}
