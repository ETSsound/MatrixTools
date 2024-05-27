import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class DimensionEntryGUI extends JFrame {
    protected int rows1;
    protected int cols1;
    protected int rows2;
    protected int cols2;

    public DimensionEntryGUI() {
        JPanel mainPanel = new JPanel(new GridLayout(4, 3, 0, 10));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JLabel label = new JLabel("Enter Matrix Dimensions");
        JTextField input1 = new JTextField("Matrix 1 Rows",5);
        JTextField input2 = new JTextField("Matrix 1 Columns",5);
        JTextField input3 = new JTextField("Matrix 2 Rows",5);
        JTextField input4 = new JTextField("Matrix 2 Columns",5);
        JButton button = new JButton("Confirm");
        mainPanel.add(label);
        JLabel output = new JLabel("");
        mainPanel.add(output);
        mainPanel.add(new JLabel(""));
        mainPanel.add(input1);
        mainPanel.add(new JLabel("          x"));
        mainPanel.add(input2);
        mainPanel.add(input3);
        mainPanel.add(new JLabel("          x"));
        mainPanel.add(input4);
        mainPanel.add(button);

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("Matrix Multiplier"); // "super" JFrame sets title
        setSize(400, 200);         // "super" JFrame sets initial size
        setVisible(true);          // "super" JFrame shows

        String empty = "";
        input1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                input1.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (empty.equals(input1.getText())) {
                    input1.setText("Matrix 1 Rows");
                }
            }
        });
        input2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                input2.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (empty.equals(input2.getText())) {
                    input2.setText("Matrix 1 Columns");
                }
            }
        });
        input3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                input3.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (empty.equals(input3.getText())) {
                    input3.setText("Matrix 2 Rows");
                }
            }
        });
        input4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                input4.setText("");
            }
            public void focusLost(FocusEvent e) {
                if (empty.equals(input4.getText())) {
                    input4.setText("Matrix 2 Columns");
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Get the String entered into the input TextField, convert to int
                try {
                    rows1 = Integer.parseInt(input1.getText());
                    input1.setText("");  // clear input TextField
                    cols1 = Integer.parseInt(input2.getText());
                    input2.setText("");  // clear input TextField
                    rows2 = Integer.parseInt(input3.getText());
                    input3.setText("");  // clear input TextField
                    cols2 = Integer.parseInt(input4.getText());
                    input4.setText("");  // clear input TextField
                    if (cols1 == rows2) {
                        new MatrixMultiplierGUI(rows1, rows2, cols1, cols2); //Advance to the next screen
                        setVisible(false);
                        dispose(); //Get rid of the old window
                    }
                    else {
                        new DimensionWarning("Incompatible matrix dimensions.");
                        setVisible(false);
                        dispose();
                    }
                } 
                catch (NumberFormatException e) {
                    output.setText("Please enter your value in the proper format.");
                    e.printStackTrace();
                }    
            }
        });
    }
}
