import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int , input().split()))

M = int(input())
num = list(map(int, input().split()))


def search(A,target, start, end) :
    while start <= end:
        mid = (start+end)//2
        
        if A[mid] == target:
            return mid
        elif A[mid] > target :
            end = mid - 1
        else:
            start = mid + 1
    
    return None

A.sort() 
for i in range(M) :
    result = search(A,num[i],0,N-1)
    if result == None :
        print(0)
    else :
        print(1)
