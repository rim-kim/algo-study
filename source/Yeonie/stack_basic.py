"""
Stack
- 데이터를 임시 저장할 때 사용하는 자료구조로 데이터의 입력과 출력 순서는 LIFO (last in first out)

push: 데이터를 스택에 넣는 작업
pop : 데이터를 스택에서 꺼내는 작업
top : 푸시하고 팝하는 윗부분
bottom : 아랫부분

스택 배열 : stk
 - 푸시한 데이터를 저장하는 스택 본체인 list 형 배열. 인덱스 0인 원소를 스택의

스택 크기 : capacity
 - 스택의 최대 크기를 나타내는 int 형 정수. len(stk)와 일치

스택 포인터 : ptr
 - 스택에 쌓여 있는 개수를 나타내는 정숫값. 스택이 비어있으면 0, 가득 차 있으면 capacity 와 같은 값
 - stk[ptr] 부터 push 가능
 - FixedStack 클래스를 사용하여 스택 작업을 수행하는 경우 스택 포인터 ptr 값은 반드시 0 이상, capacity 값 이하.
   이 때, == 연산자가 아니라 부등호 (<=, >=) 로 판단하면 스택 배열의 최솟값 최댓값에서 벗어난 접근을 막을 수 있음.

"""

# FixedStack 고정 길이 스택

from typing import Any


# 고정 길이 스택 클래스
class FixedStack:

    # 비어 있는 FixedStack 에 팝 또는 피크 할 때 내보내는 예외 처리
    class Empty(Exception):
        pass

    # 가득한 FixedStack 에 푸시할 때 내보내는 예외 처리
    class Full(Exception):
        pass

    # 스택 초기화
    def __init__(self, capacity: int = 256) -> None:
        self.stk = [None] * capacity     # 스택본체
        self.capacity = capacity
        self.ptr = 0

    # 스택에 쌓여있는 데이터 개수를 반환
    def __len__(self) -> int:
        return self.ptr

    # 스택이 비어있는지 판단
    def is_empty(self) -> bool:
        return self.ptr <= 0

    # 스택이 가득 차 있는지
    def is_full(self) -> bool:
        return self.prt >= self.capacity

    def push(self, value: Any) -> None:
        if self.is_full():
            raise FixedStack.Full

        self.stk[self.ptr] = value
        self.ptr += 1

    def pop(self) -> Any:
        if self.is_empty():
            raise FixedStack.Empty
        self.ptr -= 1
        return self.stk[self.ptr]

    # 스택에서 데이터를 피크 - 꼭대기 데이터를 들여다 봄
    def peek(self) -> Any:
        if self.is_empty():
            raise FixedStack.Empty
        return self.stk[self.ptr-1]

    # 스택을 비움 - 데이터 삭제
    def clear(self) -> None:
        self.ptr = 0

    # 스택에서 value 를 찾아 인덱스를 반환 , 없으면 -1 반환
    def find(self, value : Any) -> int:
        for i in range(self.ptr -1, -1, -1):   # 꼭대기 쪽부터 선형검색
            if self.stk[i] == value:
                return i
        return -1

    # 스택에 있는 value의 개수를 반환
    def count(self, value: Any) -> bool:
        c = 0
        for i in range(self.ptr):  # 바닥 쪽부터 선형 검색
            if self.stk[i] == value:
                c += 1
        return c

    # 스택에 value 가 있는지 판단
    def __contains__(self, value: Any) -> bool:
        return self.count(value)

    # 덤프 - 스택 안의 모든 데이터를 바다부터 꼭대기 순으로 출력
    def dump(self) -> None:
        if self.is_empty():
            print('스택이 비어 있습니다.')
        else:
            print(self.stk[:self.ptr])






