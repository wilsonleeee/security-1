package edu.jyu.security;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Arrays;

import org.junit.Test;

import edu.jyu.util.Tools;

/**
 * Êı×ÖÇ©ÃûÑİÊ¾
 * 
 * @author Jason
 *
 */
public class DigitalDignatureDemo {

	@Test
	public void sign() throws Exception {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = generator.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		Tools.saveKey(publicKey, "hjj_sign_public.key");
		PrivateKey privateKey = keyPair.getPrivate();
		Signature signature = Signature.getInstance("SHA1withRSA");
		signature.initSign(privateKey);
		signature.update("Ç×°®µÄ¸øÄãÂòÂòÂò".getBytes());
		byte[] result = signature.sign(); 
		Tools.saveData(result, "hjj_sign.data");
	}

	@Test
	public void verify() throws Exception {
		PublicKey publicKey = (PublicKey) Tools.readKey("hjj_sign_public.key");
		byte[] data = Tools.readData("hjj_sign.data");
		
		Signature signature = Signature.getInstance("SHA1withRSA");
		signature.initVerify(publicKey);
		signature.update("Ç×°®µÄ¸øÄãÂòÂòÂò".getBytes());
		boolean result = signature.verify(data);
		System.out.println(result);
	}
}
