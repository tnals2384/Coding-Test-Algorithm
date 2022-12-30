N= int(input())

A=list(map(int, input().split()))
B=list(map(int, input().split()))
newA = A[:]
newB = B[:]
for i in range(N):
    minIndex= A.index(min(A))
    maxIndex = B.index(max(B))
    newA[maxIndex]=min(A)
    A[minIndex]=101
    B[maxIndex]=-1

sum=0
for i in range(N):
   sum+=newA[i]*newB[i] 

print(sum)