package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu extends JFrame {
	private JButton startButton;
	private JButton tutorialButton;
	private JButton leaderButton;
	private JButton exitButton;

	private MapSelector mapSelector;
	private Tutorial tutorialSelector;

	private LeaderBorder leaderBorderSelector;

	public void openMap() {
		mapSelector = new MapSelector();
		mapSelector.setVisible(true);
	}

	public void openTutorial() {
		tutorialSelector = new Tutorial();
		tutorialSelector.setVisible(true);
	}

	public void openLeaderBorder() {
		leaderBorderSelector = new LeaderBorder();
		leaderBorderSelector.setVisible(true);
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JButton getTutorialButton() {
		return tutorialButton;
	}

	public JButton getLeaderButton() {
		return leaderButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public MapSelector getMapSelector() {
		return mapSelector;
	}

	public Tutorial getTutorialSelector() {
		return tutorialSelector;
	}

	public LeaderBorder getLeaderBorderSelector() {
		return leaderBorderSelector;
	}

	public MainMenu() {
		// Set up the frame
		setTitle("JPacman");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

		ImageIcon backgroundImage = new ImageIcon("src/main/resources/bg/pac_bg.png");
		Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
		ImageIcon realImg = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(realImg);

		ImageIcon startIcon = new ImageIcon("src/main/resources/button/start_btn.png");
		Image startImg = startIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon startBtn = new ImageIcon(startImg);

		ImageIcon tutorialIcon = new ImageIcon("src/main/resources/button/tutorial_btn.png");
		Image turImg = tutorialIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon tutorialBtn = new ImageIcon(turImg);

		ImageIcon leaderIcon = new ImageIcon("src/main/resources/button/leaderboard_btn.png");
		Image leaderImg = leaderIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon leaderBtn = new ImageIcon(leaderImg);

		ImageIcon exitIcon = new ImageIcon("src/main/resources/button/exit_btn.png");
		Image exitImg = exitIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon exitBtn = new ImageIcon(exitImg);

		ImageIcon icon = new ImageIcon("src/main/resources/icon.png");
		Image iconImg = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		setIconImage(iconImg);

		// Set up the button
		startButton = new JButton("");
		startButton.setIcon(startBtn);
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.setBorder(null);

		startButton.addActionListener(e -> {
			this.setVisible(false);
			openMap();
		});

		tutorialButton = new JButton("");
		tutorialButton.setIcon(tutorialBtn);
		tutorialButton.setOpaque(false);
		tutorialButton.setContentAreaFilled(false);
		tutorialButton.setBorderPainted(false);
		tutorialButton.setBorder(null);

		tutorialButton.addActionListener(e -> {
			this.setVisible(false);
			openTutorial();
		});

		leaderButton = new JButton("");
		leaderButton.setIcon(leaderBtn);
		leaderButton.setOpaque(false);
		leaderButton.setContentAreaFilled(false);
		leaderButton.setBorderPainted(false);
		leaderButton.setBorder(null);

		leaderButton.addActionListener(e -> {
			this.setVisible(false);
			openLeaderBorder();
		});

		leaderButton.setVisible(false);

		exitButton = new JButton("");
		exitButton.setIcon(exitBtn);
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setBorder(null);
		exitButton.addActionListener(e -> {
			this.dispose();
		});
		// Set up the panel
		// JPanel panel = new JPanel();
		// panel.setOpaque(false);
		// panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		// panel.add(startButton);
		// panel.add(tutorialButton);

		// add(panel, BorderLayout.CENTER);

		// add(panel);

		backgroundLabel.add(startButton, BorderLayout.CENTER);
		backgroundLabel.add(tutorialButton, BorderLayout.CENTER);
		backgroundLabel.add(leaderButton, BorderLayout.CENTER);
		backgroundLabel.add(exitButton, BorderLayout.CENTER);
		startButton.setBounds(200, 220, 200, 50);
		tutorialButton.setBounds(200, 290, 200, 50);
		leaderButton.setBounds(200, 360, 200, 50);
		exitButton.setBounds(200, 360, 200, 50);
		backgroundLabel.setLayout(null);
		add(backgroundLabel, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		new MainMenu();
	}

}
