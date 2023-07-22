import sys
input =sys.stdin.readline
from collections import deque
N = int(input())

tree = [[] for i in range(N+1)]

for i in range(N-1):
    a,b= map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)




q = int(input())
for i in range(q):
    t,k = map(int,input().split())
    if t==1:
        if len(tree[k])==1:
            print('no')
        else:
            print('yes')
    else:
        print('yes')
        