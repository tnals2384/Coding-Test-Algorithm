
M = int(input())
N = int(input())

def prime(x):
    prime=True
    if x==1:
        prime=False
    for i in range(2,x):
        if x%i==0:
            prime=False
    
    return prime

arr=[]
for i in range(M,N+1):
    if prime(i)==True:
        arr.append(i)

if len(arr)==0:
    print(-1)
else:
    print(sum(arr))
    print(arr[0])