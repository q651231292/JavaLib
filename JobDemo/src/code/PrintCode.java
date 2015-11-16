package code;



import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.MalformedURLException;
import java.net.URL;

public class PrintCode implements Printable {

	static String path;

	/**
	 * 
	 * @方法名称: print
	 * @功能描述:
	 * @作者:任冠宇
	 * @创建时间:2015年11月11日 下午3:56:05
	 * @param gra 指明打印的图形环境
	 * @param pf 指明打印页格式（页面大小以点为计量单位，1点为1英才的1/72，1英寸为25.4毫米。A4纸大致为595×842点）
	 * @param pageIndex 指明页号
	 * @return
	 * @throws PrinterException
	 * @see java.awt.print.Printable#print(java.awt.Graphics, java.awt.print.PageFormat, int)
	 */
	public int print(Graphics gra, PageFormat pf, int pageIndex)throws PrinterException {
		Component c = null;
		// 转换成Graphics2D
		Graphics2D g2 = (Graphics2D) gra;
		// 打印起点坐标
		double x = pf.getImageableX();
		double y = pf.getImageableY();
//		System.out.println(x);
//		System.out.println(y);
		switch (pageIndex) {
		case 0:
			float[] dash1 = { 2.0f };
			// 设置打印线的属性。
			// 1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量
			g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
			Image src = null;
			try {
				src = Toolkit.getDefaultToolkit().getImage(new URL(path));
			} catch (MalformedURLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			//g2.drawImage(src, (int) x, (int) y, c);
			g2.drawImage(src, 0, 0, 140, 50, 0, 0, 189, 80, null);
			int img_Height = src.getHeight(c);
			int img_width = src.getWidth(c);
			//System.out.println("img_Height=" + img_Height + "img_width="+ img_width);
			return PAGE_EXISTS;
		default:
			return NO_SUCH_PAGE;
		}
	}
	/**
	 * 
	 * @方法名称: printCode
	 * @功能描述: 打印条码
	 * @作者:任冠宇
	 * @创建时间:2015-11-4 下午3:12:41
	 * @param codePath
	 * @throws PrinterException void
	 */
	public static void printCode(String codePath) throws PrinterException {
		path=codePath;
		//System.out.println("Start printCode,path="+path);
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(189, 80);// 纸张大小 //高不能超过80 否则会出现两页
		// 设置paper可成像区域 成像区域多大paper就是多大
		p.setImageableArea(0, 0, 189, 80);// A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PrintCode(), pf);
		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);
		// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
		//boolean flag = job.printDialog();
		//if (flag) {
		job.print();
		//}
	}
}