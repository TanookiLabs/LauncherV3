package net.littlebits.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.littlebits.ui.controls.ActionButton;
import net.technicpack.launcher.settings.TechnicSettings;
import net.technicpack.launchercore.auth.IUserType;
import net.technicpack.launchercore.auth.UserModel;
import net.technicpack.launchercore.image.ImageRepository;
import net.technicpack.minecraftcore.mojang.auth.MojangUser;
import net.technicpack.ui.lang.ResourceLoader;

public class LoginInfoPanel extends BitcraftPanel {

    private ImageRepository<IUserType> skinRepository;
    private UserModel<MojangUser> userModel;
    private TechnicSettings settings;

    private JTextField name;
    private JComboBox nameSelect;
    private JCheckBox rememberAccount;
    private JPasswordField password;
    private JComboBox languages;
		
    
	public LoginInfoPanel(ResourceLoader loader, Dimension contentDimensions) {
		super(loader, contentDimensions);
        JLabel goLabel = new JLabel("LET'S GO");
        goLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.contentPanel.setBackground(COLOR_LITTLEBITS_WHITE);
	}


	// Littlebits modification
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
