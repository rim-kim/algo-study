package chap04_Stack_queue;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    IntStack stack = new IntStack(50);

    while (true) {
        System.out.println("1. 푸시 2. 팝 3. 피크 4.검색 5.비움 6.덤프 7.나머지 정보들 0.종료");
        int b = stdIn.nextInt();
        if (b == 0)
            break;

        int x = 0;
        switch (b) {
            case 1:
                System.out.print("푸시할 값을 입력하세요: ");
                x = stdIn.nextInt();
                try {
                    stack.push(x);
                } catch (IntStack.OverflowIntStackException e) {
                    System.out.println("스택이 가득 찼습니다.");
                }
                break;

            case 2:
                try {
                    x = stack.pop();
                    System.out.println(x + "를 팝했습니다.");
                } catch (IntStack.EmptyIntStackException e) {
                    System.out.println("스택이 비었습니다.");
                }
                break;

            case 3:
                try {
                    x = stack.peek();
                    System.out.println(x + "를 피크했습니다.");
                } catch (IntStack.EmptyIntStackException e) {
                    System.out.println("스택이 비었습니다.");
                }
                break;

            case 4:
                System.out.print("찾을 데이터를 입력하세요: ");
                x = stdIn.nextInt();
                int n = stack.indexOf(x);
                if (n >= 0)
                    System.out.println(stack.size() - n + "번 째에 있습니다.");    //위치 입력 틀렸었음.
                else
                    System.out.println("데이터가 없습니다.");
                break;

            case 5:
                stack.clear();
                break;

            case 6:
                stack.dump();
                break;

            case 7:
                System.out.println("용량 : " + stack.capacity());
                System.out.println("데이터의 수: " + stack.size());
                System.out.println(stack.isEmpty() ? "비었습니다." : "비어있지 않습니다.");
                System.out.println(stack.isFull() ? "가득찼습니다." : "아직 가득  차지 않았습니다.");
                break;
            }
        }
    }
}