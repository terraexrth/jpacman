package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.tudelft.jpacman.Launcher;

public class MainMenu extends JFrame {
	private JButton startButton;
	private JButton tutorialButton;

	public MainMenu() {
		// Set up the frame
		setTitle("Main Menu");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon backgroundImage = new ImageIcon("src/main/resources/pac_bg.png");
		Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
		ImageIcon realImg = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(realImg);
		backgroundLabel.setLayout(new BorderLayout());
		// Set up the button
		startButton = new JButton("Start");

		startButton.addActionListener(e -> {
			this.setVisible(false);
			new Launcher().launch();
		});

		tutorialButton = new JButton("Tutorial");

		// Set up the panel
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel.add(startButton);
		panel.add(tutorialButton);

		// add(panel, BorderLayout.CENTER);

		// add(panel);
		backgroundLabel.add(startButton);
		startButton.setLocation(0, -100);
		backgroundLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(backgroundLabel, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		new MainMenu();
	}
}
