import sys
input= sys.stdin.readline
N,K =map(int, input().split())

medal=[]
for i in range(1,N+1):
    medal.append(list(map(int,input().split())))

medal.sort(key=lambda x: (-x[1],-x[2],-x[3]))

for i in range(N):
    if medal[i][0]==K:
        index = i
for i in range(N):
    if medal[index][1:]== medal[i][1:] :
        print(i+1)
        break
