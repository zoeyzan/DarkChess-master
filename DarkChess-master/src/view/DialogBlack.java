package view;

import PicturesAndBackground.Data;
import chessComponent.SquareComponent;
import model.ChessColor;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import static view.ChessGameFrame.number;

public class DialogBlack extends JDialog {
    JPanel pan;

    public ChessGameFrame GameFrame = Data.gameFrame;


    public DialogBlack(){
        this.setVisible(true);
        this.setModal(false);
        //仿照frame里面的写法
        //1.把图片添加到标签里（把标签的大小设为和图片大小相同），把标签放在分层面板的最底层；
        URL KlavierWinsURL = Data.class.getResource("Pictures/KlavierWins.png");
        ImageIcon KlavierWins = new ImageIcon(KlavierWinsURL);
        JLabel KlavierWinsLabel = new JLabel(KlavierWins);
        KlavierWinsLabel.setSize(KlavierWins.getIconWidth(),KlavierWins.getIconHeight());
        getLayeredPane().add(KlavierWinsLabel,new Integer(Integer.MIN_VALUE));
        //2.把窗口面板设为内容面板并设为透明、流动布局。
        pan = (JPanel)getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        //3.之后把组件和面板添加到窗口面板就可以；
        setTitle("Congratulations to Klavier!");
        this.setBounds(400,200,KlavierWins.getIconWidth(),KlavierWins.getIconHeight());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//        JLabel congratulation = new JLabel("Klavier I Love You!\n            ----Apollo");
//        congratulation.setFont(new Font("Rockwell",Font.BOLD,20));
//        congratulation.setBounds(10,10,100,50);
//        pan.add(congratulation);
        JButton restartbtn=new JButton("restart");
        restartbtn.setBounds(100,100,80,50);
        restartbtn.setVisible(true);
        getLayeredPane().add(restartbtn);//1
        pan.add(restartbtn);//4
        restartbtn.addActionListener((e -> {
            //语句和ChessGameFrame里面的restart是几乎一样的
            Data.clickNumber=0;
            Data.Ae=0;Data.ae=0;Data.Pe=0;Data.pe=0;Data.Ce=0;Data.ce=0;Data.Ge=0;Data.ge=0;Data.He=0;Data.he=0;Data.Me=0;Data.me=0;
            Data.Se=0;Data.se=0;
            GameFrame.getChessboard().clickController.changeAeLabel();GameFrame.getChessboard().clickController.changeaeLabel();GameFrame.getChessboard().clickController.changePeLabel();
            GameFrame.getChessboard().clickController.changepeLabel();GameFrame.getChessboard().clickController.changeCeLabel();GameFrame.getChessboard().clickController.changeceLabel();
            GameFrame.getChessboard().clickController.changeGeLabel();GameFrame.getChessboard().clickController.changegeLabel();GameFrame.getChessboard().clickController.changeHeLabel();
            GameFrame.getChessboard().clickController.changeheLabel();GameFrame.getChessboard().clickController.changeMeLabel();GameFrame.getChessboard().clickController.changemeLabel();
            GameFrame.getChessboard().clickController.changeSeLabel();GameFrame.getChessboard().clickController.changeseLabel();

            SquareComponent[][] squareComponents=new SquareComponent[8][4];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    squareComponents[i][j]= GameFrame.getChessboard().squareComponents[i][j];
                    squareComponents[i][j].isReversal = false;
                    squareComponents[i][j].setSelected(false);
                    SquareComponent.isCheating=false;
                }
            }

            Data.RedPoint=0;
            GameFrame.getChessboard().clickController.changeRedPoints();
            Data.BlackPoint=0;
            GameFrame.getChessboard().clickController.changeBlackPoints();
            GameFrame.getStatusLabel().setText(String.format("Decide TURN"));
            GameFrame.getChessboard().setCurrentColor(ChessColor.NONE);
            GameFrame.getChessboard().initAllChessOnBoard();

            ImageIcon bg1=new ImageIcon("C:\\Users\\27365\\IdeaProjects\\test1\\project\\src\\PicturesAndBackground\\Pictures\\background.jpg");
            JLabel label1=new JLabel(bg1);
            label1.setSize(bg1.getIconWidth(),bg1.getIconHeight());
//            getLayeredPane().removeAll();
            getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE+number));
            number = number+1;
            this.dispose();
        }));
        pan.add(restartbtn);//2
        getLayeredPane().add(restartbtn);//3
        pan.repaint();
        getLayeredPane().repaint();
    }
}
