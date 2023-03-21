package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LeaderBorder extends JFrame {
	private JButton backButton;

	public LeaderBorder() {
		setTitle("JPacman");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		JLabel rankText = new JLabel("");
		ImageIcon backgroundImage = new ImageIcon("src/main/resources/bg/pac_bg.png");
		Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);

		ImageIcon realImg = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(realImg);
		backgroundLabel.setLayout(null);

		ImageIcon backIcon = new ImageIcon("src/main/resources/button/back_btn.png");
		Image backImg = backIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon backBtn = new ImageIcon(backImg);

		ImageIcon icon = new ImageIcon("src/main/resources/icon.png");
		Image iconImg = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		JSONParser jsonParser = new JSONParser();
		ArrayList<String> data = new ArrayList<>();
		try {
			FileReader reader = new FileReader("src/main/resources/scoreboard.json");
			// Object obj = jsonParser.parse(reader);

			JSONArray scoreList = (JSONArray) jsonParser.parse(reader);

			for (Object o : scoreList) {
				JSONObject rank = (JSONObject) o;

				String name = (String) rank.get("name");
				long score = (long) rank.get("score");
				String map = (String) rank.get("map");
				Double time = (Double) rank.get("time");

				data.add(name + "        " + Long.toString(score) + "        " + map + "        "
						+ Double.toString(time));
			}
			String name_col[][] = { { data.get(0) }, { data.get(1) }, { data.get(2) }, { data.get(3) } };

			String header[] = { "Col1" };

			JTable table = new JTable(name_col, header);

			table.setBounds(180, 300, 250, 100);
			backgroundLabel.add(table);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setIconImage(iconImg);
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
		backgroundLabel.add(rankText);
		backgroundLabel.add(backButton);
		backButton.setBounds(200, 500, 200, 50);
		add(backgroundLabel, BorderLayout.CENTER);

	}

	public static void parseScoreObject(JSONObject score) {
		JSONObject scoreObject = (JSONObject) score.get("name");

		String name = (String) score.get("name");
		System.out.println(name);
	}

	public static void main(String[] args) {

	}

}
