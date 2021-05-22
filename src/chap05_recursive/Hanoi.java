package chap05_recursive;
import java.util.Scanner;
//하노이의 탑

public class Hanoi {
    // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김.
    static void move(int no, int x, int y) {
        if(no > 1)
            move(no - 1, x , 6 - x - y);        // 기둥 번호의 합이 6이므로 시작기둥, 목표기둥이 어느기둥이더라도 중간 기둥은 6-x-y로 구할 수 있음.

        System.out.println("원반[" + no + "]을 " + x + "기둥에서" + y + "기둥으로 옮김");

        if(no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수:");
        int n = stdIn.nextInt();

        move(n, 1, 3);  //1번 기둥의 n개의 원반을 3번 기둥으로 옮김.
    }
}