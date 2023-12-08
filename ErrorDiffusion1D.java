import java.util.Scanner;

/**
 *
 * @author DarkShadowDemon200x
 */
public class ErrorDiffusion1D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] I = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                I[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int e = 0;
            for (int j = 0; j < n; j++) {
                int u = I[i][j] - e;
                if(u < 127){
                    e = 0 - u;
                    I[i][j] = 0;
                }else{
                    e = 255 - u;
                    I[i][j] = 255;
                }
                System.out.print(I[i][j] + " ");
            }
            System.out.println();
        }
    }
}
