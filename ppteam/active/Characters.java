package main.active;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import guiDesign.Methods;
import main.MainFrame;

public class Characters extends JLabel {
	private ImageIcon defaultImage = Methods.convertToIcon(getClass(), "images/character/character.png");
	private ImageIcon smokeImage = Methods.convertToIcon(getClass(), "images/character/smokecharatcer.png");
	private ImageIcon sleepImage = Methods.convertToIcon(getClass(), "images/active_img/sleep.png");
	private ImageIcon bedsleepImage = Methods.convertToIcon(getClass(), "images/active_img/bedsleep.png");
	private ImageIcon playgameImage = Methods.convertToIcon(getClass(), "images/active_img/playgame.png");
	private ImageIcon coupangImage = Methods.convertToIcon(getClass(), "images/active_img/coupang.png");
	private ImageIcon eatImage = Methods.convertToIcon(getClass(), "images/active_img/eat.png");
	private ImageIcon resumeImage = Methods.convertToIcon(getClass(), "images/active_img/resume.png");
	
	private MainFrame mainFrame = null;
	private JLabel characterlbl;
	private JLabel activelbl;
	
	public Characters(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void defaultCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(getDefaultImage());
		characterlbl.setBounds(211, 392, 210, 300);
		setCharacterlbl(characterlbl);
		setActivelbl(activelbl);
		mainFrame.add(characterlbl);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void smokeCharacter() {	
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(smokeImage);
		characterlbl.setBounds(211, 392, 210, 300);
		mainFrame.add(characterlbl);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
		
	public void bedsleepCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(bedsleepImage);
		characterlbl.setBounds(543, 345, 480, 260);
		mainFrame.add(characterlbl);	
		mainFrame.setProjectGo(false);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void playgameCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(defaultImage);
		characterlbl.setBounds(211, 392, 210, 300);
		activelbl.setIcon(playgameImage);
		activelbl.setBounds(331, 47, 408, 335);
		mainFrame.add(characterlbl);
		mainFrame.add(activelbl);	
		mainFrame.setProjectGo(false);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void eatCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(defaultImage);
		characterlbl.setBounds(211, 392, 210, 300);
		activelbl.setIcon(eatImage);
		activelbl.setBounds(331, 47, 408, 335);
		mainFrame.add(characterlbl);
		mainFrame.add(activelbl);	
		mainFrame.setProjectGo(false);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void resumeCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(defaultImage);
		characterlbl.setBounds(211, 392, 210, 300);
		activelbl.setIcon(resumeImage);
		activelbl.setBounds(331, 47, 408, 335);
		mainFrame.add(characterlbl);
		mainFrame.add(activelbl);	
		mainFrame.setProjectGo(false);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void coupangCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(defaultImage);
		characterlbl.setBounds(211, 392, 210, 300);
		activelbl.setIcon(coupangImage);
		activelbl.setBounds(306, 0, 490, 418);
		mainFrame.add(characterlbl);
		mainFrame.add(activelbl);
		mainFrame.getActivitybtn().setEnabled(false);
		mainFrame.setProjectGo(false);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public JLabel getCharacterlbl() {
		return characterlbl;
	}
	public void setCharacterlbl(JLabel characterlbl) {
		this.characterlbl = characterlbl;
	}
	public JLabel getActivelbl() {
		return activelbl;
	}
	public void setActivelbl(JLabel activelbl) {
		this.activelbl = activelbl;
	}

	public ImageIcon getDefaultImage() {
		return defaultImage;
	}
}
