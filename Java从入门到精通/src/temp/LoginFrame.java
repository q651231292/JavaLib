package temp;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginFrame extends JFrame {

	public LoginFrame(){
		initUI();
	}

	public void initUI() {
		setContentPane(new DrawPanel());
		setSize(300, 300);//300*300
		setVisible(true);//可视
		setLocationRelativeTo(null);//居中
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//关闭
	}

	class DrawPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			g.drawOval(10, 10, 80, 80);
			g.drawOval(80, 10, 80, 80);
			g.drawOval(150, 10, 80, 80);
			g.drawOval(50, 70, 80, 80);
			g.drawOval(120, 70, 80, 80);
		}
	}
}
