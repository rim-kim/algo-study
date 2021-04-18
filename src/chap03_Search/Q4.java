package chap03_Search;
import java.util.Scanner;

public class Q4 {
    static int binSearchEx(int[] a, int n, int key) {
            //표 구현 연습,공부 필요
            int pl = 0; //처음
            int pr = n - 1;     //끝

            do {
                int pc = (pl + pr) / 2;
                if (a[pc] == key)
                    return pc;
                else if (a[pc] < key)
                    pl = pc + 1;
                else
                    pr = pc - 1;
            } while (pl <= pr);


            return -1; // 검색실패
        }



    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수：");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");
        System.out.print("x[0]：");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]：");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("찾을 값을 입력하세요：");
        int ky = stdIn.nextInt();
        int idx = binSearchEx(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은 x[" + idx + "]에 있습니다.");
    }
}
