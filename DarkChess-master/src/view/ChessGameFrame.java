package view;

import PicturesAndBackground.Data;
import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * 这个类表示游戏窗体，窗体上包含：
 * 1 Chessboard: 棋盘
 * 2 JLabel:  标签
 * 3 JButton： 按钮
 */
public class ChessGameFrame extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;
    public final int CHESSBOARD_SIZE;
    private GameController gameController;
    private static JLabel statusLabel;
    private JPanel gamePanel;
    private JPanel buttonPanel;

    public ChessGameFrame(int width,int height) {
//        gamePanel = new JPanel();
//        gamePanel.setVisible(true);
        setBounds(10,10,985,599);
        setResizable(false);
        setVisible(true);
        ImageIcon bg = Data.title;
        JLabel label = new JLabel(bg);
        getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //
//        add(gamePanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了

        setTitle("Ace Attorney: Dark Chess Apollo vs Klavier");
        buttonPanel=(JPanel)getContentPane();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(null);
        URL buttonURL = Data.class.getResource("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\button.jpg");
        Icon button = new ImageIcon(buttonURL);

        JButton button1 = new JButton("test");
        button1.setIcon(button);
        button1.setVisible(true);

        button1.setBounds(358,445,294,60);

        buttonPanel.add(button1);
//        add(gamePanel);
        buttonPanel.setOpaque(false);
        gamePanel.setOpaque(false);
        buttonPanel.setLayout(null);
        add(buttonPanel);
        ButtonAction Action1 = new ButtonAction(1);
        button1.addActionListener(Action1);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //-----------------------------------------------------
//        setTitle("2022 CS109 Project Demo"); //设置标题

        this.WIDTH = width;
        this.HEIGHT = height;
        this.CHESSBOARD_SIZE = HEIGHT * 4 / 5;

        setSize(WIDTH, HEIGHT);
//        setLocationRelativeTo(null); // Center the window.
//        getContentPane().setBackground(Color.WHITE);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
//        setLayout(null);
//
//        addChessboard();
//        addLabel();
//        addHelloButton();
//        addLoadButton();
    }
    //---------------------------------------------------------------
    class ButtonAction implements ActionListener {
        int buttonType;
        public ButtonAction(int n) {
            buttonType = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(buttonType==1){
                System.out.println("duychxsjm");

                buttonPanel.removeAll();
                ImageIcon backGround1 = Data.background;
                JLabel label2 = new JLabel(backGround1);
                label2.setSize(985,599);
                getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE+1));
//                this.WIDTH = width;
//                this.HEIGHT = height;
//                this.CHESSBOARD_SIZE = HEIGHT * 4 / 5;

//                setSize(WIDTH, HEIGHT);
//                setLocationRelativeTo(null); // Center the window.
//                getContentPane().setBackground(Color.WHITE);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
                setLayout(null);

                addChessboard();
                addLabel();
                addHelloButton();
                addLoadButton();
                repaint();
                getLayeredPane().repaint();

//                gamePanel.removeAll();
//                gamePanel.add(label2,new Integer(Integer.MIN_VALUE));
//                buttonPanel.removeAll();
//                gamePanel.updateUI();
//                addChessboard(1);
//                addLabel();
//                repaint();
//                gamePanel.updateUI();
                //可以切换页面了，接下来就是把这一个按钮切换成谁先打，然后接一个开始游戏的方法，在那个方法里面放上棋子。
            }
        }
    }

//-------------------------------------------------------------
    /**
     * 在游戏窗体中添加棋盘
     */
    private void addChessboard() {
        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE / 2, CHESSBOARD_SIZE);
        gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGHT / 10, HEIGHT / 10);
        add(chessboard);
    }
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void addChessboard(int n) {
        Chessboard chessboard = new Chessboard(260,500,1);
        gameController = new GameController(chessboard);
        chessboard.setLocation(376,40);//数据测试中
        add(chessboard);
        chessboard.setVisible(true);
    }

//------------------------------------------------------------------


    /**
     * 在游戏窗体中添加标签
     */
    private void addLabel() {
        statusLabel = new JLabel("BLACK's TURN");
        statusLabel.setLocation(WIDTH * 3 / 5, HEIGHT / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    public static JLabel getStatusLabel() {
        return statusLabel;
    }

    /**
     * 在游戏窗体中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("Show Hello Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));
        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 120);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

    }


    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 240);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setBackground(Color.LIGHT_GRAY);
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this, "Input Path here");
            gameController.loadGameFromFile(path);
        });


    }

}
