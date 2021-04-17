import java.util.Arrays;

public class binSearchAPI {

    public static int binSearchApi(int[] a, int key){ // 연습문제 6
        int idx = Arrays.binarySearch(a, key);
        if(idx >= 0) return idx;
        else return Math.abs(idx) -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 15, 28, 29, 31, 39, 58, 68, 70};
        int key = 30;
        int idx = binSearchApi(a, key);
        System.out.println(idx);
    }
}
