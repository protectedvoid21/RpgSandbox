package gui.customUI.customUIStyles;

import gui.customUI.ICustomUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageBorderWraper extends RoundedBorderDecorator{
    private Image img;

    public ImageBorderWraper(ICustomUI ui, String path) {
        super(ui);
        System.out.println("jestemmm");
        uploadImage(path);
    }


    public void uploadImage(String path){
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            img = null;
        }
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        paintBackground(g, c, getBorderSize());
    }

    @Override
    public void paintBackground(Graphics g, JComponent c, int yOffset) {
        super.paintBackground(g, c, yOffset);//zrobic cos zeby nie byl wiekszy od wyznaczonego rozmiaru
        System.out.println(c.getBounds());
        var w = c.getWidth();
        var h = c.getHeight();
        System.out.println("oto "+w+"sdfs"+h+"  "+yOffset);
        g.drawImage(img.getScaledInstance((int)(0.8*h), (int)(0.8*h), Image.SCALE_DEFAULT), (int)(0.1*h), (int)(0.1*h), null);
    }
}
