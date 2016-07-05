package com.kobe.io.file;

import java.io.File;

/**
 * ���·�������·������File����
 * 1.���·��
 * File(String parent,String child) ==>File("E:/xp/test","2.jpg")
 * 
 * File(File parent,String child) ==>File(new File("E:/xp/test"),"2.jpg")
 * 2.����·��
 * file(String name);
 * @author ko
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		
		String parentPath = "E:/xp/test";
		String name = "2.jpg";
		//���·��
		File src = new File(parentPath,name);
		src = new File(new File(parentPath),name);
		//���
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//����·��
		src = new File("E:/xp/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//û���̷�:��user.dir ����
		src = new File("test.txt");
		src = new File(".");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	}

}
