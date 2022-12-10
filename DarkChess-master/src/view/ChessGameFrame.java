package view;


import PicturesAndBackground.Data;
import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 这个类表示游戏窗体，窗体上包含：
 * 1 Chessboard: 棋盘
 * 2 JLabel:  标签
 * 3 JButton： 按钮
 */
public class ChessGameFrame extends JFrame {//JFrame
    private final int WIDTH;
    private final int HEIGHT;
    public final int CHESSBOARD_SIZE;
    private GameController gameController;
    private static JLabel statusLabel;
    JPanel pan;

    public ChessGameFrame(int width, int height) {

//1.把图片添加到标签里（把标签的大小设为和图片大小相同），把标签放在分层面板的最底层；
        ImageIcon bg=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\title.png");
        JLabel label=new JLabel(bg);
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
//2.把窗口面板设为内容面板并设为透明、流动布局。
        pan=(JPanel)getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
//3.之后把组件和面板添加到窗口面板就可以；
        JButton btn=new JButton("测试按钮");

//      URL buttonURL = Data.class.getResource("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\button.jpg");
        URL buttonURL = Data.class.getResource("Pictures/button.jpg");
        Icon button = new ImageIcon(buttonURL);
        btn.setIcon(button);

        Action act = new Action();
        btn.addActionListener(act);
        btn.setBounds(358,445,294,60);
        pan.add(btn);
        setSize(bg.getIconWidth(),bg.getIconHeight());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


//        setTitle("2022 CS109 Project Demo"); //设置标题
        setTitle("Ace Attorney: Dark Chess Apollo vs Klavier");
        this.WIDTH = width;
        this.HEIGHT = height;
        this.CHESSBOARD_SIZE = HEIGHT * 4 / 5;

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // Center the window.
//        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
//        setLayout(null);
//
//        addChessboard();
//        addLabel();
//        addHelloButton();
//        addLoadButton();
    }
    private class Action implements ActionListener {
        public Action(){
        }
        public void actionPerformed(ActionEvent event){
//ActionEvent对应按钮点击、菜单选择、选择列表项或在文本框中ENTER
            pan.removeAll();
//            pan.setBackground((Color.YELLOW));
            ImageIcon bg=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\background.jpg");
            JLabel label=new JLabel(bg);
            label.setSize(bg.getIconWidth(),bg.getIconHeight());
//            getLayeredPane().removeAll();
            getLayeredPane().add(label,new Integer(Integer.MIN_VALUE+1));
//            pan.add(label,new Integer(Integer.MIN_VALUE));
            setLayout(null);

            addChessboard();
            addLabel();
//            addHelloButton();
            addLoadButton();
            getLayeredPane().repaint();
        }
    }


    /**
     * 在游戏窗体中添加棋盘
     */
    private void addChessboard() {
//        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE / 2, CHESSBOARD_SIZE);
        Chessboard chessboard = new Chessboard(260,500);
        gameController = new GameController(chessboard);
//        chessboard.setLocation(HEIGHT / 10, HEIGHT / 10);
        chessboard.setLocation(368,28);
        add(chessboard);//JFrame的方法，一定要记得add
    }

    /**
     * 在游戏窗体中添加标签
     */
    private void addLabel() {
        statusLabel = new JLabel("BLACK's TURN");
//        statusLabel.setLocation(WIDTH * 3 / 5, HEIGHT / 10);
        statusLabel.setLocation(100,500);

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
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));//监听器，一旦被点击则会执行后面语句
        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 120);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }


    private void addLoadButton() {
        JButton button = new JButton("Load");
//        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 240);
        button.setLocation(100,400);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setBackground(Color.LIGHT_GRAY);
        add(button);
// TODO:  105行棋步骤的存储
        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this, "Input Path here");
            gameController.loadGameFromFile(path);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setMultiSelectionEnabled(false);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    path = file.getAbsolutePath();
                    String[] part = path.split("\\.");
                    if (part[part.length - 1].equals("txt")) {
                        try {
                            List<String> chessData = Files.readAllLines(Paths.get(path));
                            for (int i = 0; i < 8; i++) {
                                if (chessData.get(i).length() != 4) {
                                    JOptionPane.showConfirmDialog(null, "错误代码:102", "提示", JOptionPane.DEFAULT_OPTION);
                                    return;
                                } else {
                                    //103
                                    for (int j = 0; j < 8; j++) {
                                        char chess = chessData.get(i).charAt(j);
                                        if (chess != 'c' && chess != 'C' && chess != 'P' && chess != 'p' && chess != 'M' &&
                                                chess != 'm' && chess != 'A' && chess != 'a' && chess != 'g' && chess != 'G' && chess != 'h' && chess != 'H' && chess != 'k') {
                                            JOptionPane.showConfirmDialog(null, "错误代码:103", "提示", JOptionPane.DEFAULT_OPTION);
                                            return;
                                        }
                                    }
                                }
                            }
                            if (!chessData.get(8).equals("B") && !chessData.get(8).equals("R")) {
                                JOptionPane.showConfirmDialog(null, "错误代码:104", "提示", JOptionPane.DEFAULT_OPTION);
                                return;
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        gameController.loadGameFromFile(path);
                    } else {
                        //不是txt文件
                        JOptionPane.showConfirmDialog(null, "错误代码:101", "提示", JOptionPane.DEFAULT_OPTION);
                    }
                }
                if (result == JFileChooser.CANCEL_OPTION) {
                    fileChooser.setVisible(false);
                }
            });


    }

}
