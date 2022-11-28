package co.com.devco.automation.screenplay.as400.utils;

import jline.internal.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Text {

    private Text(){}

    public static void toImage(String text, String name){

        String path =  System.getProperty("user.dir") + ("test".equals(System.getenv("testDir"))?"/src/test/resources/":"/target/site/serenity/");
        int fila  = 1;
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d = image.createGraphics();
        Font font = new Font("TimesNewRoman", Font.BOLD, 24);
        graphics2d.setBackground(Color.BLACK);
        graphics2d.setColor(Color.GREEN);

        for (String dato : text.split("\n")) {
            graphics2d.drawString(dato, 0,fila++ * font.getSize());
        }

        graphics2d.dispose();

        try {
            ImageIO.write(image, "png", new File(path + name + ".png"));
        } catch (IOException e) {
            Log.error(e);
        }

    }

}
