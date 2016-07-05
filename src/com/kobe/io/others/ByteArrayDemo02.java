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
 * 1.文件--程序--字节数组
 * 2.文件输入流
 * 字节数组输出流
 * 2.字节数组-->程序-->文件
 * 字节数组输入流
 * 文件输出流
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
	 * 字节数组-->程序-->文件
	 * @throws IOException 
	 * 
	 */
	public static void toFileFromByteArray(byte[] src, String destPath) throws IOException{
		//创建源
		//创建目的地
		File dest = new File(destPath);
		//选择流
		//字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//文件输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//操做不断读取字节数组
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1!=(len=is.read(flush))) {
			//写出到文件中
			os.write(flush, 0, len);
		}
		
		os.flush();
		//释放资源
		os.close();
		is.close();
	}
	
		
	
	/**
	 * 1.文件-->程序-->字节数组
	 * @return
	 * @throws IOException 
	 */
	public static byte[] getBytesFromFile(String srcPath) throws IOException{
		//创建源文件
		File src = new File(srcPath);
		//创建字节数组目的地
		byte[] dest = null;
		//选择流
		//文件输入流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		//字节数组输出流 不能使用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//操做 不断读取文件  写出到字节数组流中
		byte[] flush = new byte[1024];
		int len = 0 ;
		while (-1!=(len=(is.read(flush)))) {
			//写出到字节数组流中
			bos.write(flush, 0, len);
		}
		bos.flush();
		//获取数据
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}

}
