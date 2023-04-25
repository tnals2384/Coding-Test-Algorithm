import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(n,idx):
    if(n==6):
        for i in range(n):
            print(answer[i], end=' ')
        print()
        return
            
    for i in range(idx,len(S)):
        answer.append(S[i])
        dfs(n+1,i+1)
        answer.pop()
        


while(1):
    S = list(map(int, input().split()))
    if(S[0]==0) :
        break
    answer=[]
    dfs(0,1)
    print()
    