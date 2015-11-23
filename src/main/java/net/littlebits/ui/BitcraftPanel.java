package net.littlebits.ui;

import net.littlebits.ui.controls.ActionButton;
import net.littlebits.ui.controls.ImagePanel;
import net.technicpack.launcher.ui.LauncherFrame;
import net.technicpack.launchercore.install.LauncherDirectories;
import net.technicpack.ui.controls.TiledBackground;
import net.technicpack.ui.lang.ResourceLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BitcraftPanel extends JPanel {
    final protected ResourceLoader resources;
    final protected LauncherDirectories directories;

    public static final Color COLOR_LITTLEBITS_ORANGE = new Color(255,138,0); // #FF8A00
    public static final Color COLOR_LITTLEBITS_BUTTON_HOVER = new Color(230,140,0); // #e67c00
    public static final Color COLOR_LITTLEBITS_WHITE = new Color(255,255,255);
    public static final Color COLOR_LITTLEBITS_TEXT = new Color(68,68,68); // #444

    public ImagePanel containerPanel;
    public JPanel contentPanel;

    public BitcraftPanel(final ResourceLoader loader,final LauncherDirectories directories, Dimension contentDimensions) {
        setLayout(new BorderLayout());
        this.resources = loader;
        this.directories = directories;

        this.setFont(resources.getFont(ResourceLoader.FONT_OPENSANS, 16));

        JPanel background = new JPanel(null);
        background.setOpaque(true);
        background.setForeground(COLOR_LITTLEBITS_WHITE);
        background.setBackground(LauncherFrame.COLOR_GREEN);
        background.setLayout(new BorderLayout());
        //background.setFilterImage(true);
        this.add(background, BorderLayout.CENTER);

        BufferedImage backgroundImage = resources.getImage("BITCRAFT-purple-HR.png");

        containerPanel = new ImagePanel(new GridBagLayout());
        containerPanel.setBackground(Color.green);
        containerPanel.setImage(backgroundImage);
        containerPanel.setOpaque(true);

        background.add(containerPanel);

        contentPanel = new JPanel();
        contentPanel.setBackground(COLOR_LITTLEBITS_WHITE);
        contentPanel.setForeground(COLOR_LITTLEBITS_TEXT);

        contentPanel.setPreferredSize(contentDimensions);
        contentPanel.setMaximumSize(contentDimensions);
        contentPanel.setMinimumSize(contentDimensions);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));


        this.containerPanel.add(contentPanel);
    }
}
