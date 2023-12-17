package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.util.ConnectionProvider;

public class AccountDelete {
	
//	accountDelete(checkUsrPw(checkUsrId(id), inputPw), id);
	public static String checkUsrId(int id) { // 아이디 입력 받음
		String sql = "SELECT userPw FROM user where Id = ?";
		try (Connection conn = ConnectionProvider.makeSQLiteConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					return rs.getString("userPw"); // 아이디 있으면 비번 반환
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null; // 아이디 없으면 null 반환
	}
	public static boolean checkUsrPw(String userPw, String inputPw) {
		if (userPw.equals(inputPw)) {
			return true; // 비번과 입력 비번이 같으면 true 반환
		} else {
			return false; // 다르면 false 반환
		}
	}
	public static void accountDelete (boolean delete, int id) { // delete true면 회원탈퇴 아니면 안 함
		if (delete) {
			String sql = null;
			for (int i = 0; i < 6; i++) {
				sql = sqlchange(i);
//				System.out.println(sql);
				try (Connection conn = ConnectionProvider.makeSQLiteConnection();
						PreparedStatement stmt = conn.prepareStatement(sql)) {
					stmt.setInt(1, id);
					stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static String sqlchange (int num) {
		switch (num) {
			case 0:
				return "DELETE FROM rank WHERE nickname = (SELECT nickname FROM user WHERE id = ?)";
			case 1:
				return "DELETE FROM userproject WHERE userid = ?";
			case 2:
				return "DELETE FROM userskill WHERE userid = ?";
			case 3:
				return "DELETE FROM cigalog WHERE userid = ?";
			case 4:
				return "DELETE FROM userinfo WHERE userid = ?";
			case 5:
				return "DELETE FROM user WHERE id = ?";
			default:
				return null;
		}
	}
}