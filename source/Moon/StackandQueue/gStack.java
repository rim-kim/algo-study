public class gStack<E>{  // 연습과제 2

    private int max;
    private int ptr;
    private E[] stk;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyStackException() { }
    }

    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() {  }
    }

    public gStack<E>(int capacity) {
        ptr = 0;
        max = capacity;
        try{
            stk = new E[max];  // create stack
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    ...

}