package main.setting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import login.AccountDelete;
import login.LoginFrame;
import main.MainFrame;
import main.menual.Menual1;

public class SettingDialog extends JDialog {

	private JPanel contentPane;
	private boolean loginFrame;
	public boolean getLoginFrame() {
		return loginFrame;
	}

	public SettingDialog(int x, int y, MainFrame mainFrame) {
		
		setBounds(x + 7, y + 30, 1185, 762);
		setUndecorated(true);
		setModal(true);
		setBackground(new Color(0,0,0,100));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 0, 0, 0));

		JLabel settinglbl = new JLabel("환경설정");
		settinglbl.setHorizontalAlignment(SwingConstants.CENTER);
		settinglbl.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		settinglbl.setBounds(12, 23, 1161, 68);
		contentPane.add(settinglbl);

		JLabel lblNewLabel = new JLabel("현재 접속중인 닉네임");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("HY목각파임B", Font.PLAIN, 30));
		lblNewLabel.setBounds(50, 152, 585, 54);
		contentPane.add(lblNewLabel);
				
		JButton menualbtn = new JButton();
		menualbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menual1 menual = new Menual1(mainFrame.getX(), mainFrame.getY());
				menual.showGUI();
			}
		});
		menualbtn.setBounds(517, 246, 152, 45);
		menualbtn.setIcon(convertToIcon(getClass(), "images/btn_setting/menual.png", 165, 45));
		menualbtn.setPressedIcon(convertToIcon(getClass(), "images/btn_setting/menualPush.png", 165, 45));
		contentPane.add(menualbtn);
		menualbtn.setOpaque(false);
		menualbtn.setBorderPainted(false);

		JButton logoutbtn = new JButton();
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.YES_NO_OPTION);
				if (num == 0) {
					loginFrame = true;
					dispose();
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.showGUI();
				}
			}
		});
		
		logoutbtn.setBounds(517, 321, 152, 45);
		logoutbtn.setIcon(convertToIcon(getClass(), "images/btn_setting/logout.png", 165, 45));
		logoutbtn.setPressedIcon(convertToIcon(getClass(), "images/btn_setting/logoutPush.png", 165, 45));
		contentPane.add(logoutbtn);
		logoutbtn.setOpaque(false);
		logoutbtn.setBorderPainted(false);

		JButton outbtn = new JButton();
		outbtn.setBounds(517, 397, 152, 45);
		outbtn.setIcon(convertToIcon(getClass(), "images/btn_setting/userout.png", 165, 45));
		outbtn.setPressedIcon(convertToIcon(getClass(), "images/btn_setting/useroutPush.png", 165, 45));
		contentPane.add(outbtn);
		outbtn.setOpaque(false);
		outbtn.setBorderPainted(false);
		
		outbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = JOptionPane.showConfirmDialog(null, "정말 탈퇴하시겠습니까?", "회원 탈퇴", JOptionPane.YES_NO_OPTION);
				if (num == 0) {
					loginFrame = true;
					AccountDelete.accountDelete(true, mainFrame.getUsrId());
					dispose();
				}
			}
		});
		
		JButton closebtn = new JButton();
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setTimeGo(true);
				dispose();
			}
		});
		closebtn.setBounds(517, 543, 152, 45);
		closebtn.setIcon(convertToIcon(getClass(), "images/btn_img/closeBtnImage.png", 165, 45));
		closebtn.setPressedIcon(convertToIcon(getClass(), "images/btn_img/closeBtnPushImage.png", 165, 45));
		contentPane.add(closebtn);
		
		JLabel lblNewLabel_1 = new JLabel(mainFrame.getUsrList().get(0).getUsrNickname());
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(710, 152, 487, 54);
		contentPane.add(lblNewLabel_1);
		

	}
	
	public void showGUI() {
		setVisible(true);
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
}