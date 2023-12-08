
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DarkShadowDemon200x
 */
public class HistogramEqualizing34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), l = sc.nextInt();
        int[][] a = new int[m][n];
        float[] transf = new float[l];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                transf[a[i][j]]++;
            }
        }

        for (int i = 0; i < transf.length; i++) {
            if (i == 0) {
                transf[i] = ((float) (transf[i]) / (m * n)) * (l - 1);
            } else {
                transf[i] = ((float) (transf[i]) / (m * n)) * (l - 1) + transf[i-1];
            }
        }
        
        for (int i = 0; i < transf.length; i++) {
            transf[i] = (float) Math.round(transf[i]);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) transf[a[i][j]];
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
