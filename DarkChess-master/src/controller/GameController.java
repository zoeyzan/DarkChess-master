package controller;

import view.Chessboard;

import java.io.BufferedWriter;
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
    public int[][] chessboardint;

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

    /**
     * 点击cheatingMode的button 再点击任意一个没翻开的棋子就可以翻开
     *
     */
    public void CheatingMode(){

    }
//    public List<String> convertToList() {
//        List<String> lines = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        for (int[] ints : this.chessboardint) {
//            sb.setLength(0);
//            for (int anInt : ints) {
//                sb.append(anInt).append(",");
//            }
//            sb.setLength(sb.length() - 1);
//            lines.add(sb.toString());
//        }
//        return lines;
//    }

//    public void writeFileByFileWriter(String path) {
//        try {
//            FileWriter fileWriter = new FileWriter(path);
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            List<String> lines = this.convertToList();
//            for (String line : lines
//            ) {
//                writer.write(line);
//            }
//            writer.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void writeFileByLib(String path) {
//        try {
//            Files.write(Path.of(path), this.convertToList(), Charset.defaultCharset());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
