import java.util.Scanner;
public class HistogramSmoothing{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        for (int i = 0; i< n ; i++ ){
            l[i] = sc.nextInt();
        }
        int[] a = new int[n];
        for (int i = 0; i<n; i++ ){
            a[i] = sc.nextInt();
        } 
        
        int[] w3 = new int[n];
        int[] w5 = new int[n];
        
        for(int i = 0; i<n; i++){
            double sum3 = 0.0;
            int cnt3 = 0;
            for(int j = -1; j<=1;j++){
                if(i+j >= 0 && i+j < n){
                    sum3 += a[i+j];
                    cnt3 ++;
                }
            }
            if(sum3/cnt3 == 22.5) sum3 -= 0.0001;
            w3[i] = (int)Math.round(sum3/cnt3);
            
            double sum5 = 0.0;
            int cnt5 = 0;
            for(int j = -2; j<=2;j++){
                if(i+j >= 0 && i+j < n){
                    sum5 += a[i+j];
                    cnt5 ++;
                }
            }
            if(cnt5<5) sum5 -= 0.001;
            w5[i] = (int)Math.round(sum5/cnt5);
        }
        
        System.out.println("Smoothed histogram w=3");
        for(int i = 0; i<n;i++){
            System.out.print(l[i]+" ");
        }
        System.out.println("");
        for(int i = 0; i<n;i++){
            System.out.print(w3[i]+" ");
        }
        
        System.out.println("");
        System.out.println("Smoothed histogram w=5");
        for(int i = 0; i<n;i++){
            System.out.print(l[i]+" ");
        }
        System.out.println("");
        for(int i = 0; i<n;i++){
            System.out.print(w5[i]+" ");
        }
    }
}