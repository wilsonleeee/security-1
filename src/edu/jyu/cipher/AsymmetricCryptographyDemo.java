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
 * �ǶԳƼ�����ʾ
 * 
 * @author Jason
 *
 */
public class AsymmetricCryptographyDemo {
	/**
	 * ��˽Կ����
	 * 
	 * @throws Exception
	 */
	@Test
	public void encryptByPrivateKey() throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		// �����Կ��
		KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
		// ˽Կ
		PrivateKey privateKey = keyPair.getPrivate();
		// ��Կ
		PublicKey publicKey = keyPair.getPublic();
		Tools.saveKey(publicKey, "hjj_public.key");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] result = cipher.doFinal("��ӦѧԺ".getBytes());
		Tools.saveData(result, "hjj.data");
	}

	/**
	 * �ù�Կ����
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
	 * �ù�Կ����
	 * 
	 * @throws Exception
	 */
	@Test
	public void encryptByPublicKey() throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		// �����Կ��
		KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
		// ˽Կ
		PrivateKey privateKey = keyPair.getPrivate();
		// ��Կ
		PublicKey publicKey = keyPair.getPublic();
		Tools.saveKey(privateKey, "hjj_private.key");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] result = cipher.doFinal("��ӦѧԺ".getBytes());
		Tools.saveData(result, "hjj.data");
	}

	/**
	 * ��˽Կ����
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
