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
 * ת�������ֽ�ת��Ϊ�ַ� 1.�����OutputStreamWriter���� 2.������InputStreamReader ����
 * 
 * @author ko
 *
 */
public class ConverDemo02 {

	public static void main(String[] args) throws IOException {
		//ָ�������ַ���
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("d:/xp/test/a.txt")),"UTF-8")
				);
		//д���ļ�
		
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
