package com.kobe.ip.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ��Ķ�ȡ
 * 1.������ϵFile����
 * 2.ѡ�������ļ������� InputStream  FileInputStream
 * 3.������byte[] car = new byte[1024];+read+��ȡ��С
 * ���
 * 4.�ͷ���Դ�ر�
 * @author ko
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		//1.������ϵ
		File src = new File("d:/xp/test/a.txt");
		//2.ѡ����
		InputStream is = null;//����������
		try {
			is = new FileInputStream(src);
			//3.�������϶�ȡ ��������
			byte[] car = new byte[1024];
			int len = 0;//����ʵ�ʶ�ȡ��С
			//ѭ����ȡ
			while(-1!=(len=is.read(car))){
				// ������ֽ�����ת���ַ���
				String info = new String(car, 0, len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("��ȡ�ļ�ʧ��");
		}finally {
			try {
				// 4.�ͷ���Դ
				if (null != is) {
					is.close();
				} 
			} catch (Exception e2) {
				System.out.println("�ر��ļ�������ʧ��");
			}
		}
		
	}

}
