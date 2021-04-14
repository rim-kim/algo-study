public class LinearSearch {

    public int SeqSearch(int[] a, int n, int key){

        for(int i = 0; i < n; i++){
            if(a[i] == key) return i; // return index
        }return -1; // not found

    }

    public int sentinelSeqSearch(int[] a, int n, int key){ // time saving
        a[n] = key;
        int i = 0;
        while(true){
            if(a[i] == key) break;
            i++;
        }
        return i == n ? -1 : i;
    }
}
