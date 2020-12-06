package it.francescocassini.passwordmanagerguiv2.backend;

import java.sql.SQLException;
import java.util.List;
import it.francescocassini.passwordmanagerguiv2.frontend.FrameManager;

public class ProgramManager {

	DBManager db;
	LocalDatabase ldb;

	public ProgramManager() {
		
		FrameManager fm = new FrameManager();

		dbOpenConnection();
		dbLocalCreation();
		
		dbRead();

		ldb.printLocalDatabase();
		
		//ldb.addEntry(new Entry(ldb.getNextId(), "Moro", "4567", "www.moro.com", "Sito di paolo", "Network"));
		
		//ldb.deleteEntry(new Entry(7, "Moro", "4567", "www.moro.com", "Sito di paolo", "Network"));
		
		//dbWrite();
		
		dbCloseConnection();

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
	
	private void dbClear() {
		try {
			db.dbClear();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("#ERROR: CAN'T TRUNCATE TABLE");
		}
	}
	
	private void dbWrite() {
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

}
