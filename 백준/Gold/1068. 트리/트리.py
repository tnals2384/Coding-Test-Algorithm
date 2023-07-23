import sys
input = sys.stdin.readline

N = int(input())
tree = list(map(int, input().split()))
D = int(input())

def dfs(tree,D) :
    tree[D]=-2
    for i in range(N):
        if tree[i]==D:
            dfs(tree,i)
    
count=0
dfs(tree,D)
for i in range(N):
    if tree[i] != -2 and i not in tree:
        count+=1

print(count)
