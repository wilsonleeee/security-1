package edu.jyu.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Key;

public class Tools {
	/**
	 * ����key��Ӳ����
	 * 
	 * @param key
	 * @param fileName
	 * @throws Exception
	 */
	public static void saveKey(Key key, String fileName) throws Exception {
		OutputStream keyOS = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(keyOS);
		oos.writeObject(key);
		oos.close();
		keyOS.close();
	}

	/**
	 * ��ȡkey
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static Key readKey(String fileName) throws Exception {
		// ��ȡkey
		InputStream keyIS = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(keyIS);
		Key key = (Key) ois.readObject();
		ois.close();
		keyIS.close();
		return key;
	}

	/**
	 * �������ݵ�Ӳ����
	 * 
	 * @param data
	 * @param fileName
	 * @throws Exception
	 */
	public static void saveData(byte[] data, String fileName) throws Exception {
		OutputStream dataOS = new FileOutputStream(fileName);
		dataOS.write(data);
		dataOS.close();
	}

	/**
	 * ��ȡ����
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static byte[] readData(String fileName) throws Exception {
		InputStream dataIS = new FileInputStream("hjj.data");
		byte[] data = new byte[dataIS.available()];
		dataIS.read(data, 0, data.length);
		dataIS.close();
		return data;
	}
}
