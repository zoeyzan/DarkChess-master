package controller;


//import PicturesAndBackground.AceGameFrame;

import PicturesAndBackground.Data;
import chessComponent.CannonChessComponent;
import chessComponent.ChessComponent;
import chessComponent.SquareComponent;
import chessComponent.EmptySlotComponent;
import model.ChessColor;
import view.ChessGameFrame;
import view.Chessboard;

import java.awt.*;

public class ClickController {
    private final Chessboard chessboard;
    private SquareComponent first;
//    public int clickNumber = 0;


    public boolean isCheating;



    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void onClick(SquareComponent squareComponent) {
        //判断第一次点击
//        if (isCheating) {
//            clickNumber = clickNumber+1;
//            if(clickNumber==1){
//                if(first.getChessColor().getColor()==Color.RED){
//                    chessboard.setStartColor(ChessColor.RED);
//                    chessboard.setCurrentColor(ChessColor.BLACK);
//                    ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
//                } else if (first.getChessColor().getColor()==Color.BLACK) {
//                    chessboard.setStartColor(ChessColor.BLACK);
//                    chessboard.setCurrentColor(ChessColor.RED);
//                    ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
//                }
//            }
//
//            squareComponent.setReversal(true);
////            System.out.println(squareComponent.isReversal);
//            squareComponent.repaint();
//        }
//        if (!isCheating) {
            if (first == null) {
                if (handleFirst(squareComponent)) {
                    squareComponent.setSelected(true);
                    first = squareComponent;
                    first.repaint();
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
                    //计分
                    if (first instanceof CannonChessComponent && !(squareComponent.isReversal())) {
                        if (first.getChessColor() == squareComponent.getChessColor()) {
                            if (first.getChessColor().getColor() == Color.BLACK) {
                                Data.RedPoint += ((ChessComponent) squareComponent).getPoints();
                                chessboard.clickController.changeRedPoints();
                            }
                            if (first.getChessColor().getColor() == Color.RED) {
                                Data.BlackPoint += ((ChessComponent) squareComponent).getPoints();
                                chessboard.clickController.changeBlackPoints();
                            }
                        }//写炮打到自己的没翻开的棋子
                        if(first.getChessColor()!=squareComponent.getChessColor()){
                            if (first.getChessColor().getColor() == Color.BLACK) {
                                Data.BlackPoint += ((ChessComponent) squareComponent).getPoints();
                                chessboard.clickController.changeBlackPoints();
                            }
                            if (first.getChessColor().getColor() == Color.RED) {
                                Data.RedPoint += ((ChessComponent) squareComponent).getPoints();
                                chessboard.clickController.changeRedPoints();
                            }
                        }
                    }
                    if (squareComponent.isReversal()) {
                        if (first.getChessColor().getColor() == Color.BLACK) {
                            Data.BlackPoint += ((ChessComponent) squareComponent).getPoints();
                            chessboard.clickController.changeBlackPoints();
                        }
                        if (first.getChessColor().getColor() == Color.RED) {
                            Data.RedPoint += ((ChessComponent) squareComponent).getPoints();
                            chessboard.clickController.changeRedPoints();
                        }
                    }
                    first = null;

                }
            }
//        }
        System.out.println(Data.RedPoint);
        System.out.println(Data.BlackPoint);
        if (Data.BlackPoint >= 60) System.out.println("Black win!");//todo:写一个方法让游戏结束【弹窗】
        if (Data.RedPoint >= 60) System.out.printf("Red win!");
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

}
