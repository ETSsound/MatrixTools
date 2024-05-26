public class MatrixSolve {
    public static Matrix mult(Matrix m1, Matrix m2) {
        //NGL, I could rewrite this back in Matrix.java lmao
        
        int rows1 = m1.getRows();
        int rows2 = m2.getRows();
        int cols1 = m1.getColumns();
        int cols2 = m2.getColumns();
        int resCols = cols2;
        int resRows = rows1;
        if (cols1 != rows2) {
            Matrix returnMatrix = new Matrix(1,1);
            return returnMatrix;
            //EXCEPTION!!
        }
        double[][] returnArr = new double[resRows][resCols];
        double tempVar = 0;
        for (int i = 0; i < resRows; i++) {
            for (int j = 0; j < resCols; j++) {
                for (int k = 0; k < resRows; k++) {
                    tempVar += m1.getVal(i,k) * m2.getVal(k,j);
                    
                }
                returnArr[i][j] = tempVar;
                tempVar = 0;
            }
        }
        Matrix returnMatrix = new Matrix(resRows,resCols);
        returnMatrix.setVals(returnArr);
        return returnMatrix;
    }

}