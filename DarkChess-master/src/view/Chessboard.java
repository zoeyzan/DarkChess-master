package view;


import PicturesAndBackground.Data;
import chessComponent.*;
import model.*;
import controller.ClickController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 这个类表示棋盘组建，其包含：
 * SquareComponent[][]: 4*8个方块格子组件
 */
public class Chessboard extends JComponent {


    private static final int ROW_SIZE = 8;
    private static final int COL_SIZE = 4;
    public int win;

    public final SquareComponent[][] squareComponents = new SquareComponent[ROW_SIZE][COL_SIZE];
    private ChessColor currentColor = ChessColor.BLACK;
    public ChessColor StartColor = ChessColor.BLACK;

    //all chessComponents in this chessboard are shared only one model controller
    public final ClickController clickController = new ClickController(this);
    private final int CHESS_SIZE;

    public int getCHESS_SIZE() {
        return CHESS_SIZE;
    }

    public ArrayList<String> step=new ArrayList<>();


    public Chessboard(int width, int height) {
        setLayout(null); // Use absolute layout.
//        setSize(width + 2, height);
        setSize(width , height);
        CHESS_SIZE = (height-4 ) / 8;
        SquareComponent.setSpacingLength(CHESS_SIZE / 12);
        System.out.printf("chessboard [%d * %d], chess size = %d\n", width, height, CHESS_SIZE);

        initAllChessOnBoard();
    }
    public Chessboard(int width,int height,int n){//我重载的
        setLayout(null); // Use absolute layout.
        setSize(width,height);
        CHESS_SIZE = (height - 6) / 8;
        SquareComponent.setSpacingLength(CHESS_SIZE / 12);
        System.out.printf("chessboard [%d * %d], chess size = %d\n", width, height, CHESS_SIZE);
        initAllChessOnBoard();
        System.out.println("yes i do get in this shit");
    }

    public SquareComponent[][] getChessComponents() {
        return squareComponents;
    }

    public ChessColor getCurrentColor() {
        return currentColor;
    }
    public ChessColor getStartColor(){
        return StartColor;
    }

    public void setCurrentColor(ChessColor currentColor) {
        this.currentColor = currentColor;
    }
    public void setStartColor(ChessColor startColor){
        this.StartColor = startColor;
    }

    /**
     * 将SquareComponent 放置在 ChessBoard上。里面包含移除原有的component及放置新的component
     *
     * @param squareComponent
     */
    public void putChessOnBoard(SquareComponent squareComponent) {
        int row = squareComponent.getChessboardPoint().getX(), col = squareComponent.getChessboardPoint().getY();
        if (squareComponents[row][col] != null) {
            remove(squareComponents[row][col]);
        }
        add(squareComponents[row][col] = squareComponent);
    }

