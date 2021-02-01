package downloader;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.event.*;

public class App extends JFrame {
    static App theApp;

    JPanel MainPanel;
    JTabbedPane Panel0;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(475, 300);
    }

    class downloadPanel extends JPanel implements ActionListener {
        JButton startButton;
        JTextField playlistText;
        JLabel spotifyLabel;
        JTextField spotifyText;
        JLabel youtubeLabel;
        JTextField youtubeText;

        public downloadPanel() {
            super();

            GridBagLayout gbdownloadPanel = new GridBagLayout();
            GridBagConstraints gbcdownloadPanel = new GridBagConstraints();
            setLayout(gbdownloadPanel);

            startButton = new JButton("Start Download");
            startButton.addActionListener(this);
            gbcdownloadPanel.gridx = 0;
            gbcdownloadPanel.gridy = 3;
            gbcdownloadPanel.gridwidth = 2;
            gbcdownloadPanel.gridheight = 1;
            gbcdownloadPanel.fill = GridBagConstraints.BOTH;
            gbcdownloadPanel.weightx = 1;
            gbcdownloadPanel.weighty = 1;
            gbcdownloadPanel.anchor = GridBagConstraints.NORTH;
            gbdownloadPanel.setConstraints(startButton, gbcdownloadPanel);
            add(startButton);

            playlistText = new JTextField();
            gbcdownloadPanel.gridx = 0;
            gbcdownloadPanel.gridy = 2;
            gbcdownloadPanel.gridwidth = 2;
            gbcdownloadPanel.gridheight = 1;
            gbcdownloadPanel.fill = GridBagConstraints.BOTH;
            gbcdownloadPanel.weightx = 1;
            gbcdownloadPanel.weighty = 1;
            gbcdownloadPanel.anchor = GridBagConstraints.NORTH;
            gbdownloadPanel.setConstraints(playlistText, gbcdownloadPanel);
            add(playlistText);

            spotifyLabel = new JLabel("Spotify API");
            gbcdownloadPanel.gridx = 0;
            gbcdownloadPanel.gridy = 1;
            gbcdownloadPanel.gridwidth = 1;
            gbcdownloadPanel.gridheight = 1;
            gbcdownloadPanel.fill = GridBagConstraints.BOTH;
            gbcdownloadPanel.weightx = 1;
            gbcdownloadPanel.weighty = 1;
            gbcdownloadPanel.anchor = GridBagConstraints.CENTER;
            gbdownloadPanel.setConstraints(spotifyLabel, gbcdownloadPanel);
            add(spotifyLabel);

            spotifyText = new JTextField();
            gbcdownloadPanel.gridx = 1;
            gbcdownloadPanel.gridy = 1;
            gbcdownloadPanel.gridwidth = 1;
            gbcdownloadPanel.gridheight = 1;
            gbcdownloadPanel.fill = GridBagConstraints.BOTH;
            gbcdownloadPanel.weightx = 1;
            gbcdownloadPanel.weighty = 1;
            gbcdownloadPanel.anchor = GridBagConstraints.NORTH;
            gbdownloadPanel.setConstraints(spotifyText, gbcdownloadPanel);
            add(spotifyText);

            youtubeLabel = new JLabel("Youtube API");
            gbcdownloadPanel.gridx = 0;
            gbcdownloadPanel.gridy = 0;
            gbcdownloadPanel.gridwidth = 1;
            gbcdownloadPanel.gridheight = 1;
            gbcdownloadPanel.fill = GridBagConstraints.BOTH;
            gbcdownloadPanel.weightx = 1;
            gbcdownloadPanel.weighty = 1;
            gbcdownloadPanel.anchor = GridBagConstraints.NORTH;
            gbdownloadPanel.setConstraints(youtubeLabel, gbcdownloadPanel);
            add(youtubeLabel);

            youtubeText = new JTextField();
            gbcdownloadPanel.gridx = 1;
            gbcdownloadPanel.gridy = 0;
            gbcdownloadPanel.gridwidth = 1;
            gbcdownloadPanel.gridheight = 1;
            gbcdownloadPanel.fill = GridBagConstraints.BOTH;
            gbcdownloadPanel.weightx = 1;
            gbcdownloadPanel.weighty = 1;
            gbcdownloadPanel.anchor = GridBagConstraints.NORTH;
            gbdownloadPanel.setConstraints(youtubeText, gbcdownloadPanel);
            add(youtubeText);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startButton) {
                Main.download(youtubeText.getText(), spotifyText.getText(), playlistText.getText());
            }
        }
    }

    downloadPanel downloadPanel;

    class aboutPanel extends JPanel implements ActionListener {
        JButton YoutubeButton;
        JButton SpotifyButton;
        JLabel AboutText;

        public aboutPanel() {
            super();

            GridBagLayout gbaboutPanel = new GridBagLayout();
            GridBagConstraints gbcaboutPanel = new GridBagConstraints();
            setLayout(gbaboutPanel);

            YoutubeButton = new JButton("Youtube API Guide");
            YoutubeButton.addActionListener(this);
            gbcaboutPanel.gridx = 0;
            gbcaboutPanel.gridy = 12;
            gbcaboutPanel.gridwidth = 20;
            gbcaboutPanel.gridheight = 4;
            gbcaboutPanel.fill = GridBagConstraints.BOTH;
            gbcaboutPanel.weightx = 1;
            gbcaboutPanel.weighty = 0;
            gbcaboutPanel.anchor = GridBagConstraints.NORTH;
            gbaboutPanel.setConstraints(YoutubeButton, gbcaboutPanel);
            add(YoutubeButton);

            SpotifyButton = new JButton("Spotify API Guide");
            SpotifyButton.addActionListener(this);
            gbcaboutPanel.gridx = 0;
            gbcaboutPanel.gridy = 16;
            gbcaboutPanel.gridwidth = 20;
            gbcaboutPanel.gridheight = 4;
            gbcaboutPanel.fill = GridBagConstraints.BOTH;
            gbcaboutPanel.weightx = 1;
            gbcaboutPanel.weighty = 0;
            gbcaboutPanel.anchor = GridBagConstraints.NORTH;
            gbaboutPanel.setConstraints(SpotifyButton, gbcaboutPanel);
            add(SpotifyButton);

            String text = "Spotify Downloader" + "<br>" + "By: Ashrit Yarava" + "<br><br>"
                    + "<a href='https://github.com/Ashrit-Yarava/Spotify-Downloader'>Github</a>";

            AboutText = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>",
                    SwingConstants.CENTER);
            AboutText.addMouseListener(new MouseInputAdapter() {
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

            gbcaboutPanel.gridx = 0;
            gbcaboutPanel.gridy = 0;
            gbcaboutPanel.gridwidth = 20;
            gbcaboutPanel.gridheight = 12;
            gbcaboutPanel.fill = GridBagConstraints.BOTH;
            gbcaboutPanel.weightx = 1;
            gbcaboutPanel.weighty = 1;
            gbcaboutPanel.anchor = GridBagConstraints.NORTH;
            gbaboutPanel.setConstraints(AboutText, gbcaboutPanel);
            add(AboutText);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == YoutubeButton) {
                try {
                    Desktop.getDesktop().browse(
                            new URL("https://ashrit-yarava.github.io/Spotify-Downloader/youtube-token.html").toURI());
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == SpotifyButton) {
                try {
                    Desktop.getDesktop().browse(
                            new URL("https://ashrit-yarava.github.io/Spotify-Downloader/spotify-token.html").toURI());
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    aboutPanel aboutPanel;

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
        super("Spotify Downloader");

        MainPanel = new JPanel();
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        MainPanel.setLayout(gbMainPanel);

        Panel0 = new JTabbedPane();

        downloadPanel = new downloadPanel();
        Panel0.addTab("Downloader", downloadPanel);

        aboutPanel = new aboutPanel();
        Panel0.addTab("About & Help", aboutPanel);
        gbcMainPanel.gridx = 0;
        gbcMainPanel.gridy = 0;
        gbcMainPanel.gridwidth = 30;
        gbcMainPanel.gridheight = 20;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 1;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints(Panel0, gbcMainPanel);
        MainPanel.add(Panel0);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(MainPanel);
        pack();
        setVisible(true);
    }
}
