package database.controllDB;

import java.sql.*;
import java.util.List;

import database.dblist.Rank;
import database.dblist.UserInfo;
import database.dblist.UserProject;
import database.dblist.UserSkill;
import database.util.ConnectionProvider;

public class UpdateDB {
	
	public static int[] updateUsrInfo(UserInfo userInfo) {
		String sql = "UPDATE userInfo SET date =?, time = ?, level = ?, exp = ?"
				+ ", hp = ?, health = ?, stress = ?, ciga = ?, usedCiga = ?, hide = ?, tory = ?, gameover = ? "
				+ "WHERE userId = ? AND infoId = ?";
		try (Connection conn = ConnectionProvider.makeSQLiteConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, userInfo.getDate());
			stmt.setInt(2, userInfo.getTime());
			stmt.setInt(3, userInfo.getLevel());
			stmt.setInt(4, userInfo.getExp());
			stmt.setInt(5, userInfo.getHp());
			stmt.setInt(6, userInfo.getHealth());
			stmt.setInt(7, userInfo.getStress());
			stmt.setInt(8, userInfo.getCiga());
			stmt.setInt(9, userInfo.getUsedCiga());
			stmt.setBoolean(10, userInfo.isHide());
			stmt.setBoolean(11, userInfo.isTory());
			stmt.setBoolean(12, userInfo.isGameover());
			stmt.setInt(13, userInfo.getUsrId());
			stmt.setInt(14, userInfo.getInfoId());

			stmt.addBatch();

			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int[] updateUsrProject(List<UserProject> list) {
		String sql = "UPDATE userProject SET proceeding = ?, complete = ?, lastHour = ?, lastMin = ?, deadLine = ? WHERE userId = ? AND infoId = ? AND projectId = ?";
		try (Connection conn = ConnectionProvider.makeSQLiteConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (UserProject elem : list) {
				stmt.setBoolean(1, elem.isProceeding());
				stmt.setBoolean(2, elem.isComplete());
				stmt.setInt(3, elem.getLastHour());
				stmt.setInt(4, elem.getLastMin());
				stmt.setInt(5, elem.getDeadLine());
				stmt.setInt(6, elem.getUsrId());
				stmt.setInt(7, elem.getInfoId());
				stmt.setInt(8, elem.getProjectId());

				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int[] updateUsrSkill(List<UserSkill> list) {
		String sql = "UPDATE userSkill SET skillLevel = ? WHERE userId = ? AND infoId = ? AND skillId = ?";
		try (Connection conn = ConnectionProvider.makeSQLiteConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (UserSkill elem : list) {
				stmt.setInt(1, elem.getSkillLevel());
				stmt.setInt(2, elem.getUsrId());
				stmt.setInt(3, elem.getInfoId());
				stmt.setInt(4, elem.getSkillId());

				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int updateRanking(Rank rank) {

		String sql = "UPDATE rank SET score = ? WHERE userid = ? AND userinfoId = ?";
		try (Connection conn = ConnectionProvider.makeSQLiteConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, rank.getScore());
			stmt.setInt(2, rank.getUsrid());
			stmt.setInt(3, rank.getUsrinfoId());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
