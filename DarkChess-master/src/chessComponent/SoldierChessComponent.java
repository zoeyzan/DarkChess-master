package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

public class SoldierChessComponent extends ChessComponent {

    public SoldierChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        points=1;
        priority=1;
        number=5;
        if (this.getChessColor() == ChessColor.RED) {
            name = "兵";
        } else {
            name = "卒";
        }
    }
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        SquareComponent destinationChess=chessboard[destination.getX()][destination.getY()];
        ChessboardPoint current=getChessboardPoint();
        SquareComponent currentChess=chessboard[getChessboardPoint().getX()][getChessboardPoint().getY()];

        boolean x=true,y=true;//x判断上下左右能不能走，y判断优先级能不能走
        if(destinationChess instanceof EmptySlotComponent){
            x=((Math.abs(current.getX()-destination.getX())==1&&Math.abs(current.getY()-destination.getY())==0)||
                    (Math.abs(current.getX()-destination.getX())==0&&Math.abs(current.getY()-destination.getY())==1));

        }

        if(destinationChess instanceof ChessComponent){
            x=((Math.abs(current.getX()-destination.getX())==1&&Math.abs(current.getY()-destination.getY())==0)||
                    (Math.abs(current.getX()-destination.getX())==0&&Math.abs(current.getY()-destination.getY())==1));
            //兵只能吃将军和他自己
            y= (((ChessComponent) destinationChess).getPriority() == 6 || ((ChessComponent) destinationChess).getPriority() == 1) && destinationChess.isReversal();
        }
        return(x&&y);
    }

}
