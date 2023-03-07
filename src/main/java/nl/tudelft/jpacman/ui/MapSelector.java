package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import nl.tudelft.jpacman.Launcher;

public class MapSelector extends JFrame {
	private JButton select;
	private JButton map1Button;
	private JButton map2Button;
	private JButton map3Button;
	private JButton map4Button;
	private JButton map5Button;

	public MapSelector() {
		setTitle("JPacman");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon backgroundImage = new ImageIcon("src/main/resources/selector_bg.png");
		Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);

		ImageIcon map1Icon = new ImageIcon("src/main/resources/confirm_btn.png");
		Image map1Img = map1Icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon map1Btn = new ImageIcon(map1Img);

		ImageIcon map2Icon = new ImageIcon("src/main/resources/confirm_btn.png");
		Image map2Img = map2Icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon map2Btn = new ImageIcon(map2Img);

		ImageIcon map3Icon = new ImageIcon("src/main/resources/confirm_btn.png");
		Image map3Img = map3Icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon map3Btn = new ImageIcon(map3Img);

		ImageIcon map4Icon = new ImageIcon("src/main/resources/confirm_btn.png");
		Image map4Img = map4Icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon map4Btn = new ImageIcon(map4Img);

		ImageIcon map5Icon = new ImageIcon("src/main/resources/confirm_btn.png");
		Image map5Img = map5Icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon map5Btn = new ImageIcon(map5Img);

		ImageIcon realImg = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(realImg);

		map1Button = new JButton("");
		map1Button.setIcon(map1Btn);
		map1Button.setOpaque(false);
		map1Button.setContentAreaFilled(false);
		map1Button.setBorderPainted(false);
		map1Button.setBorder(null);

		map1Button.addActionListener(e -> {
			this.setVisible(false);
			new Launcher().launch_map1();
		});

		map2Button = new JButton("");
		map2Button.setIcon(map2Btn);
		map2Button.setOpaque(false);
		map2Button.setContentAreaFilled(false);
		map2Button.setBorderPainted(false);
		map2Button.setBorder(null);

		map2Button.addActionListener(e -> {
			this.setVisible(false);
			new Launcher().launch_map2();
		});

		map3Button = new JButton("");
		map3Button.setIcon(map3Btn);
		map3Button.setOpaque(false);
		map3Button.setContentAreaFilled(false);
		map3Button.setBorderPainted(false);
		map3Button.setBorder(null);

		map3Button.addActionListener(e -> {
			this.setVisible(false);
			new Launcher().launch_map3();
		});

		map4Button = new JButton("");
		map4Button.setIcon(map4Btn);
		map4Button.setOpaque(false);
		map4Button.setContentAreaFilled(false);
		map4Button.setBorderPainted(false);
		map4Button.setBorder(null);

		map4Button.addActionListener(e -> {
			this.setVisible(false);
			new Launcher().launch();
		});

		map5Button = new JButton("");
		map5Button.setIcon(map5Btn);
		map5Button.setOpaque(false);
		map5Button.setContentAreaFilled(false);
		map5Button.setBorderPainted(false);
		map5Button.setBorder(null);

		map5Button.addActionListener(e -> {
			this.setVisible(false);
			new Launcher().launch();
		});

		backgroundLabel.add(map1Button, BorderLayout.CENTER);
		backgroundLabel.add(map2Button, BorderLayout.CENTER);
		backgroundLabel.add(map3Button, BorderLayout.CENTER);
		backgroundLabel.add(map4Button, BorderLayout.CENTER);
		backgroundLabel.add(map5Button, BorderLayout.CENTER);

		map1Button.setBounds(200, 250, 200, 50);
		map2Button.setBounds(200, 320, 200, 50);
		map3Button.setBounds(200, 390, 200, 50);
		map4Button.setBounds(200, 460, 200, 50);
		map5Button.setBounds(200, 530, 200, 50);

		add(backgroundLabel, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {

	}
}
