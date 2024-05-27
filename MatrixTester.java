
public class MatrixTester{
    
    public static void main(String arg[]){
        //GUI config

        double[][] beans = new double[2][2];
        beans[0][0] = 9;
        beans[0][1] = -2;
        beans[1][0] = 3;
        beans[1][1] = 7;

        Matrix mat = new Matrix(beans);
        System.out.println(mat.toString());
        double[][] aug = new double[3][1];
        aug[0][0] =  4;
        aug[1][0] =  5;
        aug[2][0] = 1;
        Matrix a = new Matrix(aug);

        
        System.out.println(mat.toString());
        /*Matrix result = mat.multiply(a);
        System.out.println(result.toString());

        System.out.println(result.trace()); */

        Matrix augmented = mat.augment(a);
        System.out.println(augmented.toString());

    }
}