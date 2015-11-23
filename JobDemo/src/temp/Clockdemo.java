
package temp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Date;

import javax.swing.JApplet;

public class Clockdemo extends JApplet implements Runnable {
	Thread clock;

	public void init() {
		stop();
		if (clock == null) {
			clock = new Thread(this);
			clock.start();
		}
	}

	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public void stop() {
		clock = null;
	}

	public void paint(Graphics g) {
		String s = "";

		Date now = new Date();
		int hour = now.getHours();
		int minute = now.getMinutes();
		int second = now.getSeconds();
		s = hour + ":" + minute + ":" + second;
		g.setColor(Color.darkGray);
		Dimension dim = getSize();
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.red);
		g.drawString(s, 20, 80);
	}
}
