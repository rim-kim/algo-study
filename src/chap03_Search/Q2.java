package chap03_Search;
import java.util.Scanner;

public class Q2 {
    static int seqSearch(int[] a, int n, int key) {
        //모르겠음



        return -1; //검색 실패
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for(int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        System.out.print("키 값을 입력하세요: ");
        int ky = stdIn.nextInt();
        int idx = seqSearch(x, num, ky); //배열 x에서 값이 ky인 요소

        if(idx == -1 )
            System.out.println("그 값의 요소는 없습니다.");
        else
            System.out.println("x[" + idx + "]에 " + ky + "이 있습니다.");
    }
}
