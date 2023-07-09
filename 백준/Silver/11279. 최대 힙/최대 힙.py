import sys
input = sys.stdin.readline
import heapq
N =int(input())

arr=[]

for i in range(N):
    x=int(input())
    if x==0:
        if len(arr)==0:
            print(0)
        else: 
            print(heapq.heappop(arr)[1])
    else:
        heapq.heappush(arr,(-x,x))

