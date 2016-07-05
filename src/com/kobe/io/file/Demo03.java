package com.kobe.io.file;

import java.io.File;
import java.io.IOException;

/**
 * ���÷�����
 * 1.�ļ���
 * getName() �ļ�����·����
 * getPath()·����
 * getAbsoluteFile()����·������Ӧ��File����
 * getAbsolutePath()����·����
 * getParent()��Ŀ¼�����·���ĸ�Ŀ¼������Ϊnull ��ɾ�������Ľ��
 * 2.�ж���Ϣ
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute()����ƽ̨���죬ie���̷���ͷ��������/��ͷ
 * 3.����length()Ϊ�ֽ���
 * 4.������ɾ��
 * createNewFile()�����ڴ������ļ�
 * delete()ɾ���ļ�
 * static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp)Ĭ����ʱ�ռ�
 * staticcreateTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp��Ŀ¼)
 * deleteOnExit()�˳������ɾ����������ɾ����ʱ�ļ�
 * @author ko
 *
 */
public class Demo03 {

	public static void main(String[] args) throws IOException {
		
		test2();
	}
	
	//����ɾ���ļ�
	public static void test3() throws IOException, InterruptedException{
		//createNewFile()�����ڴ������ļ�
		String path="D:/xp/test/200.jpg";
		File src = new File(path);
		if (!src.exists()) {
			boolean flag = src.createNewFile();
			System.out.println(flag?"�ɹ�":"ʧ��");
		}
		
		//ɾ���ļ�
		boolean flag = src.delete();
		System.out.println(flag);
		
		//static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp)Ĭ����ʱ�ռ�
		//staticcreateTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp��Ŀ¼)
		File temp = File.createTempFile("tes", ".temp", new File("d:/xp/test"));
		Thread.sleep(1000);
		temp.deleteOnExit();//�˳�ʱ��ɾ��
		
		
	}
	//2.�ж���Ϣ
	public static void test2(){
		String path = "D:/xp/test/2.jpg";
		//String path = "D:/xp/test";
		File src = new File(path);
		//�Ƿ����
		System.out.println("�ļ��Ƿ���ڣ�"+src.exists());
		//�Ƿ�ɶ�дcanWrite() canRead()
		System.out.println("�ļ��Ƿ��д"+src.canWrite());
		//isFile()
		//isDirectory()
		if (src.isFile()) {
			System.out.println("�ļ�");
		}else if (src.isDirectory()) {
			System.out.println("�ļ���");
		}else {
			System.out.println("�ļ�������");
		}
		
		System.out.println("�Ƿ�Ϊ����·����"+src.isAbsolute());
		//����
		System.out.println("����Ϊ��"+src.length());
		
	}
	
	//1.����
	public static void test1(){
		//File src = new File("E:/xp/test/2.jpg");
		//������ϵ����һ�����ڣ�
		File src = new File("2.txt");
		System.out.println(src.getName());//��������
		System.out.println(src.getPath());//����Ǿ���·������������·�����������·��
		System.out.println(src.getAbsolutePath());//���ؾ���·��
		System.out.println(src.getParent());//������һ��Ŀ¼,�������ԣ�����null
		
		
	}

}
