import sys
input = sys.stdin.readline
import heapq
N=int(input())

arr=[]
for i in range(N):
    li = list(map(int,input().split()))
    for j in range(N):
        if(len(arr)<N) :
            heapq.heappush(arr,(li[j],-li[j]))
        else:
            if li[j]>=arr[0][0]:
                heapq.heappushpop(arr,(li[j],-li[j]))

print(heapq.heappop(arr)[0])