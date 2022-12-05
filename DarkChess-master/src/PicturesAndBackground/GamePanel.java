package PicturesAndBackground;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Data.Title.paintIcon(this,g,0,0);
        /*
        JButton button1 = new JButton();
        button1.setIcon(button);
        add(button1);
        
         */
    }
}
