import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ResultScreen extends JFrame {


    public ResultScreen(Matrix result) {
        double[][] arr = result.toArr();
        int rows = result.getRows();
        int cols = result.getColumns();
        JPanel mainPanel = new JPanel(new GridLayout(0, cols, 2, 2));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mainPanel.add(new JLabel("" + arr[i][j]));
            }
        }
        for (int i = 1; i < cols; i++) {
            mainPanel.add(new JLabel(""));
        }

        JButton button = new JButton("OK");

        mainPanel.add(button);

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("Matrix Multiplier -- RESULT"); // "super" JFrame sets title
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


