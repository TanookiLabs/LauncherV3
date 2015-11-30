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


public class PlayInfoPanel extends BitcraftPanel {


    private ActionListener loadListener = null;
    private ActionButton downloadButton;
    private JLabel goLabel;

    public PlayInfoPanel(final ResourceLoader loader,final LauncherDirectories directories) {
        super(loader, new Dimension(500, 320));

        contentPanel.add(Box.createVerticalStrut(75));

        goLabel = new JLabel();
        goLabel.setFont(resources.getFont(ResourceLoader.FONT_OPENSANS, 28));

        goLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        goLabel.setHorizontalAlignment(JLabel.CENTER);
        goLabel.setAlignmentX(CENTER_ALIGNMENT);

        this.contentPanel.add(goLabel);

        contentPanel.add(Box.createVerticalStrut(45));

        downloadButton = setupDownloadButton();
        this.contentPanel.add(downloadButton);



    }

    public void addDownloadActionListener(ActionListener buttonActionListener) {
        this.downloadButton.addActionListener(buttonActionListener);
    }

    public void setPlayState(String newState) {
        downloadButton.setVisible(true);
        downloadButton.setEnabled(true);
        goLabel.setText("<html>LET'S <font color='#FF8A00'><b>GO</b></font></html>");
        if (newState.equals("installer-running")) {
            downloadButton.setVisible(false);
            goLabel.setText("<html><font color='#FF8A00'><b>DOWNLOADING...</b></font></html>");
        } else if (newState.equals("installed-offline")) {
            downloadButton.setText("PLAY OFFLINE");
        } else if (newState.equals("installed")) {
                downloadButton.setText("PLAY");
        } else if (newState.equals("offline")) {
                downloadButton.setEnabled(false);
                downloadButton.setText("OFFLINE - CONNECT TO DOWNLOAD");
        } else if (newState.equals("can-install")) {
            downloadButton.setText("DOWNLOAD TO PLAY");
        }
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


