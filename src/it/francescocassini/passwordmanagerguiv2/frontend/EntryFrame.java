package it.francescocassini.passwordmanagerguiv2.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.francescocassini.passwordmanagerguiv2.backend.ProgramManager;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntryFrame extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField userTextField;
	private JTextField passwordTextField;
	private JTextField urlTextField;
	private JTextField descriptionTextField;
	private JTextField labelTextField;
	private JLabel passwordLabel;
	private JLabel descriptionLabel;
	private JLabel urlLabel;
	private JLabel labelLabel;
	
	
	protected JFrame getFrame() {
		return frame;
	}

	
	protected EntryFrame() {
		initialize();
		//login = new Login();
	}


	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ProgramManager.addEntry(userTextField.getText(), passwordTextField.getText(), urlTextField.getText(), descriptionTextField.getText(), labelTextField.getText());
			}
		});
		saveButton.setBounds(111, 235, 89, 23);
		contentPane.add(saveButton);
		
		JButton cancelButton_1 = new JButton("Cancel");
		cancelButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CANCEL EVENT
				
			}
		});
		cancelButton_1.setBounds(227, 235, 89, 23);
		contentPane.add(cancelButton_1);
		
		userTextField = new JTextField();
		userTextField.setColumns(10);
		userTextField.setBounds(229, 47, 86, 20);
		contentPane.add(userTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(229, 79, 86, 20);
		contentPane.add(passwordTextField);
		
		urlTextField = new JTextField();
		urlTextField.setColumns(10);
		urlTextField.setBounds(229, 110, 86, 20);
		contentPane.add(urlTextField);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setColumns(10);
		descriptionTextField.setBounds(229, 141, 86, 20);
		contentPane.add(descriptionTextField);
		
		labelTextField = new JTextField();
		labelTextField.setColumns(10);
		labelTextField.setBounds(229, 172, 86, 20);
		contentPane.add(labelTextField);
		
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(128, 50, 46, 14);
		contentPane.add(userLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(128, 82, 46, 14);
		contentPane.add(passwordLabel);
		
		descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(128, 144, 71, 14);
		contentPane.add(descriptionLabel);
		
		urlLabel = new JLabel("URL");
		urlLabel.setBounds(128, 113, 46, 14);
		contentPane.add(urlLabel);
		
		labelLabel = new JLabel("Label");
		labelLabel.setHorizontalAlignment(SwingConstants.LEFT);
		labelLabel.setBounds(128, 175, 46, 14);
		contentPane.add(labelLabel);
	}
	
	protected void showEntryFrame() {
		this.setVisible(true);
	}
	
	protected void hideEntryFrame() {
		this.setVisible(false);
	}
	
}
