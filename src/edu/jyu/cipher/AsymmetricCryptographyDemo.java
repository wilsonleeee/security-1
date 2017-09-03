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
	/**
	 * 用私钥加密
	 * 
	 * @throws Exception
	 */
	@Test
	public void encryptByPrivateKey() throws Exception {
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

	/**
	 * 用公钥解密
	 * 
	 * @throws Exception
	 */
	@Test
	public void decryptByPublicKey() throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		Key publicKey = Tools.readKey("hjj_public.key");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] data = Tools.readData("hjj.data");
		byte[] result = cipher.doFinal(data);
		System.out.println(new String(result));
	}
	
	//--------------------------------------------
	/**
	 * 用公钥加密
	 * 
	 * @throws Exception
	 */
	@Test
	public void encryptByPublicKey() throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		// 获得秘钥对
		KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
		// 私钥
		PrivateKey privateKey = keyPair.getPrivate();
		// 公钥
		PublicKey publicKey = keyPair.getPublic();
		Tools.saveKey(privateKey, "hjj_private.key");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] result = cipher.doFinal("嘉应学院".getBytes());
		Tools.saveData(result, "hjj.data");
	}

	/**
	 * 用私钥解密
	 * 
	 * @throws Exception
	 */
	@Test
	public void decryptByPrivateKey() throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		Key privateKey = Tools.readKey("hjj_private.key");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] data = Tools.readData("hjj.data");
		byte[] result = cipher.doFinal(data);
		System.out.println(new String(result));
	}
}
