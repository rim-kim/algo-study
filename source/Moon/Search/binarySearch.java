public class binarySearch {

    public int binarySearch(int[] a, int n, int key){
        int pl = 0;
        int pr = n-1;

        while(pl <= pr){
            int pc = (pl + pr) / 2;
            if (a[pc] < key) {
                pl = pc + 1;
                pc = (n - 1 + pc) / 2;
            } else if (a[pc] > key) {
                pr = pc;
                pc = pr / 2;
            } else {
                return pc;
            }
        }return -1;
    }
    public static int binSearch(int[] a, int n, int key){ // 연습문제 5
        int pl = 0;
        int pr = n-1;
        int pc = 0;

        while(pl <= pr) {
            pc = (pl + pr) / 2;
            if (a[pc] < key) {
                pl = pc + 1;
                pc = (n - 1 + pc) / 2;
            } else if (a[pc] > key) {
                pr = pc;
                pc = pr / 2;
            } else break;
        }
        if(pc == 0) {
            System.out.println(pc);
            return pc;
        }else{
            int first = pc;
            for(int i = pc; i >= 0; i--){
                if(a[i] == key) first = i;
            }
            System.out.println(first);
            return first;
        }

    }

    public static void main(String[] args) {
        int[] a = {2,3,4,5,6,3,5,3};
        int n = a.length;
        int key = 4;
        binSearch(a, n, key);
    }
}
