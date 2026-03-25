package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import controller.mainMVC;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

public class View_Accueil {

	private JFrame frame;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Accueil() throws SQLException {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100,756,549);
		frame.getContentPane().setLayout(null);

		JButton btnCatalogueDesLivres = new JButton("Profil");
		btnCatalogueDesLivres.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnCatalogueDesLivres.setBounds(10, 335, 235, 46);
		btnCatalogueDesLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					View_Profil windowsXp = new View_Profil();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnCatalogueDesLivres);

		JButton btnCatalogue = new JButton("Catalogue");
		btnCatalogue.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnCatalogue.setBounds(255, 399, 235, 46);
		btnCatalogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					View_Catalogue window12 = new View_Catalogue();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnCatalogue);

		JButton btnCatalogue_1 = new JButton("Retourner Livre");
		btnCatalogue_1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnCatalogue_1.setBounds(495, 335, 235, 46);
		btnCatalogue_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					View_Retourner window11 = new View_Retourner();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnCatalogue_1);

		JButton btnCatalogueDesLivres_1 = new JButton("Emprunter");
		btnCatalogueDesLivres_1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnCatalogueDesLivres_1.setBounds(255, 335, 235, 46);
		btnCatalogueDesLivres_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					View_Emprunter window11 = new View_Emprunter();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnCatalogueDesLivres_1);

		JLabel lblNewLabel = new JLabel("BIBLIOTHEQUE :");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblNewLabel.setBounds(255, 11, 261, 42);
		frame.getContentPane().add(lblNewLabel);

		// IMAGE AGRANDIE
		ImageIcon icon4 = new ImageIcon("C:\\Users\\GB\\Downloads\\biblio.png");
		Image img4 = icon4.getImage().getScaledInstance(350, 250, Image.SCALE_SMOOTH);

		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon(img4));
		lblImage.setBounds(201, 55, 350, 250);

		frame.getContentPane().add(lblImage);
	}
}