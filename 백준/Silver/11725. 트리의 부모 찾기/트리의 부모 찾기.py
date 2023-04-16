import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N= int(input())

tree = [[] for i in range(N+1)]
answer=[0]*(N+1)
for i in range(N-1):
    x, y = map(int, input().split())
    tree[x].append(y)
    tree[y].append(x)


def dfs(tree,v, answer) :
    for i in tree[v] :
        if answer[i] == 0 :
            answer[i]=v
            dfs(tree,i,answer)
        
dfs(tree,1,answer)
for i in range(2,N+1):
    print(answer[i])