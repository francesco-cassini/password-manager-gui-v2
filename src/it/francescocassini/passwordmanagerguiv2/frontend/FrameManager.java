package it.francescocassini.passwordmanagerguiv2.frontend;

import java.awt.EventQueue;

public class FrameManager {
	
	public FrameManager() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					LoginFrame loginFrame = new LoginFrame();
//					loginFrame.showLoginFrame();
//					HomeFrame homeFrame = new HomeFrame();
//					homeFrame.showLoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}

//
//public static void main(String[] args) {
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				HomeFrame frame = new HomeFrame();
//				frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	});
//}