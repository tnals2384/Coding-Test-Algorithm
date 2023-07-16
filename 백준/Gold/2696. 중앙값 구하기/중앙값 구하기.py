import sys
import heapq
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    M = int(input())
    seq=[]
    heap=[]

    while len(seq)!=M:
        seq.extend(list(map(int, input().split())))
    print((M+1)//2)
    
    for i in range(M):
        if i%2==0:
            heap=seq[:i+1]
            heapq.heapify(heap)
            for j in range((i+1)//2):
                heapq.heappop(heap)
            print(heap[0],end=' ')
            if (i+1)%10==0:
                print()
    
        
    