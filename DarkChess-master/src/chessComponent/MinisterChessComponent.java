package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

public class MinisterChessComponent extends ChessComponent{
    public MinisterChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        points=5;
        priority=4;
        number=2;
        if (this.getChessColor() == ChessColor.RED) {
            name = "m";
        } else {
            name = "M";
        }
    }
}
