package main.suddenQuestion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import guiDesign.Methods;
import main.MainFrame;

public class Basunsaeng {
	private int x;
	private int y;
	private JLabel cockroachImage;
	private int count;
	private Timer timer;
	private boolean go;
	private int touch;
	private JLabel msg;
	private JLabel lblTimer;
	private int time;
	private boolean start;
	private Timer clock;

	public Basunsaeng() {
		
	}
	
	public void DecorCusor(MainFrame mainFrame, String imageName) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		ClassLoader classLoader = getClass().getClassLoader();
		Image cursorimage = tk.getImage(classLoader.getResource(imageName));
		cursorimage = cursorimage.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
		Point point = new Point(0, 0);
		Cursor cursor = tk.createCustomCursor(cursorimage, point, "mangchi");
		mainFrame.setCursor(cursor);
	}
	
	public void Basunsaeng(MainFrame mainFrame) {
		mainFrame.setTimeGo(false);
		mainFrame.setProjectGo(false);
		
		DecorCusor(mainFrame, "images/event/mangchi.png");
		
		mainFrame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DecorCusor(mainFrame, "images/event/mangchi1.png");
				if (go) {
					mainFrame.removeMouseListener(this);
					mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					go = false;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				DecorCusor(mainFrame, "images/event/mangchi.png");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		
		lblTimer = new JLabel("50");
		lblTimer.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		lblTimer.setBounds(580, 0, 60, 60);
		mainFrame.add(lblTimer);
		
		msg = new JLabel("우웩 바번생이 나타났어용!!.");
		msg.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		msg.setForeground(Color.red);
		msg.setBounds(380, 300, 700, 45);
		mainFrame.add(msg);
		
		
		touch = 0;
		cockroachImage = new JLabel(Methods.convertToResizeIcon(getClass(), "images/event/cockroach.png", 100, 100));
		cockroachImage.setBounds(0, 0, 100, 100);
		cockroachImage.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				touch++;
				if (touch == 10) {
					timer.stop();
					mainFrame.remove(cockroachImage);
					mainFrame.remove(lblTimer);
					mainFrame.remove(msg);
					mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					mainFrame.revalidate();
					mainFrame.repaint();
					count = 0;
					touch = 0;
					mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() + 3);
					mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
					mainFrame.getProjectEventImpl().expProgressBar(30);
					go = true;					
					mainFrame.setTimeGo(true);
					mainFrame.setProjectGo(true);
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		mainFrame.add(cockroachImage);
		
		Random random = new Random();
		count = 0;
		time = 50;
		start = false;
		go = false;

		timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!start) {
					try {
						Thread.sleep(1000);
						msg.setText("시간 안에 바선생10번 잡으면 win!!");
						mainFrame.revalidate();
						mainFrame.repaint();
						start = true;
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
				count++;
				x = 100 + random.nextInt(800);
				y = random.nextInt(600);
				cockroachImage.setLocation(x, y);
				
				if (count >= 100) {
					timer.stop();
					mainFrame.remove(cockroachImage);
					mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					mainFrame.revalidate();
					mainFrame.repaint();
					int stress = mainFrame.getStressbar().getValue() + 30;
					if (stress >= 100) {
						mainFrame.getStressbar().setValue(100);
					} else {
						mainFrame.getStressbar().setValue(stress);
					}
					count = 0;
					go = true;
					mainFrame.setTimeGo(true);
					mainFrame.setProjectGo(true);
				}
			}
		});
		
		clock = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (time <= 0) {
					clock.stop();
					mainFrame.remove(lblTimer);
					mainFrame.remove(msg);
					mainFrame.revalidate();
					mainFrame.repaint();
				}
				lblTimer.setText(String.valueOf(time));
				mainFrame.revalidate();
				mainFrame.repaint();
				time--;
			}
		});
		
		timer.start();
		clock.start();
	}
}