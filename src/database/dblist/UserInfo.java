package database.dblist;

public class UserInfo {
	private int infoId;
	private int date;
	private int time;
	private int level;
	private int exp;
	private int hp;
	private int health;
	private int stress;
	private int ciga;
	private int usedCiga;
	private boolean hide;
	private boolean tory;
	private boolean gameover;
	private int userId;
	public UserInfo(int infoId, int date, int time, int level, int exp, int hp, int health, int stress, int ciga,
			int usedCiga, boolean hide, boolean tory, boolean gameover, int userId) {
		super();
		this.infoId = infoId;
		this.date = date;
		this.time = time;
		this.level = level;
		this.exp = exp;
		this.hp = hp;
		this.health = health;
		this.stress = stress;
		this.ciga = ciga;
		this.usedCiga = usedCiga;
		this.hide = hide;
		this.tory = tory;
		this.gameover = gameover;
		this.userId = userId;
	}
	public UserInfo(int date, int time, int level, int exp, int hp, int health, int stress, int ciga,
			int usedCiga, boolean hide, boolean tory, boolean gameover, int userId) {
		super();
		this.date = date;
		this.time = time;
		this.level = level;
		this.exp = exp;
		this.hp = hp;
		this.health = health;
		this.stress = stress;
		this.ciga = ciga;
		this.usedCiga = usedCiga;
		this.hide = hide;
		this.tory = tory;
		this.gameover = gameover;
		this.userId = userId;
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getStress() {
		return stress;
	}
	public void setStress(int stress) {
		this.stress = stress;
	}
	public int getCiga() {
		return ciga;
	}
	public void setCiga(int ciga) {
		this.ciga = ciga;
	}
	public int getUsedCiga() {
		return usedCiga;
	}
	public void setUsedCiga(int usedCiga) {
		this.usedCiga = usedCiga;
	}
	public boolean isGameover() {
		return gameover;
	}
	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}
	public int getUsrId() {
		return userId;
	}
	public void setUsrId(int userId) {
		this.userId = userId;
	}
	
	public boolean isHide() {
		return hide;
	}
	public void setHide(boolean hide) {
		this.hide = hide;
	}
	public boolean isTory() {
		return tory;
	}
	public void setTory(boolean tory) {
		this.tory = tory;
	}
	@Override
	public String toString() {
		return "UserInfo [infoId=" + infoId + ", date=" + date + ", time=" + time + ", level=" + level + ", exp=" + exp
				+ ", hp=" + hp + ", health=" + health + ", stress=" + stress + ", ciga=" + ciga + ", usedCiga="
				+ usedCiga + ", hide=" + hide + ", tory=" + tory + ", gameover=" + gameover + ", userId=" + userId
				+ "]";
	}

}
