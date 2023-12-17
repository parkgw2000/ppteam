package database.dblist;

public class CigaLog {
	private int lId;
	private String msg;
	private int userId;
	private int infoId;
	public CigaLog(int lId, String msg, int userId, int infoId) {
		super();
		this.lId = lId;
		this.msg = msg;
		this.userId = userId;
		this.infoId = infoId;
	}
	public CigaLog(String msg, int userId, int infoId) {
		super();
		this.msg = msg;
		this.userId = userId;
		this.infoId = infoId;
	}
	public int getLId() {
		return lId;
	}
	public void setLId(int lId) {
		this.lId = lId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
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
	@Override
	public String toString() {
		return "CigaLog [lId=" + lId + ", msg=" + msg + ", userId=" + userId + ", infoId=" + infoId + "]";
	}
}
