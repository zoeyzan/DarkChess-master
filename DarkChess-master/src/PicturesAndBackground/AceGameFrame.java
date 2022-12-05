package PicturesAndBackground;
import PicturesAndBackground.GamePanel;

import javax.swing.*;

public class AceGameFrame extends JFrame{


    public AceGameFrame() {

        setBounds(10,10,985,599);

        setResizable(false);
        add(new GamePanel());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了

        setVisible(true);
        setTitle("Ace Attorney: Dark Chess Apollo vs Klavier");
        //记得加按钮，鼠标判定，命令。
    }

}
