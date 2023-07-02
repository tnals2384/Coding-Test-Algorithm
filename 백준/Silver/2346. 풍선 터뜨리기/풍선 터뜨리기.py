from collections import deque
N = int(input())
balloon = deque(map(int, input().split()))

index = deque(i for i in range(N))
ans =[]
while balloon :
    x= balloon.popleft()
    i =index.popleft()
    if x<0:
        balloon.rotate(-x)
        index.rotate(-x)
    else: 
        balloon.rotate(-(x-1))
        index.rotate(-(x-1))
    ans.append(i+1)


for i in range(N):
    print(ans[i], end=' ')