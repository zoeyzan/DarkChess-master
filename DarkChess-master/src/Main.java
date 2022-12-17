import PicturesAndBackground.Data;
import view.ChessGameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGameFrame mainFrame = new ChessGameFrame(985,599);
            Data.gameFrame=mainFrame;
            mainFrame.setVisible(true);
        });
    }
}
