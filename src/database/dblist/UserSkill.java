package database.dblist;

public class UserSkill {
	private int id;
	private int userId;
	private int infoId;
	private int skillId;
	private int skillLevel;
	public UserSkill(int id, int userId, int infoId, int skillId, int skillLevel) {
		super();
		this.id = id;
		this.userId = userId;
		this.infoId = infoId;
		this.skillId = skillId;
		this.skillLevel = skillLevel;
	}
	
	public UserSkill(int userId, int infoId, int skillId, int skillLevel) {
		super();
		this.userId = userId;
		this.infoId = infoId;
		this.skillId = skillId;
		this.skillLevel = skillLevel;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsrId() {
		return userId;
	}
	public void setUsrId(int userId) {
		this.userId = userId;
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
	@Override
	public String toString() {
		return "UserSkill [id=" + id + ", userId=" + userId + ", infoId=" + infoId + ", skillId=" + skillId
				+ ", skillLevel=" + skillLevel + "]";
	}
	
}
