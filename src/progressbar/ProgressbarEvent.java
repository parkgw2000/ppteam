package progressbar;

import java.util.Timer;
import java.util.TimerTask;

import main.DeathStudying;
import main.MainFrame;

public class ProgressbarEvent {
	
	MainFrame mainFrame;
	Timer ClockHp = null;
	Timer ClockStrs = null;
	Timer ClockHeal = null;
	
	private int gameSpeed;
	private int hp;
	private int stress;
	private int health;
	private TimerTask hpTask;

	public ProgressbarEvent(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void CtrlPB_def() {
		int level = mainFrame.getUsrInfo().getLevel();
		int SleepBed = mainFrame.getUsrSkillList().get(0).getSkillLevel();
		int HpDrink = mainFrame.getUsrSkillList().get(1).getSkillLevel();
		int CoddingDevice = mainFrame.getUsrSkillList().get(2).getSkillLevel();
		int ElecSmok= mainFrame.getUsrSkillList().get(3).getSkillLevel();
		int AppleCom = mainFrame.getUsrSkillList().get(4).getSkillLevel();
					
		int SpdHp = 3000 + (level * 20) + (HpDrink * 50) + (AppleCom * 50);
		int SpdStrs = 1000 + (level * 20) + (AppleCom * 50);
		int SpdHeal = 2000 + (level * 20) + (AppleCom * 50);
		
		if (SpdHp < 10) {
			SpdHp = 10;
		}
		if (SpdStrs < 10) {
			SpdStrs = 10;
		}
		if (SpdHeal < 10) {
			SpdHeal = 10;
		}
		
		DecreaseTotalHp(SpdHp);
		IncreaseTotalStrs(SpdStrs);
		DecreaseTotalHeal(SpdHeal);
	}
	
	public void CtrlPB_Smok() {
		int level = mainFrame.getUsrInfo().getLevel();
		int SleepBed = mainFrame.getUsrSkillList().get(0).getSkillLevel();
		int HpDrink = mainFrame.getUsrSkillList().get(1).getSkillLevel();
		int CoddingDevice = mainFrame.getUsrSkillList().get(2).getSkillLevel();
		int ElecSmok= mainFrame.getUsrSkillList().get(3).getSkillLevel();
		int AppleCom = mainFrame.getUsrSkillList().get(4).getSkillLevel();
		
		int SpdHp = 2500 + (level * 20) + (HpDrink * 50) + (AppleCom * 50);
		int SpdStrs = 500 - (level * 20) - (AppleCom * 50) - (ElecSmok* 10);
		int SpdHeal = 1300 + (level * 20) + (AppleCom * 50);
		
		if (SpdHp < 10) {
			SpdHp = 10;
		}
		if (SpdStrs < 10) {
			SpdStrs = 10;
		}
		if (SpdHeal < 10) {
			SpdHeal = 10;
		}
		
		DecreaseTotalHp(SpdHp);
		DecreaseTotalStrs(SpdStrs);
		DecreaseTotalHeal(SpdHeal);
	}
	
	public void CtrlPB_Shop() {
		int level = mainFrame.getUsrInfo().getLevel();
		int SleepBed = mainFrame.getUsrSkillList().get(0).getSkillLevel();
		int HpDrink = mainFrame.getUsrSkillList().get(1).getSkillLevel();
		int CoddingDevice = mainFrame.getUsrSkillList().get(2).getSkillLevel();
		int ElecSmok= mainFrame.getUsrSkillList().get(3).getSkillLevel();
		int AppleCom = mainFrame.getUsrSkillList().get(4).getSkillLevel();
								
		int SpdHp = 2000 + (level * 20) + (HpDrink * 50) + (AppleCom * 50);
		int SpdStrs = 670 + (level * 20) + (AppleCom * 50);
		int SpdHeal = 1340 + (level * 20) + (AppleCom * 50);
		
		if (SpdHp < 10) {
			SpdHp = 10;
		}
		if (SpdStrs < 10) {
			SpdStrs = 10;
		}
		if (SpdHeal < 10) {
			SpdHeal = 10;
		}
		
		DecreaseTotalHp(SpdHp);
		IncreaseTotalStrs(SpdStrs);
		DecreaseTotalHeal(SpdHeal);
	}
	
	public void CtrlPB_LOL() {
		int level = mainFrame.getUsrInfo().getLevel();
		int SleepBed = mainFrame.getUsrSkillList().get(0).getSkillLevel();
		int HpDrink = mainFrame.getUsrSkillList().get(1).getSkillLevel();
		int CoddingDevice = mainFrame.getUsrSkillList().get(2).getSkillLevel();
		int ElecSmok= mainFrame.getUsrSkillList().get(3).getSkillLevel();
		int AppleCom = mainFrame.getUsrSkillList().get(4).getSkillLevel();
					
		int SpdHp = 2300 + (level * 20) + (HpDrink * 50) + (AppleCom * 50);
		int SpdStrs = 2000 - (level * 20) - (AppleCom * 50) - (CoddingDevice * 50);
		int SpdHeal = 1500 + (level * 20) + (AppleCom * 50);
		
		if (SpdHp < 10) {
			SpdHp = 10;
		}
		if (SpdStrs < 10) {
			SpdStrs = 10;
		}
		if (SpdHeal < 10) {
			SpdHeal = 10;
		}
		
		DecreaseTotalHp(SpdHp);
		DecreaseTotalStrs(SpdStrs);
		DecreaseTotalHeal(SpdHeal);
	}
	
	public void CtrlPB_Slp() {
		int level = mainFrame.getUsrInfo().getLevel();
		int SleepBed = mainFrame.getUsrSkillList().get(0).getSkillLevel();
		int HpDrink = mainFrame.getUsrSkillList().get(1).getSkillLevel();
		int CoddingDevice = mainFrame.getUsrSkillList().get(2).getSkillLevel();
		int ElecSmok= mainFrame.getUsrSkillList().get(3).getSkillLevel();
		int AppleCom = mainFrame.getUsrSkillList().get(4).getSkillLevel();
					
		int SpdHp = 2500 - (level * 20) - (HpDrink * 50) - (AppleCom * 50) - (SleepBed * 20);
		int SpdStrs = 1500 - (level * 20) - (AppleCom * 50) - (SleepBed * 20);
		int SpdHeal = 2000 - (level * 20) - (AppleCom * 50) - (SleepBed * 20);
		
		if (SpdHp < 10) {
			SpdHp = 10;
		}
		if (SpdStrs < 10) {
			SpdStrs = 10;
		}
		if (SpdHeal < 10) {
			SpdHeal = 10;
		}
		
		IncreaseTotalHp(SpdHp);
		DecreaseTotalStrs(SpdStrs);
		IncreaseTotalHeal(SpdHeal);
	}
	
	public void CtrlPB_Muk() {
		int level = mainFrame.getUsrInfo().getLevel();
		int SleepBed = mainFrame.getUsrSkillList().get(0).getSkillLevel();
		int HpDrink = mainFrame.getUsrSkillList().get(1).getSkillLevel();
		int CoddingDevice = mainFrame.getUsrSkillList().get(2).getSkillLevel();
		int ElecSmok= mainFrame.getUsrSkillList().get(3).getSkillLevel();
		int AppleCom = mainFrame.getUsrSkillList().get(4).getSkillLevel();
					
		int SpdHp = 2500 - (level * 20) - (HpDrink * 50) - (AppleCom * 50);
		int SpdStrs = 2500 - (level * 20) - (AppleCom * 50);
		int SpdHeal = 1500 - (level * 20) - (AppleCom * 50);
		
		if (SpdHp < 10) {
			SpdHp = 10;
		}
		if (SpdStrs < 10) {
			SpdStrs = 10;
		}
		if (SpdHeal < 10) {
			SpdHeal = 10;
		}
		
		IncreaseTotalHp(SpdHp);
		DecreaseTotalStrs(SpdStrs);
		IncreaseTotalHeal(SpdHeal);
	}
	
	public void CtrlPB_Resum() {
		int level = mainFrame.getUsrInfo().getLevel();
		int SleepBed = mainFrame.getUsrSkillList().get(0).getSkillLevel();
		int HpDrink = mainFrame.getUsrSkillList().get(1).getSkillLevel();
		int CoddingDevice = mainFrame.getUsrSkillList().get(2).getSkillLevel();
		int ElecSmok= mainFrame.getUsrSkillList().get(3).getSkillLevel();
		int AppleCom = mainFrame.getUsrSkillList().get(4).getSkillLevel();
						
		int SpdHp = 2500 + (level * 20) + (HpDrink * 50) + (AppleCom * 50);
		int SpdStrs = 700 + (level * 20) + (AppleCom * 50);
		int SpdHeal = 1300 + (level * 20) + (AppleCom * 50);
		
		if (SpdHp < 10) {
			SpdHp = 10;
		}
		if (SpdStrs < 10) {
			SpdStrs = 10;
		}
		if (SpdHeal < 10) {
			SpdHeal = 10;
		}
		
		DecreaseTotalHp(SpdHp);
		IncreaseTotalStrs(SpdStrs);
		DecreaseTotalHeal(SpdHeal);
	}
	

	private void DecreaseTotalHp(int speed) {
		if (ClockHp != null) {
			ClockHp.cancel();
		}
		ClockHp = new Timer();
		hp = mainFrame.getHpbar().getValue();
		hpTask = new TimerTask() {
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (hp <= 0) {
						DeathStudying DeathStudying = new DeathStudying(mainFrame.getX(), mainFrame.getY(), mainFrame);
						DeathStudying.showGUI();
					} else if (hp > 0 && mainFrame.getHealbar().getValue() >= 20) {
						hp--;
					} else if (hp > 0 && mainFrame.getHealbar().getValue() < 20) {
						hp--;
						hp--;
					}
					mainFrame.getHpbar().setValue(hp);
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(speed / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ClockHp.scheduleAtFixedRate(hpTask, 0, 1);		
	}
	
	private void IncreaseTotalHp(int speed) {
		if (ClockHp != null) {
			ClockHp.cancel();
		}
		ClockHp = new Timer();
		hp = mainFrame.getHpbar().getValue();
		TimerTask hpTask = new TimerTask() {
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (hp == 0) {
						ClockHp.cancel();
						DeathStudying DeathStudying = new DeathStudying(mainFrame.getX(), mainFrame.getY(), mainFrame);
						DeathStudying.showGUI();
					}
					if (hp < 100 && mainFrame.getHealbar().getValue() >= 80){
						hp++;
						hp++;
					} else if (hp < 100 && mainFrame.getHealbar().getValue() < 80){
						hp++;
					}
					mainFrame.getHpbar().setValue(hp);
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(speed / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ClockHp.scheduleAtFixedRate(hpTask, 0, 1);		
	}	
	
	private void DecreaseTotalStrs(int speed) {
		if (ClockStrs != null) {
			ClockStrs.cancel();
		}
		ClockStrs = new Timer();
		stress = mainFrame.getStrsBar().getValue();
		TimerTask stressTask = new TimerTask() {
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (stress == 0) {
						ClockStrs.cancel();
					} else if (stress > 0) {
						stress--;
					}
					mainFrame.getStrsBar().setValue(stress);
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(speed / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ClockStrs.scheduleAtFixedRate(stressTask, 0, 1);		
	}
	
	private void IncreaseTotalStrs(int speed) {
		if (ClockStrs != null) {
			ClockStrs.cancel();
		}
		ClockStrs = new Timer();
		stress = mainFrame.getStrsBar().getValue();
		TimerTask stressTask = new TimerTask() {
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (stress < 100) {
						stress++;
					}
					mainFrame.getStrsBar().setValue(stress);
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(speed / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ClockStrs.scheduleAtFixedRate(stressTask, 0, 1);		
	}		
	
	private void DecreaseTotalHeal(int speed) {
		if (ClockHeal != null) {
			ClockHeal.cancel();
		}
		ClockHeal = new Timer();
		health = mainFrame.getHealbar().getValue();
		TimerTask healthTask = new TimerTask() {
			@Override
			public void run() {
				if (mainFrame.isTimeGo()) {
					if (health == 0) {
						ClockHeal.cancel();
					} else if (health > 0 && mainFrame.getStressbar().getValue() >= 80) {
						health--;
						health--;
					} else if (health > 0 && mainFrame.getStressbar().getValue() < 80) {
						health--;
					}
					mainFrame.getHealbar().setValue(health);
				}
				try {
					int gameSpeed = mainFrame.getGameSpeed();
					Thread.sleep(speed / gameSpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ClockHeal.scheduleAtFixedRate(healthTask, 0, 1);		
	}
	
	private void IncreaseTotalHeal(int speed) {
		if (ClockHeal != null) {
			ClockHeal.cancel();
		}
		ClockHeal = new Timer();
		health = mainFrame.getHealbar().getValue();
		TimerTask healthTask = new TimerTask() {
			@Override
			public void run() {
					if (mainFrame.isTimeGo()) {
						if (health < 100 && mainFrame.getStressbar().getValue() <= 20) {
							health++;
							health++;
						} else if (health < 100) {
							health++;
						}
						mainFrame.getHealbar().setValue(health);
					}
					try {
						int gameSpeed = mainFrame.getGameSpeed();
						Thread.sleep(speed / gameSpeed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		};
		ClockHeal.scheduleAtFixedRate(healthTask, 0, 1);		
	}

	public Timer getClockHp() {
		return ClockHp;
	}

	public Timer getClockStrs() {
		return ClockStrs;
	}

	public Timer getClockHeal() {
		return ClockHeal;
	}	
}