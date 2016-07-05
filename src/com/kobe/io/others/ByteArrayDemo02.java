package com.kobe.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.attribute.DosFileAttributes;

/**
 * 1.�ļ�--����--�ֽ�����
 * 2.�ļ�������
 * �ֽ����������
 * 2.�ֽ�����-->����-->�ļ�
 * �ֽ�����������
 * �ļ������
 * @author ko
 *
 */
public class ByteArrayDemo02 {

	public static void main(String[] args) throws IOException {
		byte[] data = getBytesFromFile("d:/xp/test/a.txt");
		toFileFromByteArray(data, "d:/xp/test/m.txt");
		System.out.println(new String(data));

	}
	
	/**
	 * �ֽ�����-->����-->�ļ�
	 * @throws IOException 
	 * 
	 */
	public static void toFileFromByteArray(byte[] src, String destPath) throws IOException{
		//����Դ
		//����Ŀ�ĵ�
		File dest = new File(destPath);
		//ѡ����
		//�ֽ�����������
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//�ļ������
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//�������϶�ȡ�ֽ�����
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1!=(len=is.read(flush))) {
			//д�����ļ���
			os.write(flush, 0, len);
		}
		
		os.flush();
		//�ͷ���Դ
		os.close();
		is.close();
	}
	
		
	
	/**
	 * 1.�ļ�-->����-->�ֽ�����
	 * @return
	 * @throws IOException 
	 */
	public static byte[] getBytesFromFile(String srcPath) throws IOException{
		//����Դ�ļ�
		File src = new File(srcPath);
		//�����ֽ�����Ŀ�ĵ�
		byte[] dest = null;
		//ѡ����
		//�ļ�������
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		//�ֽ���������� ����ʹ�ö�̬
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//���� ���϶�ȡ�ļ�  д�����ֽ���������
		byte[] flush = new byte[1024];
		int len = 0 ;
		while (-1!=(len=(is.read(flush)))) {
			//д�����ֽ���������
			bos.write(flush, 0, len);
		}
		bos.flush();
		//��ȡ����
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}

}
