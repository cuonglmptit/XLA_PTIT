import java.util.Scanner;

/**
 *
 * @author DarkShadowDemon200x
 */
public class LaplaceOperator {
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
        // Khởi tạo ma trận Laplace
        int[][] G = {{0, -1, 0}, {-1, 4, -1}, {0, -1, 0}};

        // Khởi tạo ma trận gradient
        int[][] gradient = new int[n][n];

        // Tính gradient
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int GValue = 0;
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        GValue += G[k + 1][l + 1] * a[i + k][j + l];
                    }
                }
                gradient[i][j] = (int) Math.abs(GValue);
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
