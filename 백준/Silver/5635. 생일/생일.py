import sys
input= sys.stdin.readline

N=int(input())
arr= [[] for i in range(N)]

for i in range(N):
    name, day,month,year = list(input().split())
    arr[i]=[name,int(day),int(month),int(year)]
    

arr.sort(key=lambda x:(-x[3], -x[2], -x[1]))
print(arr[0][0], arr[N-1][0])
    