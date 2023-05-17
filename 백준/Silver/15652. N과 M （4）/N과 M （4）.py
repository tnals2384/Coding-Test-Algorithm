N,M = map(int, input().split())

seq=[]

def dfs():
    if len(seq)==M:
        for num in seq:
            print(num,end=' ')
        print()
        return 
    
    for x in range(1,N+1) :
        if len(seq)>=1 and seq[-1] > x : continue
        seq.append(x)
        dfs()
        seq.pop()

dfs()
            
            