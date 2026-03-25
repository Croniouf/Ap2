package view;

import java.awt.EventQueue;

import javax.swing.JFrame;


import controller.mainMVC;
import model.LIVRE;
import java.awt.List;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class View_Catalogue {

	private JFrame frame;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Catalogue() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		List list = new List();
		list.setBounds(52, 62, 614, 356);
		frame.getContentPane().add(list);
		mainMVC.getM().showBookList(list);
		
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
		btnNewButton.setBounds(10, 11, 196, 45);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CATALOGUE :");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblNewLabel.setBounds(262, 24, 208, 21);
		frame.getContentPane().add(lblNewLabel);
		}
	}

