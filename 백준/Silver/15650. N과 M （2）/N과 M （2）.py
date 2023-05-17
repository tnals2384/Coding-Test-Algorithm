N,M = map(int, input().split())

seq=[]
a=[0]*(N+1)

def dfs():
    if len(seq)==M:
        for num in seq:
            print(num,end=' ')
        print()
        return 
    
    for x in range(1,N+1) :
        if len(seq) >= 1 and seq[-1] > x: continue
        if a[x]==0:
            a[x]=1
            seq.append(x)
            dfs()
            seq.pop()
            a[x]=0

dfs()