package view;

import PicturesAndBackground.AceGameFrame;
import PicturesAndBackground.GamePanel;

import javax.swing.*;

public class StartTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        AceGameFrame frame = new AceGameFrame();
        
        frame.setVisible(true);
        });
    }
}
