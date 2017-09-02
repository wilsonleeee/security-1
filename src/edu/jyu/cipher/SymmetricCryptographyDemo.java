package edu.jyu.cipher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.junit.Test;

import edu.jyu.util.Tools;

/**
 * 对称加密演示
 * 
 * @author Jason
 *
 */
public class SymmetricCryptographyDemo {

	@Test
	public void encrypt() throws Exception {
		// 用于加密/解密的对象，可指定加密/解密的算法，这里指定AES
		Cipher cipher = Cipher.getInstance("AES");
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();
		cipher.init(Cipher.ENCRYPT_MODE, key);

		Tools.saveKey(key, "hjj_secret.key");

		byte[] result = cipher.doFinal("Jason".getBytes());
		System.out.println(new String(result));

		Tools.saveData(result, "hjj.data");
	}

	@Test
	public void decrypt() throws Exception {
		// 用于加密/解密的对象，可指定加密/解密的算法，这里指定AES
		Cipher cipher = Cipher.getInstance("AES");

		// 读取key
		Key key = Tools.readKey("hjj_secret.key");

		byte[] data = Tools.readData("hjj.data");

		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] result = cipher.doFinal(data);
		System.out.println(new String(result));
	}

	@Test
	public void encryptByPwd() throws Exception {
		// 用于加密/解密的对象，可指定加密/解密的算法，这里指定AES
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")//
				.generateSecret(new PBEKeySpec("12345678".toCharArray()));
		PBEParameterSpec parameterSpec = new PBEParameterSpec(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 1000);
		cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);

		byte[] result = cipher.doFinal("Jason".getBytes());
		System.out.println(new String(result));

		Tools.saveData(result, "hjj.data");
	}

	@Test
	public void decryptByPwd() throws Exception {
		// 用于加密/解密的对象，可指定加密/解密的算法，这里指定AES
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");

		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")//
				.generateSecret(new PBEKeySpec("12345678".toCharArray()));

		byte[] data = Tools.readData("hjj.data");

		PBEParameterSpec parameterSpec = new PBEParameterSpec(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 1000);
		cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
		byte[] result = cipher.doFinal(data);
		System.out.println(new String(result));
	}

}
