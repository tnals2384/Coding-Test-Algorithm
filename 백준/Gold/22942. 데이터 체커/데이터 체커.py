import sys
input = sys.stdin.readline

N = int(input())

X = []
for i in range(N):
    x,r=map(int, input().split())
    X.append((x-r,i))
    X.append((x+r,i))



X.sort()

stack = []

for c in X:
    if stack:
        if stack[-1][1]==c[1]:
            stack.pop()
        else :
            stack.append(c)
    else: stack.append(c)
        
if stack:
    print('NO')
else:
    print('YES')
