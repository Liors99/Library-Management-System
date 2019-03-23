package common;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Random;

public class CryptoUtilities {
	
	private static final Random RANDOM = new SecureRandom();
	
	
	public static byte[] Concatenate(byte[] ar1, byte[] ar2) {
		byte[] result= new byte[ar1.length+ar2.length];
        System.arraycopy(ar1, 0, result, 0, ar1.length);
        System.arraycopy(ar2, 0, result, ar1.length, ar2.length);
        
        return result;
	}
	
	public static byte[] sha2_hash(byte[] data){

		byte[] hashval = null;
		try{
			//create message digest object
			MessageDigest sha2 = MessageDigest.getInstance("SHA-256");
			
			//make message digest
			hashval = sha2.digest(data);
		}
		catch(NoSuchAlgorithmException nsae){
			System.out.println(nsae);
		}
		return hashval;
	}
	
	/*
     * Converts a byte array to hex string
     * this code from http://java.sun.com/j2se/1.4.2/docs/guide/security/jce/JCERefGuide.html#HmacEx
     */
    public static String toHexString(byte[] block) {
        StringBuffer buf = new StringBuffer();

        int len = block.length;

        for (int i = 0; i < len; i++) {
             byte2hex(block[i], buf);
             if (i < len-1) {
                 buf.append(":");
             }
        } 
        return buf.toString();
    }
    /*
     * Converts a byte to hex digit and writes to the supplied buffer
     * this code from http://java.sun.com/j2se/1.4.2/docs/guide/security/jce/JCERefGuide.html#HmacEx
     */
    public static void byte2hex(byte b, StringBuffer buf) {
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                            '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        int high = ((b & 0xf0) >> 4);
        int low = (b & 0x0f);
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }
    
    public static byte[] hex2byte(String str) {
    	byte[] val = new byte[str.length() / 2];
    	for (int i = 0; i < val.length; i++) {
    		   int index = i * 2;
    		   int j = Integer.parseInt(str.substring(index, index + 2), 16);
    		   val[i] = (byte) j;
    		}
    	
    	return val;
    }
    
    public static byte[] getNextSalt(int size) {
        byte[] salt = new byte[size];
        RANDOM.nextBytes(salt);
        return salt;
      }
    
    
    /**
     * Writes the given message to the supplied stream.
     *
     * @param message  the message (in bytes)
     * @param out  the output stream
     * @throws IOException
     */
    public static void send(byte[] message, FileOutputStream out) throws IOException{
		// send the length of the message
    	byte[] length = ByteBuffer.allocate(4).putInt(message.length).array();
		out.write(length);
		
		// send the message bytes
		out.write(message);

		// flush the stream
		out.flush();
    }


    /**
     * Receives the given byte stream
     * @param in - input stream
     * @return
     * @throws IOException
     */
    public static byte[] receive(FileInputStream in) throws IOException{
    	byte[] n = new byte[4];
    	in.read(n);
    	int length= fromByteArray(n);
    	
    	byte[] buffer= new byte[length];
    	in.read(buffer);
    	
    	return buffer;
    }
    
    /*
     * Converts a byte array into an integer (given that the byte array was 4 bytes)
     */
    static int fromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
   }
    
    

}
