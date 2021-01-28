import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;
import java.net.URI;
import java.awt.*;

public class App extends JFrame {
    static App theApp;

    JPanel pnPanel;
    JTabbedPane tbpTabPanel;

    class MainPanel extends JPanel implements ActionListener {
        JCheckBox cbOption2;
        JCheckBox cbOption1;
        JTextField tfApiKey;
        JLabel lbYoutubeLabel;
        JTextField tfPlaylist;
        JButton btStartButton;

        public MainPanel() {
            super();

            GridBagLayout gbMainPanel = new GridBagLayout();
            GridBagConstraints gbcMainPanel = new GridBagConstraints();
            setLayout(gbMainPanel);

            cbOption2 = new JCheckBox("Generate Log.");
            cbOption2.setSelected(true);
            gbcMainPanel.gridx = 0;
            gbcMainPanel.gridy = 1;
            gbcMainPanel.gridwidth = 6;
            gbcMainPanel.gridheight = 1;
            gbcMainPanel.fill = GridBagConstraints.BOTH;
            gbcMainPanel.weightx = 1;
            gbcMainPanel.weighty = 1;
            gbcMainPanel.anchor = GridBagConstraints.NORTH;
            gbMainPanel.setConstraints(cbOption2, gbcMainPanel);
            add(cbOption2);

            cbOption1 = new JCheckBox("Organize files into directories (based on artist).");
            cbOption1.setSelected(true);
            gbcMainPanel.gridx = 0;
            gbcMainPanel.gridy = 0;
            gbcMainPanel.gridwidth = 6;
            gbcMainPanel.gridheight = 1;
            gbcMainPanel.fill = GridBagConstraints.BOTH;
            gbcMainPanel.weightx = 1;
            gbcMainPanel.weighty = 1;
            gbcMainPanel.anchor = GridBagConstraints.NORTH;
            gbMainPanel.setConstraints(cbOption1, gbcMainPanel);
            add(cbOption1);

            tfApiKey = new JTextField();
            gbcMainPanel.gridx = 2;
            gbcMainPanel.gridy = 2;
            gbcMainPanel.gridwidth = 4;
            gbcMainPanel.gridheight = 1;
            gbcMainPanel.fill = GridBagConstraints.BOTH;
            gbcMainPanel.weightx = 1;
            gbcMainPanel.weighty = 0;
            gbcMainPanel.anchor = GridBagConstraints.CENTER;
            gbMainPanel.setConstraints(tfApiKey, gbcMainPanel);
            add(tfApiKey);

            lbYoutubeLabel = new JLabel("Youtube API Key");
            lbYoutubeLabel.setIconTextGap(15);
            gbcMainPanel.gridx = 0;
            gbcMainPanel.gridy = 2;
            gbcMainPanel.gridwidth = 2;
            gbcMainPanel.gridheight = 1;
            gbcMainPanel.fill = GridBagConstraints.BOTH;
            gbcMainPanel.weightx = 1;
            gbcMainPanel.weighty = 1;
            gbcMainPanel.anchor = GridBagConstraints.CENTER;
            gbMainPanel.setConstraints(lbYoutubeLabel, gbcMainPanel);
            add(lbYoutubeLabel);

            tfPlaylist = new JTextField();
            gbcMainPanel.gridx = 0;
            gbcMainPanel.gridy = 3;
            gbcMainPanel.gridwidth = 6;
            gbcMainPanel.gridheight = 2;
            gbcMainPanel.fill = GridBagConstraints.BOTH;
            gbcMainPanel.weightx = 1;
            gbcMainPanel.weighty = 1;
            gbcMainPanel.anchor = GridBagConstraints.CENTER;
            gbMainPanel.setConstraints(tfPlaylist, gbcMainPanel);
            add(tfPlaylist);

            btStartButton = new JButton("Start Download");
            btStartButton.addActionListener(this);
            gbcMainPanel.gridx = 0;
            gbcMainPanel.gridy = 5;
            gbcMainPanel.gridwidth = 6;
            gbcMainPanel.gridheight = 2;
            gbcMainPanel.fill = GridBagConstraints.BOTH;
            gbcMainPanel.weightx = 1;
            gbcMainPanel.weighty = 1;
            gbcMainPanel.anchor = GridBagConstraints.CENTER;
            gbMainPanel.setConstraints(btStartButton, gbcMainPanel);
            add(btStartButton);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btStartButton) {
                // Action for btStartButton
            }
        }
    }

    MainPanel pnMainPanel;

    JPanel pnAbout;
    JLabel lbAboutLabel;

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (UnsupportedLookAndFeelException e) {
        }
        theApp = new App();
    }

    public App() {
        super("TITLE");

        pnPanel = new JPanel();
        GridBagLayout gbPanel = new GridBagLayout();
        GridBagConstraints gbcPanel = new GridBagConstraints();
        pnPanel.setLayout(gbPanel);

        tbpTabPanel = new JTabbedPane();

        pnMainPanel = new MainPanel();
        tbpTabPanel.addTab("Downloader", pnMainPanel);

        pnAbout = new JPanel();
        GridBagLayout gbAbout = new GridBagLayout();
        GridBagConstraints gbcAbout = new GridBagConstraints();
        pnAbout.setLayout(gbAbout);

         String text = "Spotify Downloader" + "<br>" +
         "By: Ashrit Yarava" + "<br><br>" + 
         "<a href='https://github.com/Ashrit-Yarava/Spotify-Downloader'>Github</a>";

        lbAboutLabel = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>", SwingConstants.CENTER);
        lbAboutLabel.addMouseListener(new MouseInputAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             try {
                 Desktop.getDesktop().browse(new URI("https://github.com/Ashrit-Yarava/Spotify-Downloader"));
             } catch (URISyntaxException | IOException ex) {
                 System.exit(103);
             }
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         }
      
         @Override
         public void mouseExited(MouseEvent e) {
            setCursor(Cursor.getDefaultCursor());
         }
      });
        gbcAbout.gridx = 0;
        gbcAbout.gridy = 0;
        gbcAbout.gridwidth = 20;
        gbcAbout.gridheight = 20;
        gbcAbout.fill = GridBagConstraints.BOTH;
        gbcAbout.weightx = 1;
        gbcAbout.weighty = 1;
        gbcAbout.anchor = GridBagConstraints.NORTH;
        gbAbout.setConstraints(lbAboutLabel, gbcAbout);
        pnAbout.add(lbAboutLabel);
        tbpTabPanel.addTab("About", pnAbout);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 0;
        gbcPanel.gridwidth = 1;
        gbcPanel.gridheight = 1;
        gbcPanel.fill = GridBagConstraints.BOTH;
        gbcPanel.weightx = 1;
        gbcPanel.weighty = 1;
        gbcPanel.anchor = GridBagConstraints.NORTH;
        gbPanel.setConstraints(tbpTabPanel, gbcPanel);
        pnPanel.add(tbpTabPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(pnPanel);
        pack();
        setVisible(true);
    }
}
