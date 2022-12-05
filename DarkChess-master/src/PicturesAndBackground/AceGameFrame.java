package PicturesAndBackground;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AceGameFrame extends JFrame{
    private JPanel gamePanel;


    public AceGameFrame() {
        gamePanel = new JPanel();
        setBounds(10,10,985,599);
        setResizable(false);
        setVisible(true);
       //add(gamePanel);

        ImageIcon bg = Data.title;
        JLabel label = new JLabel(bg);
        getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把图加到label再把label加到frame的panel上
        //gamePanel.add(label);
        //Data.title.paintIcon(gamePanel,g,0,0);
        //加按钮
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setVisible(true);
        setTitle("Ace Attorney: Dark Chess Apollo vs Klavier");
        //加按钮
        //还没加鼠标判定和命令
        URL buttonURL = Data.class.getResource("Pictures/button.jpg");
        Icon button = new ImageIcon(buttonURL);
        JButton button1 = new JButton();
        button1.setIcon(button);
        button1.setVisible(true);
        setLayout(null);
        button1.setBounds(358,445,294,60);

        gamePanel.add(button1);
        //add(gamePanel);
        gamePanel.setOpaque(false);




    }

}
