"""
Queue _ 큐
 - 스택과 같이 데이터를 임시 저장하는 자료구조. 선입선출

enqueue 인큐 : 데이터를 큐에 추가하는 작업
dequeue 디큐 : 데이터를 큐에서 꺼내는 작업
front : 데이터를 꺼내는 쪽
rear : 데이터를 넣는 쪽

배열로 큐 구현 - 디큐 할 때 모든 원소를 앞쪽으로 옮겨야 하므로 복잡도 O(n)

링 버퍼로 규 구현 - 모든 처리의 복잡도 O(1)
"""

# 고정 길이 큐 클래스 FixedQueue 구현

from typing import Any

class FixedQueue:

    # 비어있는 FixedQueue 에서 디큐 또는 피크 할 때 내보내는 예외 처리
    class Empty(Exception):
        pass

    # 가득 차 있는 FixedQueue 에서 인큐할 때 내보내는 예외 처리
    class Full(Exception):
        pass

    def __init__(self, capacity: int) -> None:
        self.no = 0         # 현재 데이터 개수
        self.front = 0      # 맨 앞 원소 커서
        self.rear = 0       # 맨 끝 원소 커서
        self.capacity = capacity
        self.que = [None] * capacity

    def __len__(self) -> int:
        return self.no

    def is_empty(self) -> bool:
        return self.no <= 0

    def is_full(self) -> bool:
        return self.no >= self.capacity

    def enque(self, x : Any) -> None:
        if self.is_full():
            raise FixedQueue.Full

        self.que[self.rear] = x
        self.rear += 1
        self.no += 1
        if self.rear == self.capacity:
            self.rear = 0

    def deque(self) -> Any:
        if self.is_empty():
            raise FixedQueue.Empty

        x = self.que[self.front]
        self.front += 1
        self.no -= 1
        if self.front == self.capacity:
            self.front = 0

        return x

    # 큐에서 데이트를 피크 - 맨 앞 데이터를 들여다봄
    def peak(self) -> Any:
        if self.is_empty():
            raise FixedQueue.Empty
        return self.que[self.front]

    # 큐에서 value 를 찾아 인덱스를 반환 , 없으면 -1 반환
    def find(self, value : Any) -> Any:
        for i in range(self.no):
            idx = ( i + self.front ) % self.capacity
            if self.que[idx] == value:
                return idx
        return -1

    # 큐에 있는 value 의 개수를 반환
    def count(self, value: Any) -> int:
        c = 0
        for i in range (self.no):
            idx = (i + self.front) % self.capacity
            if self.que[idx] == value:
                c += 1
        return c

    def __contain(self, value: Any) -> bool:
        return self.count(value) > 0

    # 큐의 모든 데이터 비움
    def clear(self) -> None:
        self.no = self.front = self.capacity = 0




