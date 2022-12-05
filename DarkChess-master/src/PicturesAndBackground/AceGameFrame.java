package PicturesAndBackground;
import PicturesAndBackground.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AceGameFrame extends JFrame{


    public AceGameFrame() {

        setBounds(10,10,985,599);
        setResizable(false);
        add(new GamePanel());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了

        setVisible(true);
        setTitle("Ace Attorney: Dark Chess Apollo vs Klavier");
        //加按钮
        /*
        URL buttonURL = Data.class.getResource("Pictures/button.jpg");
        Icon button = new ImageIcon(buttonURL);
        JButton button1 = new JButton();
        button1.setIcon(button);
        add(button1);
        button1.setVisible(true);
        button1.setBounds(500,300,100,100);//仅是测试
        草！！怎么变成只有图片了！！我背景出现了一帧然后就消失了！
        //还没加鼠标判定和命令

         */
    }

}
