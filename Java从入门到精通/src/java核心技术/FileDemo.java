package java核心技术;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {


	public static void fun1() throws Exception{//文件基础操作
		File file = new File("D:/Eclipse WorkSpace 1.1/Java从入门到精通/FileDemo/word.txt");
		if(file.exists()){//是否存在
			file.delete();//删除
			System.out.println("File deleted");
		}else{
			file.createNewFile();//创建
			System.out.println("File created");
		}
	}
	public static String mkDir(String fileName) throws Exception{//创建文件夹
		File dirFileDemo = new File(fileName);
		if(dirFileDemo.exists()){
			String absolutePath =dirFileDemo.getAbsolutePath();//绝对路径
			System.out.println("文件夹已存在,路径->"+absolutePath);
			return absolutePath;
		}else{
			dirFileDemo.mkdir();
			String absolutePath = dirFileDemo.getAbsolutePath();//绝对路径
			System.out.println("文件夹不存在,但是已经创建,创建路径->"+absolutePath);
			return absolutePath;
		}
	}
	public static String mkFile(String filePath,String fileName)throws Exception{//创建文件
		File wordTxt = new File(filePath+"/"+fileName);
		if(wordTxt.exists()){
			String absolutePath = wordTxt.getAbsolutePath();//绝对路径
			System.out.println("文件已存在,路径->"+absolutePath);
			return absolutePath;
		}else{
			wordTxt.createNewFile();
			String absolutePath = wordTxt.getAbsolutePath();//绝对路径
			System.out.println("文件不存在,但是已经创建,路径->"+absolutePath);
			return absolutePath;
		}
	}
	public static void getFileInfo(String fileAbsolutePath)throws Exception{
		File file = new File(fileAbsolutePath);
		if(file.exists()){
			String fileName = file.getName();//文件名
			System.out.println("文件名->"+fileName);
			long fileLength = file.length();
			System.out.println("文件长度->"+fileLength);//文件长度
			boolean fileHidden = file.isHidden();
			System.out.println("文件是否隐藏->"+fileHidden);//文件是否隐藏
			boolean fileCanRead = file.canRead();//文件是否可读
			System.out.println("文件是否可读"+fileCanRead);
			boolean fileCanWrite = file.canWrite();//文件是否可写
			System.out.println("文件是否可写"+fileCanWrite);
			String fileParentPath=file.getParent();//文件的父节点的绝对路径
			System.out.println("文件的父路径"+fileParentPath);
			Date fileLastModTime = new Date(file.lastModified());//最后一次修改文件的时间
			System.out.println("文件最后一次修改的时间"+fileLastModTime);
		}else{
			System.out.println("文件不存在");
		}
	}
	public static void fun2()throws Exception{//创建文件夹/文件
		String dirAbsolutePath= mkDir("FileDemo");//创建文件夹
		System.out.println("返回文件夹绝对路径->"+dirAbsolutePath);
		String fileAbsulutePath = mkFile(dirAbsolutePath,"word.txt");//创建文件
		System.out.println("返回文件绝对路径->"+fileAbsulutePath);
		getFileInfo(fileAbsulutePath);//显示文件信息
	}
	public static void fun3(){
		
	}
	public static void main(String[] args) throws Exception {
		fun2();
	}
}
