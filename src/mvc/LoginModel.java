package mvc;

import java.io.IOException;
import common.SecureAuthenticator;
import database.DataParser;

public class LoginModel{

	public boolean authenticated = false;
	
	
	public void checkAuthentication(String x, String y, SecureAuthenticator auth) {
		
		if(auth.verifyLogin(x, y)) {
			this.authenticated=true;
			System.out.println("authenticated");
		}
	}
	
	public boolean checkAdmin(String x, String y, SecureAuthenticator auth) {
		if(auth.verifyAdmin(x, y)) {
			//this.authenticated=true;
			//System.out.println("authenticated");
			return true;
		}else {
			return false;
		}
	}
	
    
    public boolean checkFaculty(String x, String y, SecureAuthenticator auth) {
		if(auth.verifyFaculty(x, y)) {
			//this.authenticated=true;
			//System.out.println("authenticated");
			return true;
		}else {
			return false;
		}
	}
    
	public boolean checkLib(String user, String pw, SecureAuthenticator auth) {
		return auth.verifyLib(user, pw);
	}
	
	public boolean getAuthentication() {
		return this.authenticated;
	}
	
}



