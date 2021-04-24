public class IntAryQueue{
    private int max;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyStackException() { }
    }

    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntStackException() {  }
    }

    public IntAryQueue(int capacity){
        num = 0;
        max = capacity;
        try{
            que = new int[max];  // create queue
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public int enQueue(int x) throws OverflowIntQueueException{
        if(num == max) throw new OverflowIntQueueException();
        return que[num++] = x;
    }

    public int deQueue(){
        if(num = 0) throw new EmptyIntQueueException();
        int result = que[0];
        int[] tmp = new int[max];
        for(int i = 0; i < max; i++){
            tmp[i] = que[i+1];
        }
        que = tmp;
        return result;
    }


}