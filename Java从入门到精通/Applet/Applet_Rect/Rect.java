import java.awt.*;
import java.applet.*;
public class Rect extends Applet //继承Appelet类，这是Applet Java程序的特点
{
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawRect(0,0,250,100);
	}
}