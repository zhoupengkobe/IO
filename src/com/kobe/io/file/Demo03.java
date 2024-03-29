package com.kobe.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 常用方法：
 * 1.文件名
 * getName() 文件名，路径名
 * getPath()路径名
 * getAbsoluteFile()绝对路径所对应的File对象
 * getAbsolutePath()绝对路径名
 * getParent()父目录，相对路径的父目录，可能为null 如删除本身后的结果
 * 2.判断信息
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute()消除平台差异，ie以盘符开头，其他以/开头
 * 3.长度length()为字节数
 * 4.创建，删除
 * createNewFile()不存在创建新文件
 * delete()删除文件
 * static createTempFile(前缀3个字节长，后缀默认.temp)默认临时空间
 * staticcreateTempFile(前缀3个字节长，后缀默认.temp，目录)
 * deleteOnExit()退出虚拟机删除，常用于删除临时文件
 * @author ko
 *
 */
public class Demo03 {

	public static void main(String[] args) throws IOException {
		
		test2();
	}
	
	//创建删除文件
	public static void test3() throws IOException, InterruptedException{
		//createNewFile()不存在创建新文件
		String path="D:/xp/test/200.jpg";
		File src = new File(path);
		if (!src.exists()) {
			boolean flag = src.createNewFile();
			System.out.println(flag?"成功":"失败");
		}
		
		//删除文件
		boolean flag = src.delete();
		System.out.println(flag);
		
		//static createTempFile(前缀3个字节长，后缀默认.temp)默认临时空间
		//staticcreateTempFile(前缀3个字节长，后缀默认.temp，目录)
		File temp = File.createTempFile("tes", ".temp", new File("d:/xp/test"));
		Thread.sleep(1000);
		temp.deleteOnExit();//退出时即删除
		
		
	}
	//2.判断信息
	public static void test2(){
		String path = "D:/xp/test/2.jpg";
		//String path = "D:/xp/test";
		File src = new File(path);
		//是否存在
		System.out.println("文件是否存在："+src.exists());
		//是否可读写canWrite() canRead()
		System.out.println("文件是否可写"+src.canWrite());
		//isFile()
		//isDirectory()
		if (src.isFile()) {
			System.out.println("文件");
		}else if (src.isDirectory()) {
			System.out.println("文件夹");
		}else {
			System.out.println("文件不存在");
		}
		
		System.out.println("是否为绝对路径："+src.isAbsolute());
		//长度
		System.out.println("长度为："+src.length());
		
	}
	
	//1.名称
	public static void test1(){
		//File src = new File("E:/xp/test/2.jpg");
		//建立联系（不一定存在）
		File src = new File("2.txt");
		System.out.println(src.getName());//返回名称
		System.out.println(src.getPath());//如果是绝对路径，返回完整路径，否则相对路径
		System.out.println(src.getAbsolutePath());//返回绝对路径
		System.out.println(src.getParent());//返回上一级目录,如果是相对，返回null
		
		
	}

}
