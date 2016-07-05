package com.kobe.ip.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1.建立联系File对象  源头  目的地
 * 2.先择流
 * 	文件输入流 InputStream  FileInputStream
 * 	文件输出流 OutputStream  FileOutputStream
 * 3.操作： 拷贝
 * byte[] flush = new byte[1024];
 * int len = 0;
 * while(-1!=(len=输入流.read(flush))){
 * 	输出流.write(flush,0,len)
 * }
 * 输出流.flush
 * 4.释放资源：关闭两个流
 * @author ko
 *
 */
public class CopyFileDemo {

	public static void main(String[] args){
		try {
			FileUtil.copyFile(new File("d:/xp/test/a.txt"), new File("d:/xp/kobe/5.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("拷贝文件失败|关闭流失败");
		}
		
	}

		
}
