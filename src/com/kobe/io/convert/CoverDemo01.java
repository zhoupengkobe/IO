package com.kobe.io.convert;

import java.io.UnsupportedEncodingException;

public class CoverDemo01 {
/**
 * @param args
 * @throws UnsupportedEncodingException
 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "中国";
		byte[] data = str.getBytes();
		//字节数不完整
		System.out.println(new String(data,0,3));

	}
	
	public static void test01() throws UnsupportedEncodingException{
		//解码byte -->char
				String str ="中国";  //gbk
				// 编码char --> byte
				byte[] data = str.getBytes();
				//编码与解码字符集统一
				System.out.println(new String(data));
				data = str.getBytes("utf-8");//设定编码字符集
				//不统一出现乱码
				System.out.println(new String(data));
				
				//编码
				byte[] data2 = "中国".getBytes("utf-8");
				//解码
				str = new String(data2,"utf-8");
				System.out.println(str);
	}

}
