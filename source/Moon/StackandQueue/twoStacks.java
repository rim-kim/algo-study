public class twoStacks{  // 연습과제 3

    private int max;
    private int ptr1, ptr2;
    private int[] stk;

    public class EmptyStackException extends RuntimeException{
        public EmptyStackException() { }
    }

    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() {  }
    }

    public twoStacks(int capacity){
        ptr1 = 0;
        ptr2 = capacity -1;
        max = capacity;

        try{
            stk = new int[max];  // create stack
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public int pushA(int x){
        if(ptr1 >= ptr2) throw new OverflowIntStackException();
        return stk[ptr1++] = x;
    }

    public int pushB(int x){
        if(ptr1 >= ptr2) throw new OverflowIntStackException();
        return stk[ptr2--] = x;
    }

    public int popA(){
        if(ptr1 == 0) throw new EmptyStackException();
        return stk[--ptr1];
    }
    public int popB(){
        if(ptr2 == max) throw new EmptyStackException();
        return stk[++ptr2];
    }

    public peakA(){
        if(ptr1 <= 0) throw new EmptyIntStackException();
        return stk[ptr1 -1];
        }
    }

    public peakB(){
        if(ptr2 <= max) throw new EmptyIntStackException();
        return stk[ptr2 +1];
    }

    public void dumpA() {
        if (ptr1 <= 0) {
            System.out.println("Stack is empty");
        } else {
            for (int i = 0; i < ptr1; i++) {
                System.out.println(i + ": " + stk[i]);
            }
        }
    }

    public void dumpB() {
        if (ptr2 >= max) {
            System.out.println("Stack is empty");
        } else {
            for (int i = 0; i > ptr2; i--) {
                System.out.println(i + ": " + stk[i]);
            }
        }
    }

    public boolean isEmpty(){
        if(ptr1 == 0 && ptr2 == max) return true;
        return false;
    }

    public boolean isFull(){
        if(ptr1 < ptr2) return true;
        return false;

}

