"""
요세푸스 순열 - 백준 1158번

요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

출력
예제와 같이 요세푸스 순열을 출력한다.
"""

"""
from typing import Any
class Que:
    def __init__(self, capacity: int, ele: [Any]) -> None:
        self.no = capacity
        self.front = 0
        self.rear = 0
        self.capacity = capacity
        self.que = ele

    def deque(self, x: int) -> Any:
        c = (self.front + x - 1) % self.capacity
        x = self.que[c]
        self.front = c+1
        self.rear = c
        self.no -= 1
        return x

    def print(self) -> [Any]:
        c = []
        for i in range(self.no):
            idx = (i + self.front) % self.capacity
            c.append(self.que[idx])

        return c


lists = list(map(int, input().split()))
n = lists[0]
m = lists[1]

ele = []
capa = n
result = []

for i in range(1,n+1):
    ele.append(i)

while capa != 0:
    que = Que(capa, ele)
    result.append(que.deque(m))
    ele = que.print()
    capa -= 1

print('<' + ', '.join(map(str,result)) + '>')
"""

n, m = map(int, input().split())
ele = [ i for i in range(1, n+1)]
result = []
front = 0
index = n

while index != 0:
    c = (front + m -1) % index
    result.append(ele.pop(c))
    index -= 1
    if index != 0:
        front = c % index

print('<' + ', '.join(map(str,result)) + '>')


"""
위 코드로도 돌아가지만..
클래스로 큐를 만들어서 돌려 줄 필요는 없고 
그냥 메인에 바로 쓰면 코드를 더 짧게 쓸 수 있을 듯.
 - 파이썬 리스트에는 pop 이라는 삭제 함수 있음. list.pop(index) 하면 인덱스에 위치한 값 리턴하면서 삭제  

"""