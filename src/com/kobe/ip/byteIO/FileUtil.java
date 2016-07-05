package com.kobe.ip.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ļ��Ĳ��� ����
 * �ļ��еĲ���������
 * @author ko
 *
 */
public class FileUtil {
	
	/**
	 * �����ļ���
	 * @param src Դ·��
	 * @param dest Ŀ��·��
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(String srcPath, String destPath) throws FileNotFoundException, IOException{

		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	
	/**
	 * �����ļ���
	 * @param src ԴFile����
	 * @param dest Ŀ��File����
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(File src, File dest) throws FileNotFoundException, IOException{
		if (src.isDirectory()) {//�ļ���
			dest = new File(dest,src.getName());			
		}
		CopyDirDetail(src,dest);
	}
	
	/**
	 * �����ļ���ϸ��
	 * @param src
	 * @param dest
	 * @throws FileNotFoundException,IOException 
	 */
	private static void CopyDirDetail(File src, File dest) throws FileNotFoundException,IOException {
		if (src.isFile()) {//�ļ�
			try {
				FileUtil.copyFile(src, dest);
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			}
		}else if (src.isDirectory()) {//�ļ���
			//ȷ��Ŀ���ļ��д���
			dest.mkdir();
			//��ȡ��һ��Ŀ¼|�ļ�
			for(File sub:src.listFiles()){
				CopyDirDetail(sub, new File(dest, sub.getName()));
			}
		}
		
	}

	
	/**
	 * �ļ��Ŀ���
	 * 
	 * @param Դ�ļ�·��
	 * @param Ŀ¼�ļ�·��
	 * @throws FileNotFoundException,IOException
	 */

	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException, IOException {
		// 1.������ϵ Դ��������Ϊ�ļ���+Ŀ�ĵأ��ļ����Բ����ڣ�
		copyFile(new File(srcPath), new File(destPath));

	}

	/**
	 * �ļ��Ŀ���
	 * 
	 * @param Դ�ļ� File ����
	 * @param Ŀ¼�ļ�  File ����
	 * @throws IOException 
	 * @throws FileNotFoundException,IOException
	 */

	public static void copyFile (File src, File dest) throws FileNotFoundException,IOException{

		if (!src.isFile()) {// �����ļ�����Ϊ��
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");

		}
		//dest Ϊ�Ѿ����ڵ��ļ��У����ܽ������ļ���ͬ�����ļ�
		if (dest.isDirectory()) {
			System.out.println(dest.getAbsolutePath()+"���ܽ������ļ���ͬ�����ļ�");
			throw new IOException(dest.getAbsolutePath()+"���ܽ������ļ���ͬ�����ļ�");
		}
		// 2.ѡ����
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		// 3.�����ļ�
		byte[] flush = new byte[1024];
		int len = 0;

		while (-1 != (len = (is.read(flush)))) {
			os.write(flush, 0, len);
		}
		os.flush();// ǿ��ˢ��
		// �ر���
		os.close();
		is.close();

	}

}
