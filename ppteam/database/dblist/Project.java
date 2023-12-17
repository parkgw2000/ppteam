package database.dblist;

public class Project {
	private int id;
	private String projectName;
	private int rewardExp;
	private int time;
	public Project(int id, String projectName, int rewardExp, int time) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.rewardExp = rewardExp;
		this.time = time;
	}
	public Project(String projectName, int rewardExp, int time) {
		super();
		this.projectName = projectName;
		this.rewardExp = rewardExp;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getRewardExp() {
		return rewardExp;
	}
	public void setRewardExp(int rewardExp) {
		this.rewardExp = rewardExp;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", rewardExp=" + rewardExp + ", time=" + time
				+ "]";
	}
}
