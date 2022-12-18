import PicturesAndBackground.AudioPlay;
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
//        AudioPlay.audioPlay court = new AudioPlay.audioPlay(Data.courtPath1);
//        court.run = true;
//        court.start();
        //测试了，是重复播放
//        if(Data.RedPoint>=60){
//            court.run=false;
//        } else if (Data.BlackPoint>=60) {
//            court.run=false;
//        }else court.run=true;
    }
}
class MyThread extends Thread{

}
