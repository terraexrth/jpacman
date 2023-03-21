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
	JButton back;

	public YouLose() {
		setTitle("JPacman");
		setSize(600, 800);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon backgroundImage = new ImageIcon("src/main/resources/bg/lose_bg.png");
		Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
		ImageIcon realImg = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(realImg);

		ImageIcon exitIcon = new ImageIcon("src/main/resources/button/mainmenu_btn.png");
		Image exitImg = exitIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon exitBtn = new ImageIcon(exitImg);

		System.out.println();
		label1.setText("Your Score : " + Player.getScore());
		label1.setFont(new Font("monospace", Font.BOLD, 32));
		label1.setForeground(Color.WHITE);
        if (Game.getTotaltime() < 60.0) {
		    label2.setText("Your Time : " + Game.getStringtotaltime() + " s");
		}
        else if (Game.getTotaltime() >= 60.0) {
            label2.setText("Your Time : " + Game.calulatetime());
        }
		label2.setFont(new Font("monospace", Font.BOLD, 32));
		label2.setForeground(Color.WHITE);

		back = new JButton(" ");
		back.setIcon(exitIcon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setBorder(null);

		back.addActionListener(e -> {
			this.setVisible(false);
			new MainMenu();
		});

		this.setLocationRelativeTo(null);
		backgroundLabel.setLayout(null);
		add(backgroundLabel, BorderLayout.CENTER);
		backgroundLabel.add(label1);
		backgroundLabel.add(label2);
		backgroundLabel.add(back);
		label1.setBounds(165, 450, 1000, 50);
		label2.setBounds(145, 500, 1000, 50);
		back.setBounds(200, 670, 200, 50);

		setVisible(true);

	}
}
