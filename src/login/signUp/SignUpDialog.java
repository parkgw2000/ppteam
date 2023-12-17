package login.signUp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import guiDesign.Methods;
import java.awt.Font;

public class SignUpDialog extends JDialog  {

	// 유저 입력
	private JTextField idField;
	private JTextField nicknameField;
	private JTextField passwordChkField;
	private JTextField passwordField;
	
	// 조작 라벨
	private JLabel lblPwCheck;
	private JLabel lblIdCheck;
	private JLabel lblNickCheck;
	private JLabel lblPwPatternCheck;
	
	// 회원가입 기능 클래스
	private SignUpAcation signUp;

	public SignUpDialog(int x, int y) {
		setBounds(x + 8, y + 30, 984, 463);
		setUndecorated(true);
		setModal(true);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 984, 463);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(Methods.convertToIcon(getClass(), "images/back_img/SignBackground.png"));
		label.setBounds(0, 0, 984, 463);
		
		lblPwPatternCheck = new JLabel("비밀번호 입력");
		lblPwPatternCheck.setFont(new Font("굴림", Font.BOLD, 13));
		lblPwPatternCheck.setForeground(Color.RED);
		lblPwPatternCheck.setBounds(564, 255, 166, 28);
		panel.add(lblPwPatternCheck);
		
		JLabel lblNotiPw = new JLabel("(영문자, 숫자, 특수문자 포함 8자 이상)");
		lblNotiPw.setForeground(Color.BLUE);
		lblNotiPw.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		lblNotiPw.setBounds(286, 292, 206, 15);
		panel.add(lblNotiPw);
		
		JLabel lblNotiNickname = new JLabel("(한글, 영문자, 숫자만 가능)");
		lblNotiNickname.setForeground(Color.BLUE);
		lblNotiNickname.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		lblNotiNickname.setBounds(286, 209, 147, 15);
		panel.add(lblNotiNickname);
		
		JLabel lblNotiId = new JLabel("(영문자, 숫자만 가능)");
		lblNotiId.setForeground(Color.BLUE);
		lblNotiId.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		lblNotiId.setBounds(286, 137, 130, 15);
		panel.add(lblNotiId);
		
		
		// 중복확인버튼
		JButton btnIdCheck = new JButton("");
		btnIdCheck.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/duplicateBtnImage.png"));
		btnIdCheck.setPressedIcon(Methods.convertToIcon(getClass(), "images/btn_img/duplicatePushBtnImage.png"));
		btnIdCheck.setBounds(633, 102, 97, 26);
		btnIdCheck.setBorderPainted(false);
		btnIdCheck.setOpaque(false);
		btnIdCheck.setBackground(new Color(255, 0, 0, 0));
		panel.add(btnIdCheck);
		
		JButton btnNickCheck = new JButton("");
		btnNickCheck.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/duplicateBtnImage.png"));
		btnNickCheck.setPressedIcon(Methods.convertToIcon(getClass(), "images/btn_img/duplicatePushBtnImage.png"));
		btnNickCheck.setBorderPainted(false);
		btnNickCheck.setOpaque(false);
		btnNickCheck.setBackground(new Color(255, 0, 0, 0));
		btnNickCheck.setBounds(633, 169, 97, 26);
		panel.add(btnNickCheck);
		
		lblIdCheck = new JLabel("");
		lblIdCheck.setForeground(Color.RED);
		lblIdCheck.setBounds(564, 102, 57, 26);
		lblIdCheck.setOpaque(false);
		lblIdCheck.setBackground(new Color(255, 0, 0, 0));
		panel.add(lblIdCheck);
		
		idField = new JTextField();
		idField.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		idField.setBounds(436, 102, 116, 28);
		panel.add(idField);
		idField.setColumns(10);
		
		nicknameField = new JTextField();
		nicknameField.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		nicknameField.setColumns(10);
		nicknameField.setBounds(436, 169, 116, 28);
		panel.add(nicknameField);
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		passwordField.setColumns(10);
		passwordField.setBounds(436, 255, 116, 28);
		panel.add(passwordField);
		
		passwordChkField = new JTextField();
		passwordChkField.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		passwordChkField.setColumns(10);
		passwordChkField.setBounds(436, 346, 116, 28);
		panel.add(passwordChkField);
		
		lblNickCheck = new JLabel("");
		lblNickCheck.setForeground(Color.RED);
		lblNickCheck.setBounds(564, 169, 57, 28);
		panel.add(lblNickCheck);
		
		lblPwCheck = new JLabel("동일한 비밀번호를 입력");
		lblPwCheck.setFont(new Font("굴림", Font.BOLD, 13));
		lblPwCheck.setForeground(Color.RED);
		lblPwCheck.setBounds(564, 346, 166, 28);
		panel.add(lblPwCheck);
		
		btnIdCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				signUp.idCheck(idField.getText());
				revalidate();
				repaint();
			}
		});
		btnNickCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				signUp.nickNameChk(nicknameField.getText());
				revalidate();
				repaint();
			}
		});
	
		passwordChkField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				signUp.passwordIsSame(passwordChkField.getText(), passwordField.getText());
				revalidate();
				repaint();		
			}
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		passwordField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {	
			}
			@Override
			public void keyReleased(KeyEvent e) {
				signUp.passwordChk(passwordField.getText());
				revalidate();
				repaint();
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		JButton okbtn = new JButton("");
		okbtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/signofconfirmBtnImage.png"));
		okbtn.setPressedIcon(Methods.convertToIcon(getClass(), "images/btn_img/signofconfirmPushBtnImage.png"));
		okbtn.setBorderPainted(false);
		okbtn.setOpaque(false);
		okbtn.setBackground(new Color(255, 0, 0, 0));
		
		okbtn.setBounds(560, 401, 97, 41);
		okbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = signUp.signUp(idField.getText(), passwordChkField.getText(), passwordField.getText(), nicknameField.getText());
				if (success) {
					dispose();
				} 
			}
		});
		panel.add(okbtn);
		
		JButton CancelBtn = new JButton("");
		CancelBtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/cancelBtnImage.png"));
		CancelBtn.setPressedIcon(Methods.convertToIcon(getClass(), "images/btn_img/cancelPushBtnImage.png"));
		CancelBtn.setBorderPainted(false);
		CancelBtn.setOpaque(false);
		CancelBtn.setBackground(new Color(255, 0, 0, 0));
		
		CancelBtn.setBounds(670, 401, 97, 41);
		CancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panel.add(CancelBtn);		
		panel.add(label);	
		
		signUp = new SignUpAcation(this);
	}
	
	public void showGUI() {
		setVisible(true);
	}
	
	public JTextField getIdField() {
		return idField;
	}

	public JLabel getLblIdCheck() {
		return lblIdCheck;
	}
	
	public JTextField getPasswordChkField() {
		return passwordField;
	}

	public JTextField getPasswordField() {
		return passwordChkField;
	}
	
	public JLabel getLblPwCheck() {
		return lblPwCheck;
	}

	public JLabel getLblNickCheck() {
		return lblNickCheck;
	}

	public JTextField getNameField() {
		return nicknameField;
	}

	public JLabel getLblPwPatternCheck() {
		return lblPwPatternCheck;
	}
}
