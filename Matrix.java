public class Matrix {
    int rows;
    int columns;
    double arr[][];
    int augmentCol;

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
            return null;
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
            return 0.0/0.0; //Eventually, figure out how to throw an exception.
        }
    }
    

}
