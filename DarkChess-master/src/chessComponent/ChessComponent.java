package chessComponent;

import PicturesAndBackground.Data;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import javax.swing.*;
import java.awt.*;

/**
 * 表示棋盘上非空棋子的格子，是所有非空棋子的父类
 */
public class ChessComponent extends SquareComponent {
    protected String name;// 棋子名字：例如 兵，卒，士等
    protected int priority;// 棋子的优先级，判断能不能吃别的棋子
    protected int points;//棋子的得分
    protected int number;//棋子的个数
    private JPanel chessPanel;

    public ChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size, String name, int priority, int points, int number) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.name = name;
        this.priority = priority;
        this.points = points;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
    }

    @Override
    protected void paintComponent(Graphics g) {//如果我用label放在panel上的方法画棋子，那鼠标监听就是点到label？
        super.paintComponent(g);
/*
        //绘制棋子填充色
        g.setColor(Color.ORANGE);
        g.fillOval(spacingLength, spacingLength, this.getWidth() - 2 * spacingLength, this.getHeight() - 2 * spacingLength);
       //绘制棋子边框
        g.setColor(Color.DARK_GRAY);
        g.drawOval(spacingLength, spacingLength, getWidth() - 2 * spacingLength, getHeight() - 2 * spacingLength);
 */
        chessPanel = new JPanel();
        add(chessPanel);
        ImageIcon emptyImageIcon = Data.empty;
        JLabel labelEmpty = new JLabel(emptyImageIcon);
        labelEmpty.setVisible(true);
        chessPanel.add(labelEmpty);
        chessPanel.setBounds(500, 10, 300, 300);


        if (isReversal) {
            /*
            //绘制棋子文字
            g.setColor(this.getChessColor().getColor());
            g.setFont(CHESS_FONT);
            g.drawString(this.name, this.getWidth() / 4, this.getHeight() * 2 / 3);

             */
            if (this instanceof AdvisorChessComponent) {
                if (isSelected()) {//选中
                    //加图片然后用上面的方法
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RShiSII = Data.RShiS;
                        JLabel labelRShiS = new JLabel(RShiSII);
                        chessPanel.add(labelRShiS);
                        labelRShiS.setVisible(true);
                    } else {
                        ImageIcon BShiSII = Data.BShiS;
                        JLabel labelBShiS = new JLabel(BShiSII);
                        chessPanel.add(labelBShiS);
                        labelBShiS.setVisible(true);
                    }
                } else {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RShiII = Data.RShi;
                        JLabel labelRShi = new JLabel(RShiII);
                        chessPanel.add(labelRShi);
                        labelRShi.setVisible(true);
                    } else {
                        ImageIcon BShiII = Data.BShi;
                        JLabel labelBShi = new JLabel(BShiII);
                        chessPanel.add(labelBShi);
                        labelBShi.setVisible(true);
                    }
                }
            } else if (this instanceof CannonChessComponent) {
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }
            } else if (this instanceof ChariotChessComponent) {
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }
            } else if (this instanceof GeneralChessComponent) {
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }
            } else if (this instanceof HorseChessComponent) {
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }
            } else if (this instanceof MinisterChessComponent) {
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }
            } else if (this instanceof SoldierChessComponent) {
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){

                    }else{

                    }
                }
            }
            //绘制棋子被选中时状态
                    /*if (isSelected()) {

                        g.setColor(Color.RED);
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setStroke(new BasicStroke(4f));
                        g2.drawOval(spacingLength, spacingLength, getWidth() - 2 * spacingLength, getHeight() - 2 * spacingLength);

                    }

                     */
        }
    }
}

