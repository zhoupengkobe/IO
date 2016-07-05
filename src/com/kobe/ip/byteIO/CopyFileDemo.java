package com.kobe.ip.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1.������ϵFile����  Դͷ  Ŀ�ĵ�
 * 2.������
 * 	�ļ������� InputStream  FileInputStream
 * 	�ļ������ OutputStream  FileOutputStream
 * 3.������ ����
 * byte[] flush = new byte[1024];
 * int len = 0;
 * while(-1!=(len=������.read(flush))){
 * 	�����.write(flush,0,len)
 * }
 * �����.flush
 * 4.�ͷ���Դ���ر�������
 * @author ko
 *
 */
public class CopyFileDemo {

	public static void main(String[] args){
		try {
			FileUtil.copyFile(new File("d:/xp/test/a.txt"), new File("d:/xp/kobe/5.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("�����ļ�ʧ��|�ر���ʧ��");
		}
		
	}

		
}
