package java基础;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIOStreamDemo {

	public static String fosWrite(String fileAbsulutePath,String fileContent) throws Exception{//文件写入
		File file = new File(fileAbsulutePath);
		FileOutputStream fos = new FileOutputStream(file);
		byte[] wordOutByteArr = fileContent.getBytes();//转成字节数组
		fos.write(wordOutByteArr);//写入
		fos.close();//关闭流
		System.out.println("文件写入成功并关闭写入流");
		return file.getAbsolutePath();//返回写入文件的绝对路径
		
	}
	public static void fisReade(String fileAbsolutePath)throws Exception{//文件读取
		File file = new File(fileAbsolutePath);
		FileInputStream fis = new FileInputStream(file);
		byte [] wordInByteArr = new byte[1024];
		int index = fis.read(wordInByteArr);//读取
		System.out.println("读取文件中的信息->"+new String(wordInByteArr,0,index));//输出
	}
	public static void f1()throws Exception{
		String fileAbsolutePath = fosWrite("D:/GitRespository/Java从入门到精通/FileDemo/word.txt","你好世界!");
		fisReade(fileAbsolutePath);
	}
	
	public static void main(String[] args) throws Exception{
		
	}
}
