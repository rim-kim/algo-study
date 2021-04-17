"""
선형검색(Linear search)
 - 직선 모양(선형) 으로 늘어선 배열에서 검색하는 우에 원하는 키 값을 가진 원소를 찾을 때 까지 맨 앞부터 스캔하여 순서대로 검색
 - 보초법(sentinel) : 종료 조건을 검사하는 비용을 줄이기 위해 배열 제일 마지막에 검색하고자 하는 키 값을 저장. 이 때 저장하는 값은 보초(sentinel)
 - 복잡도 : O(n)

이진검색(Binary search)
 - 배열의 데이터가 정렬되어 있어야 함. 중앙값을 기준으로 범위를 반으로 줄여가면서 값을 검색.
 - 참고할 코드가 없다면 구현하기 쉽지 않으므로 가급적 외우는 것을 추천
 - 복잡도 : O(log n)
 - 탐색범위가 1000만 단위 이상으로 넘어가면 O(log N) 속도를 내는 알고리즘으로 접근 해야 함.

"""

# 이진 검색 알고리즘 / 생각하지 않고 쭉쭉 쓸 수 있을 정도로 익숙해 질 것.

from typing import Any, Sequence


def bin_search(a: Sequence, key: Any) -> int:
    """ 시퀀스 a 에서 key 와 일치하는 원소를 이진 검색"""
    pl = 0  # 검색 범위 맨 앞 원소의 인덱스
    pr = len(a) - 1  # 검색 범위 맨 끝 원소의 인덱스

    while True:
        pc = (pl + pr) // 2
        if a[pc] == key:
            return pc
        elif a[pc] < key:
            pl = pc + 1
        else:
            pr = pc - 1
        if pl > pr:
            break

    return -1


# 연습문제 1. 실습 3-3의 seqSearchSen 메서드를 for 문을 사용하여 프로그램을 작성하시오. - 선형검색

def seq_search(a: Sequence, key: Any) -> int:
    for i in range(len(a)):
        if a[i] == key:
            return i
        i += 1
    return -1


# 연습문제 3. 요솟수가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞부터 순서대로 저장하고, 일치한 요솟수를 반환하는 메서드를 작성하세요.
# 예를 들어 요솟수가 8인 배열 a의 요소가 {1, 9, 2, 9, 4, 6, 7, 9}이고 key가 9면 배열 idx에 {1, 3, 7}을 저장하고 3을 반환합니다. (117p)

def seq_search_2(a: Sequence, key: Any) -> int:
    search = []

    for i in range(len(a)):
        if a[i] == key:
            search.append(i)
        i += 1

    return len(search)


# 연습문제 5. 아래 그림의 배열에서 7을 검색하면 중앙에 위치하는 a[5]를 검색합니다. 맨 앞의 요소를 찾는 binSearchX 메서드를 작성해 보세요. (117p)

def bin_search_x(a:Sequence, key:Any) -> int:
    pl = 0
    pr = len(a) - 1

    while True:
        pc = (pl + pr) // 2
        if a[pc] == key:
            while a[pc - 1] == key:
                pc -= 1
            return pc
        elif a[pc] < key:
            pl = pc + 1
        else:
            pr = pc - 1
        if pl > pr:
            break

    return -1


if __name__ == '__main__':
    num = int(input('원소의 수를 입력하세요. : '))
    x = [None] * num

    for i in range(num):
        x[i] = int(input(f'x[{i}]: '))

    key = int(input('검색할 값을 입력하세요 : '))

    idx = bin_search_x(x, key)
    if idx == -1:
        print('검색값을 갖는 원소가 존재하지 않습니다')
    else:
        print(f'검색값이 x[{idx}]에  있습니다.')

