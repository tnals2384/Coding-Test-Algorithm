import sys
input = sys.stdin.readline
from queue import PriorityQueue
N =int(input())

arr=PriorityQueue()

for i in range(N):
    x=int(input())
    if x==0:
        if arr.empty():
            print(0)
        else: 
            print(arr.get()[1])
    else:
        arr.put((-x,x))

