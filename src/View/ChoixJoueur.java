/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Fenêtre du choix du personnage
 *
 * @author hedi
 */
public class ChoixJoueur extends JPanel {

    //Propriétés
    private JFrame frmChoixJoueur;
    //Largeur de la fenêtre.
    private int windowWidth = 400;
    //Hauteur de la fenêtre.
    private int windowHeight = 315;
    private JTextField txtPseudo;

    private void lblSuivant_clic() {
        System.out.println("Clic sur suivant");
    }

    private void lblPrecedent_clic() {
        System.out.println("Clic sur precedent");
    }

    private void lblGo_clic() {
        System.out.println("Clic sur go");
    }

    public ChoixJoueur() {
        frmChoixJoueur = new JFrame("Choix personnage");
        frmChoixJoueur.setLayout(null);
        frmChoixJoueur.setSize(windowWidth, windowHeight);
        frmChoixJoueur.setLocationRelativeTo(null);
        frmChoixJoueur.setResizable(false);

        JLabel lblFond = new JLabel("");
        String chemin = "media/fonds/fondchoix.jpg";
        URL resource = getClass().getClassLoader().getResource(chemin);
        lblFond.setIcon(new ImageIcon(resource));
        lblFond.setBounds(0, 0, 400, 275);
        frmChoixJoueur.add(lblFond);

        txtPseudo = new JTextField();
        txtPseudo.setBounds(142, 245, 120, 20);
        frmChoixJoueur.add(txtPseudo);
        txtPseudo.setColumns(10);

        JLabel lblPrecedent = new JLabel("");
        lblPrecedent.setBounds(65, 146, 31, 45);
        frmChoixJoueur.add(lblPrecedent);
        lblPrecedent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                lblPrecedent_clic();
            }
        });

        JLabel lblSuivant = new JLabel("");
        lblSuivant.setBounds(301, 145, 25, 46);
        frmChoixJoueur.add(lblSuivant);
        lblSuivant.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblSuivant_clic();
            }
        });

        JLabel lblGo = new JLabel("");
        lblGo.setBounds(311, 202, 65, 61);
        frmChoixJoueur.add(lblGo);
        lblGo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblGo_clic();
            }
        });

        frmChoixJoueur.setVisible(true);
    }
}
