package login;

import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import database.controllDB.SelectDB;
import database.dblist.User;

public class LoginEvent {
	LoginFrame loginFrame;
	
	public static int startLogin(String inputId, String inputPw) {
		User loginUsr = checkUsrId(inputId);
		if (loginUsr != null) {
			if (checkUsrPw(loginUsr.getUsrPw(), inputPw)) {
				return loginUsr.getId(); // 로그인 성공시 id값 반환
			}
		}
		return -1; // 로그인 실패시 -1 반환
	} 
	
	
	private static User checkUsrId(String userId) { // 아디 입력 받음
		UIManager.put("OptionPane.messageFont", new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
		List<User> user = new SelectDB().selectUsr(userId);
		if (user.size() > 1) {
			JOptionPane.showMessageDialog(null, "계정에 오류가 있습니다. 관리자에게 문의해주세요.", "계정 오류 발생", JOptionPane.ERROR_MESSAGE);
		} else if (user.size() == 1){
			return user.get(0);
		} else if (user.size() == 0) {
			JOptionPane.showMessageDialog(null, "존재하지 않는 아이디 입니다.", "로그인 경고", JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	
	
	private static boolean checkUsrPw(String userPw, String inputPw) {
		UIManager.put("OptionPane.messageFont", new Font("휴먼둥근헤드라인", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
		if (userPw.equals(inputPw)) {
			return true; // 비번과 입력 비번이 같으면 true 반환
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "로그인 경고", JOptionPane.WARNING_MESSAGE);
			return false; // 다르면 false 반환
		}
	}
}

