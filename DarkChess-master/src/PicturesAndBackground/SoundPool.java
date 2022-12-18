package PicturesAndBackground;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundPool extends Thread{
    public static final String wnxyy = "C:\\Users\\27365\\Desktop\\project\\java\\DarkChess-master\\DarkChess-master\\src" +
            "\\PicturesAndBackground\\music\\ApolloObjectionWav.wav";
    public static final String pa = "C:\\Users\\27365\\Desktop\\project\\java\\DarkChess-master\\DarkChess-master\\src\\" +
            "PicturesAndBackground\\music\\paWav.wav";
    public static final String ylyy = "C:\\Users\\27365\\Desktop\\project\\java\\DarkChess-master\\DarkChess-master\\src\\" +
            "PicturesAndBackground\\music\\KlavierObjectionWav.wav";

    AudioClip ac;

    public SoundPool(String path){
        URL url = Data.class.getResource(path);
        ac = Applet.newAudioClip(url);
    }
    public void play(){
        ac.play();
    }
    public void stopac(){
        ac.stop();
    }
    public void loop(){
        ac.loop();
    }

    @Override
    public void run() {
        super.run();
        play();
    }
}
