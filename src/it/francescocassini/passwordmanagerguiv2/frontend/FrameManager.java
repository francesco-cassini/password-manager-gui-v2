package it.francescocassini.passwordmanagerguiv2.frontend;

import java.awt.EventQueue;

public class FrameManager {
	
	static private LoginFrame loginFrame;
	static private HomeFrame homeFrame;
	static private EntryFrame entryFrame;
	
	public FrameManager() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					istantiateFrame();
					showLoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private void istantiateFrame() {
		loginFrame = new LoginFrame();
		homeFrame = new HomeFrame();
		entryFrame = new EntryFrame();
	}
	
	public void updateTableData() {
		homeFrame.insertTableData();
	}
	
	public void hideLoginFrame() {
		loginFrame.hideLoginFrame();
	}
	
	public void showLoginFrame() {
		loginFrame.showLoginFrame();
	}
	
	public void hideHomeFrame() {
		homeFrame.hideHomeFrame();
	}
	
	public void showHomeFrame() {
		homeFrame.showHomeFrame();
	}
	
	public void hideEntryFrame() {
		entryFrame.hideEntryFrame();
	}
	
	public void showEntryFrame() {
		entryFrame.showEntryFrame();
	}
	
	public void loginSuccessful() {
		hideLoginFrame();
		showHomeFrame();
	}
	
	public void addEntryUI() {
		hideHomeFrame();
		showEntryFrame();
	}
	
	public void addEntry() {
		hideEntryFrame();
		showHomeFrame();
	}
	

}