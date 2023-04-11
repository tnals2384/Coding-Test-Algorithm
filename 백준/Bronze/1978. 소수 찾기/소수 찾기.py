N = int(input())
num = list(map(int, input().split()))

def prime(x):
    if x==1: return False
    for i in range(2,x):
       if x%i == 0 :
           return False
    
    return True

count=0
for i in num:
    if prime(i)==True : count+=1
    
print(count)