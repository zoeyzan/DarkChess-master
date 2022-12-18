package controller;


//import PicturesAndBackground.AceGameFrame;

import PicturesAndBackground.AudioPlay;
import PicturesAndBackground.Data;
import chessComponent.CannonChessComponent;
import chessComponent.ChessComponent;
import chessComponent.SquareComponent;
import chessComponent.EmptySlotComponent;
import com.sun.tools.javac.Main;
import model.ChessColor;
import view.ChessGameFrame;
import view.Chessboard;
import view.DialogBlack;
import view.DialogRed;

import java.awt.*;

public class ClickController {
    private final Chessboard chessboard;
    private SquareComponent first;
//    public int clickNumber = 0;

//    SoundPool yl= new SoundPool(Data.yl1);
//
//    SoundPool wnx= new SoundPool(Data.wnx1);



    public boolean isCheating;



    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void onClick(SquareComponent squareComponent) {
        //判断第一次点击
            if (first == null) {
                if (handleFirst(squareComponent)) {
                    squareComponent.setSelected(true);
                    first = squareComponent;
                    first.repaint();
                    chessboard.step.add(String.format("%d%d%s",squareComponent.getChessboardPoint().getX(),squareComponent.getChessboardPoint().getY(),squareComponent.getName()));
//                    Data.clickNumber = Data.clickNumber+1;
//                    if(Data.clickNumber==1){
//                        if(first.getChessColor().getColor()==Color.RED){
//                            chessboard.setStartColor(ChessColor.RED);
//                            chessboard.setCurrentColor(ChessColor.BLACK);
//                            System.out.println("I'm in the RED if");
//                            ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
//                        } else if (first.getChessColor().getColor()==Color.BLACK) {
//                            chessboard.setStartColor(ChessColor.BLACK);
//                            chessboard.setCurrentColor(ChessColor.RED);
//                            System.out.println("I'm in the Black if");
//                            ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
//                        }
//                    }
//                    AudioPlay.audioPlay swap1 = new AudioPlay.audioPlay(Data.swap);
//                    swap1.run=true;
//                    swap1.start();
                }
            } else {
                if (first == squareComponent) { // 再次点击取消选取
                    squareComponent.setSelected(false);
                    SquareComponent recordFirst = first;
                    first = null;
                    recordFirst.repaint();
                } else if (handleSecond(squareComponent)) {
                    //repaint in swap chess method.
                    chessboard.swapChessComponents(first, squareComponent);
                    first.setSelected(false);
                    squareComponent.setSelected(false);
                    chessboard.clickController.swapPlayer();
                    Data.clickNumber = Data.clickNumber+1;
                    /**
                     * 这里！！放了音乐！不行就注释掉
                     */
//                    new SoundPool(Data.swap).start();
//                    swap1.run=true;
//                    swap1.start();
//                    swap1.run=false;
                    AudioPlay.audioPlay swap1 = new AudioPlay.audioPlay(Data.swap);
                    swap1.run=true;
                    swap1.start();
                    //计分

                    if (first instanceof CannonChessComponent && !(squareComponent.isReversal())) {
                        /**
                         * 这个循环是炮打到己方的未翻开的棋子
                         */
                        if (first.getChessColor() == squareComponent.getChessColor()) {
                            if (first.getChessColor().getColor() == Color.BLACK) {
                                Data.RedPoint += ((ChessComponent) squareComponent).getPoints();
                                chessboard.clickController.changeRedPoints();
                                //找出被吃的棋子是什么棋子并且给被吃计数器加一；被吃的数据存在Data里面
                                String Name = ((ChessComponent) squareComponent).getName();
//                                String Name = first.getName();
                                if(Name.equals("A")){
                                    Data.Ae = Data.Ae+1;
                                    chessboard.clickController.changeAeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("P")) {
                                    Data.Pe = Data.Pe+1;
                                    chessboard.clickController.changePeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("C")) {
                                    Data.Ce = Data.Ce+1;
                                    chessboard.clickController.changeCeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("G")) {
                                    Data.Ge=Data.Ge+1;
                                    chessboard.clickController.changeGeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("H")) {
                                    Data.He=Data.He+1;
                                    chessboard.clickController.changeHeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("M")) {
                                    Data.Me=Data.Me+1;
                                    chessboard.clickController.changeMeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("S")) {
                                    Data.Se=Data.Se+1;
                                    chessboard.clickController.changeSeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                }
                                /**
                                 * 这里！！放了音乐！不行就注释掉
                                 */
//                                yl = new SoundPool(Data.yl1);
//                                yl.start();
//                                yl.run();
//                                ylx.run=true;
//                                ylx.start();
//                                ylx.run=false;
//                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
//                                ylx.run=true;
//                                ylx.start();
                              }
                            if (first.getChessColor().getColor() == Color.RED) {
                                Data.BlackPoint += ((ChessComponent) squareComponent).getPoints();
                                chessboard.clickController.changeBlackPoints();
                                String Name = ((ChessComponent) squareComponent).getName();
//                                String Name = first.getName();
                                if(Name.equals("a")){
                                    Data.ae = Data.ae+1;
                                    chessboard.clickController.changeaeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxholdit);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("p")) {
                                    Data.pe = Data.pe+1;
                                    chessboard.clickController.changepeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxholdit);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("c")) {
                                    Data.ce = Data.ce+1;
                                    chessboard.clickController.changeceLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxholdit);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("g")) {
                                    Data.ge=Data.ge+1;
                                    chessboard.clickController.changegeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxholdit);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("h")) {
                                    Data.he=Data.he+1;
                                    chessboard.clickController.changeheLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxholdit);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("m")) {
                                    Data.me=Data.me+1;
                                    chessboard.clickController.changemeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxholdit);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("s")) {
                                    Data.se=Data.se+1;
                                    chessboard.clickController.changeseLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxholdit);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                }
                                /**
                                 * 这里！！放了音乐！不行就注释掉
                                 */
