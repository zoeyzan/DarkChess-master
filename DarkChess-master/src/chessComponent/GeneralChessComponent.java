package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

public class GeneralChessComponent extends ChessComponent{
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
