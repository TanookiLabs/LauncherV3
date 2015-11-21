package net.littlebits.ui.controls;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
    private BufferedImage image;


    /**
     * Create a new buffered JPanel with the specified layout manager
     *
     * @param layout  the LayoutManager to use
     */
    public ImagePanel(LayoutManager layout) {
        super(layout, true);
    }


    public void setImage(BufferedImage newImage) {
        this.image = newImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension imageDimensions = getImageDimensions();
        // This preserves the image's original ratio and centers it within the panel, filling the panel complete
        Integer startX = (this.getWidth() - imageDimensions.width) / 2;
        Integer startY = (this.getHeight() - imageDimensions.height) / 2;
        g.drawImage(image, startX, startY, imageDimensions.width, imageDimensions.height, null); // see javadoc for more info on the parameters
    }

    private Dimension getImageDimensions() {

        Double imgRatio = (double) image.getWidth() / (double) image.getHeight();
        Double panelRatio = (double) this.getWidth() / (double) this.getHeight();
        if (imgRatio > panelRatio) { // image is wider than panel
            // use panel height as max height
            return new Dimension((int) (imgRatio * this.getHeight()), this.getHeight());
        } else { // image is is taller than panel
            // use panel width as max width
            return new Dimension(this.getWidth(), (int) (this.getWidth() / imgRatio));
        }
    }

}