//                                wnx = new SoundPool(Data.wnx1);
//                                wnx.start();
//                                wnx.run();
//                                wnxfj.run=true;
//                                wnxfj.start();
//                                wnxfj.run=false;
//                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
//                                wnxfj.run=true;
//                                wnxfj.start();
                                /**
                                 * 没声音。。。
                                 */
                            }
                        }//写炮打到对方的没翻开的棋子
                        if(first.getChessColor()!=squareComponent.getChessColor()){
                            if (first.getChessColor().getColor() == Color.BLACK) {
                                Data.BlackPoint += ((ChessComponent) squareComponent).getPoints();
                                chessboard.clickController.changeBlackPoints();

                                String Name = ((ChessComponent) squareComponent).getName();
//                                String Name = first.getName();
                                if(Name.equals("a")){
                                    Data.ae = Data.ae+1;
                                    chessboard.clickController.changeaeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("p")) {
                                    Data.pe = Data.pe+1;
                                    chessboard.clickController.changepeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("c")) {
                                    Data.ce = Data.ce+1;
                                    chessboard.clickController.changeceLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("g")) {
                                    Data.ge=Data.ge+1;
                                    chessboard.clickController.changegeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("h")) {
                                    Data.he=Data.he+1;
                                    chessboard.clickController.changeheLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("m")) {
                                    Data.me=Data.me+1;
                                    chessboard.clickController.changemeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                } else if (Name.equals("s")) {
                                    Data.se=Data.se+1;
                                    chessboard.clickController.changeseLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                    ylx.run=true;
                                    ylx.start();
                                }
                                /**
                                 * 这里！！放了音乐！不行就注释掉
                                 */
//                                yl = new SoundPool(Data.yl1);
//                                yl.start();
//                                yl.run();
//                                ylx.run=true;
//                                ylx.start();
//                                ylx.run=false;
//                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
//                                ylx.run=true;
//                                ylx.start();
                            }
                            if (first.getChessColor().getColor() == Color.RED) {
                                Data.RedPoint += ((ChessComponent) squareComponent).getPoints();
                                chessboard.clickController.changeRedPoints();

                                String Name = ((ChessComponent) squareComponent).getName();
//                                String Name = first.getName();
                                if(Name.equals("A")){
                                    Data.Ae = Data.Ae+1;
                                    chessboard.clickController.changeAeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxtakethat);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("P")) {
                                    Data.Pe = Data.Pe+1;
                                    chessboard.clickController.changePeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxtakethat);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("C")) {
                                    Data.Ce = Data.Ce+1;
                                    chessboard.clickController.changeCeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxtakethat);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("G")) {
                                    Data.Ge=Data.Ge+1;
                                    chessboard.clickController.changeGeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxtakethat);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("H")) {
                                    Data.He=Data.He+1;
                                    chessboard.clickController.changeHeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxtakethat);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("M")) {
                                    Data.Me=Data.Me+1;
                                    chessboard.clickController.changeMeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxtakethat);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                } else if (Name.equals("S")) {
                                    Data.Se=Data.Se+1;
                                    chessboard.clickController.changeSeLabel();
                                    System.out.println("I'm in!");
                                    AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnxtakethat);
                                    wnxfj.run=true;
                                    wnxfj.start();
                                }
                                /**
                                 * 这里！！放了音乐！不行就注释掉
                                 */
