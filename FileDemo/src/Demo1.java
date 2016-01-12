
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse("1993-06-04 13:01:01");
		int i = judgeAp(d);
		System.out.println(i);
	}

	/**
	 * 
	 * @方法名称: judgeAp
	 * @功能描述: 输入日期,可以判断是上午还是下午
	 * @作者:任冠宇
	 * @创建时间:2015年12月24日 下午2:26:58
	 * @param date 输入一个日期
	 * @return int 0是上午,1是下午
	 */
	public static int judgeAp(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strDate = sdf.format(date);
		String[] strDates = strDate.split("-");
		String year = strDates[0];
		String month = strDates[1];
		String day = strDates[2];
		String hour = strDates[3];
		String minute = strDates[4];
		String second = strDates[5];
		Integer Y = Integer.parseInt(year);
		Integer M = Integer.parseInt(month);
		Integer D = Integer.parseInt(day);
		Integer h = Integer.parseInt(hour);
		Integer m = Integer.parseInt(minute);
		Integer s = Integer.parseInt(second);
		GregorianCalendar ca = new GregorianCalendar(Y, M, D, h, m, s);
		return ca.get(GregorianCalendar.AM_PM);
	}

	static void fun4(String dirPath) {
		File dirFile = new File(dirPath);
		if (dirFile.isDirectory()) {
			System.out.println("文件夹->" + dirFile);
			String[] dirFileList = dirFile.list();
			for (String file : dirFileList) {
				File ziFile = new File(dirPath + "/" + file);
				if (ziFile.isDirectory()) {
					fun4(dirPath + "/" + file);
				} else {
					if (file.contains("c")) {
						System.out.println("文件:" + file);
					}
				}

			}
		}
	}

	static void fun3(String path, String filePath) throws Exception {
		path = "a/b/";
		filePath = "c.txt";
		File f1 = new File(path);
		if (!f1.isDirectory()) {
			f1.mkdirs();
		}
		if (!new File(path + filePath).isFile()) {
			new File(path + filePath).createNewFile();
		}

	}

	static void createDir(String dir, String file) throws IOException {
		if (!new File(dir).isDirectory()) {
			new File(dir).mkdirs();
		} else {
			new File(dir + file).createNewFile();
		}
	}

	static void getFileNameAll(String folder) {
		File f1 = new File(folder);
		if (f1.isDirectory()) {
			System.out.println("dir->" + folder);
			String[] files = f1.list();
			for (String file : files) {
				File f2 = new File(folder + "/" + file);
				if (f2.isDirectory()) {
					getFileNameAll(folder + "/" + file);
				} else {
					System.out.println("file:" + file);
				}
			}
		}

	}

	static void fun2(String path) {
		String dirname = path;// "d:/";
		File f1 = new File(dirname);
		if (f1.isDirectory()) {
			System.out.println("Directory of " + dirname);
			String s[] = f1.list();
			for (int i = 0; i < s.length; i++) {
				File f = new File(dirname + "/" + s[i]);
				if (f.isDirectory()) {
					fun2(dirname + "/" + s[i]);
					System.out.println(s[i] + " is a directory");
				} else {
					System.out.println(s[i] + " is a file");
				}
			}
		} else {
			System.out.println(dirname + " is not a directory");
		}
	}

	void fun1() throws Exception {
		File f = new File("b.txt");
		FileOutputStream fop = new FileOutputStream(f);
		// 构建FileOutputStream对象,文件不存在会自动新建

		OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
		// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

		writer.append("中文输入");
		// 写入到缓冲区

		writer.append("\r\n");
		// 换行

		writer.append("English");
		// 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

		writer.close();
		// 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

		fop.close();
		// 关闭输出流,释放系统资源

		FileInputStream fip = new FileInputStream(f);
		// 构建FileInputStream对象

		InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
		// 构建InputStreamReader对象,编码与写入相同

		StringBuffer sb = new StringBuffer();
		while (reader.ready()) {
			sb.append((char) reader.read());
			// 转成char加到StringBuffer对象中
		}
		System.out.println(sb.toString());
		reader.close();
		// 关闭读取流

		fip.close();
		// 关闭输入流,释放系统资源
	}
}
