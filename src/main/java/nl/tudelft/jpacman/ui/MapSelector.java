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
	private JButton map1;
	private JButton map2;
	private JButton map3;
	private JButton map4;
	private JButton map5;

	public MapSelector() {
		setTitle("JPacman");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon backgroundImage = new ImageIcon("src/main/resources/pac_bg.png");
		Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);

		ImageIcon realImg = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(realImg);

		select = new JButton("Select");

		select.addActionListener(e -> {
			this.setVisible(false);
			new Launcher().launch();
		});
		backgroundLabel.add(select);

		add(backgroundLabel, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String[] args) {

	}
}
