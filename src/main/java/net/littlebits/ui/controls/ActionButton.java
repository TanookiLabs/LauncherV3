package net.littlebits.ui.controls;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.JButton;

// From RoundedButton
public class ActionButton extends JButton implements MouseListener {
    private Color hoverBackground;
    private Color clickBackground;
    private Color hoverForeground;
    private Color clickForeground;
    private Icon hoverIcon = null;
    private boolean isHovered = false;
    private boolean isClicked = false;
    private boolean shouldShowBackground = false;
    private Collection<ActionListener> actionListeners = new LinkedList();
    private Integer cornerDiameter = 0;

    public ActionButton(String text) {
        super(text);
        this.addMouseListener(this);
    }

    public Icon getHoverIcon() {
        return this.hoverIcon;
    }

    public Color getHoverBackground() {
        return this.hoverBackground != null?this.hoverBackground:this.getBackground();
    }

    public Color getClickBackground() {
        return this.clickBackground != null?this.clickBackground:this.getBackground();
    }

    public Color getHoverForeground() {
        return this.hoverForeground != null?this.hoverForeground:this.getForeground();
    }

    public Color getClickForeground() {
        return this.clickForeground != null?this.clickForeground:this.getForeground();
    }

    public Integer getCornerDiameter() { return this.cornerDiameter; }

    public void setHoverIcon(Icon icon) {
        this.hoverIcon = icon;
    }

    public void setHoverBackground(Color color) {
        this.hoverBackground = color;
    }

    public void setClickBackground(Color color) {
        this.clickBackground = color;
    }

    public void setHoverForeground(Color color) {
        this.hoverForeground = color;
    }

    public void setClickForeground(Color color) {
        this.clickForeground = color;
    }

    public void setCornerDiameter(Integer number) { this.cornerDiameter = number; }



    public boolean shouldShowBackground() {
        return this.shouldShowBackground;
    }

    public void setShouldShowBackground(boolean shouldShowBackground) {
        this.shouldShowBackground = shouldShowBackground;
    }

    public void paintComponent(Graphics g) {
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        if(this.shouldShowBackground()) {
            if(this.isClicked) {
                g2d.setColor(this.getClickBackground());
            } else if(this.isHovered) {
                g2d.setColor(this.getHoverBackground());
            } else {
                g2d.setColor(this.getBackground());
            }

            g2d.fillRoundRect(1, 1, this.getWidth() - 3, this.getHeight() - 2, this.getCornerDiameter(), this.getCornerDiameter());
        }

        if(this.isClicked) {
            g2d.setColor(this.getClickForeground());
        } else if(this.isHovered) {
            g2d.setColor(this.getHoverForeground());
        } else {
            g2d.setColor(this.getForeground());
        }

        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(1.0F));
        //g2d.drawRoundRect(1, 1, this.getWidth() - 3, this.getHeight() - 3, this.getCornerDiameter(), this.getCornerDiameter());
        g2d.setStroke(oldStroke);
        g2d.setFont(this.getFont());
        int width = g2d.getFontMetrics().stringWidth(this.getText());
        if(this.getIcon() != null) {
            width += this.getIcon().getIconWidth() + this.getIconTextGap();
        }

        int height = (this.getHeight() - g2d.getFontMetrics().getHeight()) / 2 + g2d.getFontMetrics().getAscent() - 1;
        int textX = (this.getWidth() - width) / 2;
        Icon currentIcon = this.getIcon();
        if(this.isHovered && this.getHoverIcon() != null) {
            currentIcon = this.getHoverIcon();
        }

        if(currentIcon != null) {
            textX += this.getIconTextGap() + currentIcon.getIconWidth();
        }

        g.drawString(this.getText(), textX, height);
        if(currentIcon != null) {
            currentIcon.paintIcon(this, g2d, (this.getWidth() - width) / 2, (this.getHeight() - currentIcon.getIconHeight()) / 2);
        }

    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        this.isClicked = true;
    }

    public void mouseReleased(MouseEvent e) {
        this.isClicked = false;
    }

    public void mouseEntered(MouseEvent e) {
        this.isHovered = true;
    }

    public void mouseExited(MouseEvent e) {
        this.isHovered = false;
    }
}
