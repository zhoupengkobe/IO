package com.kobe.ip.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件夹的拷贝
 * 1.文件  赋值copyFile
 * 2.文件夹 创建mkdirs()
 * 3.递归查找子孙级
 * @author ko
 *
 */
public class CopyDir {

	public static void main(String[] args) {
		// 源目录
		String srcPath = "d:/xp/kobe/3.txt";
		//目标目录
		String destPath = "d:/xp/11";
		
		try {
			FileUtil.copyDir(srcPath,destPath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
