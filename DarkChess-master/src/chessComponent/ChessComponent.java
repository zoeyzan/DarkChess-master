package chessComponent;

//import PicturesAndBackground.AceGameFrame;
//import PicturesAndBackground.Data;
import PicturesAndBackground.Data;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import javax.swing.*;
import java.awt.*;

import static PicturesAndBackground.Data.emptyI;

//import static PicturesAndBackground.Data.emptyI;

/**
 * 表示棋盘上非空棋子的格子，是所有非空棋子的父类
 */
public class ChessComponent extends SquareComponent {
    protected String name;// 棋子名字：例如 兵，卒，士等
    protected int priority;// 棋子的优先级，判断能不能吃别的棋子
    protected int points;//棋子的得分
    protected int number;//棋子的个数

    private JPanel chessPanel;

    public JPanel getChessPanel() {
        return chessPanel;
    }

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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //绘制棋子填充色
//        g.drawImage(emptyI,0,0,null);
        g.drawImage(emptyI, spacingLength, spacingLength, null);//照着原来的写了
//        g.setColor(Color.ORANGE);
//        g.fillOval(spacingLength, spacingLength, this.getWidth() - 2 * spacingLength, this.getHeight() - 2 * spacingLength);
        //绘制棋子边框
//        g.setColor(Color.DARK_GRAY);
//        g.drawOval(spacingLength, spacingLength, getWidth() - 2 * spacingLength, getHeight() - 2 * spacingLength);

//        if (isReversal) {
//            //绘制棋子文字
//            g.setColor(this.getChessColor().getColor());
//            g.setFont(CHESS_FONT);
//            g.drawString(this.name, this.getWidth() / 4, this.getHeight() * 2 / 3);
//
//            //绘制棋子被选中时状态
//            if (isSelected()) {
//                g.setColor(Color.RED);
//                Graphics2D g2 = (Graphics2D) g;
//                g2.setStroke(new BasicStroke(4f));
//                g2.drawOval(spacingLength, spacingLength, getWidth() - 2 * spacingLength, getHeight() - 2 * spacingLength);
//            }
//        }
        if (isReversal) {
            if (this instanceof AdvisorChessComponent) {
                if (isSelected()) {//选中
//                加图片然后用上面的方法
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RShiSII = Data.RShiS;

                        g.drawImage(RShiSII.getImage(), 0, 0, 60, 60, this);
//
                    } else {
                        ImageIcon BShiSII = Data.BShiS;

                        g.drawImage(BShiSII.getImage(), 0, 0, 60, 60, this);
                    }
                } else {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RShiII = Data.RShi;
                        g.drawImage(RShiII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BShiII = Data.BShi;
                        g.drawImage(BShiII.getImage(), 0, 0, 60, 60, this);
                    }
                }

            } else if (this instanceof CannonChessComponent) {
                if (isSelected()) {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RPaoSII = Data.RPaoS;
                        g.drawImage(RPaoSII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BPaoSII = Data.BPaoS;
                        g.drawImage(BPaoSII.getImage(), 0, 0, 60, 60, this);
                    }
                } else {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RPaoII = Data.RPao;
                        g.drawImage(RPaoII.getImage(), 0, 0, 60, 60, this);

                    } else {
                        ImageIcon BPaoII = Data.BPao;
                        g.drawImage(BPaoII.getImage(), 0, 0, 60, 60, this);
                    }
                }
            } else if (this instanceof ChariotChessComponent) {//车
                if (isSelected()) {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RCheSII = Data.RCheS;
                        g.drawImage(RCheSII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BCheSII = Data.BCheS;
                        g.drawImage(BCheSII.getImage(), 0, 0, 60, 60, this);
                    }
                } else {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RCheII = Data.RChe;
                        g.drawImage(RCheII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BCheII = Data.BChe;
                        g.drawImage(BCheII.getImage(), 0, 0, 60, 60, this);
                    }
                }
            } else if (this instanceof GeneralChessComponent) {//红帅黑将
                if (isSelected()) {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RShuaiSII = Data.RShuaiS;
                        g.drawImage(RShuaiSII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BJiangSII = Data.BJiangS;
                        g.drawImage(BJiangSII.getImage(), 0, 0, 60, 60, this);
                    }
                } else {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RShuaiII = Data.RShuai;
                        g.drawImage(RShuaiII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BJiangII = Data.BJiang;
                        g.drawImage(BJiangII.getImage(), 0, 0, 60, 60, this);
                    }
                }
            } else if (this instanceof HorseChessComponent) {
                if (isSelected()) {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RMaSII = Data.RMaS;
                        g.drawImage(RMaSII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BMaSII = Data.BMaS;
                        g.drawImage(BMaSII.getImage(), 0, 0, 60, 60, this);
                    }
                } else {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RMaII = Data.RMa;
                        g.drawImage(RMaII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BMaII = Data.BMa;
                        g.drawImage(BMaII.getImage(), 0, 0, 60, 60, this);
                    }
                }
            } else if (this instanceof MinisterChessComponent) {//Xiang
                if (isSelected()) {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RXiangSII = Data.RXiangS;
                        g.drawImage(RXiangSII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BXiangSII = Data.BXiangS;
                        g.drawImage(BXiangSII.getImage(), 0, 0, 60, 60, this);
                    }
                } else {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RXiangII = Data.RXiang;
                        g.drawImage(RXiangII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BXiangII = Data.BXiang;
                        g.drawImage(BXiangII.getImage(), 0, 0, 60, 60, this);
                    }
                }
            } else if (this instanceof SoldierChessComponent) {//红兵黑卒
                if (isSelected()) {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RBingSII = Data.RBingS;
                        g.drawImage(RBingSII.getImage(), 0, 0, 60, 60, this);
                    } else {
                        ImageIcon BZuSII = Data.BZuS;
                        g.drawImage(BZuSII.getImage(), 0, 0, 60, 60, this);
                    }
                } else {
                    if (this.getChessColor() == ChessColor.RED) {
                        ImageIcon RBingII = Data.RBing;
                        g.drawImage(RBingII.getImage(), 0, 0, 60, 60, this);

                    } else {
                        ImageIcon BZuII = Data.BZu;
                        g.drawImage(BZuII.getImage(), 0, 0, 60, 60, this);

                    }
                }
            }
