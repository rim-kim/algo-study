package chap05_recursive;

public class RecurX1 {
    // 꼬리 재귀를 제거했습니다.
    static void recur(int n) {
        while (n > 0) {
            recur(n - 1);
            System.out.println(n);
            n = n - 2;
        }
    }
}
