package it.francescocassini.passwordmanagerguiv2.frontend;

import java.awt.EventQueue;

public class FrameManager {
	
	public FrameManager() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.showLoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
