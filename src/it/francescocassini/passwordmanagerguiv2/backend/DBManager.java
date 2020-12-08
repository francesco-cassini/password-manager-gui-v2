package it.francescocassini.passwordmanagerguiv2.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBManager {

	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;

	public DBManager() {
		dbConnection();
		
	}

	/*	Metod: dbConnection
	 * 	this method open the database connection
	 */
	public void dbConnection() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection( 
					"jdbc:mysql://localhost:3306/password-manager-gui-v2?serverTimezone=UTC","root","root");
			
			stmt=con.createStatement();  

		}catch(Exception e){ 
			System.out.println(e);}  

	}


	/*	Metod: closeConnection
	 * 	this method close the database connection
	 */
	@SuppressWarnings("unused")
	public void closeConnection() throws SQLException {
		con.close();
		
	}


	/*	Metod: entryTabelCreation
	 * 	this method create the entry table if is not present in the database
	 */
	@SuppressWarnings("unused")
	private void entryTabelCreation() throws SQLException {
		stmt.executeQuery("CREATE TABLE `password-manager-gui-v2`.`entries` (\r\n" + 
				"  `id` INT NOT NULL,\r\n" + 
				"  `username` VARCHAR(45) NOT NULL,\r\n" + 
				"  `password` VARCHAR(45) NOT NULL,\r\n" + 
				"  `url` VARCHAR(45) NULL,\r\n" + 
				"  `description` VARCHAR(45) NULL,\r\n" + 
				"  `label` VARCHAR(45) NULL,\r\n" + 
				"  PRIMARY KEY (`id`));");

	}


	/*	Metod: closeConnection
	 * 	this method close the database connection
	 */
	public ResultSet dbRead() throws SQLException {
		rs = stmt.executeQuery("SELECT * FROM `password-manager-gui-v2`.entries;");
		System.out.println("#LOG: Reading complete");
		return rs;
		
	}
	
	public void dbWrite() throws SQLException {
		String updateQuery = "INSERT INTO entries VALUES (?, ?, ?, ?, ?, ?);";

		pstmt = con.prepareStatement(updateQuery);
		con.setAutoCommit(false);

		for(Entry e : LocalDatabase.entryList) {
			pstmt.setInt(1, e.id);
			pstmt.setString(2, e.username);
			pstmt.setString(3, e.password);
			pstmt.setString(4, e.url);
			pstmt.setString(5, e.description);
			pstmt.setString(6, e.label);
			pstmt.addBatch();
		}

		pstmt.executeBatch();
		con.commit();
		pstmt.clearBatch();
		con.setAutoCommit(true);
		System.out.println("#LOG: Writing complete");

	}
	
	public void dbClear() throws SQLException {
		stmt.executeUpdate("TRUNCATE TABLE `password-manager-gui-v2`.entries;");
		System.out.println("#LOG: Clearing complete");
		
	}

}
