import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static int SeqSearch(int[] a, int n, int key){ // 연습문제 Q1 & 2
        for(int i = 0; i < n; i++){
                System.out.print(i);
            }
            System.out.println("");
        System.out.println("-------------");

        for(int i = 0; i < n; i++){
            for(int p = 0; p < n; p++) {
                System.out.print(a[p]);
            }
            System.out.println("");

            String[] b = new String[n];
            for(int j = 0; j < n; j++){
                b[j] = " ";
            }
            b[i] = "*";

            for(int k = 0; k < n; k++) {
                System.out.print(b[k]);
            }
            System.out.println("");

            if(a[i] == key){
                System.out.println("-------------");
                System.out.println(key + "는 " + "x[" + i + "]에 있습니다.");
                return i; // return index
            }
        }System.out.println("키 값이 리스트 안에 존재하지 않습니다.");
        return -1; // not found

    }

    public static int sentinelSeqSearch(int[] a, int n, int key){ // time saving
        a[n] = key;
        int i = 0;
        while(true){
            if(a[i] == key) break;
            i++;
        }
        return i == n ? -1 : i;
    }

    public static int searchIdx(int[] a, int n, int key){ // 연습과제 3 idx 배열을 인자로 주는게 이해가 안되서 그냥 뺴고 만들었어요
        int count = 0;
        int[] tmp = new int[n];
        for (int i = 0; i < n ; i++){
            tmp[i] = 0;
            if(a[i] == key){
                count += 1;
                tmp[i] = i;
            }
        } int[] idx = new int[count];
        for(int j = 0; j < n; j++){
            if(tmp[j] != 0){
                int num = 0;
                idx[num] = tmp[j];
                num++;
            }
        }
        System.out.println(idx.length);
        return idx.length;
    }

    public static void main(String[] args) {
        int[] test = {7, 4, 2, 4, 5, 4, 1};
        int n = test.length;
        int key = 4;
        //SeqSearch(test, n, key);
        searchIdx(test, n, key);
    }
}
