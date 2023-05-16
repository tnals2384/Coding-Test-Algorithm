import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
add,sub,mul,div = list(map(int, input().split()))
maxNum=-1e9
minNum=1e9

def dfs(idx, num) :
    global add,sub,mul,div,maxNum,minNum
    if idx == N:
        maxNum=max(maxNum,num)
        minNum=min(minNum,num)
    else:
        if add>0:
            add-=1
            dfs(idx+1, num+A[idx])
            add+=1
        if sub>0:
            sub-=1
            dfs(idx+1,num-A[idx])
            sub+=1
        if mul > 0:
            mul-=1
            dfs(idx+1,num*A[idx])
            mul+=1
        if div > 0:
            div-=1
            dfs(idx+1,int(num/A[idx]))
            div+=1

dfs(1,A[0])

print(maxNum)
print(minNum)