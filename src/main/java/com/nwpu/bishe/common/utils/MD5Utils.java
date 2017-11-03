package com.nwpu.bishe.common.utils;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;

/**
 * Created by chunk on 2017/10/16.
 */
public class MD5Utils {

	public static String UTF8 = "utf-8";
	/**
	 * MD5加密 默认编码为UTF-8.
	 * 
	 * @param origin
	 *            加密字符串
	 * @return
	 */
	public static String MD5Encode(String origin) {
		return MD5Encode(origin, UTF8);
	}

	/**
	 * MD5加密
	 * 
	 * @param origin
	 *            加密字符串
	 * @param charset
	 *            字符集
	 * @return
	 */
	public static String MD5Encode(String origin, String charset) {
		if (StringUtils.isEmpty(origin)) {
			return origin;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (StringUtils.isEmpty(charset)) {
				return byteArrayToHexString(md.digest(origin.getBytes()));
			} else {
				return byteArrayToHexString(md.digest(origin.getBytes(charset)));
			}
		} catch (Exception exception) {
			// ignore exception
		}
		return origin;
	}

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return HEX_DIGITS[d1] + HEX_DIGITS[d2];
	}

	private static final String HEX_DIGITS[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	
	

}
