import sys
input = sys.stdin.readline
from datetime import datetime
from collections import defaultdict

N, L, F = input().split()
N= int(N)
F =int(F)
L= L.replace(':','/')
DDD, hh, mm= map(int,L.split('/'))

#총 빌려갈 수 있는 시간을 분으로 환산
total = DDD*24*60 + hh*60 + mm

#default값이 있는 dictionary 사용
book = defaultdict(dict) 
ans =defaultdict(int)

for i in range(N):
    str =input()
    #반납 시간
    now = datetime.strptime(str[:16], '%Y-%m-%d %H:%M')
    # 부품이름, 사람이름
    P, M = str[16:].split() 
    
    #멤버 M의 P 부품 대여 기록이 있을 경우
    if book[M].get(P):
        #빌린 시간을 계산
        borrow = now - book[M][P]
        borrowTime = borrow.days*60*24 + borrow.seconds//60
        #빌린 시간이 대여 가능한 시간보다 클 경우 비용 계산
        if borrowTime > total:
            ans[M]+= (borrowTime-total)*F
        #대여 장부에서 이력 삭제
        del book[M][P]
    #대여기록이 없다면 대여 장부에 추가
    else:
        book[M][P]=now

#비용을 내야하는 멤버가 있다면 
if len(ans.keys()):
    #사전순 정렬 후 출력
    list = sorted(ans.keys())
    for key in list:
        print(key, int(ans[key]))
# 없다면 -1 출력
else:
    print(-1)