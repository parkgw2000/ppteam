package database.dblist;

public class User {
	private int id;
	private String userId;
	private String userPw;
	private String userNickname;
	
	public User(int id, String userId, String userPw, String userNickname) {
		super();
		this.id = id;
		this.userId = userId;
		this.userPw = userPw;
		this.userNickname = userNickname;
	}
	public User(String userId, String userPw, String userNickname) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userNickname = userNickname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsrId() {
		return userId;
	}
	public void setUsrId(String userId) {
		this.userId = userId;
	}
	public String getUsrPw() {
		return userPw;
	}
	public void setUsrPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUsrNickname() {
		return userNickname;
	}
	public void setUsrNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userPw=" + userPw + ", userNickname=" + userNickname + "]";
	}
}
