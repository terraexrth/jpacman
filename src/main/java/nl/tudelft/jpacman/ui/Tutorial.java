package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;

public class Tutorial extends JFrame{
    private JButton select;

    public Tutorial() {
        setTitle("JPacman");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundImage = new ImageIcon("src/main/resources/selector_bg.png");
        Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);

        ImageIcon realImg = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(realImg);

        select = new JButton("Select");

        select.addActionListener(e -> {
            this.setVisible(false);
            new Launcher().launch();
        });
        backgroundLabel.add(select);
        select.setBounds(getBounds());
        add(backgroundLabel, BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String[] args) {

    }
}
