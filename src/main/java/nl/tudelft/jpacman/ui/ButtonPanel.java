package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import java.util.ArrayList;

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
     * @param buttons The map of caption - action for each button.
     * @param parent The parent frame, used to return window focus.
     */
    ButtonPanel(final Map<String, Action> buttons, final JFrame parent) {

        super();
        assert buttons != null;
        assert parent != null;
        /*for (final String caption : buttons.keySet()) {
            JButton button = new JButton(caption);
            button.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });*/


        ImageIcon startIcon = new ImageIcon("src/main/resources/start_btn.png");
        Image startImg = startIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
        ImageIcon startBtn = new ImageIcon(startImg);

        ImageIcon stopIcon = new ImageIcon("src/main/resources/pause_btn.png");
        Image stopImg = stopIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
        ImageIcon stopBtn = new ImageIcon(stopImg);

        ImageIcon exitIcon = new ImageIcon("src/main/resources/exit_btn.png");
        Image exitImg = exitIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
        ImageIcon exitBtn = new ImageIcon(exitImg);

        for (final String caption : buttons.keySet()) {

            JButton Startbutton = new JButton(caption);
            JButton Stopbutton = new JButton(caption);
            JButton Exitbutton = new JButton(caption);

            Startbutton.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });

            Stopbutton.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });

            Exitbutton.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });


            if (Startbutton.getText().equals("Start")) {
                Startbutton.setIcon(startBtn);
                Startbutton.setOpaque(false);
                Startbutton.setBorder(null);
                Startbutton.setBorderPainted(false);
                Startbutton.setContentAreaFilled(false);
                Startbutton.setText(" ");
                add(Startbutton);


            } else if (Stopbutton.getText().equals("Stop")) {
                Stopbutton.setIcon(stopBtn);
                Stopbutton.setOpaque(false);
                Stopbutton.setBorder(null);
                Stopbutton.setBorderPainted(false);
                Stopbutton.setContentAreaFilled(false);
                Stopbutton.setText(" ");
                add(Stopbutton);

            } else if (Exitbutton.getText().equals("Exit")) {
                Exitbutton.setIcon(exitBtn);
                Exitbutton.setOpaque(false);
                Exitbutton.setBorder(null);
                Exitbutton.setBorderPainted(false);
                Exitbutton.setContentAreaFilled(false);
                Exitbutton.setText(" ");
                add(Exitbutton);
            }
        }
    }
}

