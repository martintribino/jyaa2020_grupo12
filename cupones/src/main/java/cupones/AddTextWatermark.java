package cupones;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class AddTextWatermark {

    public static int calculateHeight(
    		ArrayList<String> texts,
    		BufferedImage watermarked) {
        Graphics2D w = (Graphics2D) watermarked.getGraphics();
        FontMetrics fontMetrics = w.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds("", w);
        int height = 0;
        for (String line : texts) {
            rect = fontMetrics.getStringBounds(line, w);
            height += (int) rect.getWidth();
        }
        return height;
    }

    public static BufferedImage addTextWatermark(
    		ArrayList<String> texts,
    		Color color,
    		String type,
    		BufferedImage image,
    		int centerY,
    		int fontSize) throws IOException {

        // determine image type and handle correct transparency
        int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
        BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

        // initializes necessary graphic properties
        Graphics2D w = (Graphics2D) watermarked.getGraphics();
        w.drawImage(image, 0, 0, null);
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f);
        w.setComposite(alphaChannel);
        w.setColor(color);
        w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontSize));
        FontMetrics fontMetrics = w.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds("", w);

        // calculate center of the image
        int centerX = 0;

        // add text overlay to the image
        //w.drawString(text, centerX, centerY);
        int lineHeight = w.getFontMetrics().getHeight();
        for (String line : texts) {
            rect = fontMetrics.getStringBounds(line, w);
            centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
            w.drawString(line, centerX, centerY += lineHeight);
        }
        w.dispose();
        return watermarked;
    }
}
