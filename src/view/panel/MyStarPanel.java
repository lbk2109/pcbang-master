package view.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyStarPanel extends JPanel implements Runnable {
	Image img;
	int i = 1;
	int sleep = 20;
	int sx = 62, sy=0;

	public MyStarPanel() {
		img = Toolkit.getDefaultToolkit().createImage("img/starDdong.png");
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(img!=null) g.drawImage(img, sx, sy, this);
	}

	@Override
	public void run() {
		try {
			do {
				Thread.sleep(sleep);
				switch (i) {
				case 1: sy+=2; if(sy>671) i=2; break;
				case 2: sx+=2; if(sx>1282) i=3; break;
				case 3: sy-=2; if(sy<43) i=4; break;
				case 4: sx-=2; if(sx<62) i=1; break;
				}
				repaint();
			} while (true);
		} catch (Exception e) {
			System.out.println("무슨 에런지참. ");
		}
	}
}