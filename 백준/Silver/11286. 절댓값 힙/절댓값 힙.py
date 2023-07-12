import sys
input = sys.stdin.readline
import heapq

N = int(input())
heap =[]
for i in range(N):
    x = int(input())
    if x==0:
        if len(heap)==0:
            print(0)
            continue
        print(heapq.heappop(heap)[1])
    else: 
        if x<0:
            heapq.heappush(heap, (-x,x))
        else:
            heapq.heappush(heap,(x,x))