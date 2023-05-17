N,M = map(int, input().split())

seq=[]

def dfs():
    if len(seq)==M:
        for num in seq:
            print(num,end=' ')
        print()
        return 
    
    for x in range(1,N+1) :
            seq.append(x)
            dfs()
            seq.pop()

dfs()