## 03-1 검색 알고리즘 <br/>
  - 데이터 집합에서 원하는 값을 가진 요소를 찾아내는 알고리즘
  
  _검색과 키_ 
  - '배열검색'은 다음의 알고리즘 활용
  1. 선형검색: 무작위로 늘어놓은 데이터 모임에서 검색을 수행
  2. 이진 검색: 일정한 규칙으로 늘어놓은 데이터 모임에서 아주 빠른 검색을 수행
  3. 해시법: 추가, 삭제가 자주 일어나는 데이터 모임에서 아주 빠른 검색을 수행 <br/>
    1) 체인법: 같은 해시값의 데이터를 선형 리스트로 연결하는 방법 <br/>
    2) 오픈 주소법 : 데이터를 위한 해시 값이 충돌할 때 재해시 하는 방법
       
  - 배열은 검색은 빠르지만 데이터를  추가하기 위한 비용은 많이 듦
  
### 03-2 선형 알고리즘(linear search) <br/>
  - 배열에서 검색하는 방법 중 가장 기본적인 알고리즘
  - 원하는 키 값을 갖는 요소를 만날때까지 맨앞부터 순서대로 요소를 검색 
  - 다음 조건 중 하나라도 성립하면 검색 종료.
    1. 검색할 값을 발견하지 못하고 배열의 끝을 지난 경우
    2. 검색할 값과 같은 요소를 발견한 경우 <br/>
 -선형검색은 배열에서 순서대로 검색하는 유일한 방법
 
 _보초법(sentinel method)_ <br/>
 
   - 검색하기 전에 검색하고자 하는 키 값을 맨끝에 저장. 저장하는 값을 보초(sentinel)라고 함 
   - 반복문에서 종료판단 횟수를 2->1 로 줄이는 역할.

### 03-3 이진검색(binary search) <br/>
 - 전제 조건: 데이터가 키 값으로 이미 정렬(sort)되어 있는 것.
 - 선형 검색보다 좀 더 빠름.
 - 요소가 오름차순 또는 내림차순으로 정렬된 배열에서 검색하는 알고리즘
 
 _이진검색_ <br/>
   - 검색 범위의 맨 앞 인덱스: pl /맨 끝 인덱스:pr /중앙인덱스:pc 
   - 시작할 때는 pl=0, pr=n-1, pc=(n-1)/2 로 초기화 <br/>
   - a[pc]와 key를 비교하여 같으면 ~~검색성공~~ <br/>
   - 원하는 값 없다면?  <br/>
      1. a[pc]<key : a[pl]~a[pc] 검색 대상에서 제외. 검색범위는 a[pc+1]~a[pr]로 좁힘. 
                   그 후 pl값을 pc+1로 업데이트. <br/>
      2. a[pc]>key : a[pc]~a[pr] 검색 대상에서 제외. 검색범위는 a[pl]~a[pc-1]로 좁힘.
                   그 후 pl값을 pc-1로 업데이트.<br/>
   - 종료조건 <br/>
        1. a[pc]=key <br/>
        2. 검색 범위 더이상 X <br/>
   - 검색을 반복할때마다 검색범위는 절반이 되므로 검색의 필요한 비교횟수의 평균값은 log n.
     실패한 경우는 천장메서드 log(n+1), 검색 성공 경우는 대략 log n -1회.
   - 정렬 되어 있음이 가정이므로 앞 입력 값보다 작은 경우에는 재입력. <br/>

 _복잡도(complexity)_ : 알고리즘의 성능을 객관적으로 평가하는 기준 <br/>
 - 요소 
    1. 시간복잡도(time complexity): 실행에 필요한 시간을 평가
    2. 공간복잡도(space complexity): 기억영역과 파일공간이 얼마나 필요한가를 평가
 
 _선형검색의 시간복잡도_ 
 - 한번만 실행하는 경우 복잡도 : O(1)
 - n에 비례하는 횟수만큼 실행하는 경우의 복잡도: O(n)
 - 일반적으로 O(f(n))과 O(g(n))의 복잡도를 계산하는 방법: O(f(n)) +O(g(n)) = O(max(f(n),g(n)))
 - 이진검색의 시간복잡도: O(1)+O(1)+O(log n)+ ...+ O(1) = O(log n)
 
 _Arrays.binarySearch에 의한 이진검색_
 - 자바는 이진검색 메서드를 표준 라이브러리로 제공.
 - 자바는 이진검색 메서드를 표준 라이브러리로 제공.
 - 이 메서드는 ~~오름차순~~으로 정렬된 배열 a를 가정하고 이진검색
 - 검색 성공한 경우) key와 일치하는 요소를 반환. 일치사는 요소가 여러개라면 무작위의 인덱스 반환 <br/>
   검색 실패한 경우) 반환값은 삽입포인트를 -x-1로 반환. <br/>
    +삽입포인트: 검색하기 위해 지정한 key보다 큰 요소 중 첫번째 요소의 인덱스 
    

### 코딩테스트에서의 이진검색 <br/>
    - 여러차례 코드를 입력하며 외워볼 것.
    - 코테 단골이므로 가급적 외우길 권장
    - 원리가 다른 알고리즘에서도 폭넓게 사용되므로 매우 중요.
    - 코테의 이진탐색 문제는 탐색 범위가 큰 상황에서의 탐색을 가정하는 문제가 많음.
     -> 탐색범위가 2000만으로 넘어가면 이진탐색으로 접근해보길 권함.