package com.kobe.ip.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * �ļ��еĿ���
 * 1.�ļ�  ��ֵcopyFile
 * 2.�ļ��� ����mkdirs()
 * 3.�ݹ�������Ｖ
 * @author ko
 *
 */
public class CopyDir {

	public static void main(String[] args) {
		// ԴĿ¼
		String srcPath = "d:/xp/kobe/3.txt";
		//Ŀ��Ŀ¼
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
