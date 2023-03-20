package nl.tudelft.jpacman.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class YouLose extends JFrame {
	JButton test;
	JLabel label1 = new JLabel("test");

	public YouLose() {
		setTitle("JPacman");
		setSize(600, 800);
		setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		label1.setText("Your Score : 5555555");
		label1.setFont(new Font("Serif", Font.BOLD, 32));

		this.setLocationRelativeTo(null);
		add(label1);
		label1.setBounds(100, 300, 1000, 50);
	}
}