    /**
     * 交换chess1 chess2的位置
     *
     * @param chess1
     * @param chess2
     */
    public void swapChessComponents(SquareComponent chess1, SquareComponent chess2) {
        // Note that chess1 has higher priority, 'destroys' chess2 if exists.
        if (!(chess2 instanceof EmptySlotComponent)) {
            remove(chess2);
            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), clickController, CHESS_SIZE));
        }
        chess1.swapLocation(chess2);
        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();

        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
        squareComponents[row2][col2] = chess2;
        squareComponents[row1][col1] = chess1;
        step.add(String.format("%d%d%d%d%s",row2,col2,row1,col1,chess1.getName()));
        //只重新绘制chess1 chess2，其他不变
        chess1.repaint();
        chess2.repaint();
        chooseWinner(Data.RedPoint,Data.BlackPoint);
        if(win==1){
            JOptionPane.showConfirmDialog(null, "红方获胜", "提示", JOptionPane.DEFAULT_OPTION);
        }else if(win==2){
            JOptionPane.showConfirmDialog(null, "黑方获胜", "提示", JOptionPane.DEFAULT_OPTION);
        }
        step.add(String.format("%d%d%d%d%s",row2,col2,row1,col1,"_"));
    }
    /**清除棋子，用于restart功能
     * */
     public void clearChessComponents(){
         for (int i = 0; i < 8; i++) {
             for (int j = 0; j < 4; j++) {
                add(squareComponents[i][j]=new EmptySlotComponent(squareComponents[i][j].getChessboardPoint(),
                        squareComponents[i][j].getLocation(),clickController,CHESS_SIZE));
                 remove(squareComponents[i][j]);
                 squareComponents[i][j].repaint();
             }
         }
     }

    /**
     * 将所有的棋子初始化
     *

     */

    public void initAllChessOnBoard() {
        Random random = new Random();
        ArrayList<Integer>A =new ArrayList<>();
        ArrayList<Integer>B =new ArrayList<>();
        for (int k = 0; k < 32; k++) {
            A.add(k);
        }
        for (int k = 0; k < 16; k++) {
            B.add(0);
            B.add(1);
        }

        for (int i = 0; i < squareComponents.length; i++) {
            for (int j = 0; j < squareComponents[i].length; j++) {
                int n = random.nextInt(A.size());
                SquareComponent squareComponent;

                if (A.get(n)>=0 && A.get(n)<=3) {
                    //炮Cannon
                    ChessColor color = B.get(n) == 0 ? ChessColor.RED : ChessColor.BLACK;
                    squareComponent = new CannonChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), color, clickController, CHESS_SIZE);
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);

                } else if (A.get(n)>=4&&A.get(n)<=13) {
                    //兵Soldier

                    ChessColor color = B.get(n) == 0 ? ChessColor.RED : ChessColor.BLACK;
                    squareComponent = new SoldierChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), color, clickController, CHESS_SIZE);
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);

                } else if (A.get(n)>=14&&A.get(n)<=17) {
                    //马horse

                    ChessColor color = B.get(n) == 0 ? ChessColor.RED : ChessColor.BLACK;
                    squareComponent = new HorseChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), color, clickController, CHESS_SIZE);
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);


                } else if (A.get(n)>=18&&A.get(n)<=21) {
                    //车chariot

                    ChessColor color = B.get(n) == 0 ? ChessColor.RED : ChessColor.BLACK;
                    squareComponent = new ChariotChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), color, clickController, CHESS_SIZE);
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);

                } else if (A.get(n)>=22&&A.get(n)<=25) {
                    //minister相

                    ChessColor color = B.get(n) == 0 ? ChessColor.RED : ChessColor.BLACK;
                    squareComponent = new MinisterChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), color, clickController, CHESS_SIZE);
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);

                } else if (A.get(n)>=26&&A.get(n)<=29) {
                    //士 advisor

                    ChessColor color = B.get(n) == 0 ? ChessColor.RED : ChessColor.BLACK;
                    squareComponent = new AdvisorChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), color, clickController, CHESS_SIZE);
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);

                } else if (A.get(n)>=30&&A.get(n)<=31) {
                    //将军general

                    ChessColor color = B.get(n) == 0 ? ChessColor.RED : ChessColor.BLACK;
                    squareComponent = new GeneralChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), color, clickController, CHESS_SIZE);
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);
                }
                A.remove(n);
                B.remove(n);

            }
        }
    }




    /**
     * 绘制棋盘格子
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.fillRect(0, 0, this.getWidth(), this.getHeight());
//        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    /**
     * 将棋盘上行列坐标映射成Swing组件的Point
     *
     * @param row 棋盘上的行
     * @param col 棋盘上的列
     * @return
     */
    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE + 3, row * CHESS_SIZE + 3);
    }

    /**
     * 通过GameController调用该方法
     *
     * @param chessData
     */
    public void loadGame(List<String> chessData) {
        char [][] loadChessBoard =new char[9][4];
        for (int i = 0; i < chessData.size(); i++) {
            for (int j = 0; j < chessData.get(i).length(); j++) {
                loadChessBoard[i][j]=chessData.get(i).charAt(j);
            }
        }
        if(chessData.get(8).equals("B")) setCurrentColor(ChessColor.BLACK);
        if(chessData.get(8).equals("R")) setCurrentColor(ChessColor.RED);
        for(int i=0;i<chessData.size()-9;i++){
            step.add(chessData.get(i+9));
        }
        System.out.println(Arrays.toString(loadChessBoard));
        chessData.forEach(System.out::println);//这两行只是看一下有没有导进去
        initialBoardByChar(loadChessBoard);
    }
    public void chooseWinner(int RedPoint,int BlackPoint){
        if(RedPoint>=60) win=1;
        if(BlackPoint>=60) win=2;
    }
    /**
     * red:  c s a g m h p
     *
     *  black:C S A G M H P
     *     把每一个棋子用代号表示


     */
    public void initialBoardByChar(char[][] symbols){
        if(symbols[8][0]=='R') setCurrentColor(ChessColor.RED);
        if(symbols[8][0]=='B') setCurrentColor(ChessColor.BLACK);
        //导入当前的行棋方
        for (int i = 0; i < squareComponents.length; i++) {
            for (int j = 0; j < squareComponents[i].length; j++) {
                SquareComponent squareComponent=null;
                switch (symbols[i][j]){
                    case 'c':
                        squareComponent = new ChariotChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                        break;
                    case 'C':
                        squareComponent = new ChariotChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                        break;
                    case 's':
                        squareComponent = new SoldierChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                        break;
                    case 'S':
                        squareComponent = new SoldierChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                        break;
                    case 'p':
                        squareComponent = new CannonChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                        break;
                    case 'P':
                        squareComponent = new CannonChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                        break;
                    case 'h':
                        squareComponent = new HorseChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                        break;
                    case 'H':
                        squareComponent = new HorseChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                        break;
                    case 'a':
                        squareComponent = new AdvisorChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                        break;
                    case 'A':
                        squareComponent = new AdvisorChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                        break;
                    case 'g':
                        squareComponent = new GeneralChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                        break;
                    case 'G':
                        squareComponent = new GeneralChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                        break;
                    case 'm':
                        squareComponent = new MinisterChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                        break;
                    case 'M':
                        squareComponent = new MinisterChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                        break;

                }
                squareComponent.setVisible(true);
                putChessOnBoard(squareComponent);
            }
        }

    }

}
