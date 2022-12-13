package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

public class GeneralChessComponent extends ChessComponent{
    @Override
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        SquareComponent destinationChess=chessboard[destination.getX()][destination.getY()];
        SquareComponent currentChess=chessboard[getChessboardPoint().getX()][getChessboardPoint().getY()];
        ChessboardPoint current=getChessboardPoint();
        boolean x=true,y=true,z=true;//x判断上下左右能不能走，y判断优先级能不能走
        if(destinationChess instanceof EmptySlotComponent){
            x=((Math.abs(current.getX()-destination.getX())==1&&Math.abs(current.getY()-destination.getY())==0)||
                    (Math.abs(current.getX()-destination.getX())==0&&Math.abs(current.getY()-destination.getY())==1));

        }
        if(destinationChess instanceof ChessComponent&&destinationChess.isReversal){
            x=((Math.abs(current.getX()-destination.getX())==1&&Math.abs(current.getY()-destination.getY())==0)||
                    (Math.abs(current.getX()-destination.getX())==0&&Math.abs(current.getY()-destination.getY())==1));
            if(((ChessComponent)currentChess).getPriority()<((ChessComponent)destinationChess).getPriority())
                y=false;
            if(destinationChess instanceof SoldierChessComponent) y=false;

        }
        if(destinationChess instanceof ChessComponent&&!destinationChess.isReversal){
            z=false;
        }
        return(x&&y&&z);
    }

    public GeneralChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        priority=6;
        points=30;
        number=1;
        if (this.getChessColor() == ChessColor.RED) {
            name = "g";
        } else {
            name = "G";
        }

    }
}
