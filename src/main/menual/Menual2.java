package main.menual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import guiDesign.MyPassword;
import guiDesign.MyTextField;
import login.LoginFrame;

public class Menual2 extends JDialog {
	public Menual2(int x, int y) {
		setBounds(x + 7, y + 30, 1000, 800);
		setUndecorated(true);
		setModal(true);
		setBackground(new Color(0, 0, 0, 255));
		
		ClassLoader classloader = getClass().getClassLoader();
		URL start = classloader.getResource("images/manualBtn_img/FirstBtn.png");
		URL prev = classloader.getResource("images/manualBtn_img/PrevBtn.png");
		URL background = classloader.getResource("images/back_img/Manual2.png");
		
		JPanel pnl = new JPanel();
		pnl.setBackground(new Color(0, 0, 0, 255));
		pnl.setBounds(0, 0, 1000, 800);
		pnl.setLayout(null);
		getContentPane().add(pnl);
		
		JButton prevBtn = new JButton("");
		prevBtn.setBounds(12, 10, 80, 50);
		prevBtn.setIcon(new ImageIcon(prev));
		prevBtn.setBackground(new Color(255, 0, 0, 0));
		prevBtn.setContentAreaFilled(false);
		prevBtn.setBorderPainted(false);
		prevBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menual1 manual1 = new Menual1(x, y);
				manual1.showGUI();
				dispose();
			}
			
		});
		pnl.add(prevBtn);
		
		JButton startBtn = new JButton("");
		startBtn.setBounds(904, 11, 80, 50);
		startBtn.setIcon(new ImageIcon(start));
		startBtn.setBackground(new Color(255, 0, 0, 0));
		startBtn.setContentAreaFilled(false);
		startBtn.setBorderPainted(false);
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				LoginFrame loginFrame = new LoginFrame();
//				loginFrame.showGUI();
				dispose();
			}
		});
		pnl.add(startBtn);
		
		
		JLabel manual = new JLabel("");
		manual.setIcon(new ImageIcon(background));
		manual.setBounds(0, 0, 1000, 800);
		pnl.add(manual);
		
	}
	
	public void showGUI() {
		setVisible(true);
	}
}
