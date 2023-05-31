from collections import deque
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline
N,M = map(int, input().split())

graph = [[] for i in range(N+1) ]
for i in range(M):
    u, v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)


queue= deque()
count= 1
visit =[0] *(N+1)
def bfs(i):
    global count

    queue.append(i)
    visit[i]=1
    
    while queue:
        n = queue.popleft()
        for v in graph[n]:
            if visit[v]==0:
                queue.append(v)
                visit[v]=1
    

    for x in range(1,N+1):
        if visit[x]!=1:
            count+=1
            bfs(x)
            return 

bfs(1)
print(count)