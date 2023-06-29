N,K = map(int, input().split())

from collections import deque

one = deque(i for i in range(1,N+1))

ans=[]

num=1
print('<', end='')
while(one) :
    one.rotate(-(K-1))
    print(one.popleft(), end='')
    if not one : break
    print(', ', end='')
print('>', end='')