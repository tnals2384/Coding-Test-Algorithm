import sys
from collections import defaultdict
input = sys.stdin.readline

N,W= map(int, input().split())
tree=defaultdict(list)
water = [0]*(N+1)

for i in range(N-1):
    u,v = map(int, input().split())
    tree[u].append(v)
    tree[v].append(u)
    

count = 0
for root, nodes in tree.items():
    if root!=1 and len(nodes)==1:
        count+=1
        
print(W/count)