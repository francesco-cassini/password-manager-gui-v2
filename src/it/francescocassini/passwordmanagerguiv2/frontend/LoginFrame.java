package it.francescocassini.passwordmanagerguiv2.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import it.francescocassini.passwordmanagerguiv2.backend.ProgramManager;


public class LoginFrame extends JFrame {

	private JFrame frame;
	private JTextField UserTextField;
	private JTextField PasswordTextField;
	private JLabel Title;
	
	protected JFrame getFrame() {
		return frame;
	}

	
	protected LoginFrame() {
		initialize();
		//login = new Login();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		UserTextField = new JTextField();
		UserTextField.setBounds(139, 40, 86, 20);
		frame.getContentPane().add(UserTextField);
		UserTextField.setColumns(10);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setBounds(139, 71, 86, 20);
		frame.getContentPane().add(PasswordTextField);
		PasswordTextField.setColumns(10);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProgramManager.login(UserTextField.getText(), PasswordTextField.getText());
				
			}
		});
		
		Login.setBounds(92, 112, 89, 23);
		frame.getContentPane().add(Login);
		
		JLabel UserLabel = new JLabel("User");
		UserLabel.setBounds(67, 43, 46, 14);
		frame.getContentPane().add(UserLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(67, 74, 46, 14);
		frame.getContentPane().add(PasswordLabel);
		
		Title = new JLabel("Password Manager - GUI");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(10, 11, 264, 18);
		frame.getContentPane().add(Title);

	}
	
	
	protected void showLoginFrame() {
		frame.setVisible(true);
	}
	
	protected void hideLoginFrame() {
		frame.setVisible(false);
	}
	
}
