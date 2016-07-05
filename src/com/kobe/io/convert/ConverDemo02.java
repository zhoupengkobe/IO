package com.kobe.io.convert;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 转换流：字节转换为字符 1.输出流OutputStreamWriter编码 2.输入流InputStreamReader 编码
 * 
 * @author ko
 *
 */
public class ConverDemo02 {

	public static void main(String[] args) throws IOException {
		//指定解码字符集
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("d:/xp/test/a.txt")),"UTF-8")
				);
		//写出文件
		
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new BufferedOutputStream(
								new FileOutputStream(new File("d:/xp/test/encode.txt"))))
					);
				
		String info = null;
		while (null!=(info=br.readLine())) {
//			System.out.println(info);
			bw.write(info);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
