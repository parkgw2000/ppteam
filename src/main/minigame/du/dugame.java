package main.minigame.du;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.sql.rowset.CachedRowSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import guiDesign.Methods;
import main.MainFrame;

public class dugame extends JFrame implements ActionListener, Runnable {
//   ImageIcon ii = new ImageIcon("character.gif");
	private JButton jbt[] = new JButton[9];
	private JButton start = new JButton(" ");
	private JButton end = new JButton(" ");
	private JLabel scorelbl = new JLabel("점수 : 0");
	private JLabel timelbl = new JLabel("시간 > 0:30");
	private BorderLayout boarderlay = new BorderLayout(5, 5);
	private JPanel pnl = new JPanel();
	private GridLayout gridlay = new GridLayout(3, 3);
	private JPanel pnl2 = new JPanel();
	private GridLayout gridlay2 = new GridLayout(1, 2);
	private JPanel pnl3 = new JPanel();
	private FlowLayout flowlay = new FlowLayout(FlowLayout.RIGHT);
	private int randomsu = 0;
	private int count = -1;
	private ClassLoader classLoader = getClass().getClassLoader();
	private URL duimg = classLoader.getResource("images/du_img/2.png");

	private URL pressed = classLoader.getResource("images/du_img/1.png");
	private URL out = classLoader.getResource("images/du_img/33.png");
	private URL in = classLoader.getResource("images/du_img/22.png");
	private JLabel cusorimage;
	private boolean go;
	private int touch;
	private MainFrame mainFrame;

	public dugame(String title, MainFrame mainFrame) {
		super(title);
		this.mainFrame = mainFrame;
		this.init();
		this.start();
		super.setBounds(200, 100, 1000, 800);
		super.setResizable(false);
		super.setVisible(true);
		start.setIcon(new ImageIcon(in));
		end.setIcon(new ImageIcon(out));
		start.setBorderPainted(false);
		end.setBorderPainted(false);
		start.setBorder(null);
		end.setBorder(null);
		pnl3.setBackground(new Color(255, 0, 0, 0));
		pnl3.setOpaque(false);
		start.setContentAreaFilled(false);
		end.setContentAreaFilled(false);
		this.cockroach();

		JLabel imglbl = new JLabel("");
		imglbl.setBounds(0, 20, 1000, 710);
		imglbl.setIcon(Methods.convertToIcon(getClass(), "images/du_img/back.png"));
		this.getContentPane().add(imglbl);

	}

	public void init() {
		Container con = this.getContentPane();
		con.setLayout(boarderlay);
		con.add("North", timelbl);
		con.add("Center", pnl);
		pnl.setLayout(gridlay);
		pnl.setOpaque(false);
		pnl.setBackground(new Color(255, 0, 0, 0));
		for (int i = 0; i < 9; ++i) {
			jbt[i] = new JButton();
			pnl.add(jbt[i]);
			jbt[i].setBorderPainted(false);
			jbt[i].setOpaque(false);
			jbt[i].setBackground(new Color(255, 0, 0, 0));

		}
		off_button();
		con.add("South", pnl2);
		pnl2.setLayout(gridlay2);
		pnl2.add(scorelbl);
		pnl2.add(pnl3);
		pnl3.setLayout(flowlay);
		pnl3.add(start);
		pnl3.add(end);
		pnl3.setBackground(new Color(255, 0, 0, 0));

	}

	public void start() {
		start.addActionListener(this);
		end.addActionListener(this);
		for (int i = 0; i < 9; ++i) {
			jbt[i].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			timelbl.setText("시간 >  0:30");
			scorelbl.setText("점수 : 0");
			count = -1;
			Thread th = new Thread(this);
			th.start();
			on_button();
			random(0);
		} else if (e.getSource() == end) {
			mainFrame.setTimeGo(true);
			dispose();
		}
		for (int i = 0; i < 9; ++i) {
			if (e.getSource() == jbt[i]) {
				random(i);
			}
		}
	}

	public void off_button() {
		for (int i = 0; i < 9; ++i) {
			jbt[i].setEnabled(false);
		}
	}

	public void on_button() {
		for (int i = 0; i < 9; ++i) {
			jbt[i].setEnabled(true);
		}
	}

