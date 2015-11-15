package java核心技术の线程;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class SleepDemo extends JFrame{
	
	Thread thread;
	Color [] color = {Color.black,Color.blue,Color.cyan,Color.green,Color.orange,Color.yellow,
					  Color.red,Color.lightGray};
	Random random = new Random();
	
	Color getColor(){
		return color[random.nextInt(color.length)];
	}
	public SleepDemo(){
		thread = new Thread(new Runnable() {
			int x=30;
			int y=50;
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					Graphics graphics=getGraphics();
					graphics.setColor(getColor());
					graphics.drawLine(x, y, 250, y++);
					if(y>=250){
						y=50;
					}
				}
			}
		});
		thread.start();
	}
	static void initUI(JFrame jframe,int w,int h){
		jframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jframe.setSize(w,h);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	public static void main(String[] args) {
		initUI(new SleepDemo(),300,300);
	}

}
