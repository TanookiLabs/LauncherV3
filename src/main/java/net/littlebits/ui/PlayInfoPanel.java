package net.littlebits.ui;

import net.littlebits.ui.controls.ActionButton;
import net.technicpack.launcher.ui.LauncherFrame;
import net.technicpack.launchercore.install.LauncherDirectories;
import net.technicpack.ui.controls.TiledBackground;
import net.technicpack.ui.lang.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PlayInfoPanel extends JPanel {

    final private ResourceLoader resources;
    final private LauncherDirectories directories;
    private ActionListener loadListener = null;
    private TiledBackground background;
    private ActionButton downloadButton;

    public static final Color COLOR_LITTLEBITS_ORANGE = new Color(255,138,0); // #FF8A00
    public static final Color COLOR_LITTLEBITS_BUTTON_HOVER = new Color(230,140,0); // #e67c00
    public static final Color COLOR_LITTLEBITS_WHITE = new Color(255,255,255);
    public static final Color COLOR_LITTLEBITS_TEXT = new Color(68,68,68); // #444

    public PlayInfoPanel(final ResourceLoader loader,final LauncherDirectories directories) {
        setLayout(new BorderLayout());
        this.resources = loader;
        this.directories = directories;

        this.setFont(resources.getFont(ResourceLoader.FONT_OPENSANS, 16));

        background = new TiledBackground(null);
        background.setOpaque(true);
        background.setForeground(COLOR_LITTLEBITS_WHITE);
        background.setBackground(LauncherFrame.COLOR_BLUE_DARKER);
        background.setLayout(new BorderLayout());
        //background.setFilterImage(true);
        this.add(background, BorderLayout.CENTER);



        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(COLOR_LITTLEBITS_WHITE);
        contentPanel.setForeground(COLOR_LITTLEBITS_TEXT);
        Dimension contentDimensions = new Dimension(500, 320);
        contentPanel.setPreferredSize(contentDimensions);
        contentPanel.setMaximumSize(contentDimensions);
        contentPanel.setMinimumSize(contentDimensions);

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JLabel goLabel = new JLabel("LET'S GO");
        goLabel.setAlignmentX(CENTER_ALIGNMENT);
        contentPanel.add(goLabel);

        downloadButton = setupDownloadButton();
        contentPanel.add(downloadButton);

        JPanel containerPanel = new JPanel(new GridBagLayout());
        containerPanel.setBackground(Color.CYAN);
        containerPanel.add(contentPanel);
        background.add(containerPanel);
    }

    public void addDownloadActionListener(ActionListener buttonActionListener) {
        this.downloadButton.addActionListener(buttonActionListener);
    }

    protected ActionButton setupDownloadButton() {
        ActionButton lbDownloadButton = new ActionButton("DOWNLOAD TO PLAY");
        lbDownloadButton.setForeground(COLOR_LITTLEBITS_WHITE);
        lbDownloadButton.setBackground(COLOR_LITTLEBITS_ORANGE);
        lbDownloadButton.setShouldShowBackground(true);
        lbDownloadButton.setHoverBackground(COLOR_LITTLEBITS_BUTTON_HOVER);
        lbDownloadButton.setHoverForeground(COLOR_LITTLEBITS_WHITE);
        lbDownloadButton.setFocusable(false);
        lbDownloadButton.setFont(resources.getFont(ResourceLoader.FONT_OPENSANS, 16, Font.BOLD));
        lbDownloadButton.setRolloverEnabled(true);
        lbDownloadButton.setCornerDiameter(14);
        lbDownloadButton.setAlignmentX(CENTER_ALIGNMENT);
        lbDownloadButton.setBorder(BorderFactory.createEmptyBorder(15,50,15,50));
        return lbDownloadButton;
    }



}


