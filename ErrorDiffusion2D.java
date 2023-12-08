import java.util.Scanner;

/**
 *
 * @author DarkShadowDemon200x
 */
public class ErrorDiffusion2D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float[][] a = new float[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextFloat();
            }
        }

        float e = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] < 127) {
                    e = a[i][j];
                    System.out.print("0 ");
                } else {
                    e = a[i][j] - 255;
                    System.out.print("255 ");
                }
                //kiem tra bien va thay doi gia tri
                if(j+1 < n)a[i][j + 1] = (float) (a[i][j + 1] + e * (7.0 / 16));
                if(i+1<n && j-1>=0) a[i + 1][j - 1] = (float) (a[i + 1][j - 1] + e * (3.0 / 16));
                if(i+1<n)a[i + 1][j] = (float) (a[i + 1][j] + e * (5.0 / 16));
                if(i+1<n&&j+1<n)a[i + 1][j + 1] = (float) (a[i + 1][j + 1] + e * (1.0 / 16));
            }
            System.out.println();
        }

    }
}