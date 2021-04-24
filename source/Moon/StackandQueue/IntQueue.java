public class IntQueue{  // ring queue
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyStackException() { }
    }

    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntStackException() {  }
    }

    public IntQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException{
        if(num >= max) throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if(rear == max) rear = 0;  // from end point to start point
        return x;
    }

    public int deque() throw EmptyIntQueueException{
        if(num <= 0) throw new EmptyIntQueueException();
        int result = que[front--];
        num--;
        if(front == max) front = 0;
        return result;
    }

    public int peak() throws EmptyIntQueueException{
        if(num <= 0) throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(int x){
        for(int i = 0; i < num; i++){
            int idx = (i + front) % max;  // **
            if(que[idx] == x) return idx
        }return -1;
    }

    public void clear(){
        front = rear = num = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return num;
    }

    public boolean isEmpty(){
        if(num == 0) return true;
        return false;
    }

    public boolean isFull(){
        if(num >= max) return true;
        return false;
    }

    public void dump(){
        if(num <= 0){
            System.out.println("Queue is empty");
        }
        else{
            for(int i = 0; i < num; i++){
                System.out.println(que[(i+front)%max]);
            }
        }
    }

    public int search(int x) {  // 연습문제 5
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;  // **
            if (que[idx] == x) return i;
        }
        return -1;
    }



}