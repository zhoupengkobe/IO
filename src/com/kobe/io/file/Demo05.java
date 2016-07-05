package com.kobe.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙及目录或者文件的名称（绝对路径）
 * 1.listFiles();
 * 2.递归
 * @author ko
 *
 */
public class Demo05 {

	public static void main(String[] args) {
		String path = "d:/xp/test";
		File parent = new File(path);
//		printName(parent);
		//所有盘符下的所有文件夹
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		for (File temp : roots) {
			printName(temp);
		}
	}
	
	/**
	 * 输出路径
	 */
	public static void printName(File src){
		if (null==src || !src.exists()) {
			return;
		}
		System.out.println(src.getAbsolutePath());
		if (src.isDirectory()) {//文件夹
			for (File sub : src.listFiles()) {
				printName(sub);
			}
		}
	}
	
}
