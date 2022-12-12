package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

public class AdvisorChessComponent extends ChessComponent {
    public AdvisorChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        points=10;
        priority=5;
        number=2;
        if (this.getChessColor() == ChessColor.RED) {
            name = "a";
        } else {
            name = "A";
        }
    }
}
