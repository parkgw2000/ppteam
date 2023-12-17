package main.minigame.different;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hidee extends JPanel {

	private JLabel jlb1, jlb2;
	private ImageIcon img, img2;

	static boolean f1 = false;
	static boolean f2 = false;
	static boolean f3 = false;
	static boolean f4 = false;
	static boolean f5 = false;
	static boolean f6 = false;
	static boolean f7 = false;

	public Hidee(String imageFile) {
		img = new ImageIcon(imageFile);
		jlb1 = new JLabel(img);
		add(jlb1);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.RED);
		if (f1 == true) {
			g.drawOval(240, 408, 50, 50);
		}
		if (f2 == true) {
			g.drawOval(500, 350, 50, 50);
		}
		if (f3 == true) {
			g.drawOval(368, 143, 50, 50);
		}
		if (f4 == true) {
			g.drawOval(568, 340, 50, 50);
		}
		if (f5 == true) {
			g.drawOval(430, 405, 50, 50);
		}
		if (f6 == true) {
			g.drawOval(220, 350, 50, 50);
		}
		if (f7 == true) {
			g.drawOval(580, 520, 50, 50);
		}
	}
}