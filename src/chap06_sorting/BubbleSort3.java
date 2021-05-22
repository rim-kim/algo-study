package chap06_sorting;
import java.util.Scanner;
// 버블 정렬(버전3)

public class BubbleSort3 {
    // a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬 (버전3)
    static void bubbleSort(int[] a, int n) {
        int k = 0;      // a[k]보다 앞쪽은 정렬을 마친 상태
        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > k; j--)
                if(a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }       // 18-22 패스
            k = last;
        }
    }


}
