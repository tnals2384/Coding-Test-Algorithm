
N =int(input())

top = list(map(int, input().split()))
ans=[0]*N
stack=[]
for i in range(0,N):
    while stack:
        if stack[-1][1] > top[i]:
            ans[i] = stack[-1][0]+1
            break
        else:
            stack.pop()
    stack.append([i, top[i]])
            
for i in range(N):
    print(ans[i], end=' ')