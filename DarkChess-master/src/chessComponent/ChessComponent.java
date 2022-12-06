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
                        ImageIcon RPaoSII = Data.RPaoS;
                        JLabel labelRPaoS = new JLabel(RPaoSII);
                        chessPanel.add(labelRPaoS);
                        labelRPaoS.setVisible(true);
                    }else{
                        ImageIcon BPaoSII = Data.BPaoS;
                        JLabel labelBPaoS = new JLabel(BPaoSII);
                        chessPanel.add(labelBPaoS);
                        labelBPaoS.setVisible(true);
                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RPaoII = Data.RPao;
                        JLabel labelRPao = new JLabel(RPaoII);
                        chessPanel.add(labelRPao);
                        labelRPao.setVisible(true);
                    }else{
                        ImageIcon BPaoII = Data.BPao;
                        JLabel labelBPao = new JLabel(BPaoII);
                        chessPanel.add(labelBPao);
                        labelBPao.setVisible(true);
                    }
                }
            } else if (this instanceof ChariotChessComponent) {//车
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RCheSII = Data.RCheS;
                        JLabel labelRCheS = new JLabel(RCheSII);
                        chessPanel.add(labelRCheS);
                        labelRCheS.setVisible(true);
                    }else{
                        ImageIcon BCheSII = Data.BCheS;
                        JLabel labelBCheS = new JLabel(BCheSII);
                        chessPanel.add(labelBCheS);
                        labelBCheS.setVisible(true);
                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RCheII = Data.RChe;
                        JLabel labelRChe = new JLabel(RCheII);
                        chessPanel.add(labelRChe);
                        labelRChe.setVisible(true);
                    }else{
                        ImageIcon BCheII = Data.BChe;
                        JLabel labelBChe = new JLabel(BCheII);
                        chessPanel.add(labelBChe);
                        labelBChe.setVisible(true);
                    }
                }
            } else if (this instanceof GeneralChessComponent) {//红帅黑将
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RShuaiSII = Data.RShuaiS;
                        JLabel labelRShuaiS = new JLabel(RShuaiSII);
                        chessPanel.add(labelRShuaiS);
                        labelRShuaiS.setVisible(true);
                    }else{
                        ImageIcon BJiangSII = Data.BJiangS;
                        JLabel labelBJiangS = new JLabel(BJiangSII);
                        chessPanel.add(labelBJiangS);
                        labelBJiangS.setVisible(true);
                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RShuaiII = Data.RShuai;
                        JLabel labelRShuai = new JLabel(RShuaiII);
                        chessPanel.add(labelRShuai);
                        labelRShuai.setVisible(true);
                    }else{
                        ImageIcon BJiangII = Data.BJiang;
                        JLabel labelBJiang = new JLabel(BJiangII);
                        chessPanel.add(labelBJiang);
                        labelBJiang.setVisible(true);
                    }
                }
            } else if (this instanceof HorseChessComponent) {
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RMaSII = Data.RMaS;
                        JLabel labelRMaS = new JLabel(RMaSII);
                        chessPanel.add(labelRMaS);
                        labelRMaS.setVisible(true);
                    }else{
                        ImageIcon BMaSII = Data.BMaS;
                        JLabel labelBMaS = new JLabel(BMaSII);
                        chessPanel.add(labelBMaS);
                        labelBMaS.setVisible(true);
                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RMaII = Data.RMa;
                        JLabel labelRMa = new JLabel(RMaII);
                        chessPanel.add(labelRMa);
                        labelRMa.setVisible(true);
                    }else{
                        ImageIcon BMaII = Data.BMa;
                        JLabel labelBMa = new JLabel(BMaII);
                        chessPanel.add(labelBMa);
                        labelBMa.setVisible(true);
                    }
                }
            } else if (this instanceof MinisterChessComponent) {//Xiang
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RXiangSII = Data.RXiangS;
                        JLabel labelRXiangS = new JLabel(RXiangSII);
                        chessPanel.add(labelRXiangS);
                        labelRXiangS.setVisible(true);
                    }else{
                        ImageIcon BXiangSII = Data.BXiangS;
                        JLabel labelBXiangS = new JLabel(BXiangSII);
                        chessPanel.add(labelBXiangS);
                        labelBXiangS.setVisible(true);
                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RXiangII = Data.RXiang;
                        JLabel labelRXiang = new JLabel(RXiangII);
                        chessPanel.add(labelRXiang);
                        labelRXiang.setVisible(true);
                    }else{
                        ImageIcon BXiangII = Data.BXiang;
                        JLabel labelBXiang = new JLabel(BXiangII);
                        chessPanel.add(labelBXiang);
                        labelBXiang.setVisible(true);
                    }
                }
            } else if (this instanceof SoldierChessComponent) {//红兵黑卒
                if(isSelected()){
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RBingSII = Data.RBingS;
                        JLabel labelRBingS = new JLabel(RBingSII);
                        chessPanel.add(labelRBingS);
                        labelRBingS.setVisible(true);
                    }else{
                        ImageIcon BZuSII = Data.BZuS;
                        JLabel labelBZuS = new JLabel(BZuSII);
                        chessPanel.add(labelBZuS);
                        labelBZuS.setVisible(true);
                    }
                }else{
                    if (this.getChessColor() == ChessColor.RED){
                        ImageIcon RBingII = Data.RBing;
                        JLabel labelRBing = new JLabel(RBingII);
                        chessPanel.add(labelRBing);
                        labelRBing.setVisible(true);
                    }else{
                        ImageIcon BZuII = Data.BZu;
                        JLabel labelBZu = new JLabel(BZuII);
                        chessPanel.add(labelBZu);
                        labelBZu.setVisible(true);
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
        }else{
            ImageIcon emptyImageIcon = Data.empty;
            JLabel labelEmpty = new JLabel(emptyImageIcon);
            labelEmpty.setVisible(true);
            chessPanel.add(labelEmpty);
        }
    }
}

