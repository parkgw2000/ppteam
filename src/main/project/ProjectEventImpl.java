package main.project;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import database.dblist.UserProject;
import main.DeathStudying;
import main.MainFrame;

public class ProjectEventImpl {
	
	private MainFrame mainFrame;
	
	public ProjectEventImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public int searchNowProject(List<UserProject> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isProceeding() && !list.get(i).isComplete()) {
				return i;
			}
		}
		return -1;
	}

	
	
	public void expProgressBar(int addExp) {
		int levelExp = mainFrame.getUsrInfo().getLevel() * 100;
		int charExp = mainFrame.getExpbar().getValue();
		int input = (int) (charExp + (((double) addExp / (double) levelExp) * 100));
		if (input >= 100) {
			int level = Integer.valueOf(mainFrame.getLevellbl().getText());
			mainFrame.getLevellbl().setText(String.valueOf(level + 1));
			mainFrame.getUsrInfo().setLevel(level + 1);
			mainFrame.getUsrInfo().setCiga(mainFrame.getUsrInfo().getCiga() + 10);
			mainFrame.getNumOfcigalbl().setText(String.valueOf(mainFrame.getUsrInfo().getCiga()));
			int hp = mainFrame.getHpbar().getValue() + 30;
			int stress = mainFrame.getStrsBar().getValue() - 30;
			int health = mainFrame.getHealbar().getValue() + 30;
			if (hp >= 100) {
				mainFrame.getHpbar().setValue(100);
			} else {
				mainFrame.getHpbar().setValue(hp);
			}
			if (stress <= 100) {
				mainFrame.getStressbar().setValue(0);
			} else {
				mainFrame.getStressbar().setValue(stress);
			}
			if (health >= 100) {
				mainFrame.getHealbar().setValue(100);
			} else {
				mainFrame.getHealbar().setValue(health);
			}
			
			double a = ((double) level / (double) (level + 1));
			input = (int) ((input - 100) * a);
			mainFrame.getExpbar().setValue(input);
		} else {
			mainFrame.getExpbar().setValue(input);
		}
	}
}
