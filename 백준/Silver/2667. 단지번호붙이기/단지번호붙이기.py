import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())

map = list(list(input().rstrip('\n')) for _ in range(N))
visited = [[False]* N for _ in range(N)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

answer=[]

def dfs(x,y) :
    global count
    visited[x][y]=True
    count+=1
    for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if(nx < 0 or nx>=N or ny<0 or ny>=N):
                continue
            if(visited[nx][ny]==False and map[nx][ny]=='1'):
                dfs(nx,ny)
    

for i in range(N):
    for j in range(N):
        if(visited[i][j] == False and map[i][j]=='1'):
            count=0
            dfs(i,j)
            answer.append(count)
            

print(len(answer))
answer.sort()
for i in range(len(answer)):
    print(answer[i])