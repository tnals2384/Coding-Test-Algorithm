n =int(input())
C =[int(input()) for _ in range(n)]

C.sort(reverse=True)
sum=0
for i in range(n):
    if((i+1)%3==0) : continue
    sum+=C[i]
    
print(sum)    