//                                wnx = new SoundPool(Data.wnx1);
//                                wnx.start();
//                                wnx.run();
//                                wnxfj.run=true;
//                                wnxfj.start();
//                                wnxfj.run=false;
//                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
//                                wnxfj.run=true;
//                                wnxfj.start();
                            }
                        }
                    }
                    if (squareComponent.isReversal()) {
                        if (first.getChessColor().getColor() == Color.BLACK) {
                            Data.BlackPoint += ((ChessComponent) squareComponent).getPoints();
                            chessboard.clickController.changeBlackPoints();

                            String Name = ((ChessComponent) squareComponent).getName();
//                            String Name = first.getName();
                            if(Name.equals("a")){
                                Data.ae = Data.ae+1;
                                chessboard.clickController.changeaeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                ylx.run=true;
                                ylx.start();
                            } else if (Name.equals("p")) {
                                Data.pe = Data.pe+1;
                                chessboard.clickController.changepeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                ylx.run=true;
                                ylx.start();
                            } else if (Name.equals("c")) {
                                Data.ce = Data.ce+1;
                                chessboard.clickController.changeceLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                ylx.run=true;
                                ylx.start();
                            } else if (Name.equals("g")) {
                                Data.ge=Data.ge+1;
                                chessboard.clickController.changegeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                ylx.run=true;
                                ylx.start();
                            } else if (Name.equals("h")) {
                                Data.he=Data.he+1;
                                chessboard.clickController.changeheLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                ylx.run=true;
                                ylx.start();
                            } else if (Name.equals("m")) {
                                Data.me=Data.me+1;
                                chessboard.clickController.changemeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                ylx.run=true;
                                ylx.start();
                            } else if (Name.equals("s")) {
                                Data.se=Data.se+1;
                                chessboard.clickController.changeseLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
                                ylx.run=true;
                                ylx.start();
                            }
                            /**
                             * 这里！！放了音乐！不行就注释掉
                             */
//                            yl = new SoundPool(Data.yl1);
//                            yl.start();
//                            yl.run();
//                            ylx.run=true;
//                            ylx.start();
//                            ylx.run=false;
//                            AudioPlay.audioPlay ylx = new AudioPlay.audioPlay(Data.yl1);
//                            ylx.run=true;
//                            ylx.start();
                        }
                        if (first.getChessColor().getColor() == Color.RED) {
                            Data.RedPoint += ((ChessComponent) squareComponent).getPoints();
                            chessboard.clickController.changeRedPoints();

                            String Name = squareComponent.getName();
//                            String Name = first.getName();
                            if(Name.equals("A")){
                                Data.Ae = Data.Ae+1;
                                chessboard.clickController.changeAeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
                                wnxfj.run=true;
                                wnxfj.start();
                            } else if (Name.equals("P")) {
                                Data.Pe = Data.Pe+1;
                                chessboard.clickController.changePeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
                                wnxfj.run=true;
                                wnxfj.start();
                            } else if (Name.equals("C")) {
                                Data.Ce = Data.Ce+1;
                                chessboard.clickController.changeCeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
                                wnxfj.run=true;
                                wnxfj.start();
                            } else if (Name.equals("G")) {
                                Data.Ge=Data.Ge+1;
                                chessboard.clickController.changeGeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
                                wnxfj.run=true;
                                wnxfj.start();
                            } else if (Name.equals("H")) {
                                Data.He=Data.He+1;
                                chessboard.clickController.changeHeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
                                wnxfj.run=true;
                                wnxfj.start();
                            } else if (Name.equals("M")) {
                                Data.Me=Data.Me+1;
                                chessboard.clickController.changeMeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
                                wnxfj.run=true;
                                wnxfj.start();
                            } else if (Name.equals("S")) {
                                Data.Se=Data.Se+1;
                                chessboard.clickController.changeSeLabel();
                                System.out.println("I'm in!");
                                AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
                                wnxfj.run=true;
                                wnxfj.start();
                            }
                            /**
                             * 这里！！放了音乐！不行就注释掉
                             */
//                            wnx = new SoundPool(Data.wnx1);
//                            wnx.start();
//                            wnx.run();
//                            wnxfj.run=true;
//                            wnxfj.start();
//                            wnxfj.run=false;
//                            AudioPlay.audioPlay wnxfj = new AudioPlay.audioPlay(Data.wnx1);
//                            wnxfj.run=true;
//                            wnxfj.start();
                        }
                    }
                    first = null;

                }
            }
        System.out.println(Data.RedPoint);
        System.out.println(Data.BlackPoint);
        if (Data.BlackPoint >= 60) {
            System.out.println("Black win!");

            Data.bgm.run=false;
            AudioPlay.audioPlay ylxllg = new AudioPlay.audioPlay(Data.ylxLLG);
            Data.bgm=ylxllg;
            ylxllg.run=true;
            ylxllg.start();
            new DialogBlack();
        }//todo:写一个方法让游戏结束【弹窗】
        if (Data.RedPoint >= 60){
            System.out.printf("Red win!");
            Data.bgm.run=false;
            AudioPlay.audioPlay wnxXzkt = new AudioPlay.audioPlay(Data.wnxxzkt);
            Data.bgm=wnxXzkt;
            wnxXzkt.run=true;
            wnxXzkt.start();
            new DialogRed();

        }

    }


    /**
     * @param squareComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    private boolean handleFirst(SquareComponent squareComponent) {
        if (!squareComponent.isReversal() && squareComponent instanceof ChessComponent) {
            squareComponent.setReversal(true);

            System.out.printf("onClick to reverse a chess [%d,%d]\n", squareComponent.getChessboardPoint().getX(), squareComponent.getChessboardPoint().getY());
            squareComponent.repaint();
            Data.clickNumber = Data.clickNumber+1;
                    if(Data.clickNumber==1){
                        if(squareComponent.getChessColor().getColor()==Color.RED){
                            chessboard.setStartColor(ChessColor.RED);
                            chessboard.setCurrentColor(ChessColor.RED);
                            System.out.println("I'm in the RED if");
                            ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
                        } else if (squareComponent.getChessColor().getColor()==Color.BLACK) {
                            chessboard.setStartColor(ChessColor.BLACK);
                            chessboard.setCurrentColor(ChessColor.BLACK);
                            System.out.println("I'm in the Black if");
                            ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
                        }
                    }
            chessboard.clickController.swapPlayer();
            return false;
        }
        return squareComponent.getChessColor() == chessboard.getCurrentColor();
    }

    /**
     * @param squareComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

    private boolean handleSecond(SquareComponent squareComponent) {


        if (!squareComponent.isReversal()) {
            //没翻开的棋子
            if (first instanceof CannonChessComponent && !(squareComponent instanceof EmptySlotComponent))
                //first棋子是炮 且second棋子非空
                return first.canMoveTo(chessboard.getChessComponents(), squareComponent.getChessboardPoint());

            if (!(first instanceof CannonChessComponent) && !(squareComponent instanceof EmptySlotComponent)) {
                return false;//second棋子非空
            }
        }
        if (squareComponent instanceof EmptySlotComponent) {
            return first.canMoveTo(chessboard.getChessComponents(), squareComponent.getChessboardPoint());
        }

        return squareComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), squareComponent.getChessboardPoint());
    }


    public void swapPlayer() {
        chessboard.setCurrentColor(chessboard.getCurrentColor() == ChessColor.BLACK ? ChessColor.RED : ChessColor.BLACK);
        ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
    }

    public void changeRedPoints() {
        ChessGameFrame.getRedPointLabel().setText(String.format("Apollo Points:%d", Data.RedPoint));
    }

    public void changeBlackPoints() {
        ChessGameFrame.getBlackPointLabel().setText(String.format("Klavier Points:%d", Data.BlackPoint));
    }

    public void changeAeLabel(){
        ChessGameFrame.getAeLabel().setText(String.format("Advisor:%d",Data.Ae));
    }
    public void changeaeLabel(){
        ChessGameFrame.getaeLabel().setText(String.format("Advisor:%d",Data.ae));
    }
    public void changePeLabel(){
        ChessGameFrame.getPeLabel().setText(String.format("Cannon:%d",Data.Pe));
    }
    public void changepeLabel(){
        ChessGameFrame.getpeLabel().setText(String.format("Cannon:%d",Data.pe));
    }
    public void changeCeLabel(){
        ChessGameFrame.getCeLabel().setText(String.format("Chariot:%d",Data.Ce));
    }
    public void changeceLabel(){
        ChessGameFrame.getceLabel().setText(String.format("Chariot:%d",Data.ce));
    }
    public void changeGeLabel(){
        ChessGameFrame.getGeLabel().setText(String.format("General:%d",Data.Ge));
    }
    public void changegeLabel(){
        ChessGameFrame.getgeLabel().setText(String.format("General:%d",Data.ge));
    }
    public void changeHeLabel(){
        ChessGameFrame.getHeLabel().setText(String.format("Horse:%d",Data.He));
    }
    public void changeheLabel(){
        ChessGameFrame.getheLabel().setText(String.format("Horse:%d",Data.he));
    }
    public void changeMeLabel(){
        ChessGameFrame.getMeLabel().setText(String.format("Minister:%d",Data.Me));
    }
    public void changemeLabel(){
        ChessGameFrame.getmeLabel().setText(String.format("Minister:%d",Data.me));
    }
    public void changeSeLabel(){
        ChessGameFrame.getSeLabel().setText(String.format("Soldier:%d",Data.Se));
    }
    public void changeseLabel(){
        ChessGameFrame.getseLabel().setText(String.format("Soldier:%d",Data.se));
    }

}
