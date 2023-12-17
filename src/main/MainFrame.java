package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import database.dblist.CigaLog;
import database.dblist.Project;
import database.dblist.Rank;
import database.dblist.SkillList;
import database.dblist.User;
import database.dblist.UserInfo;
import database.dblist.UserProject;
import database.dblist.UserSkill;
import guiDesign.ImgPanel;
import guiDesign.Methods;
import login.LoginFrame;
import main.active.ActiveDialog;
import main.active.ActiveEventTimer;
import main.minigame.GameDialog;
import main.minigame.du.dugame;
import main.project.ProjectEventImpl;
import main.ranking.RankingDialog;
import main.setting.SettingDialog;
import progressbar.ProgressbarEvent;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	// 게임속도
	int gameSpeed = 1;

	// timer 정지 및 시작
	private boolean timeGo = true;
	private boolean projectGo = true;

	// 메인페널
	private ImgPanel Mainpnl;

	// 사운드
	private static Clip clip;
	private JButton soundbtn;

	// 활동버튼
	private ActiveEventTimer activeEventTimer = new ActiveEventTimer(this);
	private JButton activitybtn;

	// 메인시간
	private GameCtrling GameCtrling = new GameCtrling(this);
	private JLabel dateslbl;
	private JLabel hourslbl;
	private JLabel minuteslbl;


	// 프로젝트
	private ProjectEventImpl projectEventImpl = new ProjectEventImpl(this);
	private JLabel nowRateslbl;
	private JLabel getnowProjectslbl;
	private JLabel projecthours;
	private JLabel projectMinutes;
	private int nowProjectId = 0;
	private int deadLine = 2880;
	private JLabel projectDeadLine;

	// 정보
	private JLabel levellbl;
	private JLabel numOfcigalbl;

	// pro-bar
	private ProgressbarEvent pb = new ProgressbarEvent(this);
	private JProgressBar hpbar;
	private JProgressBar expbar;
	private JProgressBar strsbar;
	private JProgressBar healbar;

	// DB
	private List<UserInfo> userInfoList;
	private List<SkillList> skillList;
	private List<UserSkill> userSkillList;
	private List<Project> projectList;
	private List<UserProject> userProjectList;
	private List<User> userList;
	private List<Rank> userRankList;
	private UserInfo userInfo;
	private Rank userRank;
	private int infoId;
	private int userId;
	private int score;

	// 미니게임
	GameDialog gameDialog = null;

	private JButton taskbtn;

	public MainFrame(int userId) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		ClassLoader classLoader = getClass().getClassLoader();
		URL URLmix = classLoader.getResource("music/mix.wav");
		sound(URLmix);

		setBounds(100, 100, 1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainpnl = new ImgPanel(Methods.converImage(getClass(), "images/back_img/background.png"));
		Mainpnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Mainpnl);
		Mainpnl.setLayout(null);

		activeEventTimer.getCharacters().defaultCharacter();

		ImageIcon sound = Methods.convertToResizeIcon(getClass(), "images/btn_img/sound.png", 50, 50);
		ImageIcon mute = Methods.convertToResizeIcon(getClass(), "images/btn_img/mute.png", 50, 50);

		JPanel statuspnl = new JPanel();
		statuspnl.setBounds(46, 613, 934, 114);
		Mainpnl.add(statuspnl);
		statuspnl.setLayout(null);
		statuspnl.setBackground(new Color(255, 255, 255, 100));

		JPanel currentcigapnl = new JPanel();
		currentcigapnl.setBounds(22, 10, 225, 42);
		statuspnl.add(currentcigapnl);
		currentcigapnl.setOpaque(false);
		currentcigapnl.setLayout(null);

		JLabel currentcigalbl = new JLabel("담배  X");
		currentcigalbl.setIcon(Methods.convertToIcon(getClass(), "images/rank_img/ciga.png"));

		currentcigalbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		currentcigalbl.setBounds(12, 0, 117, 43);
		currentcigapnl.add(currentcigalbl);

		numOfcigalbl = new JLabel("00");
		numOfcigalbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		numOfcigalbl.setBounds(124, 5, 89, 33);
		currentcigapnl.add(numOfcigalbl);

		JPanel stresspnl = new JPanel();
		stresspnl.setBounds(294, 40, 628, 30);
		statuspnl.add(stresspnl);
		stresspnl.setOpaque(false);
		stresspnl.setLayout(null);

		JLabel stresslbl = new JLabel("스트레스");
		stresslbl.setHorizontalAlignment(SwingConstants.LEFT);
		stresslbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		stresslbl.setBounds(39, 5, 85, 22);
		stresspnl.add(stresslbl);

		strsbar = new JProgressBar();
		strsbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		strsbar.setValue(10);
		strsbar.setStringPainted(true);
		strsbar.setForeground(new Color(139, 0, 0));
		strsbar.setBounds(136, 5, 480, 22);
		stresspnl.add(strsbar);

		JPanel developlvpnl = new JPanel();
		developlvpnl.setBounds(22, 62, 225, 42);
		statuspnl.add(developlvpnl);
		developlvpnl.setOpaque(false);
		developlvpnl.setLayout(null);

		JLabel lblNewLabel = new JLabel("개발능력Lv");
		lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 5, 110, 32);
		developlvpnl.add(lblNewLabel);

		levellbl = new JLabel("00");
		levellbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		levellbl.setBounds(124, 5, 89, 33);
		developlvpnl.add(levellbl);

		JPanel healthpnl = new JPanel();
		healthpnl.setLayout(null);
		healthpnl.setOpaque(false);
		healthpnl.setBounds(294, 75, 628, 30);
		statuspnl.add(healthpnl);

		JLabel healthlbl = new JLabel("건강");
		healthlbl.setHorizontalAlignment(SwingConstants.LEFT);
		healthlbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		healthlbl.setBounds(39, 5, 85, 22);
		healthpnl.add(healthlbl);

		healbar = new JProgressBar();
		healbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		healbar.setValue(100);
		healbar.setStringPainted(true);
		healbar.setForeground(new Color(0, 128, 0));
		healbar.setBounds(136, 5, 480, 22);
		healthpnl.add(healbar);

		JPanel hppnl = new JPanel();
		hppnl.setBounds(294, 5, 628, 30);
		statuspnl.add(hppnl);
		hppnl.setOpaque(false);
		hppnl.setBackground(new Color(255, 0, 0, 0));
		hppnl.setLayout(null);

		JLabel hplbl = new JLabel("HP");
		hplbl.setHorizontalAlignment(SwingConstants.LEFT);
		hplbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		hplbl.setBounds(39, 5, 85, 22);
		hppnl.add(hplbl);

		hpbar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		hpbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		hpbar.setForeground(Color.RED);
		hpbar.setStringPainted(true);
		hpbar.setValue(100);
		hpbar.setBounds(136, 5, 480, 22);
		hppnl.add(hpbar);

		JButton btnSpeed = new JButton(Methods.convertToResizeIcon(getClass(), "images/btn_img/speed1.png", 60, 50));
		btnSpeed.setForeground(Color.RED);
		btnSpeed.setBackground(new Color(0, 0, 0, 0));
		btnSpeed.setOpaque(false);
		btnSpeed.setBorderPainted(false);
		btnSpeed.setBounds(290, 10, 60, 50);
		Mainpnl.add(btnSpeed);
		btnSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameSpeed == 5) {
					gameSpeed = 1;
				} else {
					gameSpeed++;
				}
				if (gameSpeed == 1) {
					btnSpeed.setIcon(Methods.convertToResizeIcon(getClass(), "images/btn_img/speed1.png", 60, 50));
				} else if (gameSpeed == 2) {
					btnSpeed.setIcon(Methods.convertToResizeIcon(getClass(), "images/btn_img/speed2.png", 60, 50));
				} else if (gameSpeed == 3) {
					btnSpeed.setIcon(Methods.convertToResizeIcon(getClass(), "images/btn_img/speed3.png", 60, 50));
				} else if (gameSpeed == 4) {
					btnSpeed.setIcon(Methods.convertToResizeIcon(getClass(), "images/btn_img/speed4.png", 60, 50));
				} else if (gameSpeed == 5) {
					btnSpeed.setIcon(Methods.convertToResizeIcon(getClass(), "images/btn_img/speed5.png", 60, 50));
				}
			}
		});
		soundbtn = new JButton(sound);
		soundbtn.setBounds(978, 28, 50, 50);
		soundbtn.setBackground(new Color(0, 0, 0, 0));
		soundbtn.setBorderPainted(false);
		soundbtn.setOpaque(false);
		soundbtn.setFocusable(false);
		getContentPane().add(soundbtn);
		soundbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (soundbtn.getIcon() == sound) {
					soundbtn.setIcon(mute);
					clip.stop();
				} else if (soundbtn.getIcon() == mute) {
					soundbtn.setIcon(sound);
					clip.start();
				}
			}
		});

		expbar = new JProgressBar();
		expbar.setValue(20);
		expbar.setStringPainted(true);
		expbar.setForeground(new Color(30, 144, 255));
		expbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		expbar.setBounds(95, 737, 861, 20);
		Mainpnl.add(expbar);

		JLabel lblNewLabel_2 = new JLabel("exp");
		lblNewLabel_2.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		lblNewLabel_2.setBounds(46, 728, 37, 29);
		Mainpnl.add(lblNewLabel_2);

		JPanel date = new JPanel();
		date.setBounds(12, 10, 135, 45);
		Mainpnl.add(date);
		date.setLayout(null);
		date.setOpaque(false);

		dateslbl = new JLabel("00일차");
		dateslbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateslbl.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		dateslbl.setBounds(0, 0, 135, 45);
		date.add(dateslbl);

		JPanel currentTime = new JPanel();
		currentTime.setBounds(147, 10, 135, 45);
		Mainpnl.add(currentTime);
