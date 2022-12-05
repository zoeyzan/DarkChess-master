package PicturesAndBackground;
import PicturesAndBackground.GamePanel;

import javax.swing.*;

public class AceGameFrame extends JFrame{
    private final int WIDTH;
    private final int HEIGHT;

    public AceGameFrame(int width, int height) {

        setBounds(10,10,985,599);
        this.WIDTH = width;
        this.HEIGHT = height;
        add(new GamePanel());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

    }
}
