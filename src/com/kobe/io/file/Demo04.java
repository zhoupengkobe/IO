package com.kobe.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 5.����Ŀ¼
 * mkdir() ����Ŀ¼������ȷ����Ŀ¼���ڣ���������ڣ�����ʧ��
 * mkdirs()����Ŀ¼�������Ŀ¼��������һͬ����
 * list() �ļ�|Ŀ¼�ַ�����ʽ
 * listFiles()
 * static listRoots()��·��
 * @author ko
 *
 */
public class Demo04 {

	public static void main(String[] args) {
		 String path = "D:/xp/test";
		 File src = new File(path);//�ļ���
		 if (src.isDirectory()) {//���ڲ���ΪĿ¼
			 System.out.println("==========��Ŀ¼|�ļ���=============");
			String[] subNames = src.list();
			for (String temp : subNames) {
				System.out.println(temp);
			}
			 
			System.out.println("==========��Ŀ¼|�ļ�File����======");
			File[] subFiles = src.listFiles();
			for (File temp : subFiles) {
				System.out.println(temp.getAbsolutePath());
			}
			System.out.println("==========���ļ�.java����======");
			//�������ģʽ
			subFiles = src.listFiles(new FilenameFilter() {
				
				@Override
				/**
				 * dir ���� src
				 * 
				 */
				public boolean accept(File dir, String name) {
					
					return new File(dir, name).isFile() && name.endsWith(".java");
				}
			});
			for (File temp : subFiles) {
				System.out.println(temp.getAbsolutePath());
			}
			
		}
	}

	
		public static void test1(){
			String path = "D:/xp/test/parent/test";
			File src = new File(path);
			src.mkdir();
		}
}
