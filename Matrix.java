//Version 0.2a
public class Matrix {
    private int rows;
    private int columns;
    private double arr[][];
    private int augmentCol;

    public Matrix(int matrixRows, int matrixColumns) {
        rows = matrixRows;
        columns = matrixColumns;
        arr = new double[rows][columns];
    }

    public Matrix(double[][] newArr) {
        rows = newArr.length;
        columns = newArr[0].length;
        arr = newArr;
    }

    public void setVals(double[][] values) {
        arr = values;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double getVal(int row, int column) {
        return arr[row][column];
    }

    String str = "";
    public String toString() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str = str + arr[i][j];
                if (j == augmentCol - 1) {
                    str = str + " | ";
                }
                else if (j != columns - 1) {
                    str = str + ",  ";
                }
            }
            
            str = str + "\n";
        }

        return str;
    }

    public double[][] toArr() {
        return arr;
    }

    public Matrix augment(Matrix mat2) {
        int newCols = columns + mat2.getColumns();
        double[][] newArr = new double[rows][newCols];

        if (rows != mat2.getRows()) {
            try {    
                throw new MatrixDimensionException("Number of rows do not match.");
            }
            catch (MatrixDimensionException exception) {
                exception.printStackTrace();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newArr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < mat2.getColumns(); j++) {
                newArr[i][columns + j] = mat2.getVal(i,j);
            }
        }

        Matrix newMat = new Matrix(newArr);
        newMat.setAugCol(columns);
        return newMat;
    }

    public boolean isAugmented() {
        if (augmentCol != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setAugCol(int augCol) {
        augmentCol = augCol;
    }

    public void rowOpI(int row1, int row2) {
        double temp[] = new double[columns];
        for (int i = 0; i < columns; i++) {
            temp[i] = arr[row1][i];
        }
        for (int i = 0; i < columns; i++) {
            arr[row1][i] = arr[row2][i];
        }
        for (int i = 0; i < columns; i++) {
            arr[row2][i] = temp[i];
        }
    }
    public void rowOpII(int row, double multiplier) {
        for (int i = 0; i < columns; i++) {
            arr[row][i] = multiplier * arr[row][i];
        }
    }

    public void rowOpIII(int modRow, int refRow, double multiplier) {

        for (int i = 0; i <= columns - 1; i++) {
            arr[modRow][i] += (multiplier * arr[refRow][i]);
        }
    }

    public boolean isSquare() {
        if (rows == columns) {
            return true;
        }
        else {
            return false;
        }
    }

    public double trace() {
        double sum = 0;
        if (rows == columns) {
            for (int i = 0; i < rows; i++) {
                sum += arr[i][i];
            }
            return sum;
        }
        else {
            try {    
                throw new MatrixDimensionException("Trace can only be computed from a square matrix.");
            }
            catch (MatrixDimensionException exception) {
                exception.printStackTrace();
            }
            return 0;
        }
    }

    public Matrix multiply(Matrix m2) {
        //NGL, I could rewrite this back in Matrix.java lmao
        
        int rows1 = rows;
        int rows2 = m2.getRows();
        int cols1 = columns;
        int cols2 = m2.getColumns();
        if (cols1 != rows2) {
            Matrix returnMatrix = new Matrix(1,1);
            try {    
                throw new MatrixDimensionException("Number of rows in the second matrix do not match number of columns in the first matrix.");
            }
            catch (MatrixDimensionException exception) {
                exception.printStackTrace();
            }
            return returnMatrix;
            //EXCEPTION!!
        }
        double[][] returnArr = new double[rows1][cols2];
        double tempVar = 0;
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                tempVar = 0;
                for (int k = 0; k < cols1; k++) {
                    returnArr[i][j] += getVal(i,k) * m2.getVal(k,j);
                }
            }
        }
        Matrix returnMatrix = new Matrix(returnArr);
        return returnMatrix;
    }
    

}
