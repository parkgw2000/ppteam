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

import guiDesign.Methods;
import login.LoginEvent;
import login.LoginFrame;
import main.MainFrame;

public class Menual1 extends JDialog {
	public Menual1(int x, int y) {
		setBounds(x + 7, y + 30, 1000, 800);
		setUndecorated(true);
		setModal(true);
		setBackground(new Color(0, 0, 0, 255));
		
		
		ClassLoader classloader = getClass().getClassLoader();
		URL next = classloader.getResource("images/manualBtn_img/NextBtn.png");
		URL first = classloader.getResource("images/manualBtn_img/FirstBtn.png");
		
		JPanel pnl = new JPanel();
		pnl.setBackground(new Color(0, 0, 0, 255));
		pnl.setBounds(0, 0, 1000, 800);
		pnl.setLayout(null);
		getContentPane().add(pnl);
		
		JButton nextBtn = new JButton("");
		nextBtn.setBounds(908, 10, 80, 50);
		nextBtn.setIcon(new ImageIcon(next));
		nextBtn.setBackground(new Color(255, 0, 0, 0));
		nextBtn.setContentAreaFilled(false);
		nextBtn.setBorderPainted(false);
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menual2 manual2 = new Menual2(x, y);
				manual2.showGUI();
				dispose();
			}
		});
		pnl.add(nextBtn);
		

		JLabel manual = new JLabel("");
		
		manual.setIcon(Methods.convertToIcon(getClass(), "images/back_img/Manual1.png"));
		manual.setBounds(0, 0, 1000, 800);
		pnl.add(manual);
		
	}
	
	public void showGUI() {
		setVisible(true);
	}
}
