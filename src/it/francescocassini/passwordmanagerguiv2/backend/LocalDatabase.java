package it.francescocassini.passwordmanagerguiv2.backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LocalDatabase {
	
	public static List<Entry> entryList;
	
	public List<Entry> getEntryList() {
		return entryList;
	}

	public LocalDatabase() {
		
		entryList = new ArrayList<Entry>();
		
	}

	public List<Entry> updateLocalDatabase(ResultSet s) throws SQLException{
		
		while(s.next()) {
			entryList.add(new Entry(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getString(5), s.getString(6)));
		}
		System.out.println("#LOG: Local Database Updated");
		return entryList;
	}
	
	public void addEntry(Entry e) {
		entryList.add(e);
		System.out.println("#LOG: Entry added");
	}
	
	public void deleteEntry(Entry e) {
		boolean b = false;
		Iterator<Entry> iter = entryList.iterator();
		while (iter.hasNext()) 
		{
		    Entry h = iter.next();
		    if(h.id == e.id)
		    {
		        iter.remove();
		        b = true;
		    }
		}
		
		if(b)
			System.out.println("#LOG: Entry deleted");
		else
			System.out.println("#LOG: Entry not deleted. Entry not found");
	}
	
	public int getNextId() {
		return entryList.size() + 1;
	}
	
	public void printLocalDatabase() {
		for(Entry x : LocalDatabase.entryList) {
			System.out.println(x.username);
		}
	}
}
