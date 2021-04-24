public class IntDeque { // 연습문제 7
    private int max;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyStackException() { }
    }

    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntStackException() {  }
    }

    public IntDeque(int capacity){
        front = rear = num = 0;
        max = capacity;
        try{
            que = new int[max]
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int enqueFront(int x) throws OverflowIntQueueException{
        if(num >= max) throw new OverflowIntQueueException();
        int[] tmp = new int[max];
        tmp[0] = x;
        for(int i = 0; i < num; i++){
            tmp[i+1] = que[i];
        }
        que = tmp;
        num++;
        return x;
    }

    public int dequeFront() throws EmptyIntQueueException{
        if(num <= 0) throw new EmptyIntQueueException()
        int[] tmp = new int[max];
        int x = que[0];
        for(int i = 0; i < num; i++){
            tmp[i] = que[i+1];
        }
        que = tmp;
        num--;
        return x;
    }

    public int enqueRear(int x) throws OverflowIntQueueException{
        if(num >= max) throw new OverflowIntQueueException();
        return que[num++] = x;
    }

    public int dequeRear() throws EmptyIntQueueException{
        if(num <= 0) throw new EmptyIntQueueException();
        return que[num--];
    }
}