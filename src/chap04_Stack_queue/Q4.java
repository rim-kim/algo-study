package chap04_Stack_queue;

public class Q4 {
    private int max;    //큐 용량
    private int num;    //현재 데이터 수
    private int[] que;  //큐 본체


    public class EmptyQ4Exception extends RuntimeException {
        public EmptyQ4Exception() { }
    }

    public class OverflowQ4Exception extends RuntimeException {
        public OverflowQ4Exception() { }
    }

    public Q4(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueue(int n) {
        if (num > max)
            throw new OverflowQ4Exception();
        que[num++] = n;
        return n;
    }

    public int dequeue() {
        if(num <= 0)
            throw new OverflowQ4Exception();
        int n = que[0];
        for(int i=0; i < num-1; i++) {
            que[i] = que[i + 1];
        }
        num --;
        return n;
        }

    public int peek() throws EmptyQ4Exception {
        if(num <= 0)
            throw new EmptyQ4Exception();
        return que[num-1];
    }

    public void clear() {
        num = 0;
    }

    public int capacity(){
        return max;
    }

    public int size() {
        return num;
    }

    public int indexOf(int n) {
        for(int i=0; i<num; i++)
            if(que[i] == n)
                return i;
        return -1;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

}
