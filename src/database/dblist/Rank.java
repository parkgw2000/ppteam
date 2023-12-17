package database.dblist;

public class Rank {
	
	private String nickname;
	private int score;
	private int userinfoId;
	private int userid;
	
	public Rank(String nickname, int score, int userinfoId, int userid) {
		super();
		this.nickname = nickname;
		this.score = score;
		this.userinfoId = userinfoId;
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getUsrinfoId() {
		return userinfoId;
	}

	public void setUsrinfoId(int userinfoId) {
		this.userinfoId = userinfoId;
	}

	public int getUsrid() {
		return userid;
	}

	public void setUsrid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Rank [" + "nickname=" + nickname + ", score=" + score + ", userinfoId=" + userinfoId
				+ ", userid=" + userid + "]";
	}
}
