package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LeaderBorder extends JFrame {
	private JButton backButton;

	public LeaderBorder() {
		setTitle("JPacman");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		ImageIcon backgroundImage = new ImageIcon("src/main/resources/bg/pac_bg.png");
		Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);

		ImageIcon realImg = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(realImg);
		backgroundLabel.setLayout(null);

		ImageIcon backIcon = new ImageIcon("src/main/resources/button/back_btn.png");
		Image backImg = backIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon backBtn = new ImageIcon(backImg);

		backButton = new JButton("Select");

		backButton.addActionListener(e -> {
			this.setVisible(false);
			new MainMenu();
		});

		backButton.setIcon(backBtn);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBorderPainted(false);

		backgroundLabel.add(backButton);
		backButton.setBounds(200, 500, 200, 50);
		add(backgroundLabel, BorderLayout.CENTER);

	}

	public static void main(String[] args) {

	}

}
