package common;

import java.util.Arrays;

import database.DataParser;
import database.User;

/**
 * 
 * @author Lior
 *
 */
public class SecureAuthenticator {
	
	private final static int SALT_SIZE=16;
	
	private User user_data;
	
	/**
	 * 
	 * @param d
	 */
	public SecureAuthenticator(DataParser d) {
		user_data= new User(d);
	}
	
	/**
	 * 
	 * @param username
	 * @param pwd
	 * @return
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
	 * 
	 * @param username
	 * @param pwd
	 * @return
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

}
