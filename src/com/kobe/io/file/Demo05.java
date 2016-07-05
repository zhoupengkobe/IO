package com.kobe.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * ������ＰĿ¼�����ļ������ƣ�����·����
 * 1.listFiles();
 * 2.�ݹ�
 * @author ko
 *
 */
public class Demo05 {

	public static void main(String[] args) {
		String path = "d:/xp/test";
		File parent = new File(path);
//		printName(parent);
		//�����̷��µ������ļ���
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		for (File temp : roots) {
			printName(temp);
		}
	}
	
	/**
	 * ���·��
	 */
	public static void printName(File src){
		if (null==src || !src.exists()) {
			return;
		}
		System.out.println(src.getAbsolutePath());
		if (src.isDirectory()) {//�ļ���
			for (File sub : src.listFiles()) {
				printName(sub);
			}
		}
	}
	
}
