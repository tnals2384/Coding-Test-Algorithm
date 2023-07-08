import sys
input = sys.stdin.readline
N,M = map(int, input().split())

S= set()

for i in range(N):
    S.add(input())

ans=0
for i in range(M):
    l = len(S)
    s = input()
    S.add(s)
    if len(S)!=l:
        S.remove(s)
    else:
        ans+=1

print(ans)