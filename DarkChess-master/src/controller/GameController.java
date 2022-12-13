package controller;

import chessComponent.*;
import model.ChessColor;
import view.Chessboard;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类主要完成由窗体上组件触发的动作。
 * 例如点击button等
 * ChessGameFrame中组件调用本类的对象，在本类中的方法里完成逻辑运算，将运算的结果传递至chessboard中绘制
 */
public class GameController {
    private Chessboard chessboard;

    public Chessboard getChessboard() {
        return chessboard;
    }

    public GameController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public List<String> loadGameFromFile(String path) {
        try {
            List<String> chessData = Files.readAllLines(Path.of(path));
            chessboard.loadGame(chessData);
            return chessData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void saveGame() throws IOException {
        String path;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setSelectedFile(new File("save.txt"));
        int result = fileChooser.showSaveDialog(chessboard);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            path = file.getAbsolutePath();
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            SquareComponent[][] board = chessboard.getChessComponents();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] instanceof SoldierChessComponent) {
                        if (board[i][j].getChessColor() == ChessColor.RED) {
                            writer.write("s");
                        } else {
                            writer.write("S");
                        }
                    }
                    if (board[i][j] instanceof HorseChessComponent) {
                        if (board[i][j].getChessColor() == ChessColor.RED) {
                            writer.write("h");
                        } else {
                            writer.write("H");
                        }
                    }
                    if (board[i][j] instanceof AdvisorChessComponent) {
                        if (board[i][j].getChessColor() == ChessColor.RED) {
                            writer.write("a");
                        } else {
                            writer.write("A");
                        }
                    }
                    if (board[i][j] instanceof GeneralChessComponent) {
                        if (board[i][j].getChessColor() == ChessColor.RED) {
                            writer.write("g");
                        } else {
                            writer.write("G");
                        }
                    }
                    if (board[i][j] instanceof ChariotChessComponent) {
                        if (board[i][j].getChessColor() == ChessColor.RED) {
                            writer.write("c");
                        } else {
                            writer.write("C");
                        }
                    }
                    if (board[i][j] instanceof MinisterChessComponent) {
                        if (board[i][j].getChessColor() == ChessColor.RED) {
                            writer.write("m");
                        } else {
                            writer.write("M");
                        }
                    }
                    if (board[i][j] instanceof CannonChessComponent) {
                        if (board[i][j].getChessColor() == ChessColor.RED) {
                            writer.write("p");
                        } else {
                            writer.write("P");
                        }
                    }
                    if (board[i][j] instanceof EmptySlotComponent) {
                        writer.write("_");
                    }
                }
                writer.write("\n");
            }
            if (chessboard.getCurrentColor() == ChessColor.RED) {
                writer.write("r\n");
            } else {
                writer.write("b\n");
            }
            for (int i = 0; i < chessboard.step.size(); i++) {
                writer.write(String.format("%s\n", chessboard.step.get(i)));
            }
            writer.close();
        }
        if (result == JFileChooser.CANCEL_OPTION) {
            fileChooser.setVisible(false);
        }

    }

    // TODO: 2022/12/12 撤銷已經寫好了 你待會弄個button上去 我也不知道為啥變成繁體字
    public void undo() {
        int size = getChessboard().step.size();
        if (size > 0) {
            getChessboard().step.remove(getChessboard().step.get(size - 1));//把最后一步移除掉
        }
        chessboard.clickController.swapPlayer();
        chessboard.repaint();

        for (int i = 0; i < getChessboard().step.size(); i++) {
            SquareComponent chess1 = getChessboard().getChessComponents()[getChessboard().step.get(i).charAt(0)][getChessboard().step.get(i).charAt(1)];
            SquareComponent chess2 = getChessboard().getChessComponents()[getChessboard().step.get(i).charAt(2)][getChessboard().step.get(i).charAt(3)];
            if (getChessboard().step.get(i).charAt(4) == 'S') {
                chessboard.remove(chess1);
                chess1 = new SoldierChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.BLACK, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 's') {
                chessboard.remove(chess1);
                chess1 = new SoldierChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.RED, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'C') {
                chessboard.remove(chess1);
                chess1 = new ChariotChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.BLACK, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'c') {
                chessboard.remove(chess1);
                chess1 = new ChariotChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.RED, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'P') {
                chessboard.remove(chess1);
                chess1 = new CannonChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.BLACK, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'p') {
                chessboard.remove(chess1);
                chess1 = new CannonChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.RED, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'M') {
                chessboard.remove(chess1);
                chess1 = new MinisterChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.BLACK, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'm') {
                chessboard.remove(chess1);
                chess1 = new MinisterChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.RED, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'G') {
                chessboard.remove(chess1);
                chess1 = new GeneralChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.RED, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'g') {
                chessboard.remove(chess1);
                chess1 = new GeneralChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.RED, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'H') {
                chessboard.remove(chess1);
                chess1 = new HorseChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.RED, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            if (getChessboard().step.get(i).charAt(4) == 'h') {
                chessboard.remove(chess1);
                chess1 = new HorseChessComponent(chess1.getChessboardPoint(), chess1.getLocation(), ChessColor.RED, chessboard.clickController, chessboard.getCHESS_SIZE());
                chessboard.add(chess1);
            }
            chess1.repaint();
            chess2.repaint();
            chessboard.swapChessComponents(chess1, chess2);
            chessboard.clickController.swapPlayer();
        }
//        chessGameFrame.getTimerTask().resetTime();
    }


}
