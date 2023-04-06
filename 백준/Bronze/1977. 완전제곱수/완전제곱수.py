import math

M = int(input())
N = int(input())

x = math.ceil(math.sqrt(M))

sum=0
min=0

if(x**2 > N) : 
    print(-1)
else :
    min = x**2
    while(x**2 <= N) :
        sum += x**2
        x+=1
    print(sum)
    print(min)
