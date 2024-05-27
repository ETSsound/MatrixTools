import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.*;

import java.util.ArrayList;

public class MatrixMultiplierGUI extends JFrame {
    protected double[][] mat1;
    protected double[][] mat2;

    public MatrixMultiplierGUI(int rows1, int rows2, int cols1, int cols2) {
        //construct
        mat1 = new double[rows1][cols1];
        mat2 = new double[rows2][cols2];
        JPanel mainPanel;
        int maxRows = 1;
        System.out.println("r1:" + rows1 + "r2:" +rows2 + "c1:" +cols1 + "c2:" +cols2);
        if (rows1 >= rows2) {
            mainPanel = new JPanel(new GridLayout(0, cols1 + cols2 + 1));
            maxRows = rows1;
        }
        else if (rows1 < rows2) {
            mainPanel = new JPanel(new GridLayout(0, cols1 + cols2 + 1));
            maxRows = rows2;
        }
        else {
            System.out.println("Something went wrong.");
            mainPanel = new JPanel(new GridLayout(1, 1, 4, 4));
        }

        TwoDArrayList<JTextField> mat1inputs = new TwoDArrayList<JTextField>();
        TwoDArrayList<JTextField> mat2inputs = new TwoDArrayList<JTextField>();
        JLabel label = new JLabel("Enter Matrix:");
        mainPanel.add(label);
        for (int i = 1; i < cols1 + cols2 + 1; i++) {
            JLabel space = new JLabel("");
            mainPanel.add(space);
        }

        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < cols1; j++) {
                if (i < rows1 && j < cols1) {
                    mat1inputs.addToInnerArray(i,j,new JTextField());
                    mainPanel.add(mat1inputs.get(i,j));
                    System.out.print("i ");
                }
                else if (i >= rows1) {
                    mainPanel.add(new JLabel(""));
                    System.out.print("s ");
                }
            }   
            if (i == maxRows / 2) {
                mainPanel.add(new JLabel("x"));
            }
            else {
                mainPanel.add(new JLabel("")); 
            }
            System.out.print("x ");
            for (int j = 0; j < cols2; j++) {
                if (i < rows2 && j < cols2) {
                    mat2inputs.addToInnerArray(i,j,new JTextField());
                    mainPanel.add(mat2inputs.get(i,j));
                    System.out.print("j ");
                }
                else if (i >= rows2) {
                    mainPanel.add(new JLabel(""));
                    System.out.print("s ");
                }
            }
            System.out.println("");
        }
        JButton button = new JButton("Calc");
        mainPanel.add(button);
        for (int i = 1; i < cols1 + cols2 + 1; i++) {
            JLabel space = new JLabel("");
            mainPanel.add(space);
        }

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("Matrix Multiplier"); // "super" JFrame sets title
        setSize(400, 400);         // "super" JFrame sets initial size
        setVisible(true);          // "super" JFrame shows

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Get the String entered into the input TextField, convert to int
                try {
                    double[][] arr1 = new double[rows1][cols1];
                    double[][] arr2 = new double[rows2][cols2];
                    for (int i = 0; i < rows1; i++) {
                        for (int j = 0; j < cols1; j++) {
                            JTextField tempField = mat1inputs.get(i,j);
                            arr1[i][j] = Double.parseDouble(tempField.getText());
                        }
                    }
                    Matrix mat1 = new Matrix(arr1);
                    for (int i = 0; i < rows2; i++) {
                        for (int j = 0; j < cols2; j++) {
                            JTextField tempField = mat2inputs.get(i,j);
                            arr2[i][j] = Double.parseDouble(tempField.getText());
                        }
                    }
                    Matrix mat2 = new Matrix(arr2);
                    Matrix result = mat1.multiply(mat2);
                    System.out.println(result.toString());
                    new ResultScreen(result);
                    setVisible(false); //you can't see me!
                    dispose(); //Destroy the JFrame object  
                } 
                catch (NumberFormatException e) {
                    new DimensionWarning("Please enter all values as double precision floats.");
                    e.printStackTrace();
                    setVisible(false); //you can't see me!
                    dispose(); //Destroy the JFrame object  
                }    
            } 
        }); 
    }
    public static void main(String args[]) {
        System.out.println("BRUH");
        new DimensionEntryGUI();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               //new MatrixMultiplierGUI(); // Let the constructor do the job
            }
         });
    }
}
