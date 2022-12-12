package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

/**
 * 表示黑红车
 */
public class ChariotChessComponent extends ChessComponent {

    public ChariotChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        points=5;
        priority=3;
        number=2;
        if (this.getChessColor() == ChessColor.RED) {
            name = "c";
        } else {
            name = "C";
        }
    }

}
