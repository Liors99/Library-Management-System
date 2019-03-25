package mvc;

import java.io.IOException;

import common.LoginVerifier;

public class LoginModel extends CurrentModel{

	public boolean authenticated = false;

	
	public void checkAuthentication(String x, String y) {
		try {
			if (LoginVerifier.VerifyLogin(x, y)) {
				this.authenticated = true;
				System.out.println("authenticated");
				
			}
			else {
				System.out.println("PROBLEM");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean getAuthentication() {
		return this.authenticated;
	}
}



