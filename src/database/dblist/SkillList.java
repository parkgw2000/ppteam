package database.dblist;

import java.awt.Image;

public class SkillList {
	private int skillId;
	private String skillName;
	private int price;
	private String description;
	private Image image;
	public SkillList(int skillId, String skillName, int price, String description, Image image) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.price = price;
		this.description = description;
		this.image = image;
	}
	public SkillList(String skillName, int price, String description, Image image) {
		super();
		this.skillName = skillName;
		this.price = price;
		this.description = description;
		this.image = image;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "skillList [skillId=" + skillId + ", skillName=" + skillName + ", price=" + price + ", description="
				+ description + ", image=" + image + "]";
	}
	
}
