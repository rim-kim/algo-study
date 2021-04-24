package chap04_Stack_queue;

public class Q2<E>{
    private int max;    //스택 용량
    private int ptr;    //스택 포인터
    private E[] stk;    //스택 본체

    public static class EmptyQ2Exception extends RuntimeException {
        public EmptyQ2Exception(){
        }
    }

    public static class OverflowQ2Exception extends RuntimeException {
        public OverflowQ2Exception(){
        }
    }

    public Q2(int capacity){
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object[max];    //제네릭 스택 클래스 공부 좀 더 할것
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E push(E x) throws OverflowQ2Exception {
        if(ptr >= max)
            throw new OverflowQ2Exception();
        return stk[ptr++] = x;
    }

    public E pop() throws EmptyQ2Exception {
        if(ptr <= 0)
            throw new EmptyQ2Exception();
        return stk[--ptr];
    }

    public E peek() throws EmptyQ2Exception {
        if (ptr <= 0)
            throw new EmptyQ2Exception();
        return stk[ptr-1];
    }

    public int indexOf(E x) {
        for(int i= ptr-1; i >= 0; i--)
            if(stk[i].equals(x))
                return i;
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int capacity(){
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty(){
        return ptr <= 0;
    }

    public boolean isFull(){
        return ptr >= max;
    }

    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
