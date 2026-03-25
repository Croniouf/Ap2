package view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class View_Retourner {

	private JFrame frame;
	private JTextField textFieldISBN;


	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Retourner() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 986, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entrer l'ISBN du livre que vous voulez retourner :");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel.setBounds(290, 188, 383, 23);
		frame.getContentPane().add(lblNewLabel);
		textFieldISBN = new JTextField();
		textFieldISBN.setBounds(319, 222, 307, 56);
		frame.getContentPane().add(textFieldISBN);
		textFieldISBN.setColumns(10);
		JButton btnNewButton = new JButton("Comfirmer");
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN = textFieldISBN.getText();
				
				try {
					mainMVC.getM().retouner(ISBN);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(411, 305, 128, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Accueil");
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setBounds(10, 11, 210, 56);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("RETOUR LIVRES :");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(332, 27, 294, 56);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	}
}
