package view;


import PicturesAndBackground.AudioPlay;
import PicturesAndBackground.Data;
import chessComponent.ChessComponent;
import chessComponent.SquareComponent;
import controller.GameController;
import model.ChessColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private Chessboard chessboard;
    private static JLabel statusLabel;
    private static JLabel RedPointLabel;
    private static JLabel BlackPointLabel;
    private static JLabel AeLabel;
    private static JLabel aeLabel;
    private static JLabel PeLabel;
    private static JLabel peLabel;
    private static JLabel CeLabel;
    private static JLabel ceLabel;
    private static JLabel GeLabel;
    private static JLabel geLabel;
    private static JLabel HeLabel;
    private static JLabel heLabel;
    private static JLabel MeLabel;
    private static JLabel meLabel;
    private static JLabel SeLabel;
    private static JLabel seLabel;
    public static int number = 0;
    JPanel pan;

    public ChessGameFrame(int width, int height) {

//1.把图片添加到标签里（把标签的大小设为和图片大小相同），把标签放在分层面板的最底层；
        ImageIcon bg=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\title.png");
        JLabel label=new JLabel(bg);
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        getLayeredPane().add(label,new Integer(Integer.MIN_VALUE+number));
        number=number+1;
//2.把窗口面板设为内容面板并设为透明、流动布局。
        pan=(JPanel)getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
//3.之后把组件和面板添加到窗口面板就可以；
        JButton btn=new JButton("");
        JButton btnR = new JButton("Apollo");
        JButton btnB = new JButton("Klavier");
        btnR.setBounds(230,435,128,117);
        btnB.setBounds(660,435,95,124);
        btnR.addActionListener((e -> {
            pan.removeAll();addChessboard();
            ImageIcon bg1=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\background.jpg");
            JLabel label1=new JLabel(bg1);
            label1.setSize(bg1.getIconWidth(),bg1.getIconHeight());
            getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE+number));number = number+1;
            setLayout(null);
            addSaveButton();
            addLabel();addAeLabel();addPeLabel();addCeLabel();addGeLabel();addHeLabel();addMeLabel();addSeLabel();addaeLabel();addpeLabel();addceLabel();addgeLabel();addheLabel();addmeLabel();addseLabel();
            addRedPointLabel();addBlackPointLabel();addLoadButton();addCheatButton();addRestartButton();
            getLayeredPane().repaint();
        }));

        btnB.addActionListener((e -> {
            pan.removeAll();addChessboard();
            ImageIcon bg1=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\background.jpg");
            JLabel label1=new JLabel(bg1);
            label1.setSize(bg1.getIconWidth(),bg1.getIconHeight());
            getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE+number));number = number+1;
            setLayout(null);addSaveButton();
            addLabel();addAeLabel();addPeLabel();addCeLabel();addGeLabel();addHeLabel();addMeLabel();addSeLabel();addaeLabel();addpeLabel();addceLabel();addgeLabel();addheLabel();addmeLabel();addseLabel();
            addRedPointLabel();addBlackPointLabel();addLoadButton();addCheatButton();addRestartButton();
            getLayeredPane().repaint();
        }));

//      URL buttonURL = Data.class.getResource("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\button.jpg");
        URL buttonURL = Data.class.getResource("Pictures/button.jpg");
        Icon button = new ImageIcon(buttonURL);
        btn.setIcon(button);
        URL chooseKlavierURL = Data.class.getResource("Pictures/chooseKlavier2.png");
        URL chooseApolloURL = Data.class.getResource("Pictures/chooseApollo2.png");
        Icon ChooseKlavier = new ImageIcon(chooseKlavierURL);
        Icon ChooseApollo = new ImageIcon(chooseApolloURL);
        btnR.setIcon(ChooseApollo);
        btnB.setIcon(ChooseKlavier);
        btnR.setContentAreaFilled(false);
        btnB.setContentAreaFilled(false);
        Action act = new Action();
        btn.addActionListener(act);
        btn.setBounds(358,445,294,60);
        pan.add(btn);
        pan.add(btnR);
        pan.add(btnB);
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
//        AudioPlay.audioPlay court = new AudioPlay.audioPlay(Data.courtPath1);
//        court.run = true;
//        court.start();
        /**
         * 可以放音乐但因为用的是一个线程所以java卡死了，出来了音乐但是出不来图和所有的组件
         */
    }
    public boolean RedStart(){
        if(chessboard.getStartColor()==ChessColor.RED){
            return true;
        }else return false;
    }
    public boolean BlackStart(){
        if(chessboard.getStartColor()==ChessColor.BLACK){
            return true;
        }else return false;
    }

    private class Action implements ActionListener {
        public Action(){
        }
        public void actionPerformed(ActionEvent event){
//ActionEvent对应按钮点击、菜单选择、选择列表项或在文本框中ENTER

            pan.removeAll();
//            pan.setBackground((Color.YELLOW));
            ImageIcon bg1=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\background.jpg");
            JLabel label1=new JLabel(bg1);
            label1.setSize(bg1.getIconWidth(),bg1.getIconHeight());
//            getLayeredPane().removeAll();
            getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE+number));
            number = number+1;
