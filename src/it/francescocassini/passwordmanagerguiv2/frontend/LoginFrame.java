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


public class LoginFrame extends JFrame {

	private JFrame frame;
	private JTextField UserTextField;
	private JTextField PasswordTextField;
	private JLabel Title;
	
	public JFrame getFrame() {
		return frame;
	}

	
	public LoginFrame() {
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
//		Login.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				if (login.auth(UserTextField.getText(), PasswordTextField.getText()) != false) {
//					
//					System.out.println("LOG SUCCESSFULL");
//					FrameManager.loginWindowHide();
//					FrameManager.mainFrameWindowShow();
//
//					
//				}
//				
//			}
//		});
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
	
	
	public void showLoginFrame() {
		frame.setVisible(true);
	}
	
	public void hideLoginFrame() {
		frame.setVisible(false);
	}
	
}
