package chap03;
import java.util.Scanner; //선형검색

public class SeqSearch {
    //요솟수가 n인 배열 a에서 key와 같은 요소를 선형검색.
    static int seqSearch(int [] a, int n, int key) {
        int i = 0;

        while(true) {   // 계속 반복하기 위해 의도적으로 true 값을 넣음. (무한루프)
            if(i == n)
                return -1; //검색 실패! (1을 반환)
            if(a[i] == key)
                return i; //검색 성공! (인덱스를 반환)
            i++;
        }
    } //조건 판단 횟수는 3회.

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        for (int i=0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: "); //키 값 입력
        int ky = stdIn.nextInt();

        int idx = seqSearch(x, num, ky); //배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky +"은(는) x[" + idx + "]에 있습니다.");
    }
}
/**
 *  methode SeqSearch: 배열 a의 처음부터 끝까지 n개의 요소를 대상으로 값이 key인 요소를 선형검색하고 검색한 요소의 인덱스 반환
 *  값이 key값인 요소가 여러개 존재할 경우 가장 먼저 찾은 인덱스값을 반환.
 */
