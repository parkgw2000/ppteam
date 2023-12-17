package main.active;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import main.MainFrame;

public class ActiveEventTimer {
	private MainFrame mainFrame;
	private Timer timer;
	private Characters characters;
	private int playCount;
	
	public ActiveEventTimer(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		characters = new Characters(mainFrame);
	}
	
	public void coupangTimer(int count) {
		if (timer != null) {
			mainFrame.setProjectGo(true);
			timer.cancel();
			mainFrame.getActivitybtn().setEnabled(true);
		}
		clearlbl();
		characters.coupangCharacter();
		mainFrame.getPb().CtrlPB_Shop();
		timer = new Timer();
		playCount = 0;
		TimerTask coupangTask = new TimerTask() {		
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (playCount >= count) {
						clearlbl();
						characters.defaultCharacter();
						mainFrame.getPb().CtrlPB_def();
						timer.cancel();
						mainFrame.getActivitybtn().setEnabled(true);
						mainFrame.setProjectGo(true);
						mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() + 20);
						mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
						mainFrame.revalidate();
						mainFrame.repaint();
						timer.cancel();
					}
					playCount++;
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(250 / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(coupangTask, 0, 1);
	}
	
	public void eatTimer(int count) {
		if (timer != null) {
			mainFrame.setProjectGo(true);
			timer.cancel();
		}
		clearlbl();
		characters.eatCharacter();
		mainFrame.getPb().CtrlPB_Muk();
		timer = new Timer();
		playCount = 0;
		TimerTask eatTask = new TimerTask() {		
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (playCount >= count) {
						clearlbl();
						characters.defaultCharacter();
						mainFrame.getPb().CtrlPB_def();
						mainFrame.setProjectGo(true);
						timer.cancel();
					}
					playCount++;
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(250 / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(eatTask, 0, 1);
	}
	
	public void gameTimer(int count) {
		if (timer != null) {
			mainFrame.setProjectGo(true);
			timer.cancel();
		}
		clearlbl();
		characters.playgameCharacter();
		mainFrame.getPb().CtrlPB_LOL();
		timer = new Timer();
		playCount = 0;
		TimerTask gameTask = new TimerTask() {		
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (playCount >= count) {
						clearlbl();
						characters.defaultCharacter();
						mainFrame.getPb().CtrlPB_def();
						mainFrame.setProjectGo(true);
						timer.cancel();
					}
					playCount++;
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(250 / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(gameTask, 0, 1);
	}
	
	public void sleepTimer(int count) {
		if (timer != null) {
			mainFrame.setProjectGo(true);
			timer.cancel();
		}
		clearlbl();
		characters.bedsleepCharacter();
		mainFrame.getPb().CtrlPB_Slp();
		timer = new Timer();
		playCount = 0;
		TimerTask sleepTask = new TimerTask() {		
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (playCount >= count) {
						clearlbl();
						characters.defaultCharacter();
						mainFrame.getPb().CtrlPB_def();
						mainFrame.setProjectGo(true);
						timer.cancel();
					}
					playCount++;
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(250 / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(sleepTask, 0, 1);
	}
	
	public void smokeTimer(int count) {
		if (timer != null) {
			mainFrame.setProjectGo(true);
			timer.cancel();
		}
		clearlbl();
		characters.smokeCharacter();
		mainFrame.getPb().CtrlPB_Smok();
		timer = new Timer();
		playCount = 0;
		TimerTask smokeTask = new TimerTask() {		
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (playCount >= count) {
						clearlbl();
						characters.defaultCharacter();
						mainFrame.getPb().CtrlPB_def();
						timer.cancel();
					}
					playCount++;
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(250 / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(smokeTask, 0, 1);
	}
	
	public void resumeTimer(int count) {
		if (timer != null) {
			mainFrame.setProjectGo(true);
			timer.cancel();
		}
		clearlbl();
		characters.resumeCharacter();
		mainFrame.getPb().CtrlPB_Resum();
		timer = new Timer();
		playCount = 0;
		TimerTask resumeTask = new TimerTask() {		
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (playCount >= count) {
						clearlbl();
						characters.defaultCharacter();
						mainFrame.getPb().CtrlPB_def();
						mainFrame.setProjectGo(true);
						timer.cancel();
					}
					playCount++;
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(250 / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(resumeTask, 0, 1);
	}
	
	
	public void clearlbl() {
		
		JLabel character = characters.getCharacterlbl();
		JLabel active = characters.getActivelbl();
		
		if (character != null) {
			mainFrame.remove(character);
		}
		if (active != null) {
			mainFrame.remove(active);
		}
		
		mainFrame.revalidate();
		mainFrame.repaint();
	}

	public Characters getCharacters() {
		return characters;
	}
	
	
}
