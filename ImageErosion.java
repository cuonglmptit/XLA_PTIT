import java.util.Scanner;

/**
 *
 * @author CuongAcQuy
 */
public class ImageErosion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int[][] filter = new int[f][f];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < f; j++) {
                filter[i][j] = sc.nextInt();
            }
        }
        int n = sc.nextInt();
        
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                b[i][j] = a[i][j];
            }
        }
//        System.out.println(f / 2);
        int fs = f / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isFit = true;
//                System.out.printf("current a[%d][%d]: %d\n", i, j, a[i][j]);
                for (int k = -fs; k <= fs; k++) {

                    for (int l = -fs; l <= fs; l++) {
                        if (i + k >= 0 && i + k < n && j + l >= 0 && j + l < n) {
//                            System.out.print("a: "+a[i + k][j + l] + " "+"f: "+filter[k+fs][l+fs]+" | ");
                            if(filter[k+fs][l+fs] != 0 && a[i + k][j + l] != filter[k+fs][l+fs]){
                                b[i][j] = 0;
                                isFit = false;
                            }
                        }else{
                            b[i][j] = 0;
                            isFit = false;
                        }
                        if(!isFit) break;
                    }
                    if(!isFit) break;
//                    System.out.println("");
                }
                System.out.print(b[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
