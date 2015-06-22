package br.com.petGoHome.DAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashUtil {
	
	public static String stringToMD5(String string){
		String md5 = null;
		if(null == string){
			return null;
		}
	MessageDigest mdg;
	
	try{
		String salt = "C@raBynA!20P@raib@14";
		
		String senhaYsalt = string+salt;
		
		mdg = MessageDigest.getInstance("MD5");
		mdg.update(senhaYsalt.getBytes(), 0, senhaYsalt.length());
		//Convertendo para HEXA
		md5 = new BigInteger(1, mdg.digest()).toString(16);
		} catch (NoSuchAlgorithmException ex){
			Logger.getLogger(HashUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
	return md5;
	
	}

}
