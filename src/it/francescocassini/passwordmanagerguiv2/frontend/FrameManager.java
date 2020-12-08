package it.francescocassini.passwordmanagerguiv2.frontend;

import java.awt.EventQueue;

public class FrameManager {
	
	static private LoginFrame loginFrame;
	static private HomeFrame homeFrame;
	
	public FrameManager() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame = new LoginFrame();
					showLoginFrame();
					homeFrame = new HomeFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void updateTableData() {
		homeFrame.insertTableData();
	}
	
	public void hideLoginFrame() {
		loginFrame.hideLoginFrame();
	}
	
	public void hideHomeFrame() {
		homeFrame.hideHomeFrame();
	}
	
	public void showLoginFrame() {
		loginFrame.showLoginFrame();
	}
	
	public void showHomeFrame() {
		homeFrame.showHomeFrame();
	}
	
	public void loginSuccessful() {
		hideLoginFrame();
		showHomeFrame();
	}
	

}