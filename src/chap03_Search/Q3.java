package chap03_Search;
import java.util.Scanner;

public class Q3 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int t = 0;
        for(int i=0; i<n; i++) {
            if (a[i] == key) {
                idx[t++] = i; }
            }
        return t;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수：");
        int num = stdIn.nextInt();
        int[] x = new int[num];
        int[] y = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        System.out.print("찾을 값을 입력하세요：");
        int ky = stdIn.nextInt();
        int t = searchIdx(x, num, ky, y);

        if (t == 0)
            System.out.println("그 값이 없습니다.");
        else
            for (int i = 0; i < t; i++)
                System.out.println("x[" + y[i] + "]에 값이 있습니다.");
    }
}

