import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * MemeMagic Graphical User Interface 
 * 
 * This class contains the graphical user interface for the Meme Magic Software
 * 
 * You will need to implement certain portions of this class, marked with comments starting with "TODO" to connect 
 * it with your existing code. 
 * 
 * This class provides an example layout for the GUI. You are encouraged to be creative in your design. 
 * More information about Swing is online at: 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html.
 */
public class MemeMagic extends JFrame {

    /**
     * Serialization string required by extending JFrame
     */
    private static final long serialVersionUID = 1L;
    
    private User user;
    private GraphicalMeme currentMeme;
    
    private String backgroundImageFilename;

    private BorderLayout panelLayout;
    private JLabel backgroundImageFileNameLabel;
    private JLabel imageDisplayLabel;
    private JPanel controlPanel;
    private JPanel memeViewPanel;
    private JPanel panelPane;
    private JTextField backgroundImageTitleTextField;
    private JTextField backgroundImageDescriptionTextField;
    private JTextField MemeCaptionTextField;
    private JComboBox<String> MemeVerticalAlignJComboBox;
    
    
    public MemeMagic() {
        this.user = new User();
    }
    
    public MemeMagic(User user) {
        this.user = user;
    }


    /**
     * Main method.  This method initializes a PhotoViewer, loads images into a PhotographContainer, then
     * initializes the Graphical User Interface.
     * 
     * @param args  Optional command-line arguments
     */
    public static void main(String[] args) {
        
        // Create a User object for this instance of Meme Magic
        User user = new User();

        // Instantiate the PhotoViewer Class
        MemeMagic myViewer = new MemeMagic(user);
        
        // Invoke and start the Graphical User Interface
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.initialize());
    }

    /**
     * Initialize all the GUI components.  This method will be called by
     * SwingUtilities when the application is started.
     */
    private void initialize() {

        // Tell Java to exit the program when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tell Java to title the window to Meme Magic
        this.setTitle("Meme Magic");

        // We will use border layout on the main panel, since it is much easier for organizing panels.
        panelLayout = new BorderLayout();
        panelPane = new JPanel(panelLayout);

        // Create a label to display the full image.
        imageDisplayLabel = new JLabel();
        imageDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
        imageDisplayLabel.setPreferredSize(new Dimension(550, 550));

        // Create a panel on which to display the full image
        memeViewPanel = new JPanel(new BorderLayout());
        memeViewPanel.setPreferredSize(new Dimension(550, 550));
        memeViewPanel.add(imageDisplayLabel, BorderLayout.CENTER);


        // Create a panel on which to display the controls for building a Meme
        controlPanel = new JPanel(new BorderLayout());
        
        // Create a panel that holds BackgroundImage information and give it a title
        JPanel backgroundImagePanel = new JPanel(new BorderLayout());
        backgroundImagePanel.setBorder(BorderFactory.createTitledBorder("Background Image"));

        // Create a panel that provides input for the BackgroundImage fileName
        JPanel backgroundImageFilePanel = new JPanel();
        
        // Label
        JLabel backgroundImageFileLabel = new JLabel("Filename: ");
        backgroundImageFileLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageFilePanel.add(backgroundImageFileLabel);
        
        // Button
        JButton backgroundImageButton = new JButton("Browse");
        backgroundImageFilePanel.add(backgroundImageButton);
        backgroundImageButton.setPreferredSize(new Dimension(85, 20));
        // TODO The button needs a listener
        backgroundImageButton.addActionListener(new OpenButtonListener());
        
        // Label that will contain the filename of the image
        backgroundImageFileNameLabel = new JLabel("<choose>");
        backgroundImageFilePanel.add(backgroundImageFileNameLabel);
        backgroundImageFileNameLabel.setPreferredSize(new Dimension(265, 20));
        
        // Add the panel about the BackgroundImage fileName to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageFilePanel, BorderLayout.NORTH);
        
        // TODO Complete the Control Panel implementation (with Background Image and Meme panels)
        
        // Create a panel that provides input for the BackgroundImage Title
        JPanel backgroundImageTitlePanel = new JPanel();
        
        // Title Label
        JLabel backgroundImageTitleLabel = new JLabel("Title: ");
        backgroundImageTitleLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageTitlePanel.add(backgroundImageTitleLabel);

        //JTextField for Title input
        backgroundImageTitleTextField = new JTextField();
        backgroundImageTitleTextField.setPreferredSize(new Dimension(350,20));
        backgroundImageTitlePanel.add(backgroundImageTitleTextField);
        
        // Add the panel about the BackgroundImage fileName to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageTitlePanel, BorderLayout.CENTER);
        
        
        
        // Create a panel that provides input for the BackgroundImage Description    
        JPanel backgroundImageDescriptionPanel = new JPanel();
        
        // Description Label
        JLabel backgroundImageDescriptionLabel = new JLabel("Description:");
        backgroundImageDescriptionLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageDescriptionPanel.add(backgroundImageDescriptionLabel);
        
        //JTextField for Description input
        backgroundImageDescriptionTextField = new JTextField();
        backgroundImageDescriptionTextField.setPreferredSize(new Dimension(350,20));
        backgroundImageDescriptionPanel.add(backgroundImageDescriptionTextField);
        
        // Add the panel about the BackgroundImage Description to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageDescriptionPanel,BorderLayout.SOUTH);
        
        
        // Create a panel that provides input for the Meme information
        JPanel MemePanel = new JPanel(new BorderLayout());
        MemePanel.setBorder(BorderFactory.createTitledBorder("Meme"));
        
        //Create a panel that provides input for the Meme Caption
        JPanel MemeCaptionPanel = new JPanel();
        
        //Caption Label
        JLabel MemeCaptionLabel = new JLabel("Caption");
        MemeCaptionLabel.setPreferredSize(new Dimension(100,20));
        MemeCaptionPanel.add(MemeCaptionLabel);
        
        //JTextField for Caption input
        MemeCaptionTextField = new JTextField();
        MemeCaptionTextField.setPreferredSize(new Dimension(350,20));
        MemeCaptionPanel.add(MemeCaptionTextField);
        
        MemePanel.add(MemeCaptionPanel,BorderLayout.NORTH);
        
        
        
        //Create a panel that provides input for the Meme Vertical Align
        JPanel MemeVerticalAlignPanel = new JPanel();
        
        //Vertical Align Label
        JLabel MemeVerticalAlignLabel = new JLabel("Vertical Align");
        MemeVerticalAlignLabel.setPreferredSize(new Dimension(100,20));
        MemeVerticalAlignPanel.add(MemeVerticalAlignLabel);
        
        //JComboBox for Vertical Align
        MemeVerticalAlignJComboBox = new JComboBox<String>();
        MemeVerticalAlignJComboBox.setPreferredSize(new Dimension(350,20));
        MemeVerticalAlignJComboBox.addItem("top");
        MemeVerticalAlignJComboBox.addItem("middle");
        MemeVerticalAlignJComboBox.addItem("bottom");
        
        MemeVerticalAlignPanel.add(MemeVerticalAlignJComboBox);
        
        MemePanel.add(MemeVerticalAlignPanel,BorderLayout.CENTER);
        
        
        //Create a panel for two Generate and Save JButton
        JPanel ButtonsPanel = new JPanel();
        
        
        //JButton for Generate 
        JButton GenerateButton = new JButton("Generate");
        GenerateButton.setPreferredSize(new Dimension(100,20));
        ButtonsPanel.add(GenerateButton);
        GenerateButton.addActionListener(new GenerateButtonListenr());
        
        //JButton for Save
        JButton SaveButton = new JButton("Save");
        SaveButton.setPreferredSize(new Dimension(100,20));
        ButtonsPanel.add(SaveButton);
        SaveButton.addActionListener(new SaveButtonListener());
        
        
        
        // Add the BackgroundImage information panel to the control panel
        controlPanel.add(backgroundImagePanel, BorderLayout.NORTH);
        // Add the Meme information panel to hte control panel
        controlPanel.add(MemePanel,BorderLayout.CENTER);
        // Add the Buttons panel to control panel
        controlPanel.add(ButtonsPanel,BorderLayout.SOUTH);
        // Add all the panels to the main display based on BorderLayout
        controlPanel.setPreferredSize(new Dimension(500,570));
        panelPane.add(controlPanel, BorderLayout.WEST);
        panelPane.add(memeViewPanel, BorderLayout.CENTER);
        

        // Add the panelPane to the contentPane of the Frame (Window)
        this.getContentPane().add(panelPane);

        // Set the preferred size and show the main application window
        this.setPreferredSize(new Dimension(1150, 570));
        this.pack();
        this.setVisible(true);
    }
    
    
    /**
     * ActionListener for the open button.  When the button is pressed, this ActionListener
     * opens a FileChooser, asks the user to choose a JPG image file, then
     * sets the field backgroundImageFilename in the main class.
     */
    private class OpenButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose a JPG image file, then
         * sets the field backgroundImageFilename in the main class.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Choose a Background Image");
            chooser2.setFileFilter(new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg"));
            int returnVal = chooser2.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                backgroundImageFilename = chooser2.getSelectedFile().getAbsolutePath();
                backgroundImageFileNameLabel.setText(backgroundImageFilename);
            }

        }
    }
    
    
    
    /**
     * ActionListener for the Generate button.  When the button is pressed, this ActionListener
     *  generate a Meme with its give BackgroundImage, title, Caption and Vertical Align
     */
    private class GenerateButtonListenr implements ActionListener{
        /**
         * Action performed operation.  generate a Meme with its give BackgroundImage, title, 
         * Caption and Vertical Align and display at the panel on the right 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            backgroundImageFilename = backgroundImageFileNameLabel.getText();
            String newTitle = backgroundImageTitleTextField.getText();
            String newDescription = backgroundImageDescriptionTextField.getText();
            BackgroundImage tempBI = new BackgroundImage(backgroundImageFilename,newTitle,newDescription);
            currentMeme= new GraphicalMeme(tempBI,MemeCaptionTextField.getText(),user);
            currentMeme.setCaptionVerticalAlign((String)(MemeVerticalAlignJComboBox.getSelectedItem()));
            ImageIcon icon = null;

            try {
                icon = new ImageIcon (currentMeme.compileMeme());
            } catch (IOException e) {
                
                System.err.println("No Image file is selected to generate the meme");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            imageDisplayLabel.setIcon(icon);
            memeViewPanel.repaint();
        }
    }
    
    
    
    
    
    
    
    /**
     * ActionListener for the save button.  When the button is pressed, this ActionListener
     * opens a save FileChooser, asks the user to choose a location and filename, then
     * writes the graphical meme data to a PNG image file.
     */
    private class SaveButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose
         * a location and filename, then writes the graphical meme data to a PNG file.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Save Meme");
            chooser2.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            int returnVal = chooser2.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                String destinationFile = chooser2.getSelectedFile().getAbsolutePath();
                if (!destinationFile.contains(".png"))
                    destinationFile += ".png";
                
                // TODO: Writing an image throws a checked exception that must be handled.
                //       Catch the exceptions and provide the user with an appropriate message
             try {
                ImageIO.write(currentMeme.compileMeme(), "png", new File(destinationFile));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.err.println("No Image file is selected to generate and save the meme");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
                
            }

        }
    }
}