package it.francescocassini.passwordmanagerguiv2.backend;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import it.francescocassini.passwordmanagerguiv2.frontend.FrameManager;

public class ProgramManager {

	static DBManager db;
	LocalDatabase ldb;
	static Login l;
	static FrameManager fm;

	public ProgramManager() {

		dbOpenConnection();
		dbLocalCreation();
		dbRead();
	
		fm = new FrameManager();
		l = new Login();

		//ldb.printLocalDatabase();
		
		
//		try {
//			TimeUnit.SECONDS.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		
//		ldb.addEntry(new Entry(ldb.getNextId(), "Moro", "4567", "www.moro.com", "Sito di paolo", "Network"));
////		
//		fm.updateTableData();
//		
//		//ldb.deleteEntry(new Entry(7, "Moro", "4567", "www.moro.com", "Sito di paolo", "Network"));
//		
//		//dbWrite();
//		
//		dbCloseConnection();

	}

	private void dbOpenConnection() {
		db = new DBManager();
	}
	
	private void dbCloseConnection() {
		try {
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dbRead() {
		try {
			ldb.updateLocalDatabase(db.dbRead());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("#ERROR: CAN'T READ TABLE");
		}
		
	}
	
	private static void dbClear() {
		try {
			db.dbClear();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("#ERROR: CAN'T TRUNCATE TABLE");
		}
	}
	
	public static void dbWrite() {
		dbClear();
		try {
			db.dbWrite();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("#ERROR: CAN'T WRITE IN TABLE");
		}
	}
	
	private void dbLocalCreation() {
		ldb = new LocalDatabase();
	}
	
	public static void login(String username, String password) {
		if (l.auth(username, password) != false) {
			System.out.println("#LOG: Login Successful");
			fm.loginSuccessful();
		}
			
	}
	

}
