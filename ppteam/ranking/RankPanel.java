package main.ranking;

import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class RankPanel extends JPanel {
	
	private JLabel rankLabel;
	private JLabel nickNameLabel;
	private JLabel timeLabel;
	private JLabel usedCigaLabel;
	private JLabel dateLabel;
	private JLabel scoreLabel;
	
	public RankPanel() {
		
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		setBorder(eborder);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 540, 100);
		setLayout(null);
		
		rankLabel = new JLabel("1st");
		rankLabel.setBorder(eborder);
		rankLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setForeground(Color.BLACK);
		rankLabel.setBackground(Color.WHITE);
		rankLabel.setOpaque(true);
		rankLabel.setBounds(10, 10, 80, 80);
		add(rankLabel);
		
		nickNameLabel = new JLabel("Nickname");
		nickNameLabel.setBorder(eborder);
		nickNameLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		nickNameLabel.setForeground(Color.BLACK);
		nickNameLabel.setBackground(Color.WHITE);
		nickNameLabel.setOpaque(true);
		nickNameLabel.setBounds(104, 10, 424, 28);
		add(nickNameLabel);
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL URLCigaImage = classLoader.getResource("images/rank_img/ciga.png");
		ImageIcon cigaImageIcon = new ImageIcon(URLCigaImage);
		
		scoreLabel = new JLabel("Score: 4444");
		scoreLabel.setBorder(eborder);
		scoreLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setForeground(Color.BLACK);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setOpaque(true);
		scoreLabel.setBounds(155, 48, 91, 42);
		add(scoreLabel);
		
		JLabel scoreTextLabel = new JLabel("Total");
		scoreTextLabel.setBorder(eborder);
		scoreTextLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		scoreTextLabel.setOpaque(true);
		scoreTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreTextLabel.setForeground(Color.BLACK);
		scoreTextLabel.setBackground(Color.WHITE);
		scoreTextLabel.setBounds(104, 48, 39, 42);
		add(scoreTextLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(eborder);
		panel.setBounds(403, 48, 125, 42);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel cigaImageLabel = new JLabel();
		cigaImageLabel.setBackground(new Color(255, 0, 0, 0));
		panel.add(cigaImageLabel, BorderLayout.WEST);
		cigaImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cigaImageLabel.setIcon(cigaImageIcon);
		cigaImageLabel.setOpaque(true);
		
		
		usedCigaLabel = new JLabel("X444");
		panel.add(usedCigaLabel);
		usedCigaLabel.setBorder(eborder);
		usedCigaLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		usedCigaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usedCigaLabel.setForeground(Color.BLACK);
		usedCigaLabel.setBackground(Color.WHITE);
		usedCigaLabel.setOpaque(true);
		
		dateLabel = new JLabel("4 DAY");
		dateLabel.setBounds(258, 48, 65, 42);
		dateLabel.setBorder(eborder);
		dateLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(Color.BLACK);
		dateLabel.setBackground(Color.WHITE);
		dateLabel.setOpaque(true);
		add(dateLabel);
		
		timeLabel = new JLabel("13:20");
		timeLabel.setBounds(335, 48, 56, 42);
		timeLabel.setBorder(eborder);
		timeLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setBackground(Color.WHITE);
		timeLabel.setOpaque(true);
		add(timeLabel);
		
	}

	@Override
	public Dimension preferredSize() {
		return new Dimension(540, 100);
	}
	
	public JLabel getRankLabel() {
		return rankLabel;
	}

	public JLabel getNickNameLabel() {
		return nickNameLabel;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public JLabel getUsedCigaLabel() {
		return usedCigaLabel;
	}

	public JLabel getDateLabel() {
		return dateLabel;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}
}
