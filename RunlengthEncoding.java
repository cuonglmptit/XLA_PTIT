import java.util.Scanner;

/**
 *
 * @author CuongAcQuy
 */
public class RunlengthEncoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().trim();
        int indx = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(i-1)){
                System.out.print(String.valueOf(s.charAt(i-1))+(i-indx));
                indx = i;
            }
        }
        System.out.print(String.valueOf(s.charAt(s.length()-1))+(s.length()-indx));
    }
}
