import java.util.Scanner;

public class MatrixTester{
    
    public static void main(String arg[]){
        double[][] beans = new double[2][3];
        beans[0][0] = 9;
        beans[0][1] = -2;
        beans[0][2] = 5;
        beans[1][0] = 3;
        beans[1][1] = 7;
        beans[1][2] = 17;

        Matrix mat = new Matrix(beans);
        System.out.println(mat.toString());
        double[][] aug = new double[2][1];
        aug[0][0] =  4;
        aug[1][0] =  5;

        Matrix abba = new Matrix(2,1);
        abba.setVals(aug);

        Matrix augmie = mat.augment(abba);
        //mat = MatrixSolve.ref(mat);
        System.out.println(augmie.toString());

        double[][] ident = {{1,0},{0,2}};
        Matrix I = new Matrix(ident);

        Matrix result = MatrixSolve.mult(I,augmie);
        System.out.println(result.toString());

        System.out.println(augmie.trace());

    }
}