package PicturesAndBackground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GamePanel extends JPanel {

    private Graphics g;
    JPanel tmp = this;
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.g = g;
        Data.title.paintIcon(this,g,0,0);
        //按钮
        setLayout(null);
        URL buttonURL = Data.class.getResource("Pictures/button.jpg");
        Icon button = new ImageIcon(buttonURL);
        JButton button1 = new JButton();
        button1.setIcon(button);
        button1.setVisible(true);
        //按钮大小

        button1.setBounds(358,445,294,60);
        add(button1);
        ButtonAction Action1 = new ButtonAction(1);
        button1.addActionListener(Action1);
    }
    protected void paintComponent2(Graphics g){
        super.paintComponent(g);
        removeAll();
        Data.background.paintIcon(this,g,0,0);
    }
    class ButtonAction implements ActionListener{
        int buttonType;
        public ButtonAction(int n) {
            buttonType = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(buttonType ==1){
                System.out.println("asd");
                tmp.removeAll();
                tmp.repaint();
//                revalidate();

//                paintComponent2(g);
//                repaint();
                //paintComponent2(g);
            }
        }
    }
}
