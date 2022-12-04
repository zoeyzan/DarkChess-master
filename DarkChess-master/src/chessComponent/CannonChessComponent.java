package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;


public class CannonChessComponent extends ChessComponent{


    public CannonChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        number=2;
        points=5;
        priority=0;
        if (this.getChessColor() == ChessColor.RED) {
            name = "炮";
        } else {
            name = "砲";
        }
    }
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        SquareComponent destinationChess=chessboard[destination.getX()][destination.getY()];
        SquareComponent currentChess=chessboard[getChessboardPoint().getX()][getChessboardPoint().getY()];
        ChessboardPoint current=getChessboardPoint();
        boolean x=true,y=true,z=true;//x判断走两步，y判断有没有棋子
        if(destinationChess instanceof EmptySlotComponent){
            x=false;
        }

        if(destinationChess instanceof ChessComponent){
            x=true;
            if(((Math.abs(current.getX()-destination.getX())==2&&Math.abs(current.getY()-destination.getY())==0))||
                    ((Math.abs(current.getX()-destination.getX())==0&&Math.abs(current.getY()-destination.getY())==2)))
                z=true; else z=false;
            if(current.getX()-destination.getX()==2&&current.getY()-destination.getY()==0) {
                SquareComponent screenChess=chessboard[destination.getX()+1][destination.getY()];
                if(screenChess instanceof ChessComponent) y=true;else y=false;
            }
            if(destination.getX()-current.getX()==2&&current.getY()-destination.getY()==0) {
                SquareComponent screenChess=chessboard[destination.getX()-1][destination.getY()];
                if(screenChess instanceof ChessComponent) y=true;else y=false;
            }
            if (current.getX()-destination.getX()==0&&current.getY()-destination.getY()==2){
                SquareComponent screenChess=chessboard[destination.getX()][destination.getY()+1];
                if(screenChess instanceof ChessComponent) y=true;else y=false;
            }
            if (current.getX()-destination.getX()==0&&destination.getY()-current.getY()==2){
                SquareComponent screenChess=chessboard[destination.getX()][destination.getY()-1];
                if(screenChess instanceof ChessComponent) y=true;else y=false;

            }

        }
        return(x&&y&&z);
    }

}
