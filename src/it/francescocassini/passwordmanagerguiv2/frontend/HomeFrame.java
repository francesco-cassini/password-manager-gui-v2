package it.francescocassini.passwordmanagerguiv2.frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import it.francescocassini.passwordmanagerguiv2.backend.Entry;
import it.francescocassini.passwordmanagerguiv2.backend.LocalDatabase;
import it.francescocassini.passwordmanagerguiv2.backend.ProgramManager;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Scrollbar;
import java.awt.Toolkit;

public class HomeFrame extends JFrame {
	private JFrame frame;
	JMenuBar menuBar;
	private JTable table;
	
	protected HomeFrame() {
		initialize();

	}
	
	private void initialize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(new BorderLayout(0, 0));
		table();
		footerLable();
		menuBar();
		
		try {
			saveButton();
			addButton();
			removeButton();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	private void saveButton() throws IOException {
		
		BufferedImage saveButtonIcon = ImageIO.read(new File("C:\\Users\\Francesco\\Desktop\\Git\\password-manager-gui-v2\\img\\save_16px.png"));
		JButton saveButton = new JButton(new ImageIcon(saveButtonIcon));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProgramManager.dbWrite();
				
			}
		});
		saveButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		saveButton.setContentAreaFilled(false);
		menuBar.add(saveButton);
		
	}
	
	private void addButton() throws IOException {
		
		BufferedImage addButtonIcon = ImageIO.read(new File("C:\\Users\\Francesco\\Desktop\\Git\\password-manager-gui-v2\\img\\add.png"));
		JButton addButton = new JButton(new ImageIcon(addButtonIcon));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProgramManager.addEntryUI();
				
			}
		});
		addButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		addButton.setContentAreaFilled(false);
		menuBar.add(addButton);
		
	}
	
	private void removeButton() throws IOException {
		
		BufferedImage removeButtonIcon = ImageIO.read(new File("C:\\Users\\Francesco\\Desktop\\Git\\password-manager-gui-v2\\img\\remove.png"));
		JButton removeButton = new JButton(new ImageIcon(removeButtonIcon));
		removeButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		removeButton.setContentAreaFilled(false);
		menuBar.add(removeButton);
		
	}
	
	private void menuBar() {
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 128, 128));
		setJMenuBar(menuBar);
	}
	
	private void table() {

			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			//table.setPreferredScrollableViewportSize(new Dimension(750,800));
			table.setMinimumSize(new Dimension(500,800));
	        table.setFillsViewportHeight(true);

	        JScrollPane js=new JScrollPane(table);
	        js.setVisible(true);
	        
			getContentPane().add(js, BorderLayout.CENTER);
		
	}
	
	protected void insertTableData() {
		
		Object[][] o = new Object[LocalDatabase.entryList.size()][6];
		int i = 0;
		
		for (Entry e : LocalDatabase.entryList) {
			
			o[i][0] = e.getId();
			o[i][1] = e.getUsername();
			o[i][2] = e.getPassword();
			o[i][3] = e.getUrl();
			o[i][4] = e.getDescription();
			o[i][5] = e.getLabel();
			
			i++;
			
		}

		table.setModel(new DefaultTableModel(
				o,
			new String[] {
				"ID", "Username", "Password", "URL", "Description", "Label"
			}
		));
		
	}
	
	private void footerLable() {
			JLabel lblNewLabel = new JLabel("Password Manager GUI v2 - Francesco Cassini - www.francescocassini.it");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
	}
	
	protected void showHomeFrame() {
		insertTableData();
		this.setVisible(true);
	}
	
	protected void hideHomeFrame() {
		this.setVisible(false);
	}

}
