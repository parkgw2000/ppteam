package main.active;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import guiDesign.Methods;
import main.MainFrame;

public class ActiveDialog extends JDialog {
	private JButton[] btn = new JButton[7];
	private MainFrame mainFrame;
	private ActiveEventTimer activeEventTimer; 
	
	public ActiveDialog(int x, int y, MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		activeEventTimer = mainFrame.getActiveEventTimer(); 
		
		setUndecorated(true);
		setModal(true);
		setBounds(x + 7, y + 30, 1185, 762);
		
		setBackground(new Color(0, 0, 0, 80));
		setLayout(null);
		
		// 상하차(0), 밥먹기, 게임하기, 잠자기, 담배피기, 이력서 작성, 뒤로(6)
		for (int i = 0; i < 7; i++) {
			btn[i] = new JButton(imageIcon(i));
			btn[i].setPressedIcon(imageIconPush(i));
			add(btn[i]);
			btn[i].setBorderPainted(false);
			btn[i].setFocusPainted(false);
			btn[i].setContentAreaFilled(false);
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Object command = e.getSource();
					for (int i = 0; i < 7; i++) {
						if (command == btn[i]) {
							active(i); // 버튼 입력값 -> 작동
						}
					}
					dispose();
				}
			});
		}
		btn[0].setBounds(470, 200, 100, 50);
		btn[1].setBounds(630, 200, 100, 50);
		btn[2].setBounds(400, 300, 100, 50);
		btn[3].setBounds(700, 300, 100, 50);
		btn[4].setBounds(400, 400, 100, 50);
		btn[5].setBounds(700, 400, 100, 50);
		btn[6].setBounds(500, 550, 200, 50);
		
		
		// +8 +30 -16 -38
//		setBounds(108, 130, 1184, 762);
	}
	
	public void showGUI() {
		setVisible(true);
	}
	
	// 추가
	public void active (int num) {
		switch (num) {
			case 0: // 쿠팡
				activeEventTimer.clearlbl();
				activeEventTimer.coupangTimer(150);
				break;
			case 1: // 밥
				activeEventTimer.clearlbl();
				activeEventTimer.eatTimer(60);
				break;
			case 2: // 게임
				activeEventTimer.clearlbl();
				activeEventTimer.gameTimer(60);
				break;
			case 3: // 잠
				activeEventTimer.clearlbl();
				activeEventTimer.sleepTimer(420);
				break;
			case 4: // 담배
				if (mainFrame.getUsrInfo().getCiga() > 0) {
					mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() - 1);
					mainFrame.getUsrInfo().setUsedCiga(mainFrame.getUsrInfo().getUsedCiga() + 1);
					mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
					mainFrame.getProjectEventImpl().expProgressBar(10);
					mainFrame.revalidate();
					mainFrame.repaint();
					activeEventTimer.clearlbl();
					activeEventTimer.smokeTimer(30);
				} else {
					JOptionPane.showMessageDialog(null, "아 담배 없다고~", "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 5: // 이력서
				activeEventTimer.clearlbl();
				activeEventTimer.resumeTimer(300);
				break;
			case 6:
				break;
			default:
				break;
		}
	}
	public ImageIcon imageIcon (int num) {
		switch (num) {
			case 0:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeCouPang.png");	
			case 1:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeEat.png");
			case 2:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeGame.png");
			case 3:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeSleep.png");
			case 4:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeSmokeing.png");
			case 5:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeWrite.png");
			case 6:
				return Methods.convertToIcon(getClass(), "images/btn_img/closeBtnImage.png");
			default:
				return null;
		}
	}
	public ImageIcon imageIconPush (int num) {
		switch (num) {
			case 0:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeCouPangPush.png");
			case 1:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeEatPush.png");
			case 2:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeGamePush.png");
			case 3:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeSleepPush.png");
			case 4:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeSmokeingPush.png");
			case 5:
				return Methods.convertToIcon(getClass(), "images/activeBtn_img/activeWritePush.png");
			case 6:
				return Methods.convertToIcon(getClass(), "images/btn_img/closeBtnPushImage.png");
			default:
				return null;
		}
	}
}
