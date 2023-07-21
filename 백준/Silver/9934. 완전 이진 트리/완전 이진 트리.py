import sys
input = sys.stdin.readline

K = int(input())
building = list(map(int, input().split()))
ans = [[] for _ in range(pow(2,K))]
def program(arr,i):
    if i==K:
        return
    center = len(arr)//2
    ans[i].append(arr[center])
    program(arr[:center],i+1)
    program(arr[center+1:],i+1)

program(building,0)


for i in range(K):
    for num in ans[i]:
        print(num,end=' ')
    print()