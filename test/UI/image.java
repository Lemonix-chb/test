package test.UI;

import javax.swing.*;
import java.net.URL;

public class image  {
    public static URL bodyURL = image.class.getResource("/image/body.png");
    public static URL upURL = image.class.getResource("/image/up.png");
    public static URL downURL = image.class.getResource("/image/down.png");
    public static URL rightURL = image.class.getResource("/image/right.png");
    public static URL leftURL = image.class.getResource("/image/left.png");
    public static URL header = image.class.getResource("/image/OIP-C (1).png");
    public static URL foodURL = image.class.getResource("/image/food.png");
    public static URL body2URL = image.class.getResource("/image/body2.png");

    public static ImageIcon bodyImg = new ImageIcon(bodyURL);
    public static ImageIcon upImg = new ImageIcon(upURL);
    public static ImageIcon downImg = new ImageIcon(downURL);
    public static ImageIcon rightImg = new ImageIcon(rightURL);
    public static ImageIcon leftImg = new ImageIcon(leftURL);
    public static ImageIcon headerImg = new ImageIcon(header);
    public static ImageIcon foodImg = new ImageIcon(foodURL);
    public static ImageIcon body2Img = new ImageIcon(body2URL);
}
