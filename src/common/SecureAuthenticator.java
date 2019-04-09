package common;

import java.util.Arrays;

import database.DataParser;
import database.User;

/**
 * 
 * @author Lior Somin
 *
 */
public class SecureAuthenticator {
	
	private final static int SALT_SIZE=16;
	
	private User user_data;
	
	/**
	 * The constructor
	 * @param d - DataParser
	 */
	public SecureAuthenticator(DataParser d) {
		user_data= new User(d);
	}
	
	/**
	 * 
	 * @param username - username
	 * @param pwd - password
	 * @return - true if success, false if failure
	 */
	public boolean Store(String username, String pwd) {
		if(!user_data.userExists(username)) {
			byte[] salt=CryptoUtilities.getNextSalt(SALT_SIZE);
			byte[] hash= CryptoUtilities.sha2_hash(CryptoUtilities.Concatenate(salt, pwd.getBytes()));
			
			user_data.createUser(username, salt, hash);
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Verififes the login information of the user using salts and SHA-256
	 * @param username - username
	 * @param pwd - password
	 * @return - true if authenticated, false otherwise
	 */
	public boolean verifyLogin(String username, String pwd) {
		if(user_data.userExists(username)) {
			byte[] user_salt = user_data.getSalt(username);
			byte[] user_hash = user_data.getHash(username);
			
			byte[] entered_hash = CryptoUtilities.sha2_hash(CryptoUtilities.Concatenate(user_salt, pwd.getBytes()));
			
			if(Arrays.equals(user_hash, entered_hash)) {
				return true;
			}
			else {
				return false;
			}
			
		}
		return false;
	}
	
	public boolean verifyAdmin(String username, String pwd) {
		if(user_data.userExists(username)) {
			int type = user_data.getAccountType(username);
			
			if(type != 0) {
				if(type == 2) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	public boolean verifyLib(String username, String pwd) {
		if(user_data.userExists(username)) {
			int type = user_data.getAccountType(username);
			/* Type = 3 for Librarian */
			if (type == 3) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyFaculty(String username, String pwd) {
		if(user_data.userExists(username)) {
			int type = user_data.getAccountType(username);
			/* Type = 3 for Librarian */
			if (type == 4) {
				return true;
			}
		}
		return false;
	}

}
