import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Ashrit Yarava
 * @created January 26, 2021
 */
public class App extends JFrame {
   /**
    *
    */
   private static final long serialVersionUID = 1L;

   static App thecode;

   JPanel pnPrimaryPanel;
   JTabbedPane tbpSplit;

   /**
    * @author Ashrit Yarava
    * @created January 26, 2021
    */
   class MainPanel extends JPanel implements ActionListener {

      /**
      *
      */
      private static final long serialVersionUID = 1L;
      JPanel pnOptionsPanel;
      JCheckBox cbOption1;
      JCheckBox cbOption2;
      JCheckBox cbOption3;

      JPanel pnPlaylistBox;
      JTextField tfPlaylistURL;
      
      /**
       * Constructor for the MainPanel object
       */
      public MainPanel() {
         super();

         GridBagLayout gbMainPanel = new GridBagLayout();
         GridBagConstraints gbcMainPanel = new GridBagConstraints();
         setLayout(gbMainPanel);

         pnOptionsPanel = new JPanel();
         pnOptionsPanel.setBorder(BorderFactory.createTitledBorder("Options"));
         GridBagLayout gbOptionsPanel = new GridBagLayout();
         GridBagConstraints gbcOptionsPanel = new GridBagConstraints();
         pnOptionsPanel.setLayout(gbOptionsPanel);

         cbOption1 = new JCheckBox("Organize downloaded files into directories (Based on artist).");
         cbOption1.setSelected(true);
         gbcOptionsPanel.gridx = 0;
         gbcOptionsPanel.gridy = 0;
         gbcOptionsPanel.gridwidth = 3;
         gbcOptionsPanel.gridheight = 2;
         gbcOptionsPanel.fill = GridBagConstraints.BOTH;
         gbcOptionsPanel.weightx = 1;
         gbcOptionsPanel.weighty = 1;
         gbcOptionsPanel.anchor = GridBagConstraints.NORTH;
         gbOptionsPanel.setConstraints(cbOption1, gbcOptionsPanel);
         pnOptionsPanel.add(cbOption1);

         cbOption2 = new JCheckBox("Preserve all files.");
         cbOption2.setSelected(false);
         gbcOptionsPanel.gridx = 0;
         gbcOptionsPanel.gridy = 2;
         gbcOptionsPanel.gridwidth = 3;
         gbcOptionsPanel.gridheight = 1;
         gbcOptionsPanel.fill = GridBagConstraints.BOTH;
         gbcOptionsPanel.weightx = 1;
         gbcOptionsPanel.weighty = 1;
         gbcOptionsPanel.anchor = GridBagConstraints.NORTH;
         gbOptionsPanel.setConstraints(cbOption2, gbcOptionsPanel);
         pnOptionsPanel.add(cbOption2);

         cbOption3 = new JCheckBox("Log to file. (log.txt)");
         cbOption3.setSelected(false);
         gbcOptionsPanel.gridx = 0;
         gbcOptionsPanel.gridy = 3;
         gbcOptionsPanel.gridwidth = 3;
         gbcOptionsPanel.gridheight = 1;
         gbcOptionsPanel.fill = GridBagConstraints.BOTH;
         gbcOptionsPanel.weightx = 1;
         gbcOptionsPanel.weighty = 1;
         gbcOptionsPanel.anchor = GridBagConstraints.NORTH;
         gbOptionsPanel.setConstraints(cbOption3, gbcOptionsPanel);
         pnOptionsPanel.add(cbOption3);

         pnPlaylistBox = new JPanel();
         pnPlaylistBox.setBorder(BorderFactory.createTitledBorder("Playlist URL"));
         GridBagLayout gbPlaylistBox = new GridBagLayout();
         GridBagConstraints gbcPlaylistBox = new GridBagConstraints();
         pnPlaylistBox.setLayout(gbPlaylistBox);

         tfPlaylistURL = new JTextField();
         gbcPlaylistBox.gridx = 0;
         gbcPlaylistBox.gridy = 0;
         gbcPlaylistBox.gridwidth = 3;
         gbcPlaylistBox.gridheight = 1;
         gbcPlaylistBox.fill = GridBagConstraints.BOTH;
         gbcPlaylistBox.weightx = 1;
         gbcPlaylistBox.weighty = 1;
         gbcPlaylistBox.anchor = GridBagConstraints.NORTH;
         gbPlaylistBox.setConstraints(tfPlaylistURL, gbcPlaylistBox);
         pnPlaylistBox.add(tfPlaylistURL);
         gbcOptionsPanel.gridx = 0;
         gbcOptionsPanel.gridy = 4;
         gbcOptionsPanel.gridwidth = 3;
         gbcOptionsPanel.gridheight = 1;
         gbcOptionsPanel.fill = GridBagConstraints.BOTH;
         gbcOptionsPanel.weightx = 1;
         gbcOptionsPanel.weighty = 1;
         gbcOptionsPanel.anchor = GridBagConstraints.NORTH;
         gbOptionsPanel.setConstraints(pnPlaylistBox, gbcOptionsPanel);
         pnOptionsPanel.add(pnPlaylistBox);
         gbcMainPanel.gridx = 0;
         gbcMainPanel.gridy = 0;
         gbcMainPanel.gridwidth = 1;
         gbcMainPanel.gridheight = 1;
         gbcMainPanel.fill = GridBagConstraints.BOTH;
         gbcMainPanel.weightx = 1;
         gbcMainPanel.weighty = 1;
         gbcMainPanel.anchor = GridBagConstraints.NORTH;
         gbMainPanel.setConstraints(pnOptionsPanel, gbcMainPanel);
         add(pnOptionsPanel);
      }

