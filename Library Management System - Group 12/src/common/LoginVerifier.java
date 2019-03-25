package common;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class LoginVerifier {

	private static final int SALT_SIZE= 16;
	
	
	public static boolean Store(String ID, String pass) throws IOException{
        byte[] salt=CryptoUtilities.getNextSalt(SALT_SIZE);
        byte[] hash= CryptoUtilities.sha2_hash(CryptoUtilities.Concatenate(salt, pass.getBytes()));
        
        
		File file = new File("passwd.txt");
        FileOutputStream out = new FileOutputStream(file,true);
        FileInputStream in = new FileInputStream(file);
    	int skip=4+16+4+32;
    	int size= in.available();
    	boolean allow_register=true;
    	
    	if(size==0) {
		    System.out.println("Registered first user!");
    	}
    	else {
    		in.getChannel().position(0);
	    	while (in.getChannel().position() <= (size - skip)) {
	    		String name = new String(CryptoUtilities.receive(in));
	    		System.out.println(name);
	    		if(name.compareTo(ID)==0) {
	    			allow_register=false;
	    			break;
	    		}
	    		else {
	    			in.skip(skip);
	    		}
	    	}
    	}
    	
    	if(allow_register) {
    		CryptoUtilities.send(ID.getBytes(), out);
		    CryptoUtilities.send(salt, out);
		    CryptoUtilities.send(hash, out);
		    System.out.println("Regitration successful");
		    out.close();
	    	in.close();
		    return true;
    	}
    	else {
    		System.out.println("Username already taken");
    		out.close();
        	in.close();
        	return false;
    	}
    	

    }

    public static boolean VerifyLogin(String ID, String pass) throws IOException {
    	File file = new File("passwd.txt");
    	FileInputStream in = null;
    	in = new FileInputStream(file);
    	
    	int skip=4+16+4+32;
    	
    	
    	int size= in.available();
    	
    	
    	while (in.getChannel().position() <= (size - skip)) {
			String name = new String(CryptoUtilities.receive(in));
			if(ID.compareTo(name)==0) {
				byte[] salt= CryptoUtilities.receive(in);
		    	byte[] hash = CryptoUtilities.receive(in);
		    	
		        byte[] calculated_hash= CryptoUtilities.sha2_hash(CryptoUtilities.Concatenate(salt, pass.getBytes()));
		        in.close();
		        
		        if(Arrays.equals(calculated_hash, hash)) {
		        	System.out.println("login successful!");
		        	return true;
		        }
		        else {
		        	System.out.println("Invalid password");
		        	return false;
		        }
			}
			else {
				in.skip(skip);
				}
    	}
    	System.out.println("No such user found");
    	in.close();
    	return false;
    }
}
