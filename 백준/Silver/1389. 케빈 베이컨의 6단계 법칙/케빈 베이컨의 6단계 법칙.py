from collections import deque

N,M = map(int, input().split())
arr = [[] for i in range(N+1)]


for i in range(M):
    A,B = map(int, input().split())
    arr[A].append(B)
    arr[B].append(A)

queue = deque()
answer=[]

def bfs(i):
    #방문하지 않은 노드가 없도록 탐색
    
    visited=[0]*(N+1)
    queue.append(i)
    visited[i]=1
    while queue:
        t = queue.popleft()
        for v in arr[t]:
            if visited[v]==0:
                visited[v] = visited[t]+1
                queue.append(v)
                
    return sum(visited)


for i in range(1,N+1):
        answer.append(bfs(i))

print(answer.index(min(answer))+1)