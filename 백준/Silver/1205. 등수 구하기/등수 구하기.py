N, new, P = map(int, input().split())
rank=[]
answer=0
if N==0:
    answer=1
else:
    rank= list(map(int, input().split()))
    if N==P and new <= rank[-1]:
        answer=-1
    else :
        answer=N+1      
        for i in range(N):
            if new >= rank[i]:
                answer = i+1
                break
                
print(answer)