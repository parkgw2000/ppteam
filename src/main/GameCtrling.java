package main;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import database.controllDB.InsertDB;
import database.controllDB.SelectDB;
import database.controllDB.UpdateDB;
import database.dblist.Rank;
import database.dblist.UserInfo;
import main.project.ProjectEventImpl;
import main.suddenQuestion.Basunsaeng;
import main.suddenQuestion.StudyingCode;

public class GameCtrling implements GameCtrl {

	private MainFrame mainFrame;
	
	public GameCtrling(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	private int day;
	private int minutes = 0;

	@Override
	public void ClockCtrl() {
		currentTime = new Timer();
		currentTime.scheduleAtFixedRate(timerTask, 0, 1);
	}

	private TimerTask timerTask = new TimerTask() {

		@Override
		public void run() {
			if (mainFrame.isTimeGo()) {
				if (minutes == 1440) {
					minutes = 0;
					updatePlayDate();
					updateClock(minutes);
				} else {
					minutes++;
					updateClock(minutes);
				}
				
				if (minutes == randomMin1) {
					StudyingCodingTest();
				} else if (minutes == randomMin2) {
					StudyingCodingTest();
				}
				
				if (minutes == randomMin3 && cockroachCount >= 3) {
					new Basunsaeng().Basunsaeng(mainFrame);
					randomMin3 = random.nextInt(1339) + 1;
					cockroachCount = 0;
				} else if (minutes == randomMin3) {
					cockroachCount++;
				}
	
				if (((minutes % 60) % 10) == 0) {
					SaveUsrInfoData();
					saveUsrCoding();
					saveUsrRank();
				}
			}
			try {
				int gameSpeed = mainFrame.getGameSpeed();
				Thread.sleep(50 / gameSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
	private Timer currentTime;

	private void updateClock(int minutes) {
		mainFrame.getHourslbl().setText(String.format("%02d", minutes / 60));
		mainFrame.getMinuteslbl().setText(String.format("%02d", minutes % 60));
	}

	private void updatePlayDate() {

		day = mainFrame.getUsrInfo().getDate();
		day++;
		randomMin1 = random.nextInt(1339) + 1;
		randomMin2 = random.nextInt((1339 - randomMin1)) + randomMin1 + 1;

		mainFrame.getDateslbl().setText(String.format("%02d", day) + "일차");
	}

	@Override
	public void WaitGaming(int userId) {
		mainFrame.setUsrId(userId);

		mainFrame.setUsrList(SelectDB.selectUsr(userId));
		mainFrame.setUsrInfoList(SelectDB.selectUsrinfo(userId));
		mainFrame.setUsrInfo(SelectDB.searchNowGame(mainFrame.getUsrInfoList()));
		if (mainFrame.getUsrInfo() == null) {
			InsertDB.insertUsrInfo(userId);
			mainFrame.setUsrInfoList(SelectDB.selectUsrinfo(userId));
			mainFrame.setUsrInfo(SelectDB.searchNowGame(mainFrame.getUsrInfoList()));
		}

		int infoId = mainFrame.getUsrInfo().getInfoId();
		mainFrame.setInfoId(infoId);
		mainFrame.setSkillList(SelectDB.selectSkillList());
		mainFrame.setUsrSkillList(SelectDB.selectUsrSkill(userId, infoId));
		if (mainFrame.getUsrSkillList().size() == 0) {
			InsertDB.insertUsrSkill(userId, infoId);
			mainFrame.setUsrSkillList(SelectDB.selectUsrSkill(userId, infoId));
		}

		mainFrame.setProjectList(SelectDB.selectProject());
		mainFrame.setUsrProjectList(SelectDB.selectUsrProject(userId, infoId));
		if (mainFrame.getUsrProjectList().size() == 0) {
			InsertDB.insertUsrProject(userId, infoId);
			mainFrame.setUsrProjectList(SelectDB.selectUsrProject(userId, infoId));
		}

		String userNickName = mainFrame.getUsrList().get(0).getUsrNickname();
		mainFrame.setUsrRankList(SelectDB.selectRank());
		
		
		if (!SelectDB.searchUsrRank(userId)) {
			InsertDB.insertUsrRank(userId, infoId, scoreCalculator(), userNickName);
		}
		if (mainFrame.getUsrRankList().size() == 0) {
			InsertDB.insertUsrRank(userId, infoId, scoreCalculator(), userNickName);
			mainFrame.setUsrRankList(SelectDB.selectRank());
		}

		mainFrame.setCigaLogList(SelectDB.selectCigaLog(userId, infoId));
	}

	@Override
	public void applyDBdata() {

		UserInfo userInfo = mainFrame.getUsrInfo();

		try {
			mainFrame.getDateslbl().setText(String.format("%02d", userInfo.getDate()) + "일차");
			minutes = userInfo.getTime();
			updateClock(minutes);
			mainFrame.getLevellbl().setText(String.valueOf(userInfo.getLevel()));
			mainFrame.getExpbar().setValue(userInfo.getExp());
			mainFrame.getHpbar().setValue(userInfo.getHp());
			mainFrame.getHealbar().setValue(userInfo.getHealth());
			mainFrame.getStressbar().setValue(userInfo.getStress());
			mainFrame.getNumOfcigalbl().setText(String.valueOf(userInfo.getCiga()));
			mainFrame.setUsrId(userInfo.getUsrId());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void SaveUsrInfoData() {
		String strDate = mainFrame.getDateslbl().getText();
		int date = Integer.parseInt(strDate.substring(0, 2));
		int time = minutes;
		int level = Integer.parseInt(mainFrame.getLevellbl().getText());
		int exp = mainFrame.getExpbar().getValue();
		int hp = mainFrame.getHpbar().getValue();
		int health = mainFrame.getHealbar().getValue();
		int stress = mainFrame.getStressbar().getValue();
		int ciga = Integer.valueOf(mainFrame.getNumOfcigalbl().getText());
		int usedCiga = mainFrame.getUsrInfo().getUsedCiga();
		boolean hide = mainFrame.getUsrInfo().isHide();
		boolean tory = mainFrame.getUsrInfo().isTory();
		boolean gameover = mainFrame.getUsrInfo().isGameover();

		UserInfo userInfo = new UserInfo(mainFrame.getInfoId(), date, time, level, exp, hp, health, stress, ciga,
				usedCiga, hide, tory, gameover, mainFrame.getUsrId());

		UpdateDB.updateUsrInfo(userInfo);
	}

	public int getClocks() {
		return minutes;
	}

	private void saveUsrCoding() {

		int searchProject = mainFrame.getProjectEventImpl().searchNowProject(mainFrame.getUsrProjectList());
		if (searchProject != -1) {
			mainFrame.setNowProjectId(searchProject);
			mainFrame.getUsrProjectList().get(searchProject)
					.setLastHour(Integer.valueOf(mainFrame.getProjecthours().getText()));
			mainFrame.getUsrProjectList().get(searchProject)
					.setLastMin(Integer.valueOf(mainFrame.getProjectMinutes().getText()));
		}
		UpdateDB.updateUsrProject(mainFrame.getUsrProjectList());
	}


	public void saveUsrRank() {

		Rank userRank = new Rank(mainFrame.getUsrList().get(0).getUsrNickname(), scoreCalculator(),
				mainFrame.getUsrInfo().getInfoId(), mainFrame.getUsrInfo().getUsrId());
		
		
		
		UpdateDB.updateRanking(userRank);
	}

	private int scoreCalculator() {

		int usedCiga = mainFrame.getUsrInfo().getUsedCiga();
		int level = mainFrame.getUsrInfo().getLevel();

		int score = (usedCiga * 50) + (level * 200);

		return score;
	}
	

	public Timer getCurrentTime() {
		return currentTime;
	}
	
	private Random random = new Random();
	private int randomMin1 = random.nextInt(1339) + 1;
	private int randomMin2 = random.nextInt((1339 - randomMin1)) + randomMin1 + 1;
	private int randomMin3 = random.nextInt(1339) + 1;
	private int cockroachCount = 0;
	
	public void StudyingCodingTest() {
		
		int index = random.nextInt(16) + 1;
		StudyingCode StudyingCode = new StudyingCode(index, mainFrame, mainFrame.getX(), mainFrame.getY());
		StudyingCode.showGUI();
	}
	
	
}
