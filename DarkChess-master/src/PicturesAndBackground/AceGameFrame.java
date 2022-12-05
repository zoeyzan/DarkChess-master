package PicturesAndBackground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class AceGameFrame extends JFrame{
    private JPanel gamePanel;
    private JPanel buttonPanel;


    public AceGameFrame() {
        gamePanel = new JPanel();
        setBounds(10,10,985,599);
        setResizable(false);
        setVisible(true);
        add(gamePanel);
        ImageIcon bg = Data.title;
        JLabel label = new JLabel(bg);
        //getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把图加到label再把label加到frame的panel上
        gamePanel.add(label);
        //Data.title.paintIcon(gamePanel,g,0,0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setVisible(true);
        setTitle("Ace Attorney: Dark Chess Apollo vs Klavier");
        //加按钮
        //还没加鼠标判定和命令
        buttonPanel = new JPanel();
        URL buttonURL = Data.class.getResource("Pictures/button.jpg");
        Icon button = new ImageIcon(buttonURL);
        JButton button1 = new JButton();
        button1.setIcon(button);
        button1.setVisible(true);
        //setLayout(null);

        button1.setBounds(358,445,294,60);

        buttonPanel.add(button1);
        //add(gamePanel);
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(null);
        add(buttonPanel);
        ButtonAction Action1 = new ButtonAction(1);
        button1.addActionListener(Action1);



    }
    class ButtonAction implements ActionListener {
        int buttonType;
        public ButtonAction(int n) {
            buttonType = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(buttonType==1){
                ImageIcon backGround1 = Data.background;
                JLabel label2 = new JLabel(backGround1);
                gamePanel.removeAll();
                gamePanel.add(label2);
                buttonPanel.removeAll();
                gamePanel.updateUI();
                //可以切换页面了，接下来就是把这一个按钮切换成谁先打，然后接一个开始游戏的方法，在那个方法里面放上棋子。
            }
        }
    }

}
