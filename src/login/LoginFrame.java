package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import guiDesign.Methods;
import guiDesign.MyPassword;
import guiDesign.MyTextField;
import login.signUp.SignUpDialog;
import main.MainFrame;
import main.menual.Menual1;

public class LoginFrame extends JFrame {

	private MyTextField txtId;
	private JButton signupbtn;
	private JButton loginbtn;
	private MyPassword passwordField;
	private JLabel characterlbl;
	private static Clip clip;
	private JButton manualBtn;

	public static void main(String[] args) {
		new LoginFrame().showGUI();
	}

	public LoginFrame() {
		ClassLoader classLoader = getClass().getClassLoader();
		URL URLmix = classLoader.getResource("music/main.wav");
		sound(URLmix);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		setTitle("개발자 키우기 - 로그인");
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(309, 200, 362, 115);
		add(panel);
		panel.setBackground(new Color(255, 0, 0, 0));
		panel.setLayout(null);

		txtId = new MyTextField();
		txtId.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
		txtId.setPrefixIcon(Methods.convertToResizeIcon(getClass(), "guiDesign/user.png", 30, 30));
		txtId.setBounds(12, 10, 338, 41);
		panel.add(txtId);

		passwordField = new MyPassword();
		passwordField.setPrefixIcon(Methods.convertToResizeIcon(getClass(), "guiDesign/key.png", 30, 30));
		passwordField.setBounds(12, 61, 338, 41);
		panel.add(passwordField);



		signupbtn = new JButton("");
		signupbtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/SignBtnImage.png"));
		signupbtn.setPressedIcon(Methods.convertToIcon(getClass(), "images/btn_img/SignPushBtnImage.png"));
		signupbtn.setBorderPainted(false);
		signupbtn.setOpaque(false);
		signupbtn.setBackground(new Color(255, 0, 0, 0));
		signupbtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupbtn.setBounds(336, 335, 139, 63);
		add(signupbtn);
		signupbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpDialog signupFrame = new SignUpDialog(LoginFrame.this.getX(), LoginFrame.this.getY());
				signupFrame.showGUI();
			}
		});

		loginbtn = new JButton("");
		loginbtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/loginBtnImage.png"));
		loginbtn.setPressedIcon(Methods.convertToIcon(getClass(), "images/btn_img/loginPushBtnImage.png"));
		loginbtn.setBorderPainted(false);
		loginbtn.setOpaque(false);
		loginbtn.setBackground(new Color(255, 0, 0, 0));
		loginbtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		loginbtn.setBounds(508, 335, 139, 63);
		
		add(loginbtn);
		
		manualBtn = new JButton("");
		manualBtn.setBounds(815, 175, 200, 200);
		manualBtn.setIcon(Methods.convertToIcon(getClass(), "images/manualBtn_img/manualBtn.png"));
		manualBtn.setPressedIcon(Methods.convertToIcon(getClass(), "images/manualBtn_img/manualPushBtn.png"));
		manualBtn.setContentAreaFilled(false);
		manualBtn.setBorderPainted(false);
		manualBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menual1 manual1 = new Menual1(LoginFrame.this.getX(), LoginFrame.this.getY());
				manual1.showGUI();
			}
		});
		getContentPane().add(manualBtn);

//		characterlbl = new JLabel("");
//		characterlbl.setIcon(Methods.convertToIcon(getClass(), "images/character/logincharacter.gif"));
//		characterlbl.setBounds(683, 207, 161, 166);
//		add(characterlbl);
		
		JLabel backgourndlbl = new JLabel("");
		backgourndlbl.setIcon(Methods.convertToIcon(getClass(), "images/back_img/LoginBackground.png"));
		backgourndlbl.setBounds(0, 0, 984, 461);
		add(backgourndlbl);
		
		loginbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int userId = LoginEvent.startLogin(txtId.getText(), passwordField.getText());
				if (userId != -1) {
					dispose();
					stopSound();
					MainFrame mainFrame = new MainFrame(userId);
					mainFrame.showGUI();
				}
			}
		});
	}
	
	public void showGUI() {
		setVisible(true);
	}
	
	
	public void sound(URL file) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startSound() {
		clip.start();
	}
	
	public  void stopSound() {
		clip.stop();
	}

	public MyTextField getTxtId() {
		return txtId;
	}

	public MyPassword getPasswordField() {
		return passwordField;
	}
}