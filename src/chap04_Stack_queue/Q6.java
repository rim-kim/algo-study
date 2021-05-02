package chap04_Stack_queue;

public class Q6<E> {
    private int max;    //큐의 용량
    private int num;    //현재 데이터 수
    private int front;  //프런트 요소 커서
    private int rear;   //리어 요소 커서
    private E [] que;   //큐의 본체


    //큐가 비어있을때 예외
    public static class EmptyQ6Exception extends RuntimeException {
        public EmptyQ6Exception() { }
    }

    //큐가 가득 찼을때 예외
    public static class OverflowQ6Exception extends RuntimeException {
        public OverflowQ6Exception() { }
    }

    public Q6(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    //인큐
    public E enque(E x) throws OverflowQ6Exception {
        if (num >= max)
            throw new OverflowQ6Exception();
        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    //디큐
    public E deque() throws EmptyQ6Exception {
        if(num <= 0)
            throw new EmptyQ6Exception();
        E x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    public int indexOf(E x) {
        for(int i=0; i < num; i++)
            if(que[(i+front) % max] == x)
                return i + front;
            return -1;
    }

    public E peek() throws EmptyQ6Exception {
        if (num <= 0)
            throw new EmptyQ6Exception();
        return que[front];
    }

    public int search(E x) {
        for (int i=0; i < num; i++)
            if(que[(i+front)%max].equals(x))
                return i+1;
        return -1;
    }

    public void clear( ) {
        front = rear = num = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if(num <= 0)
            System.out.println("비어있습니다.");
    } else {
        for(int i=0; i < num; i++)
            System.out.println(que[(i+front) %max].toString() + " ");
        System.out.println();
    }
}
