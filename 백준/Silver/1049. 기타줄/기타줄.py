N,M = map(int,input().split())
#한패키지에 6줄
pak=[]
single=[]

for i in range(M):
    a,b=list(map(int, input().split()))
    pak.append(a)
    single.append(b)

money=0

while(N > 6) :
    if(6*min(single) < min(pak)) :
        money +=6*min(single)
    else :
        money += min(pak)
    N -= 6
    
if(N*min(single) < min(pak)) :
    money += N*min(single)
else :
    money += min(pak)
    
print(money)