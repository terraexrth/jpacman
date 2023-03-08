package nl.tudelft.jpacman.ui;

import java.awt.Color;
import java.awt.Image;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A panel containing a button for every registered action.
 *
 * @author Jeroen Roosen
 */
class ButtonPanel extends JPanel {

	/**
	 * Default serialisation ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create a new button panel with a button for every action.
	 * 
	 * @param buttons The map of caption - action for each button.
	 * @param parent  The parent frame, used to return window focus.
	 */
	ButtonPanel(final Map<String, Action> buttons, final JFrame parent) {
		super();
		assert buttons != null;
		assert parent != null;
		setBackground(Color.BLACK);

		ImageIcon startIcon = new ImageIcon("src/main/resources/button/start_btn.png");
		Image startImg = startIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
		ImageIcon startBtn = new ImageIcon(startImg);

		ImageIcon pauseIcon = new ImageIcon("src/main/resources/button/pause_btn.png");
		Image pauseImg = pauseIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
		ImageIcon pauseBtn = new ImageIcon(pauseImg);

		ImageIcon exitIcon = new ImageIcon("src/main/resources/button/exit_btn.png");
		Image exitImg = exitIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
		ImageIcon exitBtn = new ImageIcon(exitImg);

		for (final String caption : buttons.keySet()) {
			JButton button = new JButton(caption);
			button.addActionListener(e -> {
				buttons.get(caption).doAction();
				parent.requestFocusInWindow();
			});
			if (button.getText().equals("Start")) {
				button.setIcon(startBtn);

			} else if (button.getText().equals("Stop")) {
				button.setIcon(pauseBtn);
			} else if (button.getText().equals("Exit")) {
				button.setIcon(exitBtn);
			}
			button.setOpaque(false);
			button.setBorder(null);
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setText(" ");
			add(button);

			System.out.println(button.getText());

		}

	}
}
