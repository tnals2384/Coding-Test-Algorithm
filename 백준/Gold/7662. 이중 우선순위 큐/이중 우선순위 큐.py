import sys
import heapq
input =sys.stdin.readline

T=int(input())

for _ in range(T):
    minQ = []
    maxQ = []

    k=int(input())
    D =[True]*k
    
    for i in range(k):
        c, n = input().split()
        n=int(n)
        if c=='I':
            heapq.heappush(minQ, (n, i))
            heapq.heappush(maxQ, (-n, i))
            D[i] = False
        else:
            if n == 1:
                #상대 힙에서 삭제되지 않은 값을 찾음
                while maxQ and D[maxQ[0][1]]:
                    heapq.heappop(maxQ)
                if maxQ:
                    D[maxQ[0][1]] = True
                    heapq.heappop(maxQ)
            # n == -1 일 경우
            else:
                while minQ and D[minQ[0][1]]:
                    heapq.heappop(minQ)
                if minQ:
                    D[minQ[0][1]] = True
                    heapq.heappop(minQ)
    
    #삭제된 값은 다 삭제
    while minQ and D[minQ[0][1]]:
        heapq.heappop(minQ)
    while maxQ and D[maxQ[0][1]]:
        heapq.heappop(maxQ)
    
    if minQ and maxQ:
        print(-maxQ[0][0], minQ[0][0])
    else:
        print('EMPTY')