package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;

public class YouLose extends JFrame {
	JButton test;
	JLabel label1 = new JLabel("test");
	JLabel label2 = new JLabel(" ");

	public YouLose() {
		setTitle("JPacman");
		setSize(600, 800);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon backgroundImage = new ImageIcon("src/main/resources/bg/lose_bg.png");
		Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
		ImageIcon realImg = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(realImg);
		System.out.println();
		label1.setText("Your Score : " + Player.getScore());
		label1.setFont(new Font("monospace", Font.BOLD, 32));
		label1.setForeground(Color.WHITE);
		label2.setText("Your Time : " + Game.getTotaltime() + " s");
		label2.setFont(new Font("monospace", Font.BOLD, 32));
		label2.setForeground(Color.WHITE);

		this.setLocationRelativeTo(null);
		backgroundLabel.setLayout(null);
		add(backgroundLabel, BorderLayout.CENTER);
		backgroundLabel.add(label1);
		backgroundLabel.add(label2);

		label1.setBounds(180, 450, 1000, 50);
		label2.setBounds(165, 500, 1000, 50);
	}
}