	public void run() {
		int time = 30;
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			time--;
			if (time == 0) {
				timelbl.setText("GAME OVER");
				off_button();
				if (count > 60) {
					mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() + 2);
					mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
					mainFrame.getProjectEventImpl().expProgressBar(10);
					mainFrame.revalidate();
					mainFrame.repaint();
				} else if (count > 100) {
					mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() + 5);
					mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
					mainFrame.getProjectEventImpl().expProgressBar(30);
					mainFrame.revalidate();
					mainFrame.repaint();
				}
				break;
			}
			timelbl.setText("시간  0:" + time);
		}
	}

	public void random(int i) {
		if (i != randomsu)
			return;
		count++;
		jbt[randomsu].setIcon(null);
		randomsu = (int) (Math.random() * 9);
		jbt[randomsu].setIcon(new ImageIcon(duimg));
		scorelbl.setText("점수 : " + count);
		jbt[randomsu].setBorderPainted(false);
		jbt[randomsu].setOpaque(false);
		jbt[randomsu].setBackground(new Color(255, 0, 0, 0));
		jbt[randomsu].setPressedIcon(new ImageIcon(pressed));
		jbt[randomsu].setBorderPainted(false);
		jbt[randomsu].setContentAreaFilled(false);
		jbt[randomsu].setFocusable(false);
		
	}

	public void DecorCusor(JPanel pnl, String imageName) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		ClassLoader classLoader = getClass().getClassLoader();
		Image cursorimage = tk.getImage(classLoader.getResource(imageName));
		cursorimage = cursorimage.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
		Point point = new Point(0, 0);
		Cursor cursor = tk.createCustomCursor(cursorimage, point, "mangchi");
		pnl.setCursor(cursor);
	}

//
	public void cockroach() {
		DecorCusor(pnl, "images/du_img/mang.png");

		pnl.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DecorCusor(pnl, "images/du_img/mang.png");
				if (go) {
					pnl.removeMouseListener(this);
					pnl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					go = false;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
//				DecorCusor(pnl, "123.png");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		touch = 0;
		cusorimage = new JLabel(convertToIcon(getClass(), "images/du_img/mang.png", 500, 500));
	}

	public void expProgressBar(int addExp) {
		int levelExp = mainFrame.getUsrInfo().getLevel() * 100;
		int charExp = mainFrame.getExpbar().getValue();
		int input = (int) (charExp + (((double) addExp / (double) levelExp) * 100));
		if (input >= 100) {
			int level = Integer.valueOf(mainFrame.getLevellbl().getText());
			mainFrame.getLevellbl().setText(String.valueOf(level + 1));
			mainFrame.getUsrInfo().setLevel(level + 1);
			mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() + 10);
			mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
			int hp = mainFrame.getHpbar().getValue() + 30;
			int stress = mainFrame.getStrsBar().getValue() - 30;
			int health = mainFrame.getHealbar().getValue() + 30;
			if (hp >= 100) {
				mainFrame.getHpbar().setValue(100);
			} else {
				mainFrame.getHpbar().setValue(hp);
			}
			if (stress <= 100) {
				mainFrame.getStressbar().setValue(0);
			} else {
				mainFrame.getStressbar().setValue(stress);
			}
			if (health >= 100) {
				mainFrame.getHealbar().setValue(100);
			} else {
				mainFrame.getHealbar().setValue(health);
			}
			
			double a = ((double) level / (double) (level + 1));
			input = (int) ((input - 100) * a);
			mainFrame.getExpbar().setValue(input);
		} else {
			mainFrame.getExpbar().setValue(input);
		}
	}
	
	public static ImageIcon convertToIcon(Class useClass, String name, int width, int height) {
		String imageName = name;
		int thisWidth = width;
		int thisHeight = height;
		Toolkit kit = Toolkit.getDefaultToolkit();
		ClassLoader classLoader = useClass.getClassLoader();
		try {
			Image image = kit.getImage(classLoader.getResource(imageName));
			image = image.getScaledInstance(thisWidth, thisHeight, Image.SCALE_SMOOTH);
			// 이미지크기조절
			ImageIcon icon = new ImageIcon(image);
			return icon;
		} catch (NullPointerException e) {
			System.out.println(name + " 해당 이미지 파일을 찾을 수 없습니다.");
		}
		return null;
	}

	public void showGUI() {
		setVisible(true);
	}
}
