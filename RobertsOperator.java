/**
 *
 * @author CuongAcQuy
 */
import java.util.Scanner;

public class RobertsOperator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhận kích thước ảnh (ảnh vuông)
        int n = sc.nextInt();
        // Khởi tạo ma trận cấp xám của ảnh
        int[][] a = new int[n][n];
        // Nhận giá trị của ma trận cấp xám
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // Khởi tạo ma trận Gx và Gy cho Roberts Operator
        int[][] Gx = {{-1, 0}, {0, 1}};
        int[][] Gy = {{0, -1}, {1, 0}};

        // Khởi tạo ma trận gradient
        int[][] gradient = new int[n][n];

        // Tính gradient theo công thức G = sqrt(Gx^2 + Gy^2)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int GxValue = 0;
                int GyValue = 0;
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        GxValue += Gx[k][l] * a[i + k][j + l];
                        GyValue += Gy[k][l] * a[i + k][j + l];
                    }
                }
                gradient[i + 1][j + 1] = (int) Math.sqrt(GxValue * GxValue + GyValue * GyValue);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == n-1 || j == n-1){
                    gradient[i][j] = 0;
                }
            }
        }
        // In ảnh gradient
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(gradient[i][j] + " ");
            }
            System.out.println();
        }
    }
}