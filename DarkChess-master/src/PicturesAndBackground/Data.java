package PicturesAndBackground;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class Data {

    public static int clickNumber = 0;
    //以下是被吃子的数据存储地方
    public static int Ae = 0;//Advisor,红小黑大
    public static int ae = 0;
    public static int Pe = 0;//炮
    public static int pe = 0;
    public static int Ce = 0;//Chariot
    public static int ce = 0;
    public static int Ge = 0;//General
    public static int ge = 0;
    public static int He = 0;//Horse
    public static int he = 0;
    public static int Me = 0;///Minister
    public static int me = 0;
    public static int Se = 0;//Soldier
    public static int se = 0;



    public static ArrayList<Image> ImageList= new ArrayList<>();

    public static URL titleURL = Data.class.getResource("Pictures/title.png");
    public static URL braceletURL = Data.class.getResource("Pictures/bracelet.png");
    public static URL backgroundURL = Data.class.getResource("Pictures/background.jpg");
    public static URL backgroundCheatURL = Data.class.getResource("Pictures/backgroundCheat.jpg");
    public static ImageIcon title = new ImageIcon(titleURL);

    public static ImageIcon background = new ImageIcon(backgroundURL);
    public static ImageIcon backgroundCheat = new ImageIcon(backgroundCheatURL);
    //    public static URL buttonURL = Data.class.getResource("Pictures/button.jpg");
//    public static Icon button = new ImageIcon(buttonURL);
    public static  URL emptyURL = Data.class.getResource("Pictures/empty.png");
    public static  ImageIcon empty = new ImageIcon(emptyURL);

    public static URL BCheURL = Data.class.getResource("Pictures/BChe.png");
    public static URL BCheSURL = Data.class.getResource("Pictures/BCheS.png");
    public static URL BJiangURL = Data.class.getResource("Pictures/BJiang.png");
    public static URL BJiangSURL = Data.class.getResource("Pictures/BJiangS.png");
    public static URL BMaURL = Data.class.getResource("Pictures/BMa.png");
    public static URL BMaSURL = Data.class.getResource("Pictures/BMaS.png");
    public static URL BPaoURL = Data.class.getResource("Pictures/BPao.png");
    public static URL BPaoSURL = Data.class.getResource("Pictures/BPaoS.png");
    public static URL BShiURL = Data.class.getResource("Pictures/BShi.png");
    public static URL BShiSURL = Data.class.getResource("Pictures/BShiS.png");
    public static URL BXiangURL = Data.class.getResource("Pictures/BXiang.png");
    public static URL BXiangSURL = Data.class.getResource("Pictures/BXiangS.png");
    public static URL BZuURL = Data.class.getResource("Pictures/BZu.png");
    public static URL BZuSURL = Data.class.getResource("Pictures/BZuS.png");
    //-------------------------------------------------------------------------------------
    public static URL RBingURL = Data.class.getResource("Pictures/RBing.png");
    public static URL RBingSURL = Data.class.getResource("Pictures/RBingS.png");
    public static URL RCheURL = Data.class.getResource("Pictures/RChe.png");
    public static URL RCheSURL = Data.class.getResource("Pictures/RCheS.png");
    public static URL RMaURL = Data.class.getResource("Pictures/RMa.png");
    public static URL RMaSURL = Data.class.getResource("Pictures/RMaS.png");
    public static URL RPaoURL = Data.class.getResource("Pictures/RPao.png");
    public static URL RPaoSURL = Data.class.getResource("Pictures/RPaoS.png");
    public static URL RShiURL = Data.class.getResource("Pictures/RShi.png");
    public static URL RShiSURL = Data.class.getResource("Pictures/RShiS.png");
    public static URL RShuaiURL = Data.class.getResource("Pictures/RShuai.png");
    public static URL RShuaiSURL = Data.class.getResource("Pictures/RShuaiS.png");
    public static URL RXiangURL = Data.class.getResource("Pictures/RXiang.png");
    public static URL RXiangSURL = Data.class.getResource("Pictures/RXiangS.png");
    //`````````````````````````````````````````````````````````````
    public static URL BZuCURL = Data.class.getResource("Pictures/BzUC.png");
    public static URL BCheCURL = Data.class.getResource("Pictures/BCheC.png");
    public static URL BMaCURL = Data.class.getResource("Pictures/BMaC.png");
    public static URL BPaoCURL = Data.class.getResource("Pictures/BPaoC.png");
    public static URL BShiCURL = Data.class.getResource("Pictures/BShiC.png");
    public static URL BJiangCURL = Data.class.getResource("Pictures/BJiangC.png");
    public static URL BXiangCURL = Data.class.getResource("Pictures/BXiangC.png");

    public static URL RBingCURL = Data.class.getResource("Pictures/RBingC.png");
    public static URL RCheCURL = Data.class.getResource("Pictures/RCheC.png");
    public static URL RMaCURL = Data.class.getResource("Pictures/RMaC.png");
    public static URL RPaoCURL = Data.class.getResource("Pictures/RPaoC.png");
    public static URL RShiCURL = Data.class.getResource("Pictures/RShiC.png");
    public static URL RShuaiCURL = Data.class.getResource("Pictures/RShuaiC.png");
    public static URL RXiangCURL = Data.class.getResource("Pictures/RXiangC.png");


    public static ImageIcon BChe = new ImageIcon(BCheURL);
    public static ImageIcon BCheC = new ImageIcon(BCheCURL);
    public static ImageIcon BCheS = new ImageIcon(BCheSURL);
    public static ImageIcon BJiang = new ImageIcon(BJiangURL);
    public static ImageIcon BJiangC = new ImageIcon(BJiangCURL);
    public static ImageIcon BJiangS = new ImageIcon(BJiangSURL);
    public static ImageIcon BMa = new ImageIcon(BMaURL);
    public static ImageIcon BMaC = new ImageIcon(BMaCURL);
    public static ImageIcon BMaS = new ImageIcon(BMaSURL);
    public static ImageIcon BPao = new ImageIcon(BPaoURL);
    public static ImageIcon BPaoC= new ImageIcon(BPaoCURL);
    public static ImageIcon BPaoS = new ImageIcon(BPaoSURL);
    public static ImageIcon BShi = new ImageIcon(BShiURL);
    public static ImageIcon BShiC = new ImageIcon(BShiCURL);
    public static ImageIcon BShiS = new ImageIcon(BShiSURL);
    public static ImageIcon BXiang = new ImageIcon(BXiangURL);
    public static ImageIcon BXiangC = new ImageIcon(BXiangCURL);
    public static ImageIcon BXiangS = new ImageIcon(BXiangSURL);
    public static ImageIcon BZu = new ImageIcon(BZuURL);
    public static ImageIcon BZuC = new ImageIcon(BZuCURL);
    public static ImageIcon BZuS = new ImageIcon(BZuSURL);

    public static ImageIcon RBing = new ImageIcon(RBingURL);
    public static ImageIcon RBingC = new ImageIcon(RBingCURL);
    public static ImageIcon RChe = new ImageIcon(RCheURL);
    public static ImageIcon RCheC = new ImageIcon(RCheCURL);
    public static ImageIcon RMa = new ImageIcon(RMaURL);
    public static ImageIcon RMaC = new ImageIcon(RMaCURL);
    public static ImageIcon RPao = new ImageIcon(RPaoURL);
    public static ImageIcon RPaoC = new ImageIcon(RPaoCURL);
    public static ImageIcon RShi = new ImageIcon(RShiURL);
    public static ImageIcon RShiC = new ImageIcon(RShiCURL);
    public static ImageIcon RShuai = new ImageIcon(RShuaiURL);
    public static ImageIcon RShuaiC = new ImageIcon(RShuaiCURL);
    public static ImageIcon RXiang= new ImageIcon(RXiangURL);
    public static ImageIcon RXiangC= new ImageIcon(RXiangCURL);
    public static ImageIcon RBingS= new ImageIcon(RBingSURL);
    public static ImageIcon RCheS= new ImageIcon(RCheSURL);
    public static ImageIcon RMaS= new ImageIcon(RMaSURL);
    public static ImageIcon RPaoS= new ImageIcon(RPaoSURL);
    public static ImageIcon RShiS= new ImageIcon(RShiSURL);
    public static ImageIcon RXiangS= new ImageIcon(RXiangSURL);
    public static ImageIcon RShuaiS= new ImageIcon(RShuaiSURL);

    public static Image BCheI= Toolkit.getDefaultToolkit().getImage(BCheURL);
    public static Image BCheSI= Toolkit.getDefaultToolkit().getImage(BCheSURL);
    public static Image BJiangI= Toolkit.getDefaultToolkit().getImage(BJiangURL);
    public static Image BJiangSI= Toolkit.getDefaultToolkit().getImage(BJiangURL);
    public static Image BMaI= Toolkit.getDefaultToolkit().getImage(BMaURL);
    public static Image BMaSI= Toolkit.getDefaultToolkit().getImage(BMaSURL);
    public static Image BPaoI= Toolkit.getDefaultToolkit().getImage(BPaoURL);
    public static Image BPaoSI= Toolkit.getDefaultToolkit().getImage(BPaoSURL);
    public static Image BShiI= Toolkit.getDefaultToolkit().getImage(BShiURL);
    public static Image BShiSI= Toolkit.getDefaultToolkit().getImage(BShiSURL);
    public static Image BXiangI= Toolkit.getDefaultToolkit().getImage(BXiangURL);
    public static Image BXiangSI= Toolkit.getDefaultToolkit().getImage(BXiangSURL);
    public static Image BZuI= Toolkit.getDefaultToolkit().getImage(BZuURL);
    public static Image BZuSI= Toolkit.getDefaultToolkit().getImage(BZuSURL);

    public static Image RBingI= Toolkit.getDefaultToolkit().getImage(RBingURL);
    public static Image RBingSI= Toolkit.getDefaultToolkit().getImage(RBingSURL);
    public static Image RCheI= Toolkit.getDefaultToolkit().getImage(RCheURL);
    public static Image RCheSI= Toolkit.getDefaultToolkit().getImage(RCheSURL);
    public static Image RMaI= Toolkit.getDefaultToolkit().getImage(RMaURL);
    public static Image RMaSI= Toolkit.getDefaultToolkit().getImage(RMaSURL);
    public static Image RPaoI= Toolkit.getDefaultToolkit().getImage(RPaoSURL);
    public static Image RPaoSI= Toolkit.getDefaultToolkit().getImage(RPaoSURL);
    public static Image RShiI= Toolkit.getDefaultToolkit().getImage(RShiURL);
    public static Image RShiSI= Toolkit.getDefaultToolkit().getImage(RShiSURL);
    public static Image RShuaiI= Toolkit.getDefaultToolkit().getImage(RShuaiURL);
    public static Image RShuaiSI= Toolkit.getDefaultToolkit().getImage(RShuaiSURL);
    public static Image RXiangI= Toolkit.getDefaultToolkit().getImage(RXiangURL);
    public static Image RXiangSI= Toolkit.getDefaultToolkit().getImage(RXiangSURL);

    public static Image emptyI= Toolkit.getDefaultToolkit().getImage(emptyURL);
    public static int RedPoint = 0;
    public static int BlackPoint = 0;

}


