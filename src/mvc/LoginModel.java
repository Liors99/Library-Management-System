package mvc;

import common.SecureAuthenticator;

public class LoginModel {

	public boolean authenticated = false;

	/**
	 * Verififes the credentials of a user
	 * 
	 * @param x    - username
	 * @param y    - password
	 * @param auth - the secureAuthenticator object that is used to verify
	 */
	public void checkAuthentication(String x, String y, SecureAuthenticator auth) {

		if (auth.verifyLogin(x, y)) {
			this.authenticated = true;
			System.out.println("authenticated");
		}
	}

	/**
	 * Checks if the user is an admin
	 * 
	 * @param x    - username
	 * @param y    - password
	 * @param auth - the secureAuthenticator object that is used to verify
	 * @return - true if admin, false otherwise
	 */
	public boolean checkAdmin(String x, String y, SecureAuthenticator auth) {
		if (auth.verifyAdmin(x, y)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if the user is faculty
	 * 
	 * @param x    - username
	 * @param y    - password
	 * @param auth - the secureAuthenticator object that is used to verify
	 * @return - true if faculty, false otherwise
	 */
	public boolean checkFaculty(String x, String y, SecureAuthenticator auth) {
		if (auth.verifyFaculty(x, y)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if the user is a librarian
	 * 
	 * @param x    - username
	 * @param y    - password
	 * @param auth - the secureAuthenticator object that is used to verify
	 * @return - true if librarian, false otherwise
	 */
	public boolean checkLib(String user, String pw, SecureAuthenticator auth) {
		return auth.verifyLib(user, pw);
	}

	/**
	 * Gets the current state of the authentication
	 * 
	 * @return - true if authenticated, false otherwise
	 */
	public boolean getAuthentication() {
		return this.authenticated;
	}

}
