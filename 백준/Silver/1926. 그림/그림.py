import sys
input=sys.stdin.readline
from collections import deque

N,M = map(int, input().split())


painting = [list(map(int, input().split())) for _ in range(N)]
visited=[[0]*M for _ in range(N)]

queue = deque()
count=0

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(i,j):
    area=1
    visited[i][j]=1
    queue.append((i,j))

    while queue:
        x,y = queue.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            
            if 0<=nx<N and 0<=ny< M and visited[nx][ny]==0:
                if painting[nx][ny]==1:
                    visited[nx][ny]=1
                    area+=1
                    queue.append((nx,ny))
    return area
    
maxArea=0

for i in range(N):
    for j in range(M):
        if painting[i][j]==1 and visited[i][j]==0:
            count+=1
            area = bfs(i,j)
            maxArea = max(maxArea,area)

if count==0 :
    print(0)
    print(0)
else :
    print(count)
    print(maxArea)
