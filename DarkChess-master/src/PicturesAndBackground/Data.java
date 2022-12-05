package PicturesAndBackground;
import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL TitleURL = Data.class.getResource("Pictures/Title.jpg");
    public static URL backgroundURL = Data.class.getResource("Pictures/background.jpg");
    public static URL backgroundCheatURL = Data.class.getResource("Pictures/backgroundCheat.jpg");
    public static ImageIcon Title = new ImageIcon(TitleURL);
    public static ImageIcon background = new ImageIcon(backgroundURL);
    public static ImageIcon backgroundCheat = new ImageIcon(backgroundCheatURL);
    public static URL buttonURL = Data.class.getResource("Pictures/button.jpg");
    public static Icon button = new ImageIcon(buttonURL);
}


