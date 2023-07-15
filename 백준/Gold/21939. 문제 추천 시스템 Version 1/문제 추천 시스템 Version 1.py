import sys
input =sys.stdin.readline
import heapq
N= int(input())
maxh=[] #최대힙
minh=[] #최소힙
solved={} #풀었는지 안풀었는지를 boolean으로 저장
for _ in range(N):
    p,l=map(int,input().split())
    heapq.heappush(maxh,(-l,-p))
    heapq.heappush(minh,(l,p))
    solved[p]=False

M= int(input())

for i in range(M):
    c =input().split()
    if c[0]=='add':
        #이미 풀었던 문제면 힙에서 삭제
        while solved[-maxh[0][1]]:
            heapq.heappop(maxh)
        while solved[minh[0][1]]:
            heapq.heappop(minh)
        
        p=int(c[1])
        l=int(c[2])
        
        heapq.heappush(maxh, (-l,-p))
        heapq.heappush(minh, (l,p))
        solved[p]=False
        
    elif c[0]=='recommend':
        if c[1] == '1':
            #푼 문제 제외하고
            while solved[-maxh[0][1]]:
                heapq.heappop(maxh)
            #가장 어려운 문제 추천
            print(-maxh[0][1])
        else:
            #푼 문제 제외하고
            while solved[minh[0][1]]:
                heapq.heappop(minh)
            #가장 쉬운 문제 추천
            print(minh[0][1])
    else:
        solved[int(c[1])]=True