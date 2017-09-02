package edu.jyu.cipher;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.junit.Test;

import edu.jyu.util.Tools;

/**
 * 非对称加密演示
 * 
 * @author Jason
 *
 */
public class AsymmetricCryptographyDemo {
	@Test
	public void encrypt() throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		// 获得秘钥对
		KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
		// 私钥
		PrivateKey privateKey = keyPair.getPrivate();
		// 公钥
		PublicKey publicKey = keyPair.getPublic();
		Tools.saveKey(publicKey, "hjj_public.key");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] result = cipher.doFinal("嘉应学院".getBytes());
		Tools.saveData(result, "hjj.data");
	}

	@Test
	public void decrypt() throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		Key publicKey = Tools.readKey("hjj_public.key");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] data = Tools.readData("hjj.data");
		byte[] result = cipher.doFinal(data);
		System.out.println(new String(result));
	}
}
