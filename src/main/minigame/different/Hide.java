package main.minigame.different;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import guiDesign.Methods;
import main.MainFrame;
import main.minigame.GameDialog;

public class Hide extends JFrame {

	final Hidee center = new Hidee("");
	JLabel click;

	static int[] imageX = { 240, 500, 368, 568, 430, 220, 580 };
	static int[] imageY = { 408, 350, 143, 340, 405, 350, 520 };
	static final int range = 40;

	private MainFrame mainFrame;
	private GameDialog gameDialog;

	public Hide(String string, MainFrame mainFrame, GameDialog gameDialog) {
		super(string);
		this.mainFrame = mainFrame;
		this.gameDialog = gameDialog;

		ClassLoader classLoader = getClass().getClassLoader();

		center.setBounds(0, 0, 694, 951);
		center.setBackground(Color.white);
		CustomMouseAdapter cma = new CustomMouseAdapter();
		center.addMouseListener(cma);
		getContentPane().setLayout(null);
		center.setLayout(null);

		click = new JLabel();
		click.setIcon(Methods.convertToIcon(getClass(), "images/dif_img/check.png"));
		click.setSize(70, 70);
		center.add(click);

		JLabel leftimg = new JLabel("");
		leftimg.setIcon(Methods.convertToIcon(getClass(), "images/dif_img/1234.PNG"));
		leftimg.setBounds(28, -24, 611, 951);
		center.add(leftimg);

		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/miniGameCloseBtn.png"));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setPressedIcon(Methods.convertToIcon(getClass(), "images/btn_img/miniGameClosePushBtn.png"));
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(new Color(255, 0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.setTimeGo(true);
				dispose();
			}
		});
		btnNewButton.setBounds(537, 900, 100, 45);
		center.add(btnNewButton);
		setBounds(500, 0, 700, 1000);
		setResizable(false);
		setVisible(true);

		getContentPane().add(center);
		setBounds(500, 0, 700, 980);
		setResizable(false);
		setVisible(true);
	}

	public void showGUI() {
		setVisible(true);
	}

	public boolean isRangeof(int index, Point p) {

		int pointX = p.x;

		int pointY = p.y;

		return (pointX >= imageX[index] - range) && (pointX <= imageX[index] + range)
				&& (pointY >= imageY[index] - range) && (pointY <= imageY[index] + range);
	}

	class CustomMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			click.setLocation(x - 20, y - 20);
		}

		public void mouseReleased(MouseEvent e) {
			Point p = e.getPoint();
			if (isRangeof(0, p)) {
				Hidee.f1 = true; //
				center.repaint();

			} else if (isRangeof(1, p)) {
				Hidee.f2 = true;
				center.repaint();

			} else if (isRangeof(2, p)) {
				Hidee.f3 = true;
				center.repaint();

			} else if (isRangeof(3, p)) {
				Hidee.f4 = true;
				center.repaint();

			} else if (isRangeof(4, p)) {
				Hidee.f5 = true;
				center.repaint();

			} else if (isRangeof(5, p)) {
				Hidee.f6 = true;
				center.repaint();
			} else if (isRangeof(6, p)) {
				Hidee.f7 = true;
				center.repaint();
			}

			if (Hidee.f1 == true && Hidee.f2 == true && Hidee.f3 == true && Hidee.f4 == true && Hidee.f5 == true
					&& Hidee.f6 == true && Hidee.f7 == true) {
				JOptionPane.showMessageDialog(null, "축하합니다.");
				Hidee.f1 = false;
				Hidee.f2 = false;
				Hidee.f3 = false;
				Hidee.f4 = false;
				Hidee.f5 = false;
				Hidee.f6 = false;
				Hidee.f7 = false;
				center.repaint();
				mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() + 10);
				mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
				mainFrame.getProjectEventImpl().expProgressBar(20);
				mainFrame.revalidate();
				mainFrame.repaint();
				mainFrame.getUsrInfo().setHide(true);
				mainFrame.setTimeGo(true);
				mainFrame.setProjectGo(true);
				dispose();
			}
		}
	}

}// end