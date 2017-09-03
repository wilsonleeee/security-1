package edu.jyu.cipher;

import java.security.MessageDigest;

import org.junit.Test;

/**
 * 摘要演示
 * 
 * @author Jason
 *
 */
public class DigestDemo {

	@Test
	public void md5() throws Exception {
		String md5 = null;
		// MessageDigest digest = MessageDigest.getInstance("MD5");
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.update("Jason".getBytes());
		byte[] result = digest.digest();
		System.out.println(result.length);
		String hex = bytesToHexString(result);
		System.out.println(hex);
	}

	/**
	 * 字节数组转换成十六进制字符串
	 * 
	 * @param src
	 * @return
	 */
	public String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
