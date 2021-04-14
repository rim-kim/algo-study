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
}
