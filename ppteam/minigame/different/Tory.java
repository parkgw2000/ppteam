package main.minigame.different;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tory extends JPanel {

	private JLabel jlb1, jlb2;
	private ImageIcon img, img2;

	// 틀린그림
	static boolean f1 = false;
	static boolean f2 = false;
	static boolean f3 = false;
	static boolean f4 = false;
	static boolean f5 = false;

	public Tory(String imageFile) {
		img = new ImageIcon(imageFile);
		jlb1 = new JLabel(img);
		add(jlb1);
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		if (f1 == true) {
			g.drawOval(150, 242, 50, 50);
		}
		if (f2 == true) {
			g.drawOval(278, 242, 50, 50); 
		}
		if (f3 == true) {
			g.drawOval(205, 290, 50, 50); 
		}
		if (f4 == true) {
			g.drawOval(205, 333, 50, 50); 
		}
		if (f5 == true) {
			g.drawOval(310, 160, 50, 50);
		}
	}
}