//            绘制棋子被选中时状态
            if (isSelected()) {

                g.setColor(Color.RED);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(4f));
                g2.drawOval(spacingLength, spacingLength, getWidth() - 2 * spacingLength, getHeight() - 2 * spacingLength);

            }

        } else if (isCheating) {
            System.out.println("123");
            if(this instanceof AdvisorChessComponent){
                if (this.getChessColor() == ChessColor.RED) {
                    ImageIcon RShiCII = Data.RShiC;
                    g.drawImage(RShiCII.getImage(), 0, 0, 60, 60, this);
                } else {
                    ImageIcon BShiCII = Data.BShiC;
                    g.drawImage(BShiCII.getImage(), 0, 0, 60, 60, this);
                }
            } else if (this instanceof CannonChessComponent) {
                if (this.getChessColor() == ChessColor.RED) {
                    ImageIcon RPaoCII = Data.RPaoC;
                    g.drawImage(RPaoCII.getImage(), 0, 0, 60, 60, this);

                } else {
                    ImageIcon BPaoCII = Data.BPaoC;
                    g.drawImage(BPaoCII.getImage(), 0, 0, 60, 60, this);
                }
            } else if (this instanceof ChariotChessComponent) {
                if (this.getChessColor() == ChessColor.RED) {
                    ImageIcon RCheII = Data.RCheC;
                    g.drawImage(RCheII.getImage(), 0, 0, 60, 60, this);
                } else {
                    ImageIcon BCheII = Data.BCheC;
                    g.drawImage(BCheII.getImage(), 0, 0, 60, 60, this);
                }
            } else if (this instanceof GeneralChessComponent) {
                if (this.getChessColor() == ChessColor.RED) {
                    ImageIcon RShuaiII = Data.RShuaiC;
                    g.drawImage(RShuaiII.getImage(), 0, 0, 60, 60, this);
                } else {
                    ImageIcon BJiangII = Data.BJiangC;
                    g.drawImage(BJiangII.getImage(), 0, 0, 60, 60, this);
                }
            }else if(this instanceof HorseChessComponent){
                if (this.getChessColor() == ChessColor.RED) {
                    ImageIcon RMaII = Data.RMaC;
                    g.drawImage(RMaII.getImage(), 0, 0, 60, 60, this);
                } else {
                    ImageIcon BMaII = Data.BMaC;
                    g.drawImage(BMaII.getImage(), 0, 0, 60, 60, this);
                }
            } else if (this instanceof MinisterChessComponent) {
                if (this.getChessColor() == ChessColor.RED) {
                    ImageIcon RXiangII = Data.RXiangC;
                    g.drawImage(RXiangII.getImage(), 0, 0, 60, 60, this);
                } else {
                    ImageIcon BXiangII = Data.BXiangC;
                    g.drawImage(BXiangII.getImage(), 0, 0, 60, 60, this);
                }
            } else if (this instanceof SoldierChessComponent) {
                if (this.getChessColor() == ChessColor.RED) {
                    ImageIcon RBingII = Data.RBingC;
                    g.drawImage(RBingII.getImage(), 0, 0, 60, 60, this);

                } else {
                    ImageIcon BZuII = Data.BZuC;
                    g.drawImage(BZuII.getImage(), 0, 0, 60, 60, this);

                }
            }
        }


    }

}
