package view;

import PicturesAndBackground.GamePanel;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(10,10,985,599);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new GamePanel());
        frame.setVisible(true);
        frame.setTitle("Ace Attorney: Dark Chess Apollo vs Klavier");

    }
}
