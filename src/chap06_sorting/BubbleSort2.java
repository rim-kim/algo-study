package chap06_sorting;
import java.util.Scanner;
// 버블 정렬(버전2) - 멈춤

public class BubbleSort2 {
    // a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬 (버전2)
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;  // 패스의 교환 횟수를 기록합니다.
            for (int j = n - 1; j > i; j--)
                if(a[j - 1] > a[j]) {
                swap(a, j - 1, j);
                exchg++;        // 17-20 패스
            }
            if(exchg == 0) break;       // 교환이 이루어지지 않으면 종료합니다.
        }
    }
}