//		currentTime.setBorder(new LineBorder(Color.BLACK, 2));
		currentTime.setOpaque(false);
		currentTime.setBackground(new Color(255, 0, 0, 0));
		currentTime.setLayout(null);

		hourslbl = new JLabel("00");
		hourslbl.setHorizontalAlignment(SwingConstants.CENTER);

		hourslbl.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		hourslbl.setBounds(0, 0, 60, 45);
		currentTime.add(hourslbl);

		minuteslbl = new JLabel("00");
		minuteslbl.setHorizontalAlignment(SwingConstants.CENTER);
		minuteslbl.setFont(new Font("HY목각파임B", Font.BOLD, 28));
		minuteslbl.setBounds(75, 0, 60, 45);
		currentTime.add(minuteslbl);

		JLabel colonlbl = new JLabel(":");
		colonlbl.setHorizontalAlignment(SwingConstants.CENTER);
		colonlbl.setFont(new Font("Algerian", Font.BOLD, 30));
		colonlbl.setBounds(60, 0, 15, 45);
		currentTime.add(colonlbl);

		JButton rankingbtn = new JButton();
		rankingbtn.setBounds(1051, 275, 90, 89);
		rankingbtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/rankBtnImage.png"));
		Mainpnl.add(rankingbtn);
		rankingbtn.setBorderPainted(false);
		rankingbtn.setOpaque(false);
		rankingbtn.setBackground(new Color(255, 0, 0, 0));
		rankingbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timeGo = false;
				RankingDialog rankingFrame = new RankingDialog(MainFrame.this.getX(), MainFrame.this.getY(),
						MainFrame.this);
				rankingFrame.showGUI();
			}
		});

		JButton settingbtn = new JButton();
		settingbtn.setBounds(1051, 10, 90, 89);
		settingbtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/settingBtnImage.png"));
		Mainpnl.add(settingbtn);
		settingbtn.setOpaque(false);
		settingbtn.setBorderPainted(false);
		settingbtn.setBackground(new Color(255, 0, 0, 0));
		settingbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeGo = false;
				SettingDialog settingFrame = new SettingDialog(MainFrame.this.getX(), MainFrame.this.getY(),
						MainFrame.this);
				settingFrame.showGUI();
				if (settingFrame.getLoginFrame()) {
					new LoginFrame();
					dispose();
				}
			}
		});

		JButton LOLBtn = new JButton();
		LOLBtn.setBounds(1051, 395, 90, 81);
		LOLBtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/miniGameBtnImage.png"));
		Mainpnl.add(LOLBtn);
		LOLBtn.setOpaque(false);
		LOLBtn.setBorderPainted(false);
		LOLBtn.setBackground(new Color(255, 0, 0, 0));
		LOLBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timeGo = false;
				gameDialog = new GameDialog(MainFrame.this.getX(), MainFrame.this.getY(), MainFrame.this);
				gameDialog.showGUI();
			}
		});

		activitybtn = new JButton();
		activitybtn.setBounds(1058, 525, 83, 89);
		activitybtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/activeBtnImage.png"));
		Mainpnl.add(activitybtn);
		activitybtn.setOpaque(false);
		activitybtn.setBorderPainted(false);
		activitybtn.setBackground(new Color(255, 0, 0, 0));
		activitybtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActiveDialog activeFrame = new ActiveDialog(MainFrame.this.getX(), MainFrame.this.getY(),
						MainFrame.this);
				activeFrame.showGUI();
			}
		});

		GameCtrling.WaitGaming(userId);
		GameCtrling.applyDBdata();
		GameCtrling.ClockCtrl();
		pb.CtrlPB_def();
	}

	public void showGUI() {
		setVisible(true);
	}

	public void sound(URL file) {
		try {
			AudioInputStream ais1 = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais1);
			clip.start();
			clip.loop(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JButton getActivitybtn() {
		return activitybtn;
	}

	public void stopSound() {
		clip.stop();
		clip.close();
	}

	public JLabel getHourslbl() {
		return hourslbl;
	}

	public JLabel getMinuteslbl() {
		return minuteslbl;
	}

	public JLabel getDateslbl() {
		return dateslbl;
	}

	public JLabel getnowProjectlbl() {
		return getnowProjectslbl;
	}

	public JLabel getNowRateslbl() {
		return nowRateslbl;
	}

	public JLabel getProjecthours() {
		return projecthours;
	}

	public JLabel getProjectMinutes() {
		return projectMinutes;
	}

	public JProgressBar getHpbar() {
		return hpbar;
	}

	public JProgressBar getExpbar() {
		return expbar;
	}

	public JProgressBar getStrsBar() {
		return strsbar;
	}

	public JProgressBar getHealbar() {
		return healbar;
	}

	public ProgressbarEvent getPb() {
		return pb;
	}

	public List<UserInfo> getUsrInfoList() {
		return userInfoList;
	}

	public void setUsrInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public List<UserSkill> getUsrSkillList() {
		return userSkillList;
	}

	public List<SkillList> getSkillList() {
		return skillList;
	}

	public void setUsrSkillList(List<UserSkill> userSkillList) {
		this.userSkillList = userSkillList;
	}

	public List<UserProject> getUsrProjectList() {
		return userProjectList;
	}

	public void setUsrProjectList(List<UserProject> userProjectList) {
		this.userProjectList = userProjectList;
	}

	public UserInfo getUsrInfo() {
		return userInfo;
	}

	public void setUsrInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getUsrId() {
		return userId;
	}

	public void setUsrId(int userId) {
		this.userId = userId;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<User> getUsrList() {
		return userList;
	}

	public void setUsrList(List<User> userList) {
		this.userList = userList;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public void setCigaLogList(List<CigaLog> cigaLogList) {
	}

	public JLabel getLevellbl() {
		return levellbl;
	}

	public JLabel getNumOfcigalbl() {
		return numOfcigalbl;
	}

	public void setSkillList(List<SkillList> skillList) {
		this.skillList = skillList;
	}

	public JProgressBar getStressbar() {
		return strsbar;
	}
	
//	public dugame getdugame() {
//		return Dugame;
//	}

	public ProjectEventImpl getProjectEventImpl() {
		return projectEventImpl;
	}

	public int getNowProjectId() {
		return nowProjectId;
	}

	public void setNowProjectId(int nowProjectId) {
		this.nowProjectId = nowProjectId;
	}

	public List<Rank> getUsrRankList() {
		return userRankList;
	}

	public void setUsrRankList(List<Rank> userRankList) {
		this.userRankList = userRankList;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Rank getUsrRank() {
		return userRank;
	}

	public void setUsrRank(Rank userRank) {
		this.userRank = userRank;
	}

	public GameCtrling getGameControllerImpl() {
		return GameCtrling;
	}

	public int getGameSpeed() {
		return gameSpeed;
	}

	public boolean isTimeGo() {
		return timeGo;
	}

	public void setTimeGo(boolean timeGo) {
		this.timeGo = timeGo;
	}

	public ActiveEventTimer getActiveEventTimer() {
		return activeEventTimer;
	}

	public boolean isProjectGo() {
		return projectGo;
	}

	public void setProjectGo(boolean projectGo) {
		this.projectGo = projectGo;
	}

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}

	public JLabel getProjectDeadLine() {
		return projectDeadLine;
	}

	public JButton getTaskbtn() {
		return taskbtn;
	}
	
}
