N,M=map(int, input().split())

arr=[]
for i in range(N) :
    arr.append(list(map(int, input()))) #spilt 하면 안 됨

max=0

for i in range(N) :
    for j in range(M):
        current = arr[i][j]
        for x in range(j,M) :
            #범위 내에 있어야 함
            if arr[i][x]==current and i + x -j < N and x < M:
                if arr[i+x-j][j]==current and arr[i+x-j][x]==current:
                    if(((x-j+1)**2) > max) :
                        max=(x-j+1)**2

print(max)
