# Stack and Queue 스택과 큐 (자료구조 기본)
자료구조란 _데이터를 표현하고 관리하고 처리하기 위한 구조_ 를 의미한다.<br>
그중 스택과 큐는 자료구조의 기초 개념으로 다음의 두 핵심적인 함수로 구성된다.
- **삽입 Push** : 데이터를 삽입한다.
- **삭제 Pop** : 데이터를 삭제한다.

물론 실제로 스택과 큐를 사용할 때는 삽입과 삭제 외에도 _오버플로와 언더플로_ 를 고민해야 한다.

## Stack 스택 (Kellerspeicher)
스택은 _박스 쌓기_ 에 비유할 수 있다.
_박스는 아래에서부터 위로 차곡차곡 쌓는다. 그리고 아래에 있는 박스를 치우기 위해서는 위에 있는 박스를 먼저 내려야 한다._
이러한 구조를 **후입선출 Last In First Out(LIFO)** 또는 **선입 후출 First out Last In(FOLI)** 구조라고 한다.

```java
// Stack with Array
public class StackArray {
    int top;
    Object[] stack;

    StackArray(int capacity) {
        ptr = 0; // stack pointer
        stack = new Object[capacity];
    }

    void push(Object v) {
        if (ptr >= stack.length) {
            // handling overflow; OverflowIntStackException()
            return;
        } 
        stack[ptr++] = v;
    }

    Object pop() {
        if (ptr == 0) {
            // handling underflow; EmptyIntStackException()
            return null;
        } 
        return stack[--ptr];
    }

    Object peek() {
        if (ptr == 0) {
            throw new EmptyIntStackException();
        }
        return stack[ptr - 1];
    }

    boolean isEmpty() {
        return ptr == 0;
    }

    boolean isFull() {
        return ptr >= stack.length;
    }
}
```
```java
// Stack with List (linked list)
public class StackList<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode<T>(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    T pop() {
        if (top == null) {
            // handling underflow; EmptyIntStackException()
            return null;
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    Object peek() {
        if (top == null) {
            throw new EmptyIntStackException();
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }
```

**_파이썬_** 의 기본 리스트에서 ```append()```와 ```pop()``` 메서드를 이용하면 스택 자료구조와 동일하게 동작한다. ```append()``` 메서드는 리스트의 가장 뒤쪽에 데이터를 삽입하고, ```pop()``` 메서드는 리스트의 가장 뒤쪽에서 데이터를 꺼낸다.


## 문제 풀기   
1. 프로그래머스 스택 문제