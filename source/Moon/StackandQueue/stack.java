public class IntStack {
    private int max;  // size
    private int ptr;  // pointer
    private int[] stk;  // stack


    public class EmptyIntStackException extends RuntimeException {
        public EmptyStackException() { }
    }

    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() {  }
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try{
            stk = new int[max];  // create stack
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public int push (int x) {
        if (ptr >= max) throw new OverflowIntStackException();
        return stk[ptr++] = x;  // add and then increase ptr
    }

    public int pop() {
        if(ptr <= 0) throw new EmptyIntStackException();
        return stk[--ptr];  // decrease ptr and then return (pop)
    }

    public int peek (){
        if(ptr <= 0) throw new EmptyIntStackException();
        return stk[ptr -1];
    }

    public void dump(){
        if(ptr <= 0){
            System.out.println("Stack is empty");
        }else{
            for(int i = 0; i < ptr; i++){
                System.out.println(i + ": " + stk[i]);
            }
        }
    }

    // 연습문제 1
    public void clear(){
        ptr = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return ptr;
    }

    public boolean isEmpty(){
        if(ptr == 0) return true;
        return false;
    }

    public boolean isFull(){
        if(ptr == max) return true;
        return false;
    }

}