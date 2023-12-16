package main.minigame.different;

import java.awt.Color;
import java.awt.Font;
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

import main.MainFrame;
import main.minigame.GameDialog;

public class ToryMain extends JFrame {

	final Tory left = new Tory("dif_img/1.jpg");
	final Tory right = new Tory("dif_img/2.jpg");
	JLabel click;

	static int[] imageX = { 150, 278, 205, 205, 310 };
	static int[] imageY = { 242, 242, 290, 333, 160 };
	static final int range = 30;
	private MainFrame mainFrame;
	private GameDialog gameDialog;

	public ToryMain(String string, MainFrame mainFrame, GameDialog gameDialog) {
		super(string);
		this.mainFrame = mainFrame;
		this.gameDialog = gameDialog;
		CustomMouseAdapter cma = new CustomMouseAdapter();
		left.setBounds(10, 10, 470, 541);
		left.addMouseListener(cma);
		right.setBounds(492, 10, 458, 620);
		right.addMouseListener(cma);
		getContentPane().setLayout(null);

		getContentPane().add(left);

		ClassLoader classLoader = getClass().getClassLoader();
		URL clickImg = classLoader.getResource("images/dif_img/check.png");
		URL toryimg1 = classLoader.getResource("images/dif_img/1.jpg");
		URL toryimg2 = classLoader.getResource("images/dif_img/2.png");
		left.setLayout(null);

		click = new JLabel();
		click.setIcon(new ImageIcon(clickImg));
		click.setSize(70, 70);
		right.add(click);

		JLabel leftimg = new JLabel("");
		leftimg.setBounds(6, 23, 458, 591);
		leftimg.setIcon(new ImageIcon(toryimg1));
		left.add(leftimg);

		JLabel lblNewLabel = new JLabel("틀린 토리 찾기");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 31));
		lblNewLabel.setBounds(92, 0, 372, 81);
		left.add(lblNewLabel);
		getContentPane().add(right);
		right.setLayout(null);

		JButton btnNewButton = new JButton("");
		URL btn = classLoader.getResource("images/btn_img/miniGameCloseBtn.png");
		URL btnhide = classLoader.getResource("images/btn_img/miniGameClosePushBtn.png");
		btnNewButton.setIcon(new ImageIcon(btn));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setPressedIcon(new ImageIcon(btnhide));
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(new Color(255, 0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.setTimeGo(true);
				dispose();
			}
		});
		btnNewButton.setBounds(358, 10, 100, 45);
		right.add(btnNewButton);
		getContentPane().add(right);
		right.setLayout(null);

		JLabel rightimg = new JLabel("");
		rightimg.setBounds(0, 10, 458, 620);
		rightimg.setIcon(new ImageIcon(toryimg2));
		right.add(rightimg);

		JLabel lblNewLabel_1 = new JLabel("힌트 5군데");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 31));
		lblNewLabel_1.setBounds(0, 0, 337, 70);
		right.add(lblNewLabel_1);

		setBounds(200, 100, 1000, 600);
		setResizable(false);
	}

	public void showGUI() {
		setVisible(true);
	}

	public boolean rangeof(int index, Point p) {
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
			if (rangeof(0, p)) {
				Tory.f1 = true; //
				left.repaint();
				right.repaint();

			} else if (rangeof(1, p)) {
				Tory.f2 = true;
				left.repaint();
				right.repaint();

			} else if (rangeof(2, p)) {
				Tory.f3 = true;
				left.repaint();
				right.repaint();

			} else if (rangeof(3, p)) {
				Tory.f4 = true;
				left.repaint();
				right.repaint();

			} else if (rangeof(4, p)) {
				Tory.f5 = true;
				left.repaint();
				right.repaint();

			} else if (p.x >= 40 && p.x <= 100 && p.y >= 450 && p.y <= 500) {
				JOptionPane.showMessageDialog(null, "어따 클릭하냐ㅋ");
				left.repaint();
				right.repaint();

			} else if (p.x >= 250 && p.x <= 500 && p.y >= 400 && p.y <= 550) {
				JOptionPane.showMessageDialog(null, "틀맀따 갈기지마라");
				left.repaint();
				right.repaint();
			}

			if (Tory.f1 == true && Tory.f2 == true && Tory.f3 == true && Tory.f4 == true && Tory.f5 == true) {
				JOptionPane.showMessageDialog(null, "축하합니다.");
				Tory.f1 = false;
				Tory.f2 = false;
				Tory.f3 = false;
				Tory.f4 = false;
				Tory.f5 = false;
				left.repaint();
				right.repaint();
				mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() + 10);
				mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
				mainFrame.getProjectEventImpl().expProgressBar(20);
				mainFrame.revalidate();
				mainFrame.repaint();
				mainFrame.getUsrInfo().setTory(true);
				mainFrame.setTimeGo(true);
				mainFrame.setProjectGo(true);
				dispose();
			}
		}
	}
}