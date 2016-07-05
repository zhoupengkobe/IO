package com.kobe.ip.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * д���ļ�
 * 1.������ϵ File����  Ŀ�ĵ�
 * 2.ѡ�������ļ������ OutputStream FileOutputStream
 * 3.������write() + flush
 * 4.�ͷ���Դ:�ر�
 * @author ko
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		// 1. ������ϵFile����Ŀ�ĵ�
		File dest = new File("d:/xp/test/test.txt");
		// 2. ѡ����  �ļ������ OutputStream FileOutputStream
		OutputStream os = null;
		// ��׷����ʽд���ļ� ����Ϊtrue  ����Ϊ����
		try {
			os = new FileOutputStream(dest,true);
			//3.����
			String str = "kobe is very good \r\n";
			//�ַ���ת�ֽ�����
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			os.flush();//ǿ��ˢ�³�ȥ
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ�");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�д��ʧ��");
		}finally {
			try {
				if (null != os) {
					os.close();
				} 
			} catch (Exception e2) {
				System.out.println("�ر������ʧ��");
			}
		}

	}

}
