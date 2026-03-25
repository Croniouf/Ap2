package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import controller.mainMVC;
import model.ADHERENT;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.List;
import java.awt.Font;

public class View_Profil {

	private JFrame frame;
	private JTextField textField_numclient;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_email;
	private String num;

	

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Profil() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 923, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_numclient = new JLabel("N° Client : ");
		lblNewLabel_numclient.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lblNewLabel_numclient.setBounds(255, 24, 116, 26);
		frame.getContentPane().add(lblNewLabel_numclient);
		
		textField_numclient = new JTextField();
		textField_numclient.setBounds(381, 24, 208, 32);
		frame.getContentPane().add(textField_numclient);
		textField_numclient.setColumns(10);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 89, 887, 325);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		textField_nom = new JTextField();
		textField_nom.setColumns(10);
		textField_nom.setBounds(98, 99, 134, 20);
		panel.add(textField_nom);
		
		textField_prenom = new JTextField();
		textField_prenom.setColumns(10);
		textField_prenom.setBounds(98, 138, 134, 20);
		panel.add(textField_prenom);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(98, 180, 134, 20);
		panel.add(textField_email);
		
		JLabel lblNewLabel_nom = new JLabel("Nom :");
		lblNewLabel_nom.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel_nom.setBounds(31, 100, 57, 14);
		panel.add(lblNewLabel_nom);
	
		
		JLabel lblNewLabel_prenom = new JLabel("Prenom :");
		lblNewLabel_prenom.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel_prenom.setBounds(10, 139, 82, 14);
		panel.add(lblNewLabel_prenom);
		
		JLabel lblNewLabel_email = new JLabel("Email :");
		lblNewLabel_email.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel_email.setBounds(31, 181, 53, 14);
		panel.add(lblNewLabel_email);
		
		JButton btnNewButton_maj = new JButton("Maj");
		btnNewButton_maj.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnNewButton_maj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String email = textField_email.getText();
				String nom = textField_nom.getText();
				String prenom = textField_prenom.getText();
			    try {
					boolean verif=mainMVC.getM().modifprofil(nom, prenom, email, num);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_maj.setBounds(120, 211, 89, 23);
		panel.add(btnNewButton_maj);
		
		List list_ISBN = new List();
		list_ISBN.setBounds(302, 29, 522, 260);
		panel.add(list_ISBN);
		
		
		JButton btnNewButton_numclient = new JButton("OK");
		btnNewButton_numclient.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnNewButton_numclient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        num = textField_numclient.getText();
		        ADHERENT ad = mainMVC.getM().findAdherent(num);
		        if (ad==null) {
		        	panel.setVisible(false); 
		            System.out.println("Aucun adherent trouvé !");
		        } else {
		            panel.setVisible(true);
		            textField_nom.setText(ad.getNom());
		            textField_prenom.setText(ad.getPrenom());
		            textField_email.setText(ad.getEmail());
		        }
		        mainMVC.getM().showBookListPerso(list_ISBN, num);
		    }
		});

		btnNewButton_numclient.setBounds(449, 66, 89, 23);
		frame.getContentPane().add(btnNewButton_numclient);
		
		JButton btnNewButton = new JButton("Accueil");
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					View_Accueil window = new View_Accueil();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(24, 9, 182, 55);
		frame.getContentPane().add(btnNewButton);
	}	
}