      /**
       */
      public void actionPerformed(ActionEvent e) {
      }

   }

   MainPanel pnMainPanel;

   class AboutPanel extends JPanel {
      /**
      *
      */
      private static final long serialVersionUID = 1L;
      JLabel lbLabel6;
      /**
       * Constructor for the AboutPanel object
       */
      public AboutPanel() {
         super();

         // GridBagLayout gbAboutPanel = new GridBagLayout();
         // GridBagConstraints gbcAboutPanel = new GridBagConstraints();
         // setLayout(gbAboutPanel);

         String text = "Spotify Downloader" + "<br>" +
                     "By: Ashrit Yarava" + "<br><br>" + 
                     "<a href='https://github.com/Ashrit-Yarava/Spotify-Downloader'>Github</a>";
         lbLabel6 = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>", SwingConstants.CENTER);
         lbLabel6.addMouseListener(new MouseInputAdapter() {
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
         // gbcAboutPanel.gridx = 0;
         // gbcAboutPanel.gridy = 0;
         // gbcAboutPanel.gridwidth = 20;
         // gbcAboutPanel.gridheight = 20;
         // gbcAboutPanel.fill = GridBagConstraints.BOTH;
         // gbcAboutPanel.weightx = 1;
         // gbcAboutPanel.weighty = 1;
         // gbcAboutPanel.anchor = GridBagConstraints.BOTH;
         // gbAboutPanel.setConstraints(lbLabel6, gbcAboutPanel);
         add(lbLabel6);
      }

   }

   AboutPanel pnAboutPanel;
   JButton btEnterButton;

   /**
    */
   public static void main(String[] args) {
      try {
         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } catch (ClassNotFoundException e) {
      } catch (InstantiationException e) {
      } catch (IllegalAccessException e) {
      } catch (UnsupportedLookAndFeelException e) {
      }
      thecode = new App();
   }

   /**
    */
   public App() {
      super("Spotify Downloader");

      pnPrimaryPanel = new JPanel();
      GridBagLayout gbPrimaryPanel = new GridBagLayout();
      GridBagConstraints gbcPrimaryPanel = new GridBagConstraints();
      pnPrimaryPanel.setLayout(gbPrimaryPanel);

      tbpSplit = new JTabbedPane();

      pnMainPanel = new MainPanel();
      pnAboutPanel = new AboutPanel();
      tbpSplit.addTab("Main", pnMainPanel);
      tbpSplit.addTab("About", pnAboutPanel);
      gbcPrimaryPanel.gridx = 0;
      gbcPrimaryPanel.gridy = 0;
      gbcPrimaryPanel.gridwidth = 30;
      gbcPrimaryPanel.gridheight = 17;
      gbcPrimaryPanel.fill = GridBagConstraints.BOTH;
      gbcPrimaryPanel.weightx = 1;
      gbcPrimaryPanel.weighty = 1;
      gbcPrimaryPanel.anchor = GridBagConstraints.NORTH;
      gbPrimaryPanel.setConstraints(tbpSplit, gbcPrimaryPanel);
      pnPrimaryPanel.add(tbpSplit);

      btEnterButton = new JButton("Start Download");
      gbcPrimaryPanel.gridx = 0;
      gbcPrimaryPanel.gridy = 17;
      gbcPrimaryPanel.gridwidth = 30;
      gbcPrimaryPanel.gridheight = 30;
      gbcPrimaryPanel.fill = GridBagConstraints.BOTH;
      gbcPrimaryPanel.weightx = 1;
      gbcPrimaryPanel.weighty = 0;
      gbcPrimaryPanel.anchor = GridBagConstraints.NORTH;
      gbPrimaryPanel.setConstraints(btEnterButton, gbcPrimaryPanel);
      pnPrimaryPanel.add(btEnterButton);

      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setContentPane(pnPrimaryPanel);
      setSize(500, 300);
      // pack();
      setVisible(true);
   }
}