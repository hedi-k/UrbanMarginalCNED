package View;

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
public class Arene {

    //Propriétés:
    private JFrame frmArene;
    //Largeur de la fenêtre.
    private int windowWidth = 815;
    //Hauteur de la fenêtre.
    private int windowHeight = 805;
    //Zone de saisie du t'chat
    private JTextField txtSaisie;
    //Zone d'affichage du t'chat
    private JTextArea txtChat;

    public Arene() {
        //Caractéristiques Fenêtre principale
        frmArene = new JFrame();
        frmArene.setLayout(null);
        frmArene.setSize(windowWidth, windowHeight);
        frmArene.setLocationRelativeTo(null);
        frmArene.setResizable(false);

        JLabel lblFond = new JLabel("");
        String chemin = "media/fonds/fondarene.jpg";
        URL resource = getClass().getClassLoader().getResource(chemin);
        lblFond.setIcon(new ImageIcon(resource));
        lblFond.setBounds(0, 0, 800, 600);
        frmArene.add(lblFond);

        txtSaisie = new JTextField();
        txtSaisie.setBounds(0, 600, 800, 25);
        frmArene.add(txtSaisie);
        txtSaisie.setColumns(10);

        JScrollPane jspChat = new JScrollPane();
        jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jspChat.setBounds(0, 625, 800, 140);
        frmArene.add(jspChat);

        txtChat = new JTextArea();
        jspChat.setViewportView(txtChat);

        frmArene.setVisible(true);
        System.out.println("Essai vue arene");
    }
}
