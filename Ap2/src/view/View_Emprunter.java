package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.mainMVC;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.List;
import java.awt.Font;

public class View_Emprunter {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Emprunter() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1065, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(361, 59, 256, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Emprunter un Livre :");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblNewLabel.setBounds(321, 12, 380, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Accueil");
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					View_Accueil window11 = new View_Accueil();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(840, 11, 199, 47);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(361, 106, 256, 36);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Numero d'Adherent :");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(182, 62, 168, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN :");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(285, 115, 66, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		List list = new List();
		list.setBounds(244, 193, 485, 226);
		frame.getContentPane().add(list);
		mainMVC.getM().showBookListAvailable(list); 
		
		JButton btnNewButton_1 = new JButton("EMPRUNTER");
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adherent = textField.getText();
				String ISBN = textField_1.getText();
				try {
					mainMVC.getM().Emprunter(ISBN, adherent);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list.clear();
				try {
					mainMVC.getM().getAll();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mainMVC.getM().showBookListAvailable(list);
			}
		});
		btnNewButton_1.setBounds(421, 153, 133, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