//            pan.add(label,new Integer(Integer.MIN_VALUE));
            setLayout(null);

            addChessboard();
            /**
             * 就是这个地方搞的随机红蓝
             */
//            Random r = new Random();
//            int n =r.nextInt(2);
//            if(n==1){
//                chessboard.setCurrentColor(ChessColor.RED);
//                chessboard.setStartColor(ChessColor.RED);
//            }else{
//                chessboard.setCurrentColor(ChessColor.BLACK);
//                chessboard.setStartColor(ChessColor.BLACK);
//            }
            chessboard.setCurrentColor(ChessColor.NONE);
            addLabel();addRedPointLabel();addBlackPointLabel();
            addAeLabel();addPeLabel();addCeLabel();addGeLabel();addHeLabel();addMeLabel();addSeLabel();addaeLabel();addpeLabel();addceLabel();
            addgeLabel();addheLabel();addmeLabel();addseLabel();
//            addHelloButton();
            addLoadButton();addSaveButton();
            addCheatButton();addRestartButton();
            getLayeredPane().repaint();
            Data.clickNumber = 0;


        }
    }


    /**
     * 在游戏窗体中添加棋盘
     */
    private void addChessboard() {
//        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE / 2, CHESSBOARD_SIZE);
//        Chessboard chessboard = new Chessboard(260,500);//写出来是临时变量
        chessboard = new Chessboard(260,500);//c!!!!!!!!!!!!存下来
        gameController = new GameController(chessboard);
//        chessboard.setLocation(HEIGHT / 10, HEIGHT / 10);
        chessboard.setLocation(368,28);
        add(chessboard);//JFrame的方法，一定要记得add
    }

    /**
     * 在游戏窗体中添加标签
     */
    private void addLabel() {
        statusLabel = new JLabel();
//        statusLabel.setText(String.format("%s'sTURN",chessboard.getCurrentColor().getName()));
        statusLabel.setText(String.format("Decide TURN"));
        chessboard.setCurrentColor(ChessColor.NONE);
//        statusLabel.setLocation(WIDTH * 3 / 5, HEIGHT / 10);
        statusLabel.setLocation(420,0);

        statusLabel.setSize(200, 50);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }
    private void addRedPointLabel(){
        RedPointLabel = new JLabel("Apollo Points:0");
        RedPointLabel.setLocation(100,10);
        RedPointLabel.setSize(200,60);
        RedPointLabel.setFont(new Font("Rockwell",Font.BOLD,20));
        add(RedPointLabel);
    }
    private void addBlackPointLabel(){
        BlackPointLabel = new JLabel("Klavier Points:0");
        BlackPointLabel.setLocation(700,10);
        BlackPointLabel.setSize(200,60);
        BlackPointLabel.setFont(new Font("Rockwell",Font.BOLD,20));
        add(BlackPointLabel);
    }
    //~~~~~~~~~~~~~~~~~

    /**
     * 注意！因为小王吃掉的棋子跑到小王这边去了，被吃的棋子显示反了
     * 所以我把他两标签调换了！！！！！
     * 加图的时候记得反着加！！！小王的label要加黑色的棋子！！
     */
    private void addAeLabel(){
        AeLabel = new JLabel("Advisor:0");
        AeLabel.setBounds(870,10,150,40);
        AeLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(AeLabel);
    }

    private void addPeLabel(){
        PeLabel = new JLabel("Cannon:0");
        PeLabel.setBounds(870,30,150,40);
        PeLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(PeLabel);
    }
    private void addCeLabel(){
        CeLabel = new JLabel("Chariot:0");
        CeLabel.setBounds(870,50,150,40);
        CeLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(CeLabel);
    }
    private void addGeLabel(){
        GeLabel = new JLabel("General:0");
        GeLabel.setBounds(870,70,150,40);
        GeLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(GeLabel);
    }private void addHeLabel(){
        HeLabel = new JLabel("Chariot:0");
        HeLabel.setBounds(870,90,150,40);
        HeLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(HeLabel);
    }
    private void addMeLabel(){
        MeLabel = new JLabel("Minister:0");
        MeLabel.setBounds(870,110,150,40);
        MeLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(MeLabel);
    }
    private void addSeLabel(){
        SeLabel = new JLabel("Soldier:0");
        SeLabel.setBounds(870,130,150,40);
        SeLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(SeLabel);
    }
    private void addaeLabel(){
        aeLabel = new JLabel("Advisor:0");
        aeLabel.setBounds(10,10,150,40);
        aeLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(aeLabel);
    }
    private void addpeLabel(){
        peLabel = new JLabel("Cannon:0");
        peLabel.setBounds(10,30,150,40);
        peLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(peLabel);
    }
    private void addceLabel(){
        ceLabel = new JLabel("Chariot:0");
        ceLabel.setBounds(10,50,150,40);
        ceLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(ceLabel);
    }
    private void addgeLabel(){
        geLabel = new JLabel("General:0");
        geLabel.setBounds(10,70,150,40);
        geLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(geLabel);
    }private void addheLabel(){
        heLabel = new JLabel("Chariot:0");
        heLabel.setBounds(10,90,150,40);
        heLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(heLabel);
    }
    private void addmeLabel(){
        meLabel = new JLabel("Minister:0");
        meLabel.setBounds(10,110,150,40);
        meLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(meLabel);
    }
    private void addseLabel(){
        seLabel = new JLabel("Soldier:0");
        seLabel.setBounds(10,130,150,40);
        seLabel.setFont(new Font("Rockwell",Font.BOLD,17));
        add(seLabel);
    }

    public static JLabel getStatusLabel() {return statusLabel;}
    public static JLabel getRedPointLabel() {return RedPointLabel;}
    public static JLabel getBlackPointLabel() {return BlackPointLabel;}

    public static JLabel getAeLabel() {return AeLabel;}
    public static JLabel getaeLabel() {return aeLabel;}
    public static JLabel getPeLabel() {return PeLabel;}
    public static JLabel getpeLabel() {return peLabel;}
    public static JLabel getCeLabel() {return CeLabel;}
    public static JLabel getceLabel() {return ceLabel;}
    public static JLabel getGeLabel() {return GeLabel;}
    public static JLabel getgeLabel() {return geLabel;}
    public static JLabel getHeLabel() {return HeLabel;}
    public static JLabel getheLabel() {return heLabel;}
    public static JLabel getMeLabel() {return MeLabel;}
    public static JLabel getmeLabel() {return meLabel;}
    public static JLabel getSeLabel() {return SeLabel;}
    public static JLabel getseLabel() {return seLabel;}


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
    private void addCheatButton(){
        JButton CheatButton = new JButton();
        CheatButton.addActionListener((e -> {
            if(firstCheat()==true){
                ImageIcon bgC = new ImageIcon("C:\\Users\\27365\\Desktop\\project\\java\\DarkChess-master\\DarkChess-master\\src\\PicturesAndBackground\\Pictures\\backgroundCheat.jpg");
                JLabel label2 = new JLabel(bgC);
                label2.setSize(bgC.getIconWidth(),bgC.getIconHeight());
                getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE+number));
                number = number+1;
                getLayeredPane().repaint();
//            chessboard.clickController.isCheating=true;//设置可以点 看棋子
                SquareComponent.isCheating=true;
//            chessComponent.setCheating(true);
//            chessComponent.repaint();
//            ChessComponent.isCheating
                SquareComponent[][] squareComponents = chessboard.squareComponents;
                System.out.println(squareComponents[0][0].isCheating);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        squareComponents[i][j].repaint();
                    }
                }
            } else if (firstCheat()==false) {
                ImageIcon bg1=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\background.jpg");
                JLabel label1=new JLabel(bg1);
                label1.setSize(bg1.getIconWidth(),bg1.getIconHeight());
//            getLayeredPane().removeAll();
                getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE+number));
                number = number+1;
                getLayeredPane().repaint();
                SquareComponent.isCheating=false;
                SquareComponent[][] squareComponents = chessboard.squareComponents;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        squareComponents[i][j].repaint();
                    }
                }
            }

        }));
        URL braceletURL = Data.class.getResource("Pictures/bracelet.png");
        Icon bracelet = new ImageIcon(braceletURL);
        CheatButton.setIcon(bracelet);
        CheatButton.setLocation(10,400);
        CheatButton.setSize(122, 95);
        CheatButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        CheatButton.setBackground(Color.LIGHT_GRAY);
        add(CheatButton);
    }
    public boolean firstCheat(){
        if(SquareComponent.isCheating==false){
            return true;
        }else return false;
    }
    public void addRestartButton(){
        JButton RestartButton = new JButton("Restart");
        RestartButton.addActionListener((e -> {

            Data.clickNumber=0;
            Data.Ae=0;Data.ae=0;Data.Pe=0;Data.pe=0;Data.Ce=0;Data.ce=0;Data.Ge=0;Data.ge=0;Data.He=0;Data.he=0;Data.Me=0;Data.me=0;
            Data.Se=0;Data.se=0;
            chessboard.clickController.changeAeLabel();chessboard.clickController.changeaeLabel();chessboard.clickController.changePeLabel();
            chessboard.clickController.changepeLabel();chessboard.clickController.changeCeLabel();chessboard.clickController.changeceLabel();
            chessboard.clickController.changeGeLabel();chessboard.clickController.changegeLabel();chessboard.clickController.changeHeLabel();
            chessboard.clickController.changeheLabel();chessboard.clickController.changeMeLabel();chessboard.clickController.changemeLabel();
            chessboard.clickController.changeSeLabel();chessboard.clickController.changeseLabel();

            SquareComponent[][] squareComponents=new SquareComponent[8][4];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    squareComponents[i][j]= chessboard.squareComponents[i][j];
                    squareComponents[i][j].isReversal = false;
                    squareComponents[i][j].setSelected(false);
                    SquareComponent.isCheating=false;
                }
            }

            Data.RedPoint=0;
            chessboard.clickController.changeRedPoints();
            Data.BlackPoint=0;
            chessboard.clickController.changeBlackPoints();
            statusLabel.setText(String.format("Decide TURN"));
            chessboard.setCurrentColor(ChessColor.NONE);
            chessboard.initAllChessOnBoard();

            ImageIcon bg1=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\background.jpg");
            JLabel label1=new JLabel(bg1);
            label1.setSize(bg1.getIconWidth(),bg1.getIconHeight());
//            getLayeredPane().removeAll();
            getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE+number));
            number = number+1;
        }));
        RestartButton.setLocation(800,400);
        RestartButton.setSize(90, 30);
        RestartButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        RestartButton.setBackground(Color.LIGHT_GRAY);
        add(RestartButton);
    }

    private void addSaveButton(){
        JButton SaveButton = new JButton("Save");
        SaveButton.setBounds(140,460,100,60);
        SaveButton.setFont(new Font("Rockwell",Font.BOLD,20));
        SaveButton.setBackground(Color.LIGHT_GRAY);
        add(SaveButton);
        SaveButton.addActionListener(e -> {
            try {
                gameController.saveGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    private void addLoadButton() {
        JButton button = new JButton("Load");
//        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 240);
        button.setLocation(140,400);
        button.setSize(100, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setBackground(Color.LIGHT_GRAY);
        add(button);
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
                                    for (int j = 0; j < 4; j++) {
                                        char chess = chessData.get(i).charAt(j);

                                        if (chess != 'c' && chess != 'C' && chess != 'P' && chess != 'p' && chess != 'M' &&
                                                chess != 'm' && chess != 'A' && chess != 'a' && chess != 'g' && chess != 'G' && chess != 'h' && chess != 'H' && chess != 's'&&chess!='S'&&chess!='_') {
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
                            if(chessData.size()>10) {
                                JOptionPane.showConfirmDialog(null, "错误代码:105", "提示", JOptionPane.DEFAULT_OPTION);
                                return;
                            }

                        }
                            catch (IOException ex) {
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

    public Chessboard getChessboard() {
        return chessboard;
    }

    public static int getNumber() {
        return number;
    }
}
