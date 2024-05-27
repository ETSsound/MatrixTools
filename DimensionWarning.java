import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class DimensionWarning extends JFrame {


    public DimensionWarning(String message) {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JLabel label = new JLabel("Error: " + message);
        JButton button = new JButton("OK");
        mainPanel.add(label);
        mainPanel.add(button);

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("Matrix Multiplier -- ERROR"); // "super" JFrame sets title
        setSize(400, 400);         // "super" JFrame sets initial size
        setVisible(true);          // "super" JFrame shows

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Get the String entered into the input TextField, convert to int
                    new DimensionEntryGUI();
                    setVisible(false); //you can't see me!
                    dispose(); //Destroy the JFrame object  
            }
        });
    }
}

