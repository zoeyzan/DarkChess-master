package PicturesAndBackground;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlay {
    public static class audioPlay extends Thread  {
        public String path;
        private AudioInputStream audioStream;
        private AudioFormat audioFormat;
        private SourceDataLine sourceDataLine;
        public boolean run = true;
        public audioPlay(String path) {
            this.path = path;
//            playMusic(path);
        }
        private void playMusic(String path){
            try{
                int count;
                byte buf[] = new byte[1024];
                //获取音频输入流
                audioStream = AudioSystem.getAudioInputStream(new File(path));
                //获取音频的编码格式
                audioFormat = audioStream.getFormat();
                DataLine.Info dataLineInfo = new
                        DataLine.Info(SourceDataLine.class,
                        audioFormat,AudioSystem.NOT_SPECIFIED);
                sourceDataLine =
                        (SourceDataLine)AudioSystem.getLine(dataLineInfo);
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();
                 //播放音频
                while((count = audioStream.read(buf,0,buf.length)) != -1){
                    if(run){
                        sourceDataLine.write(buf,0,count);
                    }else {
                        break;
                    }
                }
                //播放结束，释放资源
                sourceDataLine.drain();
                sourceDataLine.close();
                audioStream.close();
            }catch(UnsupportedAudioFileException ex){
                ex.printStackTrace();
            }catch(LineUnavailableException ex){
                ex.printStackTrace();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }

        public void run(){
            playMusic(path);
        }

    }
    }

