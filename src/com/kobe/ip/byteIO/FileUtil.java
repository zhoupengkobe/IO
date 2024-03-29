package com.kobe.ip.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件的操做 拷贝
 * 文件夹的操做，拷贝
 * @author ko
 *
 */
public class FileUtil {
	
	/**
	 * 拷贝文件夹
	 * @param src 源路径
	 * @param dest 目标路径
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(String srcPath, String destPath) throws FileNotFoundException, IOException{

		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	
	/**
	 * 拷贝文件夹
	 * @param src 源File对象
	 * @param dest 目标File对象
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(File src, File dest) throws FileNotFoundException, IOException{
		if (src.isDirectory()) {//文件夹
			dest = new File(dest,src.getName());			
		}
		CopyDirDetail(src,dest);
	}
	
	/**
	 * 拷贝文件夹细节
	 * @param src
	 * @param dest
	 * @throws FileNotFoundException,IOException 
	 */
	private static void CopyDirDetail(File src, File dest) throws FileNotFoundException,IOException {
		if (src.isFile()) {//文件
			try {
				FileUtil.copyFile(src, dest);
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			}
		}else if (src.isDirectory()) {//文件夹
			//确保目标文件夹存在
			dest.mkdir();
			//获取下一级目录|文件
			for(File sub:src.listFiles()){
				CopyDirDetail(sub, new File(dest, sub.getName()));
			}
		}
		
	}

	
	/**
	 * 文件的拷贝
	 * 
	 * @param 源文件路径
	 * @param 目录文件路径
	 * @throws FileNotFoundException,IOException
	 */

	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException, IOException {
		// 1.建立联系 源（存在且为文件）+目的地（文件可以不存在）
		copyFile(new File(srcPath), new File(destPath));

	}

	/**
	 * 文件的拷贝
	 * 
	 * @param 源文件 File 对象
	 * @param 目录文件  File 对象
	 * @throws IOException 
	 * @throws FileNotFoundException,IOException
	 */

	public static void copyFile (File src, File dest) throws FileNotFoundException,IOException{

		if (!src.isFile()) {// 不是文件或者为空
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");

		}
		//dest 为已经存在的文件夹，不能建立与文件夹同名的文件
		if (dest.isDirectory()) {
			System.out.println(dest.getAbsolutePath()+"不能建立与文件夹同名的文件");
			throw new IOException(dest.getAbsolutePath()+"不能建立与文件夹同名的文件");
		}
		// 2.选择流
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		// 3.拷贝文件
		byte[] flush = new byte[1024];
		int len = 0;

		while (-1 != (len = (is.read(flush)))) {
			os.write(flush, 0, len);
		}
		os.flush();// 强制刷出
		// 关闭流
		os.close();
		is.close();

	}

}
