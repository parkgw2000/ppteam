package main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import database.controllDB.UpdateDB;
import guiDesign.ImgPanel;
import guiDesign.Methods;
import main.MainFrame;

public class DeathStudying extends JDialog {
	private MainFrame mainFrame;
	private ImgPanel contentPane;
	
	public DeathStudying(int x, int y, MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		mainFrame.setTimeGo(false);
		mainFrame.setProjectGo(false);
		mainFrame.stopSound();
		mainFrame.getUsrInfo().setGameover(true);
		mainFrame.getGameControllerImpl().saveUsrRank();
		UpdateDB.updateUsrInfo(mainFrame.getUsrInfo());
		
		getContentPane().setLayout(null);
		setUndecorated(true);
		setModal(true);
		setBounds(x, y, 1200, 800);
		setBackground(new Color(0, 0, 0, 100));
		
		contentPane = new ImgPanel(Methods.converImage(getClass(), "images/back_img/DeathBackground.png"));
		contentPane.setBounds(0, 0, 1200, 800);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		
		JButton returnBtn = new JButton("다시하기");
		returnBtn.setBounds(1030, 698, 146, 53);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainFrame.getPb().getClockHp() != null) {
					mainFrame.getPb().getClockHp().cancel();
				}
				if (mainFrame.getPb().getClockStrs() != null) {
					mainFrame.getPb().getClockStrs().cancel();
				}
				if (mainFrame.getPb().getClockHeal() != null) {
					mainFrame.getPb().getClockHeal().cancel();
				}
				if (mainFrame.getGameControllerImpl().getCurrentTime() != null) {
					mainFrame.getGameControllerImpl().getCurrentTime().cancel();
				}
				int userId = mainFrame.getUsrId();
				mainFrame.dispose();
				MainFrame mainFrameNew = new MainFrame(userId);
				dispose();
				mainFrameNew.showGUI();
			}
		});
		
		JButton finishBtn = new JButton("게임종료");
		finishBtn.setBounds(27, 698, 146, 53);
		finishBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		contentPane.add(finishBtn);
		contentPane.add(returnBtn);
	}
	
	public void showGUI() {
		setVisible(true);
	}
}
