package mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.User;

public class AdminModel{
	
	/*
	 * Returns the list of all users in the system
	 */
	public ArrayList<String> getAllUsers(){
        ArrayList<String> lst = new ArrayList<String>();
		int i = 0;
		
		ResultSet r = User.getData().performQuery("SELECT * FROM users_and_passwords ");

		try {
			while(r.next() ) {
				lst.add( r.getString("username"));// + "  DATE RENTED: " + r.getString("dateRented")); 
				i++;
			}
		}
		catch(SQLException ex) {
		}
        
        return lst;
    }
